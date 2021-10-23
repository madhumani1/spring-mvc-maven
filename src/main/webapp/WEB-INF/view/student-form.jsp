<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Madhukar - MVC Form Tag</title>
</head>
<body>
<h2>Enter student details</h2>
<form:form action="processForm" modelAttribute="student">
First Name: <form:input path="firstName" />
<br><br>
Last Name: <form:input path="lastName" />
<br><br>
Country:
<form:select path="country">
	<%-- <form:option label="Bra" value="Brazil" />
	<form:option label="Rus" value="Russia" />
	<form:option label="Ind" value="India" />
	<form:option label="Chn" value="China" />
	<form:option label="Saf" value="South Africa" /> 
	<form:options items="${student.countryOptions}" />	--%>
	<form:options items="${theCountryOptions}" />
</form:select>
<br><br>
<input type="submit" value="Submit" />
</form:form>
</body>
</html>