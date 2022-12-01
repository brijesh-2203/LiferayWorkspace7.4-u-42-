<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.nio.file.FileStore" %>
<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="userlist.caption"/></b>
</p>

<%  List<User> studentList = (List<User>)request.getAttribute("allUsers"); %>
<portlet:renderURL var="addUserRenderURL">
	<portlet:param name="mvcPath" value="/add-student.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="addOrganizationRenderURL">
	<portlet:param name="mvcPath" value="/add-org.jsp"/>
</portlet:renderURL>

<div class="mb-5">
	<a href="<%= addUserRenderURL %>" class="btn  btn-primary btn-default">
		<i class="glyphicon glyphicon-plus"></i> Add User
	</a>
</div>
<div class="mb-5">
	<a href="<%= addOrganizationRenderURL %>" class="btn  btn-primary btn-default">
		<i class="glyphicon glyphicon-plus"></i> Add Organization
	</a>
</div>

<table class="table table-striped">
	<tr >
		<th>Screen Name</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email Address</th>
		<th colspan="2" style="width: 100px">Action</th>

	</tr>
	<c:forEach items="${requestScope.allUsers}" var="student">

		<portlet:renderURL var="updateStudentRenderURL">
			<portlet:param name="mvcPath" value="/update-student.jsp"/>
			<portlet:param name="screenName" value="${student.screenName}"/>
			<portlet:param name="firstName" value="${student.firstName}"/>
			<portlet:param name="lastName" value="${student.lastName}"/>
			<portlet:param name="emailAddress" value="${student.emailAddress}"/>
			<portlet:param name="userId" value="${student.userId}"/>
		</portlet:renderURL>

		<portlet:actionURL name="deleteStudent" var="deleteStudentActionURL">
			<portlet:param name="userId" value="${student.getUserId()}"/>
		</portlet:actionURL>

		<tr>
			<td>${student.getScreenName()}</td>
			<td>${student.getFirstName()}</td>
			<td>${student.getLastName()}</td>
			<td>${student.getEmailAddress()}</td>

			<td class="text-center" style="width: 50px">
				<a href="<%=updateStudentRenderURL%>" class="btn  btn-primary btn-default btn-sm px-2 py-1" >
					<i class ="glyphicon glyphicon-edit"></i>edit
				</a>
			</td>
			<td class="text-center" style="width:50px">
				<a href="<%=deleteStudentActionURL%>"
				   class="btn  btn-primary btn-default btn-sm px-2 py-1"
				   onclick="return confirm('Are you sure you want to delete this item?');">
					<i class ="glyphicon glyphicon-remove"></i>delete
				</a>
			</td>
		</tr>
	</c:forEach>
</table>
