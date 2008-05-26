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

	<div id="contenedor">
		<jsp:include  page="head.jsp"/>
		
		<div id="contenido">
			<jsp:include  page="menu.jsp"/>
			<div id="principal">
				<h2>Introduzca el nombre del artículo</h2>
				<form action="./FrontController?res=S4l" method="post">
					<input class="inputBlock" type="text" id="id" name="id" size="12">
					<input class="boton" type="submit" id="Confirmar" name="Confirmar" value="Continuar">				
				</form>
				
			</div>
		</div>
	</div>	
	
</body>
</html>