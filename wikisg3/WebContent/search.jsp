<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,isg3.operations.*,isg3.article.*" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="./estilo.css" rel="stylesheet"></link>
<title>WikiMedia: Búsqueda</title>
</head>
<body>
<%
IWikiOperations op = new WikiOperations();
String article = (String)request.getParameter("busca");
Collection c = op.searchArticle(article);
%>

	<div id="contenedor">
		<jsp:include  page="head.jsp"/>
		
		<div id="contenido">
			<jsp:include  page="menu.jsp"/>
			<div id="principal">
			<h3>Se han producido <%out.print(c.size()); %> resultados:</h3>  
			<table>
				<%
			
				Iterator it = c.iterator();
				
				while (it.hasNext()){
					Article ar = (Article)it.next();
				
				%>
				
				
					<tr>
						<td><h3>&bull;<a href="./FrontController?res=A2&id=<%out.print(ar.getTitle()); %>"><% out.print(ar.getTitle()); %> </a></h3><td>
						
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