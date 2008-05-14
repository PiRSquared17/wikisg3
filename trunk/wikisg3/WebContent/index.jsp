<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="./estilo.css" rel="stylesheet"></link>
<title>WikiMedia</title>
</head>
<body>
	<div id="contenedor">
		<jsp:include  page="head.jsp"/>
		
		<div id="contenido">
			<jsp:include  page="menu.jsp"/>
			<div id="principal">
			<%
			out.print("sdfsdflsd");
			HttpSession h = request.getSession(false);
			if (h==null){
				out.print("no ");
			}
			else{
				
				out.print("tenemos un problema");
			}
			%>
				<div id="artPrincipal">
					<div id="tituloArt">
						gdfgdfg
					</div>
					<div id="cuerpoArt">
							dgdg<br>fgg<br>fgg<br>fgg<br>
							fgg<br>fgg<br>fgg<br>
					</div>
				</div>
				<div id="ultArticulos">
						
				</div>
			</div>
			
		</div>
	</div>
</body>
</html>