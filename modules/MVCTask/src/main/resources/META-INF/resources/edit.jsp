<%@ include file="/init.jsp" %>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="editEntry" var="editEntryURL"></portlet:actionURL>

<%--<aui:form action="<%= editEntryURL %>" name="<portlet:namespace />fm">--%>
<%--    <aui:fieldset>--%>
<%--        <aui:input name="booknumber" />--%>
<%--        <aui:input name="name" />--%>
<%--        <aui:input name="email" />--%>
<%--        <aui:input name="message" />--%>
<%--    </aui:fieldset>--%>
<%--    <aui:button-row>--%>
<%--        <aui:button type="submit"></aui:button>--%>
<%--        <aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>--%>
<%--    </aui:button-row>--%>
<%--</aui:form>--%>


<aui:form action="<%= editEntryURL %>">
    <aui:fieldset label="Edit Web Content Information">
        <aui:row>
            <aui:col width="50">
                <aui:input label="ArticleId" name="articleId" type="text" value="${articleId}" readonly="true" />
            </aui:col>
            <aui:col width="50">
                <aui:input label="Title" name="title" type="text"  value="${title}"/>
            </aui:col>
        </aui:row>
        <aui:row>
            <aui:col width="100">
                <aui:input label="content" name="content" type="textarea" value="${content}"/>
            </aui:col>
        </aui:row>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>
    </aui:button-row>
</aui:form>

