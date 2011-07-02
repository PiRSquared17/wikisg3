<%@  page  language="java"  contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
  <title>Practica ISG3</title>
	<link rel="stylesheet" type="text/css" href="style/style.css" />
</head>
<div id="container">

<div id="top">
<img src="http://www.lsi.us.es/imagenes/logolsi49x56.gif" alt="Lenguajes y Sistemas Informï¿½ticos"/>
<img src="http://www.lsi.us.es/imagenes/rotulo-lsi-grande2.gif" alt="Lenguajes y Sistemas Informï¿½ticos"/>
<img src="http://www.lsi.us.es/imagenes/logous50x50.gif" alt="Universidad de Sevilla"/>
</div>


<div id="content">
		<form:form  action="loginform.html"  commandName="loginForm">
		 <div id="arribaDcha">
		 <fieldset>
		 <legend  style="font-family: Arial,sans-serif; font-size: 18px; color: #660000" align="center">Datos de Usuario</legend>

		<table summary="Identificacion de Usuario" align="center">

		 <tr>
		 <td>		 Nombre de Usuario:		 </td>
		 <td>		 <form:input  path="userName" /> </td>
		 </tr>
		
		 <tr>
		 <td>		 Contraseña:		 </td>
		 <td>		 <form:password  path="password" /> </td>
		 </tr>
		 
		 <tr>
		 <td colspan="3" align="center"><input type="submit" value="ENTRAR"/></td>
		 </tr>

		 
		 </table>		 
 		 </fieldset>
		 </div> <!--cierra arribaDcha -->
		 
</form:form>
</div> <!-- cierra content -->


</div> <!-- cierra container -->
</html>
