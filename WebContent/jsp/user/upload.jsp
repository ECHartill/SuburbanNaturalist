<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="POST" action="upload" enctype="multipart/form-data" >
		<input type="hidden" name="action" value="upload" />
			File: <input type="file" name="file" id="file" /> <br/>
			Name: <input type="text" value="" name="filename"/> <br/>
		<input type="submit" value="Upload" name="upload" id="upload" />
	</form>

</body>
</html>