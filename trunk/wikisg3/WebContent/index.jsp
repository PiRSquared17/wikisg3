<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="isg3.article.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<link type="text/css" href="./estilo.css" rel="stylesheet"></link>
		<title>Untitled Document</title>
	</head>
	<body>
		<div id="contenedor">
			
			<div id="cabecera">
					
			</div>
				por aqui ira una imagen que se insertara luego sdfsfsdsdffffdfffdfasfdf
			<div id="contenido">
				<div id="menuizq">
					<div id="inicio">
						<ul>
							<li>Portada</li>
							<li>Categorias</li>
							<li>Art&iacute;culos</li>
							<li>Actualidad</li>
							<li>Ayuda</li>
						</ul>
					</div>
					<div id="usuario">
						<!-- Aquí irá el login y los datos del usuario -->
					</div>
					<div id="buscador">
						
					</div>
				</div>
				<div id="principal">
					<div id="artPrincipal">
						<div id="tituloArt">
							<%
								Wiki w = Wiki.getInstance();
								List l = w.getListArt();
								Iterator it = l.iterator();
								Article a = (Article)it.next();
								String s = a.getTitle();
								out.println(s);
								
							%>
						</div>
						<div id="cuerpoArt">
							<%
								out.println(a.getContent());
							%>
						</div>
					</div>
					<div id="ultArticulos">
						
					</div>
				</div>
				
				<div id="menuder">
					
				</div>	
			</div>
			
			<div id="pie">
				
			</div>
			
		</div>
		
	</body>
</html>
>