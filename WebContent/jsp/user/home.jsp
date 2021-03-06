<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<c:if test="${user == null}" >
	<title>Login</title>
</c:if>
<c:if test="${user != null}" >
	<title>Hello ${user.username}</title>
</c:if>
</head>
<body>

<!-- Use this for redirecting to login page -->
<!-- http://docs.oracle.com/javaee/5/tutorial/doc/bncbe.html#bncbn -->
	<c:if test="${user != null}" >
		<jsp:include page="../includes/logout_link.jsp" />

		<a href="upload" >Upload Pictures</a> <a href="http://docs.oracle.com/javaee/6/tutorial/doc/glrbb.html" >help for file uploads</a><br/>
		<h4>View Others' Pictures</h4><br/><br/><br/>
		
		<h2>This is an array of thumbnails</h2>
	</c:if>

</body>
</html>