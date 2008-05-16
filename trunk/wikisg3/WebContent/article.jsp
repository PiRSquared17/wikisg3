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
	
	RatesCollection rates = art.getRates();
	
	
%>

	<div id="contenedor">
		<jsp:include  page="head.jsp"/>
		
		<div id="contenido">
			<jsp:include  page="menu.jsp"/>
			<div id="principal">
				<div id="artPrincipal">
					<div id="barrita">
						<a href="./FrontController?res=A4e&id=<%out.print(id); %>">Edite</a> o <a href="">valore</a> este art&iacute;culo
					</div>
					<div id="tituloArt">
						<% out.print(art.getTitle()); %>
					</div>
					<div id="cuerpoArt">
							<% out.print(art.getContent()); %>
					</div>
					<div id="valoraciones">
						<table>
							<tr>
								<td>Usuario</td>
								<td>Nota</td>
								<td>Raz&oacute;n</td>
							</tr>
						<%
						if (art.hasRates()){
							Iterator it = rates.getRates().iterator();
							while (it.hasNext()){
								Rate r = (Rate)it.next();
							%>
							
							
								<tr>
									<td><% out.print(r.getUser().getNick()); %></td>
									<td><% out.print(r.getRate()) ;%></td>
									<td><% out.print(r.getReason()); %></td>
								</tr>
							
							
							<%	
							}
						}
						%>
						</table>
					</div>
				</div>
				
			</div>
			
		</div>
	</div>

</body>
</html>