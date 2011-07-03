<%@ page language="java" import="pos.domain.*,java.util.*" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title><spring:message code="label.products"/></title>
<link rel="stylesheet" type="text/css" href="style/style.css" />
<style type="text/css">
<!--
	#cabecera td{background-color: rgb(238, 238, 238);}
  	#productos td{
		border-top-width: 1px;
    border-top-style: solid;
 		border-top-color: rgb(153, 0, 51);
	}
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
<table summary ="Listado de Productos" cellSpacing="1" cellPadding="6" width="770" align="center" border="0">
	<tr valign ="middle" align="center">
		<td  colspan="6"><b><spring:message code="label.products"/></b></td>
	</tr>
	<tr valign ="middle" align="center" id="cabecera">
		<td>&nbsp;</td><td><spring:message code="label.description"/></td><td><spring:message code="label.price"/></td> <td><spring:message code="label.add"/></td>
	</tr>

<c:url var="carritoImg" value="img/carro.gif" />
<c:forEach items="${products}" var="product">
<tr align="center" id="productos">
				<c:url var="addUrl" value="/store/carrito/?pid=${product.id}"/>
				<td>--</td>
				<td> <c:out value="${product.description}"/> </td>
				<td> <c:out value="${product.price}"/></td>
				<td> <a href="${addUrl}"><img src="${carritoImg}"> </a></td>
			</tr>
</c:forEach>

</table>
</div>
</body>
</html>