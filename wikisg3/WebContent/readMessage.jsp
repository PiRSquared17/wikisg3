<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,isg3.operations.*,isg3.article.*,isg3.mailBox.*" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="./estilo.css" rel="stylesheet"></link>
<title>Insert title here</title>
</head>
<body>
	<div id="contenedor">
		<jsp:include  page="head.jsp"/>
		
		<div id="contenido">
			<jsp:include  page="menu.jsp"/>
			<div id="principal">
			
			<%
			IWikiOperations op = new WikiOperations();
			//String nick = (String)request.getSession(false).getAttribute("user");
			String idMessage = request.getParameter("message");
			Message m = op.getMessage(idMessage);
			%>
			
			<table>
				
				<tr>
					<td>Asunto:</td>
					<td><% out.print(m.getSubject()); %></td>
				</tr>
				
				<tr>
					<td>De:</td>
					<td><% out.print(m.getFrom()); %></td>
				</tr>
				
				<tr>
					<td>Fecha:</td>
					<td><% out.print(m.getDate()); %></td>
				</tr>
				
				<tr>
					<td>Contenido:</td>
					<td><% out.print(m.getContent()); %></td>
				</tr>
				
			</table>
			
			</div>
		</div>
	</div>
</body>
</html>