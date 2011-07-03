<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<table summary="forma de pago">
  	<tr>
	 		 <td style="font-family: Arial,sans-serif; font-size: 18px; color: #660000;" align="left"><spring:message code="label.address"/></td> 
		</tr>
		
		 <tr>
		 <td>		 <form:label path="address.name"><spring:message code="label.name"/>:	</form:label>	 </td>
		 <td>		 <form:input path="address.name"/> </td>
		 </tr>
		
		 <tr>
		 <td>		 <form:label path="address.street"><spring:message code="label.street"/>:	</form:label>	 </td>
		 <td>		 <form:input path="address.street"/> </td>
		 </tr>

		 <tr>
		 <td>		 <form:label path="address.city"><spring:message code="label.city"/>:	</form:label>	 </td>
		 <td>		 <form:input path="address.city"/> </td>
		 </tr>

		 <tr>
		 <td>		 <form:label path="address.zipcode"><spring:message code="label.postal"/>:	</form:label>	 </td>
		 <td>		 <form:input path="address.zipcode"/> </td>
		 </tr>

		 <tr>
		 <td>		 <form:label path="address.email"><spring:message code="label.email"/>:	</form:label>	 </td>
		 <td>		 <form:input path="address.email"/> </td>
		 </tr>

		 <tr>
		 <td>		 <form:label path="address.phone"><spring:message code="label.telephone"/>:</form:label>		 </td>
		 <td>		 <form:input path="address.phone"/> </td>
		 </tr>
	 
		 <tr>
		 <td>		 <form:label path="address.fax"><spring:message code="label.fax"/>:	</form:label>	 </td>
		 <td>		 <form:input path="address.fax"/> </td>
		 </tr>

 		 <tr>
		 <td colspan="3" align="center"><input type="submit" value="<spring:message code="label.buy"/>"/></td>
		 </tr>

		 </table>		 
