<%@ page language="java" import="pos.domain.*" %>
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

<%
	// extraigo del el parámetro indicándome l producto que se va a eliminar del carro
	// independientemente del número de items que haya, se elimina el producto
	String pid = request.getParameter("pid");
	Order sessionCart = null;

	// si el parámetro no es nulo (se acceder directamente a carrito) o si su longitud no es mayor a cero
	if(pid!=null && pid.length()>0)
	{

		sessionCart = (Order)session.getAttribute("session.cart");
		if(sessionCart != null) 
		{
			sessionCart.removeDetail(pid);		
		}
	}
%>
<div id="top">
<jsp:include  page="head.jsp"/>
</div>
<div id="content">
<jsp:include page="printCarrito.jsp?botones=1"  />
</div>
</body>
</html>