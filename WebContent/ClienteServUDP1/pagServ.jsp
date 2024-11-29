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


<form action="ServUDPServ" method="POST">
			
					
			 					
			<p class = centro>Estado do servidor:</p>  
			<input  type ="text" name="estad" > <br/>
			<p class = centro>mensagem:</p>  
			<input  type ="text" name="msgEnv" > <br/>
						
			<p class = centro><input type="submit" value="Ligar"/> </p>
					   
					 
				
			<%out.println("Mensagem, " +msg);%>					
										
</form>

</body>
</html>