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

			<form:form commandName="newUser" id="reg" method="POST">

				<table>
					<tbody>
						<tr>
							<td><form:label path="usuario">Usuario:</form:label></td>
							<td><form:input path="usuario" placeholder="Usuario" /></td>
							<td>${errorUsuario}</td>
						</tr>
						<tr>
							<td><form:label path="password">Contraseña:</form:label></td>
							<td><form:password path="password" placeholder="Contraseña" /></td>
							<td>${errorPassword}</td>
						</tr>
						<tr>
							<td><form:label path="passwordConfirm">Confirmar contraseña:</form:label>
							<td><form:password path="passwordConfirm"
									placeholder="Confirmar contraseña" /></td>
							<td>${errorPasswordConfirm}</td>
						</tr>
						<tr>
							<td>${error}</td>
						</tr>
						<tr>
							<td><form:label path="nombre">Nombre:</form:label>
							<td><form:input path="nombre" placeholder="Nombre" /></td>
							<td>${errorNombre}</td>
						</tr>
						<tr>
							<td><form:label path="apellido">Apellido:</form:label>
							<td><form:input path="apellido" placeholder="Apellido" /></td>
							<td>${errorApellido}</td>
						</tr>
						<tr>

							<td><form:label path="fechaNacimientoDia">Fecha de Nacimiento:</form:label>
							<td><form:input path="fechaNacimientoDia"
									placeholder="Dia" /></td>
							<td><form:input path="fechaNacimientoMes"
									placeholder="Mes" /></td>
							<td><form:input path="fechaNacimientoAnho"
									placeholder="Año" /></td>
							<td>${errorFecha}</td>
						</tr>
						<tr>
							<td><form:label path="documento">Documento:</form:label>
							<td><form:input path="documento" placeholder="Documento" /></td>
							<td>${errorDocumento}</td>
						</tr>

					</tbody>
				</table>
				<table>
					<tr>
						<td><input type="submit" value="Register" class="register" />
						</td>
						<td><a href="cancelar.do"><input type="button"
								value="Cancelar" /></a></td>
					</tr>
				</table>
			</form:form>
</body>
</html>
