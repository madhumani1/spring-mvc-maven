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
The customer age: <span class="output">${customer.age}</span>
The Postal Code: <span class="output">${customer.postalCode}</span>
The Course Code: <span class="output">${customer.courseCode}</span>
<br><br>
<a href="../">Back to main menu</a>
</body>
</html>