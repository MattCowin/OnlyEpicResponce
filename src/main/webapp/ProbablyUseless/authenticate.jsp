<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to our session tracked application.<%=session.getAttribute("currentUser") %></h1>


getAllTodos = () => {
 const xhr = new XMLHttpRequest();
 xhr.onreadystatechange = () =>{
 	if(xhr.status === 200 && xhr.readhState ===4){
 	console.log
 	}
 }
 xhr.open
 xhr.send 
 }
</body>
</html>