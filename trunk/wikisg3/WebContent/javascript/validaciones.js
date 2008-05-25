/**
 * @author jesus
 */

/**
 * Función para validar el contenido del campo de un formulario.
 * Existen 3 tipos, que se identifican por el número (del 1 al 6).
 * Tipo 1: validación para asegurarnos de que el campo tiene contenido utilizable,
 * es decir, contiene algo distinto a espacios en blanco.
 * Tipo 2: validación para asegurarnos de que se insertó un número. Utiliza
 * también la validación anterior.
 * Tipo 3: validación para asegurarnos que se haya escogido un elemento
 * de una lista desplegable, y que éste no sea el elemento inicial.
 * Tipo 4: validamos que una cadena tenga formato de fecha: DD-MM-AAAA.
 * Tipo 5: validamos una dirección IP.
 * Tipo 6: validamos una dirección ethernet.
 * 
 * @param {int} tipo el tipo de validación que queremos realizar. 
 * @param {String} idCampo
 * El id del campo de formulario que queremos validar
 * @return {boolean} true si la validación fue correcta, o false si no lo fue
 * (o bien el ID del elemento o el tipo de validación pasados a la función
 * no eran correctos).
 * 
 */
function valida(tipo,idCampo){

	//alert("hola, estamos en la funcion valida");
	//document.getElementById(idCampo)
	var existeId = document.getElementById(idCampo);
	//comprobamos si existe el elemento con el id pasado
	if (existeId != null){
		valor = document.getElementById(idCampo).value;
		//alert("El id: "+idCampo+" es valido");
	}
	else{
		//alert("El id:" +idCampo+" no es valido");
		return false;
	}
	
	var valido = true;
	var valor = document.getElementById(idCampo).value;
	if ((tipo == 1)){//validacion tipo 1
	//que el campo sea distinto de null, su longitud mayor que 0
	//y no contenga solo espacios en blanco
		if( valor == null || valor.length == 0 || /^\s+$/.test(valor) ) {
 			valido =  false;
		}
	}
	else if (tipo == 2){//validacion de tipo 2
		//que el campo sea distinto de null, su longitud mayor que 0,
		//no contenga solo espacios en blanco y sea numérico
		if(isNaN(valor) || valor == null || valor.length == 0) {
 			valido =  false;
		}
	}
	else if (tipo == 3){//validacion tipo 3, para listas desplegables
		var indice = document.getElementById(idCampo).selectedIndex;
		//ha de estar seleccionado algún elemento que no sea el inicial
		if ((indice == null) || (indice == 0)){
			valido = false;
		}
	}
	else if (tipo == 4){//validación tipo 4, para fechas
		valido = validaFecha(valor);
	}
	else if (tipo == 5){//validación tipo 5, para las direcciones IP
		valido = validacionRecursivaIP(valor,3);
	}
	else if (tipo == 6){//validación tipo 6, para las direcciones Eth
		valido = validacionRecursivaEth(valor,5);
	}
	else{
		valido = false;
	}
	
	
	
	return valido;
}

/**
 * Función utilizada para validar el formato de una dirección ip,
 * siendo éste el siguiente: X.X.X.X
 * Donde X es un número entero del 0 al 255, yendo un punto
 * como separación entre cada par.
 * @param {String} id id del formulario donde está la dirección ip.
 * @return {boolean} true si la dirección es válida, false
 * en caso contrario.
 */
function validaIP(id){
	var b;
	//alert("Esto no ha petado :] 1");
	var existeId = document.getElementById(id);
	//comprobamos si existe el elemento con el id pasado
	if (existeId != null){
		valor = document.getElementById(id).value;
		b = validacionRecursivaIP(valor,3);
		//alert("Esto no ha petado :] 2");
		//alert("¿La ip es valida?: "+b);
	}else{
		b = false;
	}
	return b;
}

/**
 * Función auxiliar para validar la IP de forma recursiva.
 * Es utilizada por la función validaIP(id).
 * Busca un punto en texto. Si lo encuentra, separa la cadena en 2:
 * lo anterior (con lo que hace la llamada recursiva) y 
 * lo posterior (comprueba que esté entre 0 y 255) al punto.
 * @param {String} texto la dirección IP.
 * @param {int} iteracion iteraciones que nos quedan
 * @return {boolean} true si la dirección es válida, false en otro caso
 */
function validacionRecursivaIP(texto, iteracion){
	
	var correcta;
	
	if (iteracion == 0){//caso base
		//alert("Estamos en el caso base");
		if ((texto.lastIndexOf(".") < 0) && texto.length > 0){
			//ya no pueden quedan puntos en la IP
			val = Number(texto);
			//alert("Soy iteracion "+iteracion+" y mi valor es "+val);
			if (val >= 0 && val <= 255){
				correcta = true;
			}
			else{
				correcta = false;
			}
		}
		else{
			correcta = false;
		}
	}
	else{//quedan aún iteraciones
		//alert("Aun quedan iteraciones");
		indice = texto.lastIndexOf(".");
		if (indice < 0){
			correcta = false;
		}
		else{//queda algún punto
			inicio = texto.substring(0,indice);
			res = validacionRecursivaIP(inicio, iteracion - 1);
			indice = texto.lastIndexOf(".");
			fin = texto.substring(indice+1);
			if (res == true && fin.length > 0){
				val = Number(fin);
				//alert("Soy iteracion "+iteracion+" y mi valor es "+val);
				if (val >= 0 && val <= 255){
					correcta = true;
				}
				else{
					correcta = false;
				}
			}
			else{
				correcta = false;
			}
		}
	}
	return correcta;
}

function validaEth(id){
	var b;
	//alert("Esto no ha petado :] 1");
	var existeId = document.getElementById(id);
	//comprobamos si existe el elemento con el id pasado
	if (existeId != null){
		valor = document.getElementById(id).value;
		b = validacionRecursivaEth(valor,5);
		//alert("Esto no ha petado :] 2");
		//alert("¿La eth es valida?: "+b);
	}else{
		b = false;
	}
	return b;
}

function validacionRecursivaEth(texto, iteracion){
	
	var correcta;
	
	if (iteracion == 0){//caso base
		//alert("Estamos en el caso base");
		if ((texto.lastIndexOf(":") < 0) && texto.length > 0){
			//ya no pueden quedar dos puntos en la MAC
			//val = Number(texto);
			//alert("Soy iteracion "+iteracion+" y mi valor es "+texto);
			if (texto.length == 2){
				c1 = caracteresPermitidos(texto.charAt(0),'eth');
				c2 = caracteresPermitidos(texto.charAt(1),'eth');
				if (c1 == true && c2 == true){
					correcta = true;
					//alert("peta");
				}
				else{
					correcta = false;
					//alert("no peta: "+texto.length+" "+c1+" "+c2);
				}
			}
		}
		else{
			correcta = false;
		}
	}
	else{//quedan aún iteraciones
		//alert("Aun quedan iteraciones");
		indice = texto.lastIndexOf(":");
		if (indice < 0){
			correcta = false;
		}
		else{//queda algún punto
			inicio = texto.substring(0,indice);
			res = validacionRecursivaEth(inicio, iteracion - 1);
			indice = texto.lastIndexOf(":");
			fin = texto.substring(indice+1);
			//alert(fin);
			if (res == true && fin.length > 0){
				//val = Number(fin);
				//alert("Soy iteracion "+iteracion+" y mi valor es "+fin);
				if (fin.length == 2){
					c1 = caracteresPermitidos(fin.charAt(0));
					c2 = caracteresPermitidos(fin.charAt(1));
					if (c1 == true && c2 == true){
						correcta = true;
					}
					else{
						correcta = false;
					}
				}
			}
			else{
				correcta = false;
			}
		}
	}
	return correcta;
}

/**
 * Función que dado un evento sobre un cuadro de texto de formulario, y un
 * tipo de caracteres, permitirá escribir en el cuadro únicamente ese
 * tipo de caracteres.
 * 
 * @param {Object} elEvento objeto de tipo event que representa al evento sobre
 * el que vamos a actuar.
 * @param {String} tipo el tipo de caracteres que vamos a permitir escribir en
 * el cuadro de texto.
 * @return {boolean} true si permitimos escribir el caracter en el cuadro,
 * false en caso contrario.
 */
function permite(elEvento, tipo) {
  // Variables que definen los caracteres permitidos
  var numeros = "0123456789";
  var caracteres = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
  var numeros_caracteres = numeros + caracteres;
  // Seleccionar los caracteres a partir del parámetro de la función
  switch(tipo) {
    case 'num':
      permitidos = numeros;
      break;
    case 'car':
      permitidos = caracteres;
      break;
    case 'num_car':
      permitidos = numeros_caracteres;
      break;
	case 'ip':
		permitidos = numeros + ".";
		break;
	case 'eth':
		permitidos = numeros + "AaBbCcDdEeFf:";//hexadecimal
		break;
	case 'fecha':
		permitidos = numeros +"-/";
		break;
  }
  // Obtener la tecla pulsada
  var evento = elEvento || window.event;
  var codigoCaracter = evento.charCode || evento.keyCode;
  var caracter = String.fromCharCode(codigoCaracter);
  // Comprobar si la tecla pulsada se encuentra en los caracteres permitidos
  return permitidos.indexOf(caracter) != -1;
}

/**
 * Función que dado un caracter, nos dirá si está o no incluido en el tipo
 * que se le pasa como parámetro
 * 
 * @param {char} c el caracter a evaluar.
 * @param {String} tipo el conjunto de caracteres sobre el que
 * queremos mirar.
 * @return {boolean} true si el caracter se encuentra dentro
 * del conjunto.
 */
function caracteresPermitidos(c, tipo){
	// Variables que definen los caracteres permitidos
  var numeros = "0123456789";
  var caracteres = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
  var numeros_caracteres = numeros + caracteres;
  // Seleccionar los caracteres a partir del parámetro de la función
  switch(tipo) {
    case 'num':
      permitidos = numeros;
      break;
    case 'car':
      permitidos = caracteres;
      break;
    case 'num_car':
      permitidos = numeros_caracteres;
      break;
	case 'ip':
		permitidos = numeros + ".";
		break;
	case 'eth':
		permitidos = numeros + "AaBbCcDdEeFf:";//hexadecimal
		break;
	case 'fecha':
		permitidos = numeros +"-/";
		break;
  }
  return permitidos.indexOf(c)!=-1;
}

/**
 * Función que dada una cadena que representa una fecha,
 * comprueba que ésta sea correcta (formato DD-MM-AAAA, pudiendo
 * los días tomar valores entre 1 y 31, los meses entre 1 y 12,
 * y los años cualquier valor no negativo de 4 cifras)
 * @param {String} fecha una cadena con la fecha que queremos validar
 * @return {boolean} b true si la fecha es válida, false en caso contrario
 */
function validaFecha(fecha){
	var b = false;//el booleano a devolver
	//alert("Estamos en validar fecha, con fecha: "+fecha);
	var indice = fecha.lastIndexOf("-");
	
	if (indice != -1){
		var year = fecha.substring(indice + 1);
		//alert(year);
		var resto = fecha.substring(0,indice);
		indice = resto.lastIndexOf("-");
		if (indice != -1){
			var mes = resto.substring(indice + 1);
			//alert(mes);
			var dia = resto.substring(0,indice);
			//alert(dia);
			if ((dia.length <= 2) && (dia.length >= 1) && (mes.length <= 2)
				&& (mes.length >= 1) && (year.length == 4)){
					if (!isNaN(year) && !isNaN(mes) && !isNaN(dia)){
						mes = Number(mes);
						dia = Number(dia);
						if ((mes <= 12) && (mes > 0) && (dia <= 31) && (dia > 0)){
							//alert ("Lo logramos :D!");
							b = true;
						}
						
					}
				}
		}
	}
	
	return b;
	
}
