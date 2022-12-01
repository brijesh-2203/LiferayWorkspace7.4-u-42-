<%@include file="../init.jsp"%>

<%
    ResultRow row = (ResultRow) request
            .getAttribute("SEARCH_CONTAINER_RESULT_ROW");

    Entry entry = (Entry) row.getObject();
%>

<liferay-ui:icon-menu>

    <portlet:renderURL var="editURL">
        <portlet:param name="entryId"
                       value="<%=String.valueOf(entry.getEntryId()) %>" />
        <portlet:param name="mvcPath"
                       value="/guestbookwebportlet/edit_entry.jsp" />
    </portlet:renderURL>

    <liferay-ui:icon image="edit" message="Edit"
                     url="<%=editURL.toString() %>" />

    <portlet:actionURL name="deleteEntry" var="deleteURL">
        <portlet:param name="entryId"
                       value="<%= String.valueOf(entry.getEntryId()) %>" />
    </portlet:actionURL>

    <liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />

</liferay-ui:icon-menu>