<%@ include file="init.jsp"%>
<portlet:defineObjects />

<portlet:actionURL name="addStudent" var="addStudentActionURL"/>


<h2>Add Student Form here !</h2>

<aui:form action="<%=addStudentActionURL %>" name="studentForm" method="POST">

	<aui:input name="screenName" >
		<aui:validator name="required"/>
		<aui:validator name="alpha"/>
	</aui:input>

	<aui:input name="firstName" >
		<aui:validator name="required"/>
		<aui:validator name="alpha"/>
	</aui:input>

	<aui:input name="lastName" >
		<aui:validator name="required"/>
		<aui:validator name="alpha"/>
	</aui:input>

	<aui:input name="emailAddress" type="email">
	</aui:input>

<%--	<aui:input name="password" type="password">--%>
<%--	</aui:input>--%>


<%--	<aui:input name="greeting" type="text">--%>
<%--	</aui:input>--%>

<%--	<aui:input name="contactId" type="number">--%>
<%--	</aui:input>--%>

<%--	<aui:input name="ctCollectionId" type="number">--%>
<%--	</aui:input>--%>

<%--	<aui:input name="languageId" type="text">--%>
<%--	</aui:input>--%>

<%--	<aui:input name="jobTitle" type="text">--%>
<%--	</aui:input>--%>

<%--	<aui:input name="createDate" type="date">--%>
<%--	</aui:input>--%>


	<aui:button type="submit" name="" value="Submit"></aui:button>
</aui:form>