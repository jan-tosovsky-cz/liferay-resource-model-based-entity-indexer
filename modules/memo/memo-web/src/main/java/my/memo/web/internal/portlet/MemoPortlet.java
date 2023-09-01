package my.memo.web.internal.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import java.io.IOException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import my.memo.model.Memo;
import my.memo.service.MemoLocalService;
import my.memo.web.internal.util.PortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.cms",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + PortletKeys.MEMO_PORTLET,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user,guest,administrator",
                "javax.portlet.version=3.0"
        },
        service = Portlet.class
)
public class MemoPortlet extends MVCPortlet {

    @Reference
    private MemoLocalService memoLocalService;

    @Override
    public void doDispatch(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

        long resourcePrimKey = ParamUtil.getLong(renderRequest, "resourcePrimKey");

        if (resourcePrimKey > 0) {
            Memo memo = memoLocalService.fetchLatestMemo(resourcePrimKey, WorkflowConstants.STATUS_ANY);
            if (memo != null) {
                renderRequest.setAttribute("memo", memo);
            }
        }

        super.doDispatch(renderRequest, renderResponse);
    }

    public void editMemo(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long groupId = themeDisplay.getScopeGroupId();
        long userId = themeDisplay.getUserId();

        long resourcePrimKey = ParamUtil.getLong(actionRequest, "resourcePrimKey");
        String text = ParamUtil.getString(actionRequest, "text");
        String summary = ParamUtil.getString(actionRequest, "summary");
        boolean isNew = resourcePrimKey == 0;

        if (isNew) {
            memoLocalService.addMemo(userId, groupId, text, null);

        } else {
            memoLocalService.updateMemo(userId, resourcePrimKey, text, summary);
        }
    }

}
