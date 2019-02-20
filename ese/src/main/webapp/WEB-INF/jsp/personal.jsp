<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
<title>Welcome</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

</head>

<body>
	<h2 align="center">Welcome personal ${usuario.nombre}</h2>



	<form:form modelAttribute="formularioPersonal" id="personal"
		method="POST">
		<form:label path="nombre">Compañia:</form:label>
		<form:input path="nombre" id="nombre" placeholder="nombre" />
		<form:label path="idCargo">Cargo:</form:label>
		<form:select path="idCargo" id="idCargo">
			<form:option value="0">Selecciona uno:</form:option>
			<c:forEach items="${cargos}" var="cargo">
				<form:option value="${cargo.idCargo}">${cargo.nombre}</form:option>
			</c:forEach>
		</form:select>
		<input type="button" onclick="filtrarPersonal();" value="filtrar"
			class="filtrar" />
		<input type="button" onclick="borrarFiltrosPersonal();"
			value="Borrar filtros" class="Borrar filtros" />
		<br />
		<%-- 		<form:checkboxes element="li" items="${personas}" path="listPersonal" --%>
		<%-- 			itemLabel="nombrePersonal" itemValue="idPersonal" /> --%>
		<form:select path="listIdPersonal" id="listIdPersonal"
			items="${personas}" multiple="true" itemLabel="nombrePersonal"
			itemValue="idPersonal" size="10" />
		<input type="submit" value="personal" class="personal" />
	</form:form>



	<script src="/resources/js/script.js" type="text/javascript"></script>
</body>
</html>
