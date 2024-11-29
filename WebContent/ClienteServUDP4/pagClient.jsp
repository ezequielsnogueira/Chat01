<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%
	
	String msg = (String)request.getAttribute("msg");

	
%>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="ServUDPClientUDP4" method="POST">
			
					
						<p class = centro>mensagem:</p>  
						<input  type ="text" name="msgCli" > <br/>
						
					   	<p class = centro><input type="submit" value="Enviar"/> </p>
					   
				
										
										
			</form>

</body>
</html>