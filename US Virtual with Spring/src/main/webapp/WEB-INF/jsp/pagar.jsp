<%@ page language="java" import="pos.domain.*,java.util.*,java.security.SecureRandom" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title><spring:message code="label.products"/></title>
<link rel="stylesheet" type="text/css" href="style/style.css" />
</head>
<body>


<div id="top">
<jsp:include  page="head.jsp"/>
</div>
<div id="content">
<p>
<c:if test="${!empty order.details}">
	<spring:message code="label.success"/>
</c:if>

<c:if test="${empty order.details}">
	<spring:message code="label.failure"/>>
</c:if>
</p>

</div>

</body>
</html>
