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
	
	<script>
	function imputAutomatico() 
	{
		document.getElementById("inTeste").click();
	}
	</script>

	<body onload="imputAutomatico()">
		
		<div class = "container"> 
		
						
			<div class = "nav-voltarSair"> 
				<table  class = bTable>	
					<thead><tr><th><%out.println("Olá, " +usuAutenticado);%>
					</th></tr></thead>
					<form  action="listUsuComp" method="POST">
					<thead><tr> <th>	<button class = btn type ="submit" >Voltar</button></th> </tr> </thead>
					</form>
				</table>
				
			</div>
			<div class = "nav-usuariosMob">			
					<%
					UsuarioComparDAO usuComparDao = new UsuarioComparDAO();
					ArrayList<TabUsuariosCompar> listaUsuCompar = usuComparDao.getLista(usuariosCompar);
					%>
					
				<table  class="rTable">
					<tbody><tr><th>Compartilhamento de:</th></tr></tbody>
						<%for( TabUsuariosCompar usuCompar : listaUsuCompar )
						{%>
						<tbody><tr><td><a href="./BuscCompar?&usuNome=<%= usuCompar.getUsuario() %>"><%= usuCompar.getUsuario() %></a></td></tr></tbody>
						<%}%>
				</table>	
			</div>

		<div class = "nav-listArquivosCompMob"> 
				<%			
				ArquivoDAO dao = new ArquivoDAO();
				ArrayList<ArquivosCompar> lista = dao.listarArqComumCompar(arquivoCompar);
				%>
				<table class = "chatTable">
				<tbody>
				<%for( ArquivosCompar arq : lista )
						{%><tr> <td><%
						if (arq.getUsuario().equals(usuAutenticado))
						{
						usuNomeChat = "Você";
						}
						else
						{
						usuNomeChat = arq.getUsuario();
						}
							img2 = arq.getTipo();if( img1.equals(img2))	{%> <%=usuNomeChat%> <%= arq.getData() %> <img  src="./Arquivo?&cod=<%= arq.getCodigo() %>&name=<%= arq.getNome() %>" width="320" height= "240"> <%}
							app_pdf2 = arq.getTipo();if( app_pdf1.equals(app_pdf2))	{%> <%=usuNomeChat%> <%= arq.getData() %> <a  href="./Arquivo?&cod=<%= arq.getCodigo() %>&name=<%= arq.getNome() %>"><%= arq.getNome() %></a><%}
							mp3b = arq.getTipo();if( mp3a.equals(mp3b)) {%> <%=usuNomeChat%> <%= arq.getData() %> <audio controls="controls">	<source src="./Arquivo?&cod=<%= arq.getCodigo() %>&name=<%= arq.getNome() %>" type="audio/mp3" /> </audio><%}
							xls2 = arq.getTipo();if( xls1.equals(xls2))	{%> <%=usuNomeChat%> <%= arq.getData() %> <a href="./Arquivo?&cod=<%= arq.getCodigo() %>&name=<%= arq.getNome() %>"><%= arq.getNome() %></a><%}
							vid2 = arq.getTipo(); if (vid1.equals(vid2)) {%> <%=usuNomeChat%> <%= arq.getData() %> <video width="320" height="240" controls><source src="./Arquivo?&cod=<%= arq.getCodigo() %>&name=<%= arq.getNome() %>"></video><%} 
							exe2 = arq.getTipo(); if (exe1.equals(exe2)) {%> <%=usuNomeChat%> <%= arq.getData() %> <a href="./Arquivo?&cod=<%= arq.getCodigo() %>&name=<%= arq.getNome() %>"><%= arq.getNome() %></a><%}
							msg2 = arq.getTipo(); if (msg1.equals(msg2)) {%> <%=usuNomeChat%> <%= arq.getData() %>:  <%= arq.getTexto() %>  <%}

						%></td> </tr><%	
						}%>
				
				</tbody>
				</table>
						
									
						
						
		</div>
		
			<div class = "nav-listArquivosCompInf">
				
				
			<%if(usuNome != null){out.println("Enviar mensagem para: " +usuNome);}%><br/>
			
			<%HttpSession sessaoMsg =  request.getSession();
			  sessaoMsg.setAttribute("sMsg", usuNome);
			%>
			
					 
				<form action="./listarArqComparRes" method="post"	enctype="multipart/form-data">
					 <input type="submit" value="RESPONDER" /> <br/>
				</form>
				
				<%HttpSession sessaoServidor = request.getSession();
				sessaoServidor.getAttribute("estadoServ") ;
				System.out.println("Estado do servidor: " + sessaoServidor.getAttribute("estadoServ"));
				if (sessaoServidor.getAttribute("estadoServ")==null)
				{
				%>
				<form action="ServUDPRec" method="POST">
				<input type="submit" id="inTeste"  value="Enviar"/> 
				</form>  
				<%}%>
				
			</div>
		</div>
	</body>


</html>