<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,isg3.operations.*,isg3.article.*" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="./estilo.css" rel="stylesheet"></link>
<script type="text/javascript" src="./javascript/validaciones.js" ></script>
<script type="text/javascript">
	
function mensajeValido(){
	var b = true;
	if(!valida(1,"to")){
		b = false;
		alert("Por favor, escriba el nick de un destinatario");
	}
	return b;
}

</script>
<title>WikiMedia: Nuevo Mensaje</title>
</head>
<body>
	<div id="contenedor">
		<jsp:include  page="head.jsp"/>
		
		<div id="contenido">
			<jsp:include  page="menu.jsp"/>
			<div id="principal">
			
			<%
			String b = request.getParameter("error");
			if (b != null){
				if (b.equals("true")){
					out.print("El mensaje no ha podido ser enviado. Revise el destinatario");
				}
			}
			%>
			
			<form action="./FrontController?res=S10l" method="post" onsubmit="return mensajeValido();">
				<table>
					
					<tr>
						<td>Destino:</td>
						<td> <input type="text" id="to" name="to" size="20"> </td>
					</tr>
					
					<tr>
						<td>Asunto:</td>
						<td> <input type="text" id="subject" name="subject" size="20"> </td>
					</tr>
					
					<tr>
						<td valign="top"><br>Contenido:</td>
						<td> <textarea name="content" id="content" rows="8" cols="20"> </textarea></td>
					</tr>

					<tr>
						<td><input class="boton" type="submit" value="Enviar"></td>
					</tr>
				</table>
			</form>
			
			</div>
		</div>
	</div>
</body>
</html>