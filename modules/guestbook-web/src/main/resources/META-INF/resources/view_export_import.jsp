<%@include file="../init.jsp"%>



<%--<%--%>
<%--       String backURL = ParamUtil.getString(request, "backURL");--%>
<%--    System.out.println("backurl :"+backURL);--%>
<%--    long backgroundTaskId = ParamUtil.getLong(request, "backgroundTaskId");--%>

<%--    portletDisplay.setDescription(LanguageUtil.get(request, "process-details"));--%>

<%--    if (Validator.isNotNull(backURL)) {--%>
<%--        portletDisplay.setShowBackIcon(true);--%>
<%--        portletDisplay.setURLBack(backURL);--%>
<%--    }--%>

<%--//     renderResponse.setTitle(LanguageUtil.get(request, "process-details"));--%>
<%--    System.out.println("nasbamnsba: "+backgroundTaskId);--%>
<%--//    resourceRequest.setAttribute("backgroundTaskId",backgroundTaskId);--%>
<%--%>--%>

<portlet:resourceURL id="/exportEntry" var="exportD" />

GuestBook
<aui:input name="backgroundTaskId" value="hrl" type="hidden"/>
<a href="<%=exportD.toString()%>"><clay:icon symbol="download"/></a>
<%--<aui:button onClick="<%= exportD %>"--%>
<%--                                value="Download" />--%>
