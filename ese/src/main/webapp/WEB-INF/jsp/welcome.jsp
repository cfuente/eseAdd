<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
<title>Welcome</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

</head>

<body>
	<h2 align="center">Welcome ${usuario.nombre}</h2>


	<div
		style="text-align: center; width: 100%; clear: both; display: table;">
		<c:if
			test="${usuario.lista['registrar usuario'] !=null && usuario.lista['registrar usuario'] !=0}">
			<div style="width: 30%; float: left;">
				<br /> <a href="register.do"> <input type="button"
					value="Crear una cuenta" /></a> <br />
			</div>
		</c:if>
		<c:if
			test="${usuario.lista['registrar compañia'] !=null && usuario.lista['registrar compañia'] !=0}">
			<div style="width: 30%; float: left;">
				<br /> <a href="registerCompania.do"><input type="button"
					value="Crear una compañia" /></a> <br />
			</div>
		</c:if>
		<c:if
			test="${usuario.lista['personal'] !=null && usuario.lista['personal'] !=0}">
			<div style="width: 30%; float: left;">
				<br /> <a href="personal.do"> <input type="button" value="Personal" /></a> <br />
			</div>
		</c:if>
		<c:if
			test="${usuario.lista['habilitaciones'] !=null && usuario.lista['habilitaciones'] !=0}">
			<div style="width: 30%; float: left;">
				<br /> <a href="#"> <input type="button" value="Habilitaciones" /></a>
				<br />
			</div>
		</c:if>
		<c:if
			test="${usuario.lista['formacion'] !=null && usuario.lista['formacion'] !=0}">
			<div style="width: 30%; float: left;">
				<br /> <a href="#"> <input type="button" value="Formacion" /></a> <br />
			</div>
		</c:if>
		<c:if
			test="${usuario.lista['reconocimientos'] !=null && usuario.lista['reconocimientos'] !=0}">
			<div style="width: 30%; float: left;">
				<br /> <a href="#"> <input type="button" value="Reconocimientos" /></a>
				<br />
			</div>
		</c:if>
		<c:if test="${usuario.lista['7'] !=null && usuario.lista['7'] !=0}">
			<div style="width: 30%; float: left;">
				<br /> <a href="#"> <input type="button"
					value="Crear una cuenta" /></a> <br />
			</div>
		</c:if>
		<c:if test="${usuario.lista['8'] !=null && usuario.lista['8'] !=0}">
			<div style="width: 30%; float: left;">
				<br /> <a href="#"> <input type="button"
					value="Crear una cuenta" /></a> <br />
			</div>
		</c:if>
		<c:if test="${usuario.lista['9'] !=null && usuario.lista['9'] !=0}">
			<div style="width: 30%; float: left;">
				<br /> <a href="#"> <input type="button"
					value="Crear una cuenta" /></a> <br />
			</div>
		</c:if>
		<c:if test="${usuario.lista['10'] !=null && usuario.lista['10'] !=0}">
			<div style="width: 30%; float: left;">
				<br /> <a href="#"> <input type="button"
					value="Crear una cuenta" /></a> <br />
			</div>
		</c:if>
		<c:if test="${usuario.lista['11'] !=null && usuario.lista['11'] !=0}">
			<div style="width: 30%; float: left;">
				<br /> <a href="#"> <input type="button"
					value="Crear una cuenta" /></a> <br />
			</div>
		</c:if>
		<c:if test="${usuario.lista['12'] !=null && usuario.lista['12'] !=0}">
			<div style="width: 30%; float: left;">
				<br /> <a href="#"> <input type="button"
					value="Crear una cuenta" /></a> <br />
			</div>
		</c:if>

	</div>
</body>
</html>
