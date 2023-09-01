<%@include file="/init.jsp" %>

<portlet:renderURL var="addMemoURL">
    <portlet:param name="mvcPath" value="/edit.jsp" />
    <portlet:param name="redirect" value="<%= redirect%>" />
</portlet:renderURL>

<aui:form action="<%= addMemoURL%>">
    <aui:button primary="<%= true %>" type="submit" value="Create Memo" />
</aui:form>

<div class="container-fluid-1280">

    <liferay-portlet:renderURL varImpl="iteratorURL"/>

    <liferay-ui:search-container searchContainer='<%= new MemoSearchContainer(renderRequest, iteratorURL) %>'>
        <liferay-ui:search-container-row
            className="my.memo.model.Memo"
            keyProperty="resourcePrimKey"
            modelVar="memo"
            >

            <liferay-ui:search-container-column-text property="text" />
            <liferay-ui:search-container-column-text property="summary" />

            <liferay-ui:search-container-column-text align="right">

                <liferay-ui:icon-menu markupView="lexicon">

                    <portlet:renderURL var="editURL">
                        <portlet:param name="mvcPath" value="/edit.jsp" />
                        <portlet:param name="resourcePrimKey" value="<%= String.valueOf(memo.getResourcePrimKey())%>"/>
                        <portlet:param name="redirect" value="<%= redirect%>" />
                    </portlet:renderURL>

                    <liferay-ui:icon image="edit" url="<%= editURL%>" />
                </liferay-ui:icon-menu>
            </liferay-ui:search-container-column-text>
        </liferay-ui:search-container-row>

        <liferay-ui:search-iterator markupView="lexicon" />

    </liferay-ui:search-container>

</div>