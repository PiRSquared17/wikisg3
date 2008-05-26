<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,isg3.operations.*,isg3.article.*" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="./estilo.css" rel="stylesheet"></link>
<script type="text/javascript" src="./javascript/validaciones.js" ></script>
<script type="text/javascript">
	
function valoracionValida(){
	var b = true;
	if(!valida(3,"rate")){
		b = false;
		alert("Por favor, elija una nota");
	}
	return b;
}

</script>
<title>WikiMedia</title>
</head>
<body>
	<%
		String title = (String)request.getParameter("id");
		IWikiOperations op = new WikiOperations();
		String user = (String)request.getSession(false).getAttribute("user");
		Rate rate = op.getRate(title,user);
		
	%>
	<div id="contenedor">
		<jsp:include  page="head.jsp"/>
		
		<div id="contenido">
			<jsp:include  page="menu.jsp"/>
			<div id="principal">
			
				<div id="tituloArt">
						<h3><% out.print(title); %></h3>
				</div>
				<div id="rating">
					<form action="./FrontController?res=S3l" method="post" onsubmit="return valoracionValida();">
						<textarea name="reason" id="reason" rows="20" cols="50"><%if (rate != null){out.print(rate.getReason());}%></textarea>
						<br>
						Nota: &nbsp;&nbsp;
						<select name="rate" id="rate">
							<option <% if(rate == null){out.print("selected");} %> value="">-</option>
							<option <% if ((rate != null) && (rate.getRate() == 0)){out.print("selected");} %> value="0">0</option>
							<option <% if ((rate != null) && (rate.getRate() == 1)){out.print("selected");} %> value="1">1</option>
							<option <% if ((rate != null) && (rate.getRate() == 2)){out.print("selected");} %> value="2">2</option>
							<option <% if ((rate != null) && (rate.getRate() == 3)){out.print("selected");} %> value="3">3</option>
							<option <% if ((rate != null) && (rate.getRate() == 4)){out.print("selected");} %> value="4">4</option>
							<option <% if ((rate != null) && (rate.getRate() == 5)){out.print("selected");} %> value="5">5</option>
						</select>
						<input type="hidden" name="title" value="<%out.print(title); %>" >
						<input type="hidden" name="user" value="<%out.print(user); %>" >
						<input class="boton" type="submit" value="Aceptar"/>
							
							
					</form>
				</div>
			
			</div>
		</div>
	</div>
</body>
</html>