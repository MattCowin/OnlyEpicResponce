<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <link type="text/css" rel="stylesheet" href="onlyepic.css"/>
   	
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"/>
    <link href="http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet"/>
    <title>Employee Info</title>
    <meta name="author" content="Matt Cowin" />
</head>
<body>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
        <div class="navbar-header" style="margin: 0px; padding: 0px;">
            <a class="navbar-brand" href="https://www.onlyepic.com/">
            <img src="./Images/onlyepiclogo.jpg" style="width: 90px; height: 55px;
             margin-top: -20px; margin-left: -20px; margin-right: -20px;"/></a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="./managerhome.jsp">Home</a></li>
            <li><a href="https://www.onlyepic.com/">About Us</a></li>
            <li><a href="./managerreimbursments.jsp">Reimbursements</a></li>
            <li><a href="./viewallreimbursements.jsp">View All Reimbursements</a></li>
            <li><a href="./createrequest.jsp">Create Request</a></li>
        </ul>
      <form method="get" action="./invalidateSession"><a  href="./index.html" style="float: right; padding-top: 15px; ">
          Log Out<span class="glyphicon glyphicon-user"></span>
      </a></form>
  </div>
</nav>
    <br/>

   <!-- <div class="emp" id="emp1">    
        <nav class="navbar navbar">
            <div class="container-fluid">
                <ul class="nav navbar-nav" style="text-align: center;">
                <li><a href="./managerhome.jsp">Home</a></li>
                <li><a href="./managerreimbursments.jsp">Reimbursements</a></li>
                <li><a href="./viewallreimbursements.jsp">View All Reimbursements</a></li>
                <li><a href="./mcreaterequest.jsp">Create Request</a></li>
                </ul>
            </div>
        </nav>
    </div>-->
        </nav>
        <form action="" class="empform">
        	<h1>Management Home</h1>
  			<h2><%=session.getAttribute("currentUser") %></h2>
  			
  			
  			

  
</form>
    </div>
   
   <script src="OnlyEpic.js"></script>
</body>

</html>