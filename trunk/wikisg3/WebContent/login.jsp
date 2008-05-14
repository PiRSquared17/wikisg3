<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrese</title>
</head>
<body>
	<h2>Est&aacute; intentando acceder a un &aacute;rea restringida</h2>
	Por favor, ingrese como usuario.
	<%
		String s = request.getParameter("b");
		if (s != null){
			out.print("Usuario o contraseña incorrecta");
		}
	%>
	<form action="por determinar">
		<fieldset>
			<legend>Login</legend>
			<label class="inputBlock" for="usuario">Usuario: </label>
			<input class="inputBlock" type="text"id="usuario" name="usuario" size="12">
			<label class="inputBlock" for="pass">Contraseña: </label>
			<input class="inputBlock" id="pass" type="password" name="pass" size="12">
			<input class="inputBlock" type="submit" value="login">
		</fieldset>
	</form>
</body>
</html>