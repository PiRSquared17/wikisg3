<%@ page language="java" import="pos.domain.*" %>
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
<jsp:include  page="head.html"/>
</div>

<div id="content">


<%

Order sessionCart = (Order)session.getAttribute("session.cart");
		
// El carrito está vacío porque no se ha creado o porque no tiene elementos
if(sessionCart == null || sessionCart.getDetails().size() == 0) 
{%>
	<jsp:include page="errorcarrito.html"/>
<%
}
else{

%>
<jsp:include page="printCarrito.jsp?botones=0"/>

<form action="FrontController?res=pagar.jsp" method="post">
<div id="left">
<jsp:include page="pago.html"/>
</div>
<div="right">
<jsp:include page="direccion.html"/>

<%
}

%>

</div>
</form>

</div>
</body>
</html>