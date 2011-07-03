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
<%
        List products = ProductStore.getInstance().getProducts();
        for (Iterator iter = products.iterator(); iter.hasNext();) {
            Product p = (Product) iter.next();
%>
<c:url var="addUrl" value="/store/carrito" />
			<tr align="center" id="productos">
				<td>--</td>
				<td> <%=p.getDescription()%> </td>
				<td> <%=p.getPrice()%>�</td>
				<c:url var="carritoImg" value="img/carro.gif" />
				<td> <a href="${addUrl}?pid=<%=p.getProductID()%>"><img src="${carritoImg}"> </a></td>
			</tr>
<%
		}
%>
</table>
</div>
</body>
</html>