<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<table summary="forma de pago">
		 <tr>
		  		 <td style="font-family: Arial,sans-serif; font-size: 18px; color: #660000;" align="left"><spring:message code="label.datapayment"/></td> 
		</tr>

		 <tr>
		 <td>		 <form:label path="creditCard.number"><spring:message code="label.card"/>:	</form:label>	 </td>
		 <td>		 <form:input path="creditCard.number" /> </td>
		 </tr>
		
		 <tr>
		 <td>		 <form:label path="creditCard.holder"><spring:message code="label.holder"/>:	</form:label>	 </td>
		 <td>		 <form:input path="creditCard.holder"/> </td>
		 </tr>

		 <tr><!-- por aqui podria fallar, cuidado. un solo label y dos input -->
		 <td>		 <form:label path="creditCard.month"><spring:message code="label.expiration"/>:	</form:label>	 </td>
		 <td>		 <form:input path="creditCard.month" size="2"/> <form:input path="creditCard.year" size="2"/></td>
		 </tr>
		 </table>		 
