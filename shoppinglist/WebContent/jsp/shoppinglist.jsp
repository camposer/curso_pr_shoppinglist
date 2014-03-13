<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
	<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Lista de compras</title>
	<script>
		var cambiarEstado = function(e) {
			var url = "cambiarEstado.sl";
			var checkbox = $(e.target);
			var estado = checkbox.is(':checked');
			
			$.ajax(url, {
				type: "post",
				data: "id=" + checkbox.val()
			}).fail(function() {
				$(checkbox).attr("checked", !estado);
			});
		};
	
		$(document).ready(function() {
			$("input[type=checkbox]").click(cambiarEstado);
		});
	</script>
</head>
<body>
	<h1>Lista de compras</h1>
	Bienvenido: <c:out value="${sessionScope.usuario.login}"/>
	<br/>
	<br/>
	<table>
		<tr>
			<th>Estado</th>
			<th>Elemento</th>
		<tr>
		<spring:eval expression="T(es.indra.formacion.pr.shoppinglist.model.ShoppingItemStatus).ACTIVO" var="activo" />
			
		<c:forEach var="i" items="${items}">
			<c:set var="checked" value=""/>
			
			<c:if test="${i.status == activo.ordinal() }">
				<c:set var="checked" value="checked='checked'"/>
			</c:if>
		
			<tr>
				<td><input type="checkbox" value="<c:out value="${i.id}"/>" <c:out value="${checked}"/>></td>
				
				<td><c:out value="${i.name}" /></td>
			<tr>	
		</c:forEach>
	</table>
</body>
</html>
