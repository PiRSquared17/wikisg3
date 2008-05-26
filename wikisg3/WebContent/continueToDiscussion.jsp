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
			String title = request.getParameter("id");
			%>
			Su valoración sobre éste artículo ha sido muy baja.<br>
			¿Desea abrir una discusión para la eliminación del artículo?<br>
			Si es así, haga click <a class="edit" href="./FrontController?res=S11l&id=<%out.print(title); %>">aquí</a>.<br>
			Si no, puede volver a la <a  class="edit" href="./FrontController?res=A2&id=<%out.print(title); %>">página del artículo</a>.
			</div>
		</div>
	</div>
</body>
</html>