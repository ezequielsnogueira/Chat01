<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%
	
	String msgRec = (String)request.getAttribute("msgR");

	
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TESTE WHILE</title>
</head>
<body>

		
					
		<form action="TesteWhile" method="POST">
					
							
			Mensagem Recebida: <%out.println("Mensagem, " +msgRec);%>
			 					
			<p class = centro>Enviar mensagem:</p>  
			<input  type ="text" name="msgEnv" > <br/>
			<p class = centro><input type="submit" value="Enviar"/> </p>

			
			
			
		</form>


</body>
</html>