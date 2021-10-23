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
Favorite Programming Languages: <br>
<form:radiobutton path="favoriteLanguage" value="Java" /> &nbsp;Java &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<form:radiobutton path="favoriteLanguage" value="CPP" /> &nbsp;C/C++<br>
<form:radiobutton path="favoriteLanguage" value="Node" /> &nbsp;Node &nbsp;&nbsp;&nbsp;&nbsp;
<form:radiobutton path="favoriteLanguage" value="Cloud" />  &nbsp;Cloud&nbsp;&nbsp;&nbsp;&nbsp;
<form:radiobutton path="favoriteLanguage" value="Net" /> &nbsp;.Net 
<br><br>
<input type="submit" value="Submit" />
</form:form>
</body>
</html>