<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://www.springframework.org/tags/form" prefix="fo" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<script>
$(document).ready(function() { 
	  $('#newFriendForm').submit(function(event) {
	      
	      var NAMES = $('#NAMES').val();
	      var TEL = $('#TEL').val();
	      var ADDR = $('#ADDR').val();
	      
	      var json = { "names" : NAMES, "tel" : TEL, "addr": ADDR};
  
	     // alert(JSON.stringify(json));
	      
	    $.ajax({
	        url: $("#newFriendForm").attr( "action"),
	        data: JSON.stringify(json),
	        type: "POST",
	        beforeSend: function(xhr){
	            xhr.setRequestHeader("Accept", "application/json");
	            xhr.setRequestHeader("Content-Type", "application/json");
	        },
	        success: function(friend) {
	            var respContent = "";  
	            respContent += "<span class='success'>friend was created: [";
	            respContent += friend.names + " : ";
	            respContent += friend.tel + " : " ;
	            respContent += friend.addr + "]</span>";
	             
	            $("#sFriendFromResponse").html(respContent); 
	            window.location.href="${pageContext.request.contextPath}/listFriend";
	        }
	    });
	      
	    event.preventDefault();
	  });
	    
	});

</script>
</head>



<body>

<div id="sFriendFromResponse"></div>  

<fo:form id="newFriendForm" commandName="friend" action="${pageContext.request.contextPath}/addFriend.json">
<table>
		<tr><td>Name: </td><td><fo:input path="NAMES" /></td></tr>
		<tr><td>Telephone: </td><td><fo:input path="TEL" /></td></tr>
		<tr><td>Address: </td><td><fo:input path="ADDR" /></td></tr>
		<tr><td colspan="3"><input type="submit" value="Add Friend"/></td></tr>
	</table>
	
</fo:form>

	
</body>
</html>