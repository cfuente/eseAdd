<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
<title>Registro</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- <link rel="stylesheet" type="text/css" -->
<%-- 	href="<c:url value="/static/resources/css/screen.css"/>" /> --%>


</head>

<body>
	<div id="container">
		<div class="dualbrand">
			<%-- 			<img src="<c:url value="/static/resources/gfx/dualbrand_logo.png"/>" /> --%>
		</div>
		<div id="content">
			<h1>Registro</h1>

			<!-- 			<div> -->
			<!-- 				<p>You have successfully deployed a Spring MVC web application.</p> -->
			<!-- 				<h3>Your application can run on:</h3> -->
			<!-- 				<img -->
			<%-- 					src="<c:url value="/static/resources/gfx/dualbrand_as7eap.png"/>" /> --%>
			<!-- 			</div> -->

			<form:form modelAttribute="formularioUser" id="reg" method="POST">
				<table>
					<tbody>
						<tr>
							<td><form:label path="usuario">Usuario:</form:label></td>
							<td><form:input id="usuario" path="usuario" maxlength="20"
									placeholder="Usuario" /></td>
							<td id="errorUsuario">${errorUsuario}</td>
						</tr>
						<tr>
							<td><form:label path="password">Contraseña:</form:label></td>
							<td><form:password id="password" path="password" 
									placeholder="Contraseña" /></td>
							<td id="errorPassword">${errorPassword}</td>
						</tr>
						<tr>
							<td><form:label path="passwordConfirm">Confirmar contraseña:</form:label></td>
							<td><form:password id="passwordConfirm"
									path="passwordConfirm" placeholder="Confirmar contraseña" /></td>
							<td id="errorPasswordConfirm">${errorPasswordConfirm}</td>
						</tr>
						<tr>
							<td id="error">${error}</td>
						</tr>
						<tr>
							<td><form:label path="nombre">Nombre:</form:label></td>
							<td><form:input id="nombre" path="nombre" maxlength="30"
									placeholder="Nombre" /></td>
							<td id="errorNombre">${errorNombre}</td>
						</tr>
						<tr>
							<td><form:label path="apellido">Primer apellido:</form:label></td>
							<td><form:input path="apellido" id="apellido" maxlength="30"
									placeholder="Primer apellido" /></td>
							<td id="errorApellido">${errorApellido}</td>
						</tr>
						<tr>
							<td><form:label path="apellido2">Segundo apellido:</form:label></td>
							<td><form:input path="apellido2" id="apellido2" maxlength="30"
									placeholder="Segundo apellido" /></td>
						</tr>
						<tr>
							<td><form:label path="documento">Documento:</form:label></td>
							<td><form:input path="documento" id="documento" maxlength="14"
									placeholder="Documento" /></td>
							<td id="errorDocumento">${errorDocumento}</td>
						</tr>
						<tr>
							<td><form:label path="fechaNacimiento">Fecha de Nacimiento(dd/mm/aaaa):</form:label></td>
							<td><form:input path="fechaNacimiento" id="fechaNacimiento" maxlength="10"
									placeholder="Fecha nacimiento" /></td>


							<td id="errorFecha">${errorFecha}</td>
						</tr>
						<tr>
							<td><form:label path="tipoVia">Tipo via:</form:label></td>
							<td><form:input path="tipoVia" id="tipoVia" maxlength="10"
									placeholder="Tipo via" /></td>
						</tr>
						<tr>
							<td><form:label path="via">Via:</form:label></td>
							<td><form:input path="via" id="via" placeholder="Via" maxlength="30" /></td>
						</tr>
						<tr>
							<td><form:label path="numero">Numero:</form:label></td>
							<td><form:input path="numero" id="numero" 
									placeholder="Numero" /></td>
							<td id="errorNumero">${errorNumero}</td>
						</tr>
						<tr>
							<td><form:label path="planta">Planta:</form:label></td>
							<td><form:input path="planta" id="planta"
									placeholder="Planta" /></td>
							<td id="errorPlanta">${errorPlanta}</td>
						</tr>
						<tr>
							<td><form:label path="puerta">Puerta:</form:label></td>
							<td><form:input path="puerta" id="puerta" maxlength="2"
									placeholder="Puerta" /></td>
						</tr>
						<tr>
							<td><form:label path="idCompania">Compañia:</form:label></td>
							<td><form:select path="idCompania" id="idCompania">
									<form:option value="0">Selecciona uno:</form:option>
									<c:forEach items="${companias}" var="compania">
										<form:option value="${compania.idCompania}">${compania.nombre}</form:option>
									</c:forEach>
								</form:select></td>
						</tr>
						<tr>
							<td><form:label path="idCargo">Cargo:</form:label></td>
							<td><form:select path="idCargo" id="idCargo">
									<form:option value="0">Selecciona uno:</form:option>
									<c:forEach items="${cargos}" var="cargo">
										<form:option value="${cargo.idCargo}">${cargo.nombre}</form:option>
									</c:forEach>
								</form:select></td>
						</tr>
						<tr>
							<td><form:label path="licencia">Licencia:</form:label></td>
							<td><form:input path="licencia" id="licencia" 
									placeholder="Licencia" /></td>
						</tr>
						<tr>
							<td><form:label path="docEmpresa">Documento empresa:</form:label></td>
							<td><form:input path="docEmpresa" id="docEmpresa"
									placeholder="Documento empresa" /></td>
						</tr>
						<tr>
							<td><form:label path="email">Email:</form:label></td>
							<td><form:input path="email" id="email" maxlength="50"
									placeholder="Email" /></td>
						</tr>


					</tbody>
				</table>
				<table>
					<tr>

						<td><input type="button"
							onclick="validarFormularioCliente();" value="Register"
							class="register" /></td>

						<td><a href="cancelar.do"><input type="button"
								value="Cancelar" /></a></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
	<script src="/resources/js/script.js" type="text/javascript"></script>
</body>
</html>
