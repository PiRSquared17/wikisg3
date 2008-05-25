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
				<h1>Últimos artículos</h1>
				<table>
				<%
				IWikiOperations op = new WikiOperations();
				
				Collection mostRated = op.getMostRatedArticles();
				
				Iterator it = mostRated.iterator();
				
				while (it.hasNext()){
					Article ar = (Article)it.next();
				//en un futuro, mostrar tambien las valoraciones, junto al enlace
				%>
				
				
					<tr>
						<td><a href="./FrontController?res=A2&id=<%out.print(ar.getTitle()); %>"><% out.print(ar.getTitle()); %> </a><td>
						
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