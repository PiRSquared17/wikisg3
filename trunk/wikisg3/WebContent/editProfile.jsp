<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,isg3.operations.*,isg3.user.*" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="./estilo.css" rel="stylesheet"></link>
<title>Editar Perfil</title>
</head>
<body>
	<%
	HttpSession s = request.getSession(false);
	String u = (String)s.getAttribute("user");
	IWikiOperations op = new WikiOperations();
	User user = op.getUser(u);
	
	%>
	<div id="contenedor">
		<jsp:include  page="head.jsp"/>
		
		<div id="contenido">
			<jsp:include  page="menu.jsp"/>
			<div id="principal">
			<%
			String b = request.getParameter("b");
			if (b != null){
				out.print("Datos Incorrectos");
			}
			%>
			
			<form action = "./FrontController?res=S6l" method = "post">
				<fieldset>
					<legend>Editar Perfil</legend>
					<label class="inputBlock" for="password">Contraseña: </label>
					<input class="inputBlock" id="password" type="password" name="password" size="12">
					<label class="inputBlock" for="newPassword">Nueva Contraseña: </label>
					<input class="inputBlock" id="newPassword" type="password" name="newPassword" size="12">
					<label class="inputBlock" for="passwordConfirm">Confirmar contraseña: </label>
					<input class="inputBlock" id="passwordConfirm" type="password" name="passwordConfirm" size="12">
					<label class="inputBlock" for="eMail">eMail: </label>
					<input class="inputBlock" id="eMail" type="text" name="eMail" size="12" value=<% out.print(user.getProfile().getMail()); %>>
					<input class="inputBlock" type="submit" value="Editar">
				</fieldset>
			</div>
		</div>
	</div>
</body>
</html>