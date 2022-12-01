<%@ taglib prefix="liferay-util" uri="http://liferay.com/tld/util" %>
<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="demo.caption"/></b>
</p>

<liferay-util:dynamic-include key="com.demo#/view.jsp#pre" />

<liferay-util:dynamic-include key="com.demo#/view.jsp#post" />
