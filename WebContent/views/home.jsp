<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.spring.user.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<link rel="icon" 
      type="image/png" 
      href="images/lifeglueedit.jpg">
      </head>
  <title>LifeGlue</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <style>
  .footer {
   position: fixed;
   left: 0;
   bottom: 0;
   width: 100%;
   height: 10%;
   background-color: grey;
   color: white;
   text-align: center;
}
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    .row.content {height: 450px}
    
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
</head>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <img src="images/lifeglueedit.jpg" style="height:50px; width:50px;"/><h2 style="font-style: oblique; font-color:white;"><h2 style="color:white">LifeGlue</h2>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">About</a></li>
        <li class="active"> <a href="/LifeGlue/UploadMedicalHistory.do">Upload</a></li>
        <li><a href="/LifeGlue/emergency.do">Emergency</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="/LifeGlue/logout.do"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>
  
  <% User user= (User) request.getAttribute("user"); 
 session.setAttribute("user",user);%>
  
  <center><h1><b>Welcome <%=user.getUserName() %></b></h1></center>
 
<div class="container-fluid text-center"> 
   
  <div class="row content">
    <div class="col-sm-2 sidenav">
     <div id="error" style="color:red; display:block">${error}</div>
      <p><a href="#"></a></p>
      <p><a href="#"></a></p>
      <p><a href="#"></a></p>
    </div>
    <div class="col-sm-8 text-left"> 
      <h1>Welcome</h1>
        <hr>
      <h3>Lets save life through LifeGlue</h3>
      <p>Upload your medical history if available for better experience...</p>
      <p>Use the emergency button whenever you need an emergency help...</p>
    </div>
    <div class="col-sm-2 sidenav">
      <div class="well">
        <p></p>
      </div>
      <div class="well">
        <p></p>
      </div>
      
      
      
      
    </div>
  </div>
</div>


<div class="footer">&copy;CopyRights for LifeGlue... Developed By Pavithra R</div> 

</body>
</html>
