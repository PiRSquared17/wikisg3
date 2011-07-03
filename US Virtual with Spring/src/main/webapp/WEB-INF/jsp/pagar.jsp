<%@ page language="java" import="pos.domain.*,java.util.*,java.security.SecureRandom" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title><spring:message code="label.products"/></title>
<link rel="stylesheet" type="text/css" href="style/style.css" />
</head>
<body>
<%!
//función de validación simple que permite mirar si se han rellenado todos los campos
private boolean validar(Map elements)
{
	boolean valido = true;
	if(elements != null)
	{
	Collection parameters = elements.values();
	Iterator iter = parameters.iterator();
	
	while (iter.hasNext() && valido) {
		String[] element = (String[]) iter.next();
		for (int i = 0; i < element.length; i++) {
			if(! (element[i].length() > 0)){
				valido = false;
			}
		}
	}
	}
	return valido;
}
%>

<%

String mensaje = new String();

// me va a permitir introductir una orden
IPOSProcessor pos = new POSProcessor();
//esta es la orden que voy a incluir
Order order = (Order)session.getAttribute("session.cart");

// si hay una orden y al menos tiene un producto
if(order != null)
{
		//saco un mapa con los parametros del formulario
		Map datosForm = request.getParameterMap();

		//datos relativos a la tarjeta de crédito
		String holderForm = request.getParameter("holder");
		String typeForm = request.getParameter("type");
		
		String numberForm = request.getParameter("number");
		String monthForm = request.getParameter("month");
		String yearForm = request.getParameter("year");
		
		// datos relativos a la dirección
		
		String receiverForm = request.getParameter("receiver");
		String streetForm = request.getParameter("street");
		String cityForm = request.getParameter("city");
		String zipcodeForm = request.getParameter("zipcode");
		String emailForm = request.getParameter("email");
		String phoneForm = request.getParameter("phone");
		String faxForm = request.getParameter("fax");
		
		//valido los datos que me han pasado
		
		
		if(validar(datosForm))
		{

			/*CreditCard ccard = new CreditCard();
			ccard.setHolder(holderForm);
			ccard.setNumber(numberForm);
			ccard.setMonth(Integer.parseInt(monthForm));
			ccard.setYear(Integer.parseInt(yearForm));
			
			Address address = new Address();
			address.setCity(cityForm);
			address.setEmail(emailForm);
			address.setFax(faxForm);
			address.setName(receiverForm);
			address.setPhone(phoneForm);
			address.setStreet(streetForm);
			address.setZipcode(Integer.parseInt(zipcodeForm));
			
			order.setDeliverto(address);
			order.setPayment(ccard);
			order.setTimeplaced(new Date());
			order.setPlacedbyCustomer((String)session.getAttribute("session.user"));
			SecureRandom random = new SecureRandom();*/
			
			//pos.placeOrder(order);
			
			/*DocGenerator dg = new DocGenerator();
			byte[] res = dg.generateDoc(numberForm,holderForm,monthForm);
			response.setContentType("application/pdf");
			response.getOutputStream().write(res);*/
			mensaje = new String("SU ORDEN HA SIDO PROCESADA CON ÉXITO");
		}
		else
		{
			mensaje = new String("FALTAN CAMPOS POR RELLENAR");
		}

}
else// no tiene orden o no tiene producto
{
		mensaje = new String ("NO TIENE NINGÚN ELEMENTO SELECCIONADO EN SU PEDIDO");
}


%>


<div id="top">
<jsp:include  page="head.jsp"/>
</div>
<div id="content">
<p>
<%=mensaje%>
</p>

</div>




</body>
</html>
