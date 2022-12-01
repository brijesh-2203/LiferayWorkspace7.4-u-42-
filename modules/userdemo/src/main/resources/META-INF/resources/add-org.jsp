<%@ include file="/init.jsp" %>



<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="addOrganization" var="addOrgURL"></portlet:actionURL>

<aui:form action="<%= addOrgURL %>">
    <aui:fieldset label="Organization">
        <aui:row>
            <aui:col width="50">
                <aui:input label="Name" name="orgname" type="text" />
            </aui:col>
            <aui:col width="50">
                <aui:input label="Type" name="type" type="text" value="organization" readonly="true" />
            </aui:col>
        </aui:row>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>
    </aui:button-row>
</aui:form>