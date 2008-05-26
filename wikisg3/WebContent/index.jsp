<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,isg3.operations.*,isg3.article.*" session="false"%>
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
			String id = (String)request.getParameter("id");
			//IWikiOperations op = new WikiOperations();
			//Article art = op.getArticle(id);
			Collection c = new WikiOperations().getLastArticles(3);
			Iterator it = c.iterator();
			Article art = (Article)it.next();
			%>
			
				<h3>Bienvenido al wiki de ISG3.</h3>
			
				<div id="artPrincipal">
					<h4> Ultimo Artículo</h4>
					<div id="tituloArt">
						<h3><a href="./FrontController?res=A2&id=<%out.print(art.getTitle()); %>"> <%out.print(art.getTitle());%></a>
						<% out.print("  -  Categoría:   "+art.getCat().getName()); %></h3>
						<% if (art.getUnderDiscussion()){
							 out.print("<br><div class=\"aviso\">(Atención, artículo bajo discusión)</div>");
						 }
						 %>
						 
					</div>
					<div id="cuerpoArt">
							<% out.print(art.getContent()); %>
					</div>
				</div>
				<div id="ultArticulos">
					<h4> Ultimos Artículos:</h4>
						<table id="tabla">
						<tr>
							<td class="titulo"><h4>Nombre</h4></td>
							<td class="titulo"><h4>Categoría</h4></td>
							
							
							</tr>
						<%
						while (it.hasNext()){
							Article ar= (Article)it.next();
							String title = ar.getTitle();
							String cat = ar.getCat().getName();
							
						%>
							<tr>
							<td class="contenido"><a href="./FrontController?res=A2&id=<%out.print(title); %>"><%out.print(title);%></td>
							<td class="contenido"><a href="./FrontController?res=C2&id=<%out.print(cat); %>"><%out.print(cat);%></td>
							</tr>
						<%
						}
						%>
						
						</table>
				</div>
			</div>
			
		</div>
	</div>
</body>
</html>