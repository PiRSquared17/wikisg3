<%@ page language="java" import="pos.domain.*,java.util.*" %>

<table summary ="Listado de Productos" cellSpacing="1" cellPadding="6" width="770" align="center" border="0">
	<tr valign ="middle" align="center">
		<td id = "colchones" colspan="6"><b>SU PEDIDO</b></td>
	</tr>
	<tr valign =" middle" align="center" id="cabecera">
		<td>&nbsp;</td><td>Descripción</td><td>Cantidad</><td>Precio</td><td>Total</td><td>Eliminar</td>
	</tr>
<%
		Order sessionCart = (Order)session.getAttribute("session.cart");

        int importeTotal = 0;
		if(sessionCart != null) 
		{
        Collection litems = sessionCart.getDetails();
        Iterator li = litems.iterator();
        while (li.hasNext()) {
			Detail detailSession= (Detail) li.next();
			Product p = detailSession.getProduct();
			String description = p.getDescription();
			int amount = detailSession.getQuantity();
			int price = p.getPrice();
			String pid = p.getProductID();
			int	total = price*amount;
			
%>
			<tr align="center" id="productos">
				<td>--</td>	<td> <%=description%> </td>	<td> <%=amount%> </td><td> <%=price%>€</td>	<td> <%=total%>€</td>
				<td> <a href="FrontController?res=eliminar.jsp?pid=<%=pid%>">
				     <img src='img/eliminar.jpg'></a>
			    </td>
				</tr>
<%
		importeTotal+=total;
		}
        }
        else
        {%>
			<tr align="center" id="productos">
			<td colspan='6'>NO HAY PRODUCTOS</td>
			</tr>
        <%}
%>

			<tr align="center" id="productos">
				<td colspan='5' align="right">	<b>Importe Total</b></td>
				<td> <%=importeTotal%> €</td>
			</tr>

	<%if(!request.getParameter("botones").equals("0")){%>
			<tr align="center" id="productos">
				<td colspan='3'>
				<a href="FrontController?res=productos.jsp"><img src='img/seguir.jpg'></a>
				</td>
				<td colspan='3'>
				<a href="FrontController?res=confirmar.jsp"><img src='img/confirmar.jpg'></a>
				</td>
			</tr>
<%}
%>
</table>
