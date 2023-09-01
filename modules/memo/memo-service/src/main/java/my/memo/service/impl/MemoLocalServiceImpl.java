package my.memo.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import java.util.Date;
import my.memo.exception.NoSuchMemoException;
import my.memo.model.Memo;
import my.memo.service.base.MemoLocalServiceBaseImpl;
import my.memo.util.MemoConstants;
import my.memo.util.comparator.MemoVersionComparator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	property = "model.class.name=my.memo.model.Memo", service = AopService.class
)
public class MemoLocalServiceImpl extends MemoLocalServiceBaseImpl {

	@Reference
	private IndexerRegistry indexerRegistry;

	@Override
	public Memo addMemo(
			long userId, long groupId, String text, String summary)
			throws PortalException {

		User user = userLocalService.getUser(userId);

		long memoId = counterLocalService.increment();
		long resourcePrimKey = counterLocalService.increment();

		Memo memo = memoPersistence.create(memoId);

		memo.setResourcePrimKey(resourcePrimKey);
		memo.setGroupId(groupId);
		memo.setCompanyId(user.getCompanyId());
		memo.setUserId(userId);
		memo.setUserName(user.getFullName());
		memo.setText(text);
		memo.setSummary(summary);
		memo.setVersion(MemoConstants.DEFAULT_VERSION);
		memo.setLatest(true);
		memo.setMain(false);
		memo.setStatus(WorkflowConstants.STATUS_DRAFT);

		memoLocalService.updateMemo(memo);

		// skipping workflow here and approving the version directly
		memo = updateStatus(userId, resourcePrimKey, WorkflowConstants.STATUS_APPROVED, new ServiceContext());

		return memo;
	}

	@Override
	public Memo updateMemo(
			long userId, long resourcePrimKey, String text, String summary)
			throws PortalException, SystemException {

		User user = userLocalService.getUser(userId);

		Memo oldMemo = fetchLatestMemo(resourcePrimKey, WorkflowConstants.STATUS_ANY);

		long groupId = oldMemo.getGroupId();

		Memo memo;

		if (oldMemo.isApproved()) {

			long memoId = counterLocalService.increment();

			memo = memoPersistence.create(memoId);

			memo.setResourcePrimKey(oldMemo.getResourcePrimKey());
			memo.setGroupId(groupId);
			memo.setCompanyId(user.getCompanyId());
			memo.setUserId(user.getUserId());
			memo.setUserName(user.getFullName());
			memo.setCreateDate(oldMemo.getCreateDate());
			memo.setVersion(oldMemo.getVersion() + 1);

		} else {
			memo = oldMemo;
		}

		memo.setText(text);
		memo.setSummary(summary);
		memo.setLatest(true);
		memo.setMain(false);

		memo.setStatus(WorkflowConstants.STATUS_DRAFT);

		memoLocalService.updateMemo(memo);

		if (oldMemo.isApproved()) {
			oldMemo.setLatest(false);
			oldMemo.setModifiedDate(oldMemo.getModifiedDate());
			memoLocalService.updateMemo(oldMemo);

			// Reindexing doesn't remove old versions
			Indexer<Memo> indexer = indexerRegistry.getIndexer(Memo.class);
			indexer.delete(oldMemo);
		}

		return memo;
	}

	@Override
	public Memo fetchLatestMemo(long resourcePrimKey, int status) {
		try {
			if (status == WorkflowConstants.STATUS_ANY) {
				return memoPersistence.findByR_First(resourcePrimKey, new MemoVersionComparator());
			}
			return memoPersistence.findByR_S_First(resourcePrimKey, status, new MemoVersionComparator());

		} catch (NoSuchMemoException e) {
			return null;
		}
	}

	@Override
	public Memo updateStatus(long userId, long resourcePrimKey, int status, ServiceContext serviceContext) throws PortalException, SystemException {

		User user = userLocalService.getUser(userId);
		boolean main = false;
		Date now = new Date();

		if (status == WorkflowConstants.STATUS_APPROVED) {
			main = true;
		}

		Memo memo = fetchLatestMemo(resourcePrimKey, WorkflowConstants.STATUS_ANY);

		memo.setModifiedDate(serviceContext.getModifiedDate(now));
		memo.setMain(main);
		memo.setStatus(status);
		memo.setStatusByUserId(user.getUserId());
		memo.setStatusByUserName(user.getFullName());
		memo.setStatusDate(serviceContext.getModifiedDate(now));

		memo = memoLocalService.updateMemo(memo);

		if (status != WorkflowConstants.STATUS_APPROVED) {
			return memo;
		}

		if (memo.getVersion() > MemoConstants.DEFAULT_VERSION) {

			Memo oldMemo = memoPersistence.findByR_V(resourcePrimKey, memo.getVersion() - 1);
			oldMemo.setMain(false);
			oldMemo.setModifiedDate(oldMemo.getModifiedDate());

			memo = memoLocalService.updateMemo(oldMemo);

			// Reindexing doesn't remove old versions
			Indexer<Memo> indexer = indexerRegistry.getIndexer(Memo.class);
			indexer.delete(oldMemo);
		}

		return memo;
	}

}