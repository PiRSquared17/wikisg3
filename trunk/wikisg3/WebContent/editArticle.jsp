<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,isg3.operations.*,isg3.article.*" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="./estilo.css" rel="stylesheet"></link>
<script type="text/javascript" src="./javascript/validaciones.js" ></script>
<script type="text/javascript">
	
function articuloValido(){
	var b = true;
	if(!valida(3,"cat")){
		b = false;
		alert("Por favor, elija una categoria");
	}
	return b;
}

</script>
<title>Insert title here</title>
</head>
<body>
	<%
	String id = (String)request.getParameter("id");
	IWikiOperations op = new WikiOperations();
	Article art = null;
	if (id != null){
		art = op.getArticle(id);
	}
	Category c = null;
	
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
						<form action="./FrontController?res=S2l&id=<%out.print(id); %>" method="post" onsubmit="return articuloValido();">
							<textarea name="content" id="content" rows="20" cols="50">
								<%
								if (art != null){
									out.print(art.getContent());
									c = art.getCat();
								}
								
								%>
							</textarea>
							<select name="cat" id="cat">
								<option <%if (c==null){out.print("selected");} %> value="-">-</option>
								<option <%if (c!=null && c.getName().equals("Deportes")){out.print("selected");} %> value="Deportes">Deportes</option>
								<option <%if (c!=null && c.getName().equals("Ciencia")){out.print("selected");} %> value="Ciencia">Ciencia</option>
								<option <%if (c!=null && c.getName().equals("Sociedad")){out.print("selected");} %> value="Sociedad">Sociedad</option>
								<option <%if (c!=null && c.getName().equals("Historia")){out.print("selected");} %> value="Historia">Historia</option>
								<option <%if (c!=null && c.getName().equals("Cine")){out.print("selected");} %> value="Cine">Cine</option>
								<option <%if (c!=null && c.getName().equals("Tecnologias")){out.print("selected");} %> value="Tecnologia">Tecnologias</option>
								<option <%if (c!=null && c.getName().equals("Sucesos")){out.print("selected");} %> value="Sucesos">Sucesos</option>
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