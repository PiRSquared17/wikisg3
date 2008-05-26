<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="isg3.operations.*,isg3.user.*" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="./estilo.css" rel="stylesheet"></link>
<title>WikiMedia: Perfil</title>
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
			if (b!=null && b.equals("true")){
				out.print("Cambios guardados");
			}
			%>
				<h2>Perfil de <% out.print(user.getNick()); %></h2>
				<table id="tabla">
				<tr>
					<td>Nick:</td>
					<td><%out.print(user.getNick()); %></td>
					
				</tr>
				<tr>
					<td>eMail:</td>
					<td><%out.print(user.getProfile().getMail()); %></td>
					
				</tr>
				<tr>
					<td>Fecha de Registro: </td>
					<td><%out.print(op.convertDate(user.getProfile().getRegisteredDate())); %></td>
					
				</tr>
				<tr>
					<td><br><a class="edit"  href="./FrontController?res=P2l&id=<%out.print(u); %>">Editar Perfil</a></td>

				</tr>
				</table>
			
			
			</div>
		</div>
	</div>
</body>
</html>