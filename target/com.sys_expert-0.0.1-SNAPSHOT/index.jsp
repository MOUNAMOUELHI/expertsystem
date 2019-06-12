<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>system expert</title>
</head>
<body>


<h1>PROLOG consult!</h1>
	
	
	<form action="prolog" method="post">
		Enter Rule: <input type="text" name="rule" id="rule" size="20">
	    <input type="submit" value="Save" />
	    
	    Enter query: <input type="text" name="query" id="query" size="20">
	    <input type="submit" value="Compile" />
	</form>


</body>
</html>