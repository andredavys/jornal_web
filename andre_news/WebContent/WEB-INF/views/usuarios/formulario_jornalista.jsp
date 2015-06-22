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

<title>Cadastrando Jornalista</title>
</head>
<body>

<center><h1> Cadastrando Jornalista</h1></center>

<div class="container">
	<form action="cadastrar_jornalista" enctype="multipart/form-data" method="post">
	<br> <br>
	    <div class="form-group">
	    	<label for="nome"> Nome: </label>
			<input type="text" name="nome"> <br><br> 
		</div>
		<div class="form-group">
			<label for="login"> Login: </label>
			<input type="text" name="login"> <br><br>
		</div>
		<div class="form-group">
			<label for="senha"> Senha: </label>
			<input type="password" name="senha"> <br><br>
		</div>
		<div class="form-group">
			<label for="email"> Email: </label>
			<input type="text" name="email"> <br><br>
		</div>
		
		
		<div class="form-group">
			<label for="exampleInputEmail1">Imagem</label> 
			<input type="file" name="file">		
		</div>
		
		<button type="submit" class="btn btn-default"> Cadastrar </button><br>
	</form>
</div>
	
</body>
</html>