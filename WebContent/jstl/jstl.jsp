<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<jsp:useBean id="dao" class="dao.UsuarioDAO"/>

<c:forEach var="contato" items="${dao.lista}">
<li>
Usuários:  ${contato.email},
</li>
</c:forEach>





<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>