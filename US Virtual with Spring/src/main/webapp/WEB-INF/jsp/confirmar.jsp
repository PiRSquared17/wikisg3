<%@ page language="java" import="pos.domain.*" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title>Productos</title>
<link rel="stylesheet" type="text/css" href="style/style.css" />
<style type="text/css">
<!--
	#cabecera td{background-color: rgb(238, 238, 238);}
  	#productos td{
		border-top-width: 1px;
	    border-top-style: solid;
 		border-top-color: rgb(153, 0, 51);
	}
	#content td{font-size:80%;}
	#left {float:left;padding-left:10px}
-->
</style>
</head>
<body>
<div id="top">
<jsp:include  page="head.jsp"/>
<span style="float: right">
    <a href="?lang=en">en</a>
    |
    <a href="?lang=es">es</a>
</span>
</div>

<div id="content">

<c:if test="${empty order.details}">
	<jsp:include page="errorcarrito.jsp"/>
</c:if>
<c:if test="${!empty order.details}">
	<jsp:include page="printCarrito.jsp?botones=0"/>

	<c:url var="pagarUrl" value="/store/pagar" />

	<form:form action="${pagarUrl}" method="post" modelAttribute="addressCreditCard">
		<div id="left">
			<jsp:include page="pago.jsp"/>
 		</div>
		<div id="right">
			<jsp:include page="direccion.jsp"/>
 		</div>
	</form:form>
</c:if>


</div>
</body>
</html>