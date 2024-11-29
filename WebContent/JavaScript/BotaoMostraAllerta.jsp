<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<button id = "botaoEnviar" type ="submit" >botão</button>


<script type="text/javascript">

function	mostraAlerta()	{
	alert("Funciona!");
}
//obtendo	um	elemento	através	de	um	seletor	de	ID
var	botao	=	document.querySelector("#botaoEnviar");
botao.onclick	=	mostraAlerta;

</script>

</body>
</html>