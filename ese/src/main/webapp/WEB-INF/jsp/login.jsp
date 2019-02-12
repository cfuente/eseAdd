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
	<form commandName="login" method="POST" action="login.do"
		class="form-signin ">
		<h2 class="form-heading">Acceso</h2>

		<div class="form-group ${error != null ? 'has-error' : ''}">
			<span>${message}</span> <input name="nombre" type="text"
				class="form-control" placeholder="Usuario" autofocus="true" /> <input
				name="password" type="password" class="form-control"
				placeholder="Contraseña" /> <span>${error}</span>


			<button class="btn btn-lg btn-primary btn-block" type="submit">Acceder</button>
			<h4 class="text-center">
				<a href="register.do"><input type="button" value="Crear una cuenta" /></a>
				<a href="cancelar.do"><input type="button" value="Cancelar" /></a>
			</h4>
		</div>

	</form>
</body>
</html>
