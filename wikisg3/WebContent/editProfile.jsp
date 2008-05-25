<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,isg3.operations.*,isg3.article.*" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="./estilo.css" rel="stylesheet"></link>
<title>Editar Perfil</title>
</head>
<body>
	<div id="contenedor">
		<jsp:include  page="head.jsp"/>
		
		<div id="contenido">
			<jsp:include  page="menu.jsp"/>
			<div id="principal">
			
			<form action = "./FrontController?res=S6l" method = "post">
				<fieldset>
					<legend>Editar Perfil</legend>
					<label class="inputBlock" for="password">Contraseña: </label>
					<input class="inputBlock" id="password" type="password" name="password" size="12">
					<label class="inputBlock" for="passwordConfirm">Confirmar contraseña: </label>
					<input class="inputBlock" id="passwordConfirm" type="password" name="passwordConfirm" size="12">
					<input class="inputBlock" type="submit" value="Editar">
				</fieldset>
			</div>
		</div>
	</div>
</body>
</html>