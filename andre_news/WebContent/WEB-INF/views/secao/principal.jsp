<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sessao principal</title>
</head>
<body>

	<h1>Bem vindo, ${usuario_logado.nome } </h1> 
	<h1> Sessão principal </h1>


	<c:forEach var="papel" items="${usuario_logado.roleList }">
		<c:if test="${papel.role == 'Editor' }">
			<a href="formulario_jornalista"> Cadastrar jornalista </a> <br>
			<a href="formulario_secao"> Cadastrar seção </a> <br>
			<a href="formulario_classificado"> Cadastrar classificado</a>
		</c:if>
	</c:forEach>
	
</body>
</html>