<%@ page language="java" import="pos.domain.*,java.util.*" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table summary ="Listado de Productos" cellSpacing="1" cellPadding="6" width="770" align="center" border="0">
	<tr valign ="middle" align="center">
		<td id = "colchones" colspan="6"><b><spring:message code="label.order"/></b></td>
	</tr>
	<tr valign =" middle" align="center" id="cabecera">
		<td>&nbsp;</td><td><spring:message code="label.description"/></td><td><spring:message code="label.quantity"/></><td><spring:message code="label.price"/></td><td><spring:message code="label.total"/></td><td><spring:message code="label.remove"/></td>
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
				<c:url var="deleteUrl" value="/store/eliminar" />
				<td> <a href="${deleteUrl}?pid=<%=pid%>">
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
			<td colspan='6'><spring:message code="label.noproducts"/></td>
			</tr>
        <%}
%>

			<tr align="center" id="productos">
				<td colspan='5' align="right">	<b><spring:message code="label.totalcost"/></b></td>
				<td> <%=importeTotal%> €</td>
			</tr>

	<%if(!request.getParameter("botones").equals("0")){%>
			<tr align="center" id="productos">
				<td colspan='3'>
				<c:url var="productosUrl" value="/store/productos" />
				<a href="${productosUrl}"><img src='img/seguir.jpg'></a>
				</td>
				<td colspan='3'>
				<c:url var="confirmarUrl" value="/store/confirmar" />
				<a href="${confirmarUrl}"><img src='img/confirmar.jpg'></a>
				</td>
			</tr>
<%}
%>
</table>
