<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,isg3.operations.*,isg3.article.*" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String id = (String)request.getParameter("id");
	//IWikiOperations op = new WikiOperations();
	//Category cat = op.getCategory(id);
	Category cat = new WikiOperations().getCategory(id);

%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="./estilo.css" rel="stylesheet"></link>
<title>WikiMedia: Categoría de <%out.print(cat.getName()); %></title>
</head>
<body>


	<div id="contenedor">
		<jsp:include  page="head.jsp"/>
		
		<div id="contenido">
			<jsp:include  page="menu.jsp"/>
			<div id="principal">
				<div id="artPrincipal">
					<div id="tituloArt">
						<h2><% out.print(cat.getName()); %></h2>
					</div>
					<div id="cuerpoArt">
							<h3><% out.print(cat.getDescription()); %><h3>
					</div>
					
					<table>
				<%
				
				Iterator it = cat.getArticles().iterator();
				
				while (it.hasNext()){
					Article ar = (Article)it.next();
				//en un futuro, mostrar tambien las valoraciones, junto al enlace
				%>
				
				
					<tr>
						<td><h3>&bull; <a href="./FrontController?res=A2&id=<%out.print(ar.getTitle()); %>"><% out.print(ar.getTitle()); %></a></h3><td>
						
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