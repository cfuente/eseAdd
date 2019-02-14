<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
<title>Spring MVC Starter Application</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/resources/css/screen.css"/>" />
</head>

<body>
	<h1 align="center">BIENVENIDO</h1>
	<div style="text-align: center;">
		<a href="login.do"><input type="button" value="Loguearse" /></a> <br />
		<br /> <br /> <a href="register.do"><input type="button"
			value="Crear una cuenta" /></a> <br /> <br /> <br /> <a
			href="registerCompania.do"><input type="button"
			value="Crear una compa�ia" /></a> <br />
	</div>
</body>
</html>
