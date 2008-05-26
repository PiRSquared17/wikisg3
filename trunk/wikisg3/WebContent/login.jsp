<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="./estilo.css" rel="stylesheet"></link>
<title>WikiMedia: Acceso</title>
</head>
<body>

<div id="contenedor">
		<jsp:include  page="head.jsp"/>
		
		<div id="contenido">
			<jsp:include  page="menu.jsp"/>
			<div id="principal">
			<h2>Est&aacute; intentando acceder a un &aacute;rea restringida</h2>
	Por favor, ingrese como usuario.
	<%
		String s = request.getParameter("b");
		String res = request.getParameter("res");
		String idArt = request.getParameter("id");
		if (res.equals("L1")){
			res = request.getParameter("oldres");
		}
		if (s != null){
			out.print("Usuario o contraseña incorrecta");
		}
	%>
	<form action="./Login" method="post">
		<fieldset>
		<legend>Login</legend>
		<table> 
			<tr>
				<td>Usuario</td>
				<td><input  type="text" id="usuario" name="usuario" size="8"></td>
			</tr>
			<tr>
				<td>Contraseña</td>
				<td><input  id="pass" type="password" name="pass" size="12"></td>
			</tr>

		</table>
		<input type="hidden" name="oldres" value="<%out.print(res); %>"/>
		<input type="hidden" name="id" value="<%out.print(idArt); %>"/>
		<input class="boton" type="submit" value="Entrar">
		</fieldset>
		
	</form>
			</div>
		</div>
	</div>

	
</body>
</html>