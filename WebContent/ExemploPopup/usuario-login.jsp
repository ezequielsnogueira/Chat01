

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%
	String erro = (String)request.getAttribute("erro");
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="./cssLogin.css">

		
	
	</head>


	<body>
		
		<div class = "container"> 
		
			
			<div class = "nav-a"> 
			
			</div>
			<div class = "nav-b"> 
			
			</div>
			<div class = "nav-c">
			
			</div>
			
			<div class = "nav-d"> 
			
			</div>
				
			
			<div class = "nav-e"> 
			
			<form action="login" method="POST">
			
						<p class = titulo> SISTEMA WEB</p>
					
						<p class = centro>Email:</p>  
						<input class = login type ="text" name="email1" required> <br/>
						<p class = centro>Senha: </p>
						<input class = login type="password" name="senha1" required>
					   	<p class = centro><input type="submit" value="Enviar"/> </p>
					   
					 
				
					 	
					
					<p class = centro>
							<%
							if(erro != null)
							{
							out.print(erro);
							}
							%>
						</p>
					
			</form>
			
			</div>
			<div class = "nav-f">
			
			</div>
			
			<div class = "nav-g"> 
			
			</div>
			
			<div class = "nav-h"> 
			
				
					<p class = centro>Caso não for cadastrado, clique <a class = centro href="http://localhost:8080/l8/Web2/usuario-cadastro.jsp">aqui</a>.</p>
				
				
			
			

			
			
			</div>
			
			
			<div class = "nav-i">
			
			
			</div>
			
			
			
			
		</div>
		
			
		
	</body>


</html>

