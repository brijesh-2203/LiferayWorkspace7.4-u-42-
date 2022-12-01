<%@ include file="/init.jsp" %>

<%@page import="com.task.demo.portlet.MVCTaskPortlet"%>
<%@ page import="java.net.ContentHandler" %>
<%@ page import="com.liferay.journal.model.JournalArticle" %>

<p>
	<b><liferay-ui:message key="mvctask.caption"/></b>
</p>

<h2>WebContent:</h2>
<div align="center">
<table class="table table-striped">
	<tr >
		<th>ID</th>
		<th>Title</th>
		<th>Content</th>
		<th>Structure</th>
		<th colspan="2" style="width: 100px">Action</th>
	</tr>

	<c:forEach items="${requestScope.webList}" var="article" varStatus="articleCount">

<%--		<c:set value="${article.getContent()}" var="tet" />--%>
<%--		${tet}--%>
<%--		${MVCTaskPortlet.getDataFromXML(tet)}--%>

		<portlet:renderURL var="editWebContentRenderURL">
			<portlet:param name="mvcPath" value="/edit.jsp"/>
			<portlet:param name="articleId" value="${article.getArticleId()}"/>
			<portlet:param name="title" value="${article.getTitle()}"/>
			<portlet:param name="content" value="${content.get(articleCount.index)}"/>
		</portlet:renderURL>

<%--		<liferay-portlet:renderURL portletName="<%= MVCTaskPortletKeys.JOURNAL_CONTENT %>" var="editURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">--%>
<%--			<portlet:param name="struts_action" value="/journal/edit_article" />--%>
<%--&lt;%&ndash;			<portlet:param name="redirect" value="<%= currentURL %>" />&ndash;%&gt;--%>
<%--			<portlet:param name="groupId" value="${article.getGroupId()}"/>--%>
<%--			<portlet:param name="folderId" value="${article.getFolderId()}" />--%>
<%--			<portlet:param name="articleId" value="${article.getArticleId()}" />--%>
<%--			<portlet:param name="version" value="${article.getVersion()}" />--%>
<%--		</liferay-portlet:renderURL>--%>


		<portlet:actionURL name="deleteWebContent" var="deleteWebcontentActionURL">
			<portlet:param name="articleId" value="${article.getId()}"/>
		</portlet:actionURL>


		<tr>
			<td>${article.getId()}</td>
			<td>${article.getTitle()}</td>
			<td>${content.get(articleCount.index)}</td>
			<td>${article.getDDMStructure().getStructureKey()}</td>

			<td class="text-center" style="width: 50px">
				<a href="<%=editWebContentRenderURL%>" class="btn  btn-primary btn-default btn-sm px-2 py-1" >
					Edit
				</a>
			</td>
			<td class="text-center" style="width:50px">
				<a href="<%= deleteWebcontentActionURL %>"
				   class="btn  btn-danger btn-default btn-sm px-2 py-1"
				   onclick="return confirm('Are you sure you want to delete this item?');">
					Delete
				</a>
			</td>
		</tr>

	</c:forEach>
</table>
</div>