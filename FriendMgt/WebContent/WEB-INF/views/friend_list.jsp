<%@page import="friend.dao.DTOFriend"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>MVC Friend Management System</title>
</head>

<body>

<table>
	<tr>
		<td colspan=2><h1>Friend Management</h1></td>
	</tr>
	
	<tr align="center" valign="middle" bordercolor="#333333">
		<td>
			<div align="center">Num</div>
		</td>
		<td>
			<div align="center">Name</div>
		</td>
		<td>
			<div align="center">TEL</div>
		</td>
		<td>
			<div align="center">ADDR</div>
		</td>
	</tr>
	
	<c:forEach var="p" items="${friends}">
	<tr align="center" valign="middle" bordercolor="#333333">
		<td>
			<div align="center">${p.NUM}</div>
		</td>
		<td>
			<div align="center">${p.NAMES}</div>
		</td>
		<td>
			<div align="center">${p.TEL}</div>
		</td>
		<td>
			<div align="center">${p.ADDR}</div>
		</td>
	</tr>
	</c:forEach>
	
</table>
<div align="right"><a href="./addFriend">[Add more friend]</a></div>



</body>
</html>