<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://www.springframework.org/tags/form" prefix="fo" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fo:form commandName="friend" action="saveFriend">
<table>
		<tr><td>Name: </td><td><fo:input path="NAMES" /></td></tr>
		<tr><td>Telephone: </td><td><fo:input path="TEL" /></td></tr>
		<tr><td>Address: </td><td><fo:input path="ADDR" /></td></tr>
		<tr><td colspan="3"><input type="submit" value="Add Friend"/></td></tr>
	</table>
	
</fo:form>

	
</body>
</html>