package my.memo.web.internal.search;

import com.liferay.petra.function.transform.TransformUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.SearchResultUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import java.util.List;
import java.util.Locale;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import my.memo.model.Memo;
import my.memo.service.MemoLocalServiceUtil;

public class MemoSearchContainer extends SearchContainer<Memo> {

    private static final Log LOGGER = LogFactoryUtil.getLog(MemoSearchContainer.class);

    public MemoSearchContainer(PortletRequest portletRequest, PortletURL iteratorURL) {

        super(portletRequest, iteratorURL, null, "no-memos-were-found");

        HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(portletRequest);
        SearchContext searchContext = SearchContextFactory.getInstance(httpServletRequest);

        searchContext.setStart(getStart());
        searchContext.setEnd(getEnd());

        Hits hits = search(searchContext);

        List<Memo> memoList = TransformUtil.transform(
                SearchResultUtil.getSearchResults(
                        hits, Locale.US),
                searchResult -> MemoLocalServiceUtil.fetchLatestMemo(
                        searchResult.getClassPK(), WorkflowConstants.STATUS_ANY));

        setResultsAndTotal(() -> memoList, hits.getLength());
    }

    private Hits search(SearchContext searchContext) {

        try {
            Indexer<Memo> indexer = IndexerRegistryUtil.nullSafeGetIndexer(Memo.class);
            return indexer.search(searchContext);

        } catch (SearchException e) {
            LOGGER.error(e);
        }

        return null;
    }
}
