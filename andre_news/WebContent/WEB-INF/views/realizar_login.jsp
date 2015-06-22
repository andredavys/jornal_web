<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<title>Login</title>
</head>
<body>

<div class="container">
	<form action="verifica_login" method="post">
		<div class="form-group">
			<label for="login"> Login:</label> <br>
			<input type="text" name="login" class="form-control">
		</div>
		<div class="form-group">
			<label for="senha"> Senha:</label> <br> 
			<input type="password" name="senha" class="form-control">
			<br><button type="submit" class="btn btn-default"> Logar</button>
		</div>
	</form>
</div>

</body>
</html>