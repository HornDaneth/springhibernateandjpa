<%@page import="friend.model.DTOFriend"%>
<%@page import="friend.dao.BaseDao"%>
<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Spring And Hibernate</title>
</head>
<body>
	<h1>WelCome To Friend Management</h1>

	

<div align="center"><a href="./addFriend">[Add friend]</a></div>
<div align="center"><a href="./listFriend">[List friend]</a></div> 
 

</body>
</html>