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
			<h1>Registro Compañia</h1>

			<!-- 			<div> -->
			<!-- 				<p>You have successfully deployed a Spring MVC web application.</p> -->
			<!-- 				<h3>Your application can run on:</h3> -->
			<!-- 				<img -->
			<%-- 					src="<c:url value="/static/resources/gfx/dualbrand_as7eap.png"/>" /> --%>
			<!-- 			</div> -->

			<form:form modelAttribute="formularioCompania" id="regCompania" method="POST">
				<table>
					<tbody>
						
						<tr>
							<td><form:label path="nombre">Nombre:</form:label></td>
							<td><form:input id="nombre" path="nombre" maxlength="30"
									placeholder="Nombre" /></td>
							<td id="errorNombre">${errorNombre}</td>
						</tr>
						<tr>
							<td><form:label path="tipoCompania">Tipo Compañia:</form:label></td>
							<td><form:input path="tipoCompania" id="tipoCompania" maxlength="30"
									placeholder="Tipo compañia" /></td>
									<td id="errorTipoCompania">${errorTipoCompania}</td>
						</tr>
						
						<tr>
							<td><form:label path="documento">Documento:</form:label></td>
							<td><form:input path="documento" id="documento" maxlength="14"
									placeholder="Documento" /></td>
							<td id="errorDocumento">${errorDocumento}</td>
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
						

					</tbody>
				</table>
				<table>
					<tr>

						<td><input type="button"
							onclick="validarFormularioEmpresa();" value="Register"
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
