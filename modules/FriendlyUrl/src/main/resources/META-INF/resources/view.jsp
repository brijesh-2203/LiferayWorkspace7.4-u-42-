<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="friendlyurl.caption"/></b>
</p>

<portlet:renderURL var="viewEntryURL">
	<portlet:param name="mvcRenderCommandName" value="/blogs/view_entry" />
	<portlet:param name="urlTitle" value="<%= entry.getUrlTitle() %>" />
</portlet:renderURL>