<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>PopUp</title>
	
	<script language=javascript type="text/javascript">
	function newPopup()
	{
	varWindow = window.open ('usuario-login.jsp', 'popup')
	}
	</script>

</head>
<body>
	<a href="javascript:newPopup()">Abrir popup</a>
	

</body>
</html>