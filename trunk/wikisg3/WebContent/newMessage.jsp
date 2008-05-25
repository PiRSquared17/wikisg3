<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,isg3.operations.*,isg3.article.*" session="false"%>
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
			String b = request.getParameter("error");
			if (b != null){
				if (b.equals("true")){
					out.print("El mensaje no ha podido ser enviado. Revise el destinatario");
				}
			}
			%>
			
			<form action="./FrontController?res=S10l" method="post">
				<table>
					
					<tr>
						<td>Destino:</td>
						<td> <input type="text" id="to" name="to" size="15"> </td>
					</tr>
					
					<tr>
						<td>Asunto:</td>
						<td> <input type="text" id="subject" name="subject" size="15"> </td>
					</tr>
					
					<tr>
						<td>Contenido:</td>
						<td> <textarea name="content" id="content" rows="20" cols="20"> </textarea></td>
					</tr>

					<tr>
						<input type="submit" value="Enviar">
					</tr>
				</table>
			</form>
			
			</div>
		</div>
	</div>
</body>
</html>