<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New registration</title>
</head>
<body>
	<h2>create New account</h2>
	<form action="saveReg" method="post">
		<pre>
       first name<input type="text" name="firstName" />
       last name<input type="text" name="lastName" />
       email<input type="text" name="email" />
       password<input type="text" name="password" />
       <input type="submit" Value="save" />
    </pre>
	</form>
</body>
</html>