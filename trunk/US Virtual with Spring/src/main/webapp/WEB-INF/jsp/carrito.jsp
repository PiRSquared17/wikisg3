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
-->
</style>
</head>
<body>

<%
	// extraigo del el parámetro indicándome el producto que se va a añadir al carro
	String pid = request.getParameter("pid");
	Order sessionCart = null;

	// si el parámetro no es nulo (se acceder directamente a carrito) o si su longitud no es mayor a cero
	if(pid!=null && pid.length()>0)
	{
		Detail detail = new Detail();
		detail.setNote("session");
		detail.setProduct(ProductStore.getInstance().getProduct(pid));
		detail.setQuantity(1);
		
	
		//saco si esque existe el carrito de la sessión
		//el carrito será un objeto de tipo Order
		sessionCart = (Order)session.getAttribute("session.cart");
		// es la primera vez que se añade un elemento
		if(sessionCart == null)  {
		   sessionCart = new Order();
		   sessionCart.setOrderID(""+System.currentTimeMillis());
		}
		sessionCart.addDetail(detail);
		session.setAttribute("session.cart", sessionCart);
	}
	else
	{
	System.out.println("PRODUCTO NULO");
	
	}
%>
<div id="top">
<jsp:include  page="head.html"/>
</div>
<div id="content">
<jsp:include page="printCarrito.jsp?botones=1"  />
</div>
</body>
</html>