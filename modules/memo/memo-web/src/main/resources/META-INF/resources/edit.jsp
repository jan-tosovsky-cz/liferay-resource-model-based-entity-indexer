<%@include file="/init.jsp" %>

<%
    Memo memo = (Memo) renderRequest.getAttribute("memo");
%>

<portlet:actionURL name="editMemo" var="editMemoURL">
    <portlet:param name="redirect" value="<%= redirect%>"/>
    <portlet:param name="resourcePrimKey" value="<%= String.valueOf((memo != null) ? memo.getResourcePrimKey() : 0) %>"/>
</portlet:actionURL>

<aui:form action="<%= editMemoURL%>" method="post">

    <aui:input type="textarea" name="text" label="Text" value='<%= (memo != null) ? memo.getText() : ""%>' />
    <c:if test="<%= memo != null%>">
        <aui:input type="text" name="summary" label="Summary" />
    </c:if>

    <aui:button primary="<%= true %>" type="submit" />
    <aui:button href="<%= redirect %>" type="cancel" />

</aui:form>