<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@page import= "java.net.DatagramPacket" %>
	<%@page import= "java.net.DatagramSocket" %>
	<%@page import= "dao.UsuarioDAO" %>
	<%@page import= "model.Usuario" %>
	<%@page import= "java.util.ArrayList" %>
	<%@page import= "java.sql.SQLException" %>
	
	
	
	
	
	
<!DOCTYPE html>

<%
	
	String msgSrv = (String)request.getAttribute("msgSrv");
	String msgCli = (String)request.getAttribute("msgCli");
	
	HttpSession sessao = request.getSession();
	Usuario usuarioAutentic = new Usuario();
	usuarioAutentic.setEmail((String) sessao.getAttribute("usuAutenticado"));
	Usuario usuarioServ = new Usuario();
	usuarioServ.setEmail(usuarioAutentic.getEmail());
	Usuario usuarioCli = new Usuario();
	usuarioCli.setEmail(request.getParameter("usuDest"));
	

	
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CHAT</title>
</head>
<body>

		<form  action="pagina-principal.jsp" method="POST">
			<button class = btn type ="submit" >Voltar</button>
		</form>

		<p class = centro>Usuário autenticado:</p> 
		<%out.println(usuarioAutentic.getEmail());%>

		<form action="ServUDPmsgCli" method="POST">
		
	
					
			<p class = centro>CHAT:</p> 
			<p class = centro>Enviar mensagem:</p>  
			<input  type ="text" name="msgServ" > <br/>
			<p class = centro>Usuário de destino:</p>  
			<input  type ="text" name="usuDest" > <br/>
			<p class = centro><input type="submit" value="Enviar"/> </p>
					
							
			
			
		</form>
					


</body>
</html>