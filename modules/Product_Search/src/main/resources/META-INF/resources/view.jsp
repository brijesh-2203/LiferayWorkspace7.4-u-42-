<%@ include file="/init.jsp" %>


<portlet:renderURL var="searchURL">
	<portlet:param name="mvcRenderCommandName" value="/view" />
</portlet:renderURL>

<aui:form action="${searchURL}" name="fm">


	<div class="row">
		<div class="col-md-8">
			<aui:input inlineLabel="left" label="" name="keywords" placeholder="search-entries" size="256" />
		</div>

		<div class="col-md-4">
			<aui:button type="submit" value="search" />
		</div>
	</div>
</aui:form>