<%@page import="java.util.ArrayList"%>
<%@page import= "dao.*" %>
<%@page import= "model.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
    
 <%
	
	String usuAutenticado = (String)request.getAttribute("usuAutentic");
	String usuNome = (String)request.getAttribute("usuNo");
	TabUsuariosCompar usuariosCompar = new TabUsuariosCompar();
	usuariosCompar.setUsuario(usuAutenticado);
	TabUsuariosCompar arquivoCompar = new TabUsuariosCompar();
	arquivoCompar.setUsuario(usuAutenticado);
	arquivoCompar.setUsuarioCompar(usuNome);
	String img1 = "image/png";
	String img2= null;
	String app_pdf1 = "application/pdf";
	String app_pdf2= null;
	String mp3a = "audio/mpeg";
	String mp3b = null;
	String xls1 = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	String xls2 = null;
	String vid1 = "video/mp4";
	String vid2 = null;
	String exe1 = "application/x-msdownload";
	String exe2 = null;
	String msg1 = "msg";
	String msg2 = null;
	String usuNomeChat = null;
	
%>


 
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
		
						
			<div class = "nav-voltarSair"> 
			"nav-voltarSair
			</div>
			
			
			<div class = "nav-usuarios">			
			nav-usuarios"	
			</div>

			<div class = "nav-listArquivosComp"> 
			nav-listArquivosComp"						
			</div>
		
			<div class = "nav-listArquivosCompInf">
			nav-listArquivosCompInf	
			</div>
		</div>
	</body>


</html>