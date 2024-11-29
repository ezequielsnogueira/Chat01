<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<script>
function imputAutomatico() 
{
	document.getElementById("inTeste").click();
}
</script>

<body onload="imputAutomatico()">


<form action="ServUDPClient" method="POST">
 	 <input type="submit" id="inTeste"  value="Enviar"/> 
</form>


corpo do site...

</body>