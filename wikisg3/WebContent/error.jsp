<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,isg3.operations.*,isg3.article.*" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="./estilo.css" rel="stylesheet"></link>
<title>WikiMedia: Error</title>
</head>
<body>
	<div id="contenedor">
		<jsp:include  page="head.jsp"/>
		
		<div id="contenido">
			<jsp:include  page="menu.jsp"/>
			<div id="principal">
			<%
			String type = request.getParameter("type");
			String t;
			if (type.equals("search")){
				t= "b�squedas";
			}else{
				t="ediciones";
			}
			%>
			<h1>Tiempo m�nimo entre <%out.print(t); %> no transcurrido</h1>
			
			</div>
		</div>
	</div>
</body>
</html>