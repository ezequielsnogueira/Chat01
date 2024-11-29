<%@page import="java.util.ArrayList"%>
<%@page import= "dao.*" %>
<%@page import= "model.*" %>

    

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@page import= "model.*" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Sistema Web</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="./cssGrid.css">

		
	
	</head>


	<body>
		
		
		
<div class = "container"> 
		
			
			<div class = "nav-menuPric"> 
			
						<%
							HttpSession sessaoPast = request.getSession();
							Pastas pastas = new Pastas();
							pastas.setUsuario((String) sessaoPast.getAttribute("usuAutenticado"));
							PastaDAO pastaDao = new PastaDAO();
							ArrayList<Pastas> listaPast = pastaDao.listarPastas(pastas);
							
							
							
						%>
			
					
			<table  class = bTable>	
			
					<tr><th>
							<%
							HttpSession sessao = request.getSession();
							Usuario usuario = new Usuario();
							usuario.setEmail((String) sessao.getAttribute("usuAutenticado"));
							out.println("Olá, " +usuario.getEmail());
							%>
					</th></tr>
					<form  action="LogoutServlet" method="POST">
					<tr> <th>	<button class = btn type ="submit" >Sair</button></th> </tr> 
					</form>
					<form  action="usuario-conta.jsp" method="POST">
					<tr> <th>	<button class = btn type ="submit" >Acessar sua conta</button></th> </tr> 
					</form>		
					<form  action="ListarPastas" method="POST">
					<tr> <th>	<button class = btn type ="submit" >Arquivos</button></th> </tr> 
					</form>
					<form  action="listUsuComp" method="POST">
					<tr> <th>	<button class = btn type ="submit" >Chat</button></th> </tr> 
					</form>
					<form  action="listarVid" method="POST">
					<tr> <th>	<button class = btn type ="submit" >Vídeos</button></th> </tr> 
					</form>
					<form  action="listarImag" method="POST">
					<tr> <th>	<button class = btn type ="submit" >Imagens</button></th> </tr> 
					</form>
					<form  action="listarAud" method="POST">
					<tr> <th>	<button class = btn type ="submit" >Mp3</button></th> </tr>
					</form>
					
					<form  action="listarTudo" method="POST">
					<tr> <th>	<button class = btn type ="submit" >Listar todos arquivos</button></th> </tr>
					</form>
					
					<form  action="pagChat.jsp">
					<tr> <th>	<button class = btn type ="submit" >Msg Rec</button></th> </tr>
					</form>
					
					<form  action="pagChatMsgEnv.jsp">
					<tr> <th>	<button class = btn type ="submit" >Msg Env</button></th> </tr>
					</form>
								
						
					
			</table>
							
			
				
			
				
			
			</div>
			
			
			<div class = "nav-listArquivos"> 
		
			
 			</div>
 </div>
			
			
			
				
			
		
	</body>


</html>