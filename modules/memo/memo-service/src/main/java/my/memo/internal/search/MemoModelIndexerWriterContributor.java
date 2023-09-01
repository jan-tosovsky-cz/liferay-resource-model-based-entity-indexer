package my.memo.internal.search;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import my.memo.model.Memo;
import my.memo.service.MemoLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=my.memo.model.Memo",
        service = ModelIndexerWriterContributor.class
)
public class MemoModelIndexerWriterContributor implements ModelIndexerWriterContributor<Memo> {

    @Reference
    private DynamicQueryBatchIndexingActionableFactory dynamicQueryBatchIndexingActionableFactory;

    @Reference
    private MemoLocalService memoLocalService;

    @Override
    public void customize(
            BatchIndexingActionable batchIndexingActionable,
            ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

        batchIndexingActionable.setPerformActionMethod((Memo memo) -> {
            if (memo.isLatest()) {
                Document document = modelIndexerWriterDocumentHelper.getDocument(memo);
                batchIndexingActionable.addDocuments(document);
            }
        });
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
                memoLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(Memo memo) {
        return memo.getCompanyId();
    }

}
