<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import= "dao.*" %>
<%@page import= "model.*" %> 
<!DOCTYPE html>

<%
	
	String codCompar = (String)request.getAttribute("cod");
	String erro = (String)request.getAttribute("erro");
	
%>



<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	
	
	
	
	<form action="ArquivoComparExe" method="POST">
	
				<%
				
				HttpSession sessaoCompart = request.getSession();
				System.out.println("codCompart");
				System.out.println(sessaoCompart.getAttribute("codCompart"));
				%>		
				
					
				<table border="1">
							<tr>
								
								
								<th>CodCompar</th>
								
							</tr>
						
						
						
						
							<tr>
								
								
								
								<td><%= sessaoCompart.getAttribute("codCompart") %></td>
								
								
								
							
								
								
							</tr>
						
						</table>
						
				
										
				Usuário: <input type="text" name="usuCompar"/><br/>	   
				<input  type="submit" value="Compartilhar"/><br/>	 
				<%
					if(erro != null)
					{
					out.print(erro);
					}
				
					
				%>
				<a href="arquivo-listar.jsp">Voltar</a> <br>
				
				
					 	
	</form>	
				
			
			

			
			
	

</body>
</html>