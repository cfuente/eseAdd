/**
 * 
 */

function validarFormularioLogin() {
	var error=false;
	var codigoError="";
	var usuario = document.getElementById('usuario').value;
	if (validarVacio(usuario)) {
		error = true;
		codigoError+="El usuario no puede estar vacio";
	}
	var password = document.getElementById('password').value;
	if (validarVacio(password)) {
		if(error){
			codigoError+="<br/>";
		}
		error = true;
		codigoError+="La contrase&ntilde;a no puede estar vacia";
	}
	if (!error) {
		document.getElementById("formLogin").submit();
	}else{
		document.getElementById('error').innerHTML=codigoError;
	}
}
function validarFormularioEmpresa() {
	var error = false;
	
	var nombre = document.getElementById('nombre').value;
	if (validarVacio(nombre)) {
		error = true;
		document.getElementById('errorNombre').innerHTML="El nombre no puede estar vacio"
	}
	var documento = document.getElementById('documento').value;
	if (validarVacio(documento)) {
		error = true;
		document.getElementById('errorDocumento').innerHTML="El documento no puede estar vacio"
	}
	var numero = document.getElementById('numero').value;
	if (!validarVacio(numero)) {
		if(isNaN(numero)){
			document.getElementById('errorNumero').innerHTML="El numero tiene que ser numerico"
			error = true;
		}
	}
	
	var planta = document.getElementById('planta').value;
	if (!validarVacio(planta)) {
		if(isNaN(planta)){
			document.getElementById('errorPlanta').innerHTML="La planta tiene que ser numerica"
			error = true;
		}
	}
	if (!error) {
		document.getElementById("regCompania").action="registerCompania.do"
		document.getElementById("regCompania").submit();
	}
}
function validarFormularioCliente() {

	var error = false;
	var todosLosDatos = true;
	var usuario = document.getElementById('usuario').value;
	var password = document.getElementById('password').value;
	var passwordConfirm = document.getElementById('passwordConfirm').value;

	if((!validarVacio(usuario) && validarVacio(password)) ||(validarVacio(usuario) && !validarVacio(password))){
		error=true;
		alert("error");
	}
	if (todosLosDatos && password !== passwordConfirm) {
		error = true;
		document.getElementById('error').innerHTML="Las contrase&ntilde;as tienen que ser iguales"
	}
	var nombre = document.getElementById('nombre').value;
	if (validarVacio(nombre)) {
		document.getElementById('errorNombre').innerHTML="El nombre no puede estar vacio"
		error = true;
	}
	var apellido = document.getElementById('apellido').value;
	if (validarVacio(apellido)) {
		document.getElementById('errorApellido').innerHTML="El apellido no puede estar vacio"
		error = true;
	}
	var fechaNacimiento = document.getElementById('fechaNacimiento').value;
	if (validarVacio(fechaNacimiento)) {
		document.getElementById('errorFecha').innerHTML="La fecha de nacimiento no puede estar vacia"
		error = true;
	}else if(!fechaCorrecta(fechaNacimiento)){
		document.getElementById('errorFecha').innerHTML="La fecha de nacimiento es incorrecta"
		error = true;
		
	}
	var documento = document.getElementById('documento').value;
	if (validarVacio(documento)) {
		error = true;
		document.getElementById('errorDocumento').innerHTML="El documento no puede estar vacio"
	}else if(!documentoCorrecto(documento)){
		document.getElementById('errorDocumento').innerHTML="El documento es incorrecto"
		error = true;
	}
	
	var numero = document.getElementById('numero').value;
	if (!validarVacio(numero)) {
		if(isNaN(numero)){
			document.getElementById('errorNumero').innerHTML="El numero tiene que ser numerico"
			error = true;
		}
	}
	
	var planta = document.getElementById('planta').value;
	if (!validarVacio(planta)) {
		if(isNaN(planta)){
			document.getElementById('errorPlanta').innerHTML="La planta tiene que ser numerica"
			error = true;
		}
	}
	
	
	if (!error) {
		document.getElementById("reg").action="registrousuario.do"
		document.getElementById("reg").submit();
	}

}

function validarVacio(string) {
	if (string == "" || string == null) {
		return true
	} else {
		return false;
	}
}

function fechaCorrecta( cFecha ) {

	// Comprobación de longitud
	if ( cFecha.length < 6 || cFecha.length > 10 ) {
		return false;
	}

	// Buscar primer separador de la fecha
	var nSeparador1 = cFecha.indexOf( "/", 0 )
	if ( nSeparador1 < 1 || nSeparador1 > 2 ) {
		return false;
	}

	// Obtener el día
	var cDia = cFecha.substring(0, nSeparador1)

	// Buscar el segundo separador de la fecha
	var nSeparador2 = cFecha.indexOf( "/", nSeparador1+1 )
	if ( nSeparador2 < nSeparador1+2 || nSeparador2 > nSeparador1+3 ) {
		return false;
	}

	// Obtener el mes
	var cMes = cFecha.substring(nSeparador1+1, nSeparador2)

	// Obtener el año
	var cYear = cFecha.substring(nSeparador2+1, cFecha.length)

	// Normalización del año
	if ( cYear.length == 1 || cYear.length == 3 ) {
		return false;
	}
	if ( cYear.length == 2 ) {
		if ( parseInt( cYear ) > 29 ) {
			cYear = "19" + cYear
		} else {
			cYear = "20" + cYear
		}
	}

	// Comprobación del mes
	if ( cMes < 1 || cMes >12 ) {
		return false;
	}

	// Comprobación básica del día
	if ( cDia < 1 || cDia >31) {
		return false;
	}

	// Comprobación del día en los meses con 30 días
	if ( (cMes==4 || cMes==6 || cMes==9 || cMes==11) && (cDia == 31 ) ) {
		return false;
	}

	// Comprobación del mes de febrero teniendo en cuenta los bisiestos
	if ( cMes==2 ){
		if ( cDia > 29 ) {
			return false;
		}
		if ( ( cYear / 4 == parseInt( cYear / 4 ) )
		     && ! ( ( cYear / 100 == parseInt( cYear / 100 ) )
                         && ( cYear / 400 != parseInt( cYear / 400 ) ) ) ) {
			var bBisiesto = true;
		} else {
			var bBisiesto = false;
		}
		if ( ! bBisiesto && cDia==29 ) {
			return false;
		}
	}

	// Normalización del Día
	if ( cDia.length == 1 ) { cDia = "0" + cDia; }

	// Normalización del mes
	if ( cMes.length == 1 ) { cMes = "0" + cMes; }

	// Retorno de la fecha normalizada
	return true;

}
function documentoCorrecto(documento){
	var numero
	  var letr
	  var letra
	  var expresion_regular_dni
	 
	  expresion_regular_dni = /^\d{8}[a-zA-Z]$/;
	 
	  if(expresion_regular_dni.test (documento) == true){
	     numero = documento.substr(0,documento.length-1);
	     letr = documento.substr(documento.length-1,1);
	     numero = numero % 23;
	     letra='TRWAGMYFPDXBNJZSQVHLCKET';
	     letra=letra.substring(numero,numero+1);
	    if (letra!=letr.toUpperCase()) {
	      return false
	     }else{
	       return true;
	     }
	  }else{
	    return false;
	   }
}