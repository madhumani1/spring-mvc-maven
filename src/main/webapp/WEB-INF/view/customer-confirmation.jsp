<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Madhukar - MVC Form Tag</title>
<link rel="stylesheet" type="text/css" 
		  href="${pageContext.request.contextPath}/resources/css/my-test.css">

<script src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script> 
</head>
<body>
The customer is confirmed: <span class="output">${customer.firstName} ${customer.lastName}</span>
<br><br>
<a href="../">Back to main menu</a>
</body>
</html>