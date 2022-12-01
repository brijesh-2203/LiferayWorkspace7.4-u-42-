<%@include file="../init.jsp" %>

hello from edit under
<%

    long entryId = ParamUtil.getLong(renderRequest, "entryId");

    Entry entry = null;
    if (entryId > 0) {
        entry = EntryLocalServiceUtil.getEntry(entryId);
    }

    long guestbookId = ParamUtil.getLong(renderRequest, "guestbookId");
List<Guestbook> guestbooks = (List<Guestbook>) renderRequest.getAttribute("guestbooks");
%>

<portlet:renderURL var="viewURL">

    <portlet:param name="mvcPath" value="/guestbookwebportlet/view.jsp"/>

</portlet:renderURL>

<portlet:actionURL name="addEntry" var="addEntryURL"/>

<aui:form action="<%= addEntryURL %>" name="<portlet:namespace />fm">

    <aui:model-context bean="<%= entry %>" model="<%= Entry.class %>" />

    <aui:fieldset>

        <aui:input name="name"  value='<%= entry == null ? "" : entry.getName() %>'/>
        <aui:input name="email" value='<%= entry == null ? "" : entry.getEmail() %>' />
        <aui:input name="message" value='<%= entry == null ? "" : entry.getMessage() %>' />

        <aui:select name="guestbook" >
            <c:forEach items="${guestbooks}" var="currOption">
                <option value="${currOption.getGuestbookId()}"<c:if test="${currOption == title}"> selected="selected"</c:if>>
                        ${currOption.getName()}
                </option>
            </c:forEach>
        </aui:select>
        <aui:input name="entryId" type="hidden" />

    </aui:fieldset>

    <aui:button-row>

        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>

    </aui:button-row>
</aui:form>