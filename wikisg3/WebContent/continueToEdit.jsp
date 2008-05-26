<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="./estilo.css" rel="stylesheet"></link>
<title>WikiMedia</title>
</head>
<body>
	<%
	String idArt = request.getParameter("id");
	%>
	<div id="contenedor">
		<jsp:include  page="head.jsp"/>
		
		<div id="contenido">
			<jsp:include  page="menu.jsp"/>
			<div id="principal">
				<h2>El artículo ya existe</h2>
				Puede <a  class="edit" href="./FrontController?res=A2&id=<%out.print(idArt); %>">verlo</a>,
				 o <a  class="edit" href="./FrontController?res=A4e&id=<%out.print(idArt); %>">editar</a> su contenido.
				
			</div>
		</div>
	</div>	
	
</body>
</html>