<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Form</title>
</head>
<body>
	<form action="StudentController">
		<label>Name:</label><br>
		<input type="text" name="name" value="${student.name}" /><br>
		<label>Group:</label><br>
		<input type="text" name="groupStudent" value="${student.groupStudent}" /><br>
		<label>Turn:</label><br>
		<input type="text" name="turn" value="${student.turn}" /><br>
		<input type="submit" name="btn_save" value="Save" /><br>
	</form>

</body>
</html>