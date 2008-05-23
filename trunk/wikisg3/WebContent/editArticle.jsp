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
	<%
	String id = (String)request.getParameter("id");
	IWikiOperations op = new WikiOperations();
	Article art = op.getArticle(id);
	
	%>
	<div id="contenedor">
		<jsp:include  page="head.jsp"/>
		
		<div id="contenido">
			<jsp:include  page="menu.jsp"/>
			<div id="principal">
				<div id="artPrincipal">
					<div id="tituloArt">
						<% out.print(id); %>
					</div>
					<div id="cuerpoArt">
						<form action="./EditArticle?res=S2&id=<%out.print(id); %>" method="post">
							<textarea name="content" id="content" rows="20" cols="50">
								<%
								if (art != null){
									out.print(art.getContent());	
								}
								
								%>
							</textarea>
							<select name="cat" id="cat">
								<option value="-">-</option>
								<option value="Deportes">Deportes</option>
								<option value="Ciencias">Ciencias</option>
								<option value="Sociedad">Sociedad</option>
								<option value="Historia">Historia</option>
								<option value="Arte">Arte</option>
								<option value="Tecnologias">Tecnologias</option>
							</select>
							<input type="submit" value="Aceptar"/>
							
							
						</form>
							
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>