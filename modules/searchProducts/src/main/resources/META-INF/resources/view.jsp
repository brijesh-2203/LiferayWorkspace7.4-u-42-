<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="searchproducts.caption"/></b>
</p>

<portlet:renderURL var="searchURL">
	<portlet:param name="mvcPath"
				   value="/view.jsp" />
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

	<table class="table table-striped">
		<tr >
			<th>ProductId</th>

		</tr>

		<c:forEach items="${requestScope.productName}" var="product">
			<tr>
				<td>${product.name}</td>
			</tr>
		</c:forEach>
	</table>

</aui:form>