<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="./estilo.css" rel="stylesheet"></link>
<title>Introducir nombre articulo</title>
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
				<h2>Usted ya ha valorado este art&iacute;culo</h2>
				Puede <a href="./FrontController?res=A2&id=<%out.print(idArt); %>">ver el art&iacute;culo</a>,
				 o <a href="./FrontController?res=A6l&id=<%out.print(idArt); %>">editar</a> su valoraci&oacute;n previa.
				
			</div>
		</div>
	</div>	
	
</body>
</html>