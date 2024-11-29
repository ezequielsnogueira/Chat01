<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<head>
		

		
		<script type="text/javascript">
		
		var counter = 0;
		window.setInterval("refreshDiv()", 5000);
		function refreshDiv()
			{
			counter = counter +1;
			
			
			document.getElementById("teste").innerHTML = "Testando... " + counter;
			}
		</script>
		
	</head>
	</head>

	<body>
		
			<jsp:useBean id="dao" class="dao.UsuarioDAO"/>
		
		
	
	
		<div id="teste">
			Testando
		</div>
		
		
		<div id="estatico">
			Parte estática da página.
		</div>
	</body>
</html>
