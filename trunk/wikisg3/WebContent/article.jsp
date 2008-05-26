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
	//IWikiOperations op = new WikiOperations();
	//Article art = op.getArticle(id);
	Article art = new WikiOperations().getArticle(id);
	RatesCollection rates = art.getRates();
	
	
%>

	<div id="contenedor">
		<jsp:include  page="head.jsp"/>
		
		<div id="contenido">
			<jsp:include  page="menu.jsp"/>
			<div id="principal">
				<div id="artPrincipal">
					<div id="barrita">
						<a class="edit"  href="./FrontController?res=A4e&id=<%out.print(id); %>">Edite</a> o <a  class="edit" href="./FrontController?res=S5l&id=<%out.print(id); %>">valore</a> este art&iacute;culo
					</div>
					<br>
					<div id="tituloArt">
					
						<h3><% out.print(art.getTitle()); %>
						<% out.print("  -  Categoría:   "+art.getCat().getName()); %></h3>
						<% if (art.getUnderDiscussion()){
							 out.print("<br><div class=\"aviso\">(Atención, artículo bajo discusión)</div>");
						 }
						 %>
					
					</div>
					<div id="cuerpoArt">
							<% out.print(art.getContent()); %>
					</div>
					<br><br>
					<div id="valoraciones">
						<h3>Valoraciones</h3>
						<table id="tabla">
							<tr>
								<td width="20%" class="titulo">Usuario</td>
								<td width="10%" class="titulo">Nota</td>
								<td width="70%" class="titulo">Raz&oacute;n</td>
							</tr>
						<%
						if (art.hasRates()){
							Iterator it = rates.getRates().iterator();
							while (it.hasNext()){
								Rate r = (Rate)it.next();
							%>
							
							
								<tr>
									<td class="contenido"><% out.print(r.getUser().getNick()); %></td>
									<td class="contenido"><% out.print(r.getRate()) ;%></td>
									<td class="contenido"><% out.print(r.getReason()); %></td>
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