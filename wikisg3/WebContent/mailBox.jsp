<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,isg3.operations.*,isg3.mailBox.*" session="false"%>
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
String user = (String)s.getAttribute("user");
IWikiOperations op = new WikiOperations();
Collection c = op.getAllMessages(user);

String b = request.getParameter("error");
if (b != null){
	if (b.equals("false")){
		out.print("El mensaje ha sido enviado correctamente");
	}
}

%>
	<div id="contenedor">
		<jsp:include  page="head.jsp"/>
		
		<div id="contenido">
			<jsp:include  page="menu.jsp"/>
			<div id="principal">
			<a  class="edit" href="./FrontController?res=M3l">Enviar Mensaje</a>
			<h2>Mensajes recibidos</h2>
			<table id="tabla">
			<tr>
				<td width="30%" class="titulo">Asunto</td>
				<td width="25%" class="titulo">De:</td>
				<td width="35%" class="titulo">Fecha</td>
				<td width="10%" class="titulo">Eliminar</td>
			</tr>
			<%
			Iterator it = c.iterator();
			while (it.hasNext()){
				Message m = (Message)it.next();
				String subject = m.getSubject();
				String sender = m.getFrom();
				Date date = m.getDate();				
			%>
			<tr>
				<td class="contenido"><a href="./FrontController?res=M2l&message=<% out.print(m.getIdMessage()); %>"><% out.print(subject); %></a></td>
				<td class="contenido"><% out.print(sender); %></td>
				<td class="contenido"><% out.print(date); %></td>
				<td class="contenido"><a href="./FrontController?res=S8l&message=<% out.print(m.getIdMessage()); %>" ><img src="./imagenes/botonBorrar.png"></a></td>
			</tr>	
				
			<%
			}
			%>
			
			</table>
			</div>
		</div>
	</div>
</body>
</html>