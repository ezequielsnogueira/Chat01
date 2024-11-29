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


<form action="ServUDPServUDP4" method="POST">
			
					
					<p class = centro>Servidor:</p>  
						
					   	<p class = centro><input type="submit" value="Ligar"/> </p>
					   
					 
				
										
										
			</form>
			 <%out.println("Mensagem, " +msg);%>

</body>
</html>