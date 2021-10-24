<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h2>Enter Customer details</h2>
<form:form action="processForm" modelAttribute="customer">
First Name: <form:input path="firstName" />
<br><br>
Last Name (*): <form:input path="lastName" />
<form:errors path="lastName" cssClass="error" />
<br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Age (*): <form:input path="age" value="18" />
<form:errors path="age" cssClass="error" />
<br><br>
Postal Code (*): <form:input path="postalCode" />
<form:errors path="postalCode" cssClass="error" />
<br><br>
<input type="submit" value="Submit" />
</form:form>
<input type="button" onclick="doSomeWork()" value="Click Me"/>
</body>
</html>