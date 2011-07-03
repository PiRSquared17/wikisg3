<%@ page language="java" import="pos.domain.*,java.util.*" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table summary ="Listado de Productos" cellSpacing="1" cellPadding="6" width="770" align="center" border="0">
	<tr valign ="middle" align="center">
		<td id = "colchones" colspan="6"><b><spring:message code="label.order"/></b></td>
	</tr>
	<tr valign ="middle" align="center" id="cabecera">
		<td>&nbsp;</td><td><spring:message code="label.description"/></td><td><spring:message code="label.quantity"/></><td><spring:message code="label.price"/></td><td><spring:message code="label.total"/></td><td><spring:message code="label.remove"/></td>
	</tr>
	
	<c:if test="${!empty order.details}">
	<c:forEach items="${order.details}" var="detail">
		<tr align="center" id="productos">
				<td>--</td>	<td> <c:out value="${detail.product.description}"/> </td>	<td> <c:out value="${detail.quantity}"/> </td><td> <c:out value="${detail.product.price}"/></td>	<td> <c:out value="${detail.total}"/>€</td>
				<c:url var="deleteUrl" value="/store/eliminar?pid=${detail.product.id}" />
				<td> <a href="${deleteUrl}">
				     <img src='http://findicons.com/files/icons/1620/crystal_project/32/button_cancel.png'></a>
			    </td>
				</tr>
	</c:forEach>
	<tr align="center" id="productos">
				<td colspan='5' align="right">	<b><spring:message code="label.totalcost"/></b></td>
				<td> <c:out value="${order.total}"/> €</td>
			</tr>
	</c:if>
	<c:if test="${empty order.details}">
		<tr align="center" id="productos">
			<td colspan='6'><spring:message code="label.noproducts"/></td>
			</tr>
	</c:if>
	<c:if  test="${botones != 0}">
		<tr align="center" id="productos">
				<td colspan='3'>
				<c:url var="productosUrl" value="/store/productos" />
				<a href="${productosUrl}"><spring:message code="label.products"/></a>
				</td>
				<td colspan='3'>
				<c:url var="confirmarUrl" value="/store/confirmar" />
				<a href="${confirmarUrl}"><spring:message code="label.shipping"/></a>
				</td>
			</tr>
	</c:if>

</table>
