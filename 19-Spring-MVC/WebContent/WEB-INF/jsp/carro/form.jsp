<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Carro</title>
</head>
<body>

	<h1>Carro</h1>
	
	<form action="cadastrar" method="post">
		<div>
			<label for="iModelo">Modelo</label>
			<input type="text" name="modelo" id="iModelo">
		</div>
		<div>
			<label for="iMarca">Marca</label>
			<input type="text" name="marca" id="iMarca">
		</div>
		<div>
			<input type="checkbox" name="novo" id="iNovo">
			<label for="iNovo">Novo</label>
		</div>
		<div>
			<input type="radio" name="cambio" value= "automatico">
			<input type="radio" name="cambio" value= "manual">		
		</div>
		<div>
			<label for="iAno" >Ano</label>
			<input type="text" name="ano" id="iAno">
		</div>
		<div>
			<input type="submit" value="OK">
		</div>
	</form>

</body>
</html>