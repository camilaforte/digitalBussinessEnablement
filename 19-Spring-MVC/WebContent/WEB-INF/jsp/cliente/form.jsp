<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Cliente</title>
</head>
<body>
	<form action="cadastrar" method="post"> <!-- methodo que será chamado, e o action busca o metodo de uma controler que a ação do botao deve chamar -->
		<div>
			<label for="iNome">Nome</label>
			<input type="text" name="nome" id="iNome">
		</div>
		<div>
			<label for="iIdade">Idade</label>
			<input type="text" name="idade" id="iIdade">
		</div>
		<div>
			<label for="iCNH">Habilitado</label>
			<input type="checkbox" name="cnh" id="iCNH">
		</div>
		<div>
			<label for="iGenero">Genero</label>
			<select name="genero" id="iGenero">
				<option label="Feminino" value="F">
				<option label="Masculino" value="M">
				<option label="Outro" value="O">
			</select>
		</div>
		<div>
			<input type="submit" value="ENVIAR">
		</div>
	</form>
</body>
</html>