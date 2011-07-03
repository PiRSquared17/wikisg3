<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
  <title>US Virtual</title>
	<link rel="stylesheet" type="text/css" href="style/style.css" />
</head>
<div id="container">

<div id="top">
<jsp:include  page="head.jsp"/>
<span style="float: right">
    <a href="?lang=en">en</a>
    |
    <a href="?lang=es">es</a>
</span>
</div>


<div id="content">
<c:url var="loginUrl" value="/store/login"></c:url>
<form:form method="POST" action="${loginUrl}" modelAttribute="loginForm">
		<div id="arribaDcha">
		 <fieldset>
		 <legend  style="font-family: Arial,sans-serif; font-size: 18px; color: #660000" align="center"><spring:message code="label.userdata"/></legend>

		<table summary="Identificaci�n de Usuario" align="center">

		 <tr>
		 <td>		 <form:label path="userName"><spring:message code="label.user"/>:	</form:label>	 </td>
		 <td>		 <form:input path="userName"/> </td>
		 </tr>
		
		 <tr>
		 <td>		 <form:label path="password"><spring:message code="label.pass"/>:		</form:label>	 </td>
		 <td>		 <form:input path="password" type="password"/> </td>
		 </tr>
		 
		 <tr>
		 <td colspan="3" align="center"><input type="submit" value="<spring:message code="label.login"/>"/></td>
		 </tr>
		 
		 </table>		 
 		 </fieldset>
 		 </div> <!--cierra arribaDcha -->
</form:form>

</div> <!-- cierra content -->

</div> <!-- cierra container -->
</html>