<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Madhukar - MVC Form Tag</title>
</head>
<body>
The student is confirmed: ${student.firstName} ${student.lastName}
<br><br>
Country: ${student.country}
<br><br>
Favorite language: ${student.favoriteLanguage}
<br><br>

Operating Systems: 
<ul>
	<c:forEach var="temp" items="${student.operatingSystems}">
		<li> ${temp} </li>
	</c:forEach>
</ul>
<br><br>
<a href="../">Back to main menu</a>
</body>
</html>