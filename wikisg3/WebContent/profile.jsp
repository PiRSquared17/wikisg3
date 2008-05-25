<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="isg3.operations.*,isg3.user.*" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="./estilo.css" rel="stylesheet"></link>
<title>Insert title here</title>
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
				<h1>Perfil de Usuario</h1>
				<div id="nick">
					<h2>Nick: </h2><%out.print(user.getNick()); %>
				</div>
				<div id="mail">
					<h2>eMail: </h2><%out.print(user.getProfile().getMail()); %>
				</div>
				<div id="registeredDate">
					<h2>Fecha de Registro: </h2><%out.print(user.getProfile().getRegisteredDate()); %>
				</div>
				<div id=editar>
					<a href="./FrontController?res=P2l&id=<%out.print(u); %>">Editar Perfil</a>
			</div>
		</div>
	</div>
</body>
</html>