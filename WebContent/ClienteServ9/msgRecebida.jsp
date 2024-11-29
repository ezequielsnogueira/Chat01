<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
String msg = (String)request.getAttribute("mensagem");
%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="ServletServidorLiga" method="POST">
	<p class = centro>Servidor:</p>  
						
					   	<p class = centro><input type="submit" value="ServletServidorLiga"/> </p>		

</form>
	
	<form action="ServUDPClient" method="POST">
			
					
						<p class = centro>mensagem:</p>  
						<input  type ="text" name="msgCli" > <br/>
						
					   	<p class = centro><input type="submit" value="Enviar"/> </p>
					   
				
										
										
			</form>
		
		<%HttpSession sessaoServ = request.getSession();
			 	String mensagem;
				mensagem = (String) sessaoServ.getAttribute("msgRec");
				System.out.println("Sessao ServDisp : " + mensagem);%>

			 <%out.println("Mensagem, " +mensagem);%>

</body>
</html>