<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
<title>Acceso a eSe</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/resources/css/screen.css"/>" />
</head>

<body>
	<form:form modelAttribute="login" id="formLogin" method="POST"
		action="login.do" class="form-signin ">
		<h2 class="form-heading">Acceso</h2>

		<div class="form-group ${error != null ? 'has-error' : ''}">
			<span>${message}</span> <input name="nombre" id="usuario" type="text"
				class="form-control" placeholder="Usuario" autofocus /> <input
				name="password" id="password" type="password" class="form-control"
				placeholder="Contraseña" /> <br /> <span id="error">${error}</span><br />
			<button class="btn btn-lg btn-primary btn-block" type="button"
				onclick="validarFormularioLogin();">Acceder</button>
			<a href="cancelar.do"><input type="button" value="Cancelar" /></a>
		</div>
	</form:form>
	<script src="/resources/js/script.js" type="text/javascript"></script>
</body>
</html>
