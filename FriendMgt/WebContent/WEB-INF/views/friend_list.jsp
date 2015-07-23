<%@page import="friend.model.DTOFriend"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>MVC Friend Management System</title>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>
   
    $(document).ready(function() {
    	
    	var deleteLink = $("a:contains('Delete')");
    	
    	$(deleteLink).click(function(event){
    		
    		var NUM =$(this).attr("name");
			 var json = { "num" : NUM };			 
			
			$.ajax({
				url: "${pageContext.request.contextPath}/deleteFriend",
			  	type: "POST",
			  	data: JSON.stringify(json),
			  	beforeSend: function(xhr) {
			  		xhr.setRequestHeader("Accept", "application/json");
			  		xhr.setRequestHeader("Content-Type", "application/json");
			  	},
			  	
			  	success: function(friend) {
			  		var respContent = "";
			  		var rowToDelete = $(event.target).closest("tr");
			  		
			  		rowToDelete.remove();
			  		
			  		respContent += "<span class='success'>friend was deleted: [";
			  		respContent += friend.names + " : ";
			  		respContent += friend.tel + " : " ;
			  		respContent += friend.addr + "]</span>";
			  		
			  		$("#sFriendFromResponse").html(respContent);   		
			  	}
			});
			event.preventDefault();
	
		     });
    	});   
</script>
	
	
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
		<td>
			<div align="center">action</div>
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
		<td>
			<a href="${pageContext.request.contextPath}/updateFriend/${p.NUM}">Edit</a> &nbsp
			<a href=""  name="${p.NUM}" >Delete</a>
		</td>
	</tr>
	</c:forEach>
	<tr bordercolor="#333333">
		<td colspan="6"  align="right"><a href="${pageContext.request.contextPath}/addFriend">[Add more friend]</a></td>		
	</tr>
</table>
	
<div id="sFriendFromResponse"></div>  
</body>
</html>