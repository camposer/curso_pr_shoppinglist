<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de compras</title>
</head>
<body>
	<h1>Lista de compras</h1>
	<form:form action="autenticar.sl" commandName="usuarioForm" method="post">
		<form:errors path="*" cssStyle="border: 1px solid red;"/>
		<table>
			<tr>
				<td>Usuario:</td>
				<td><form:input path="usuario"/></td>
			</tr>
			<tr>
				<td>Contraseña:</td>
				<td><form:input path="clave"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Entrar"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>