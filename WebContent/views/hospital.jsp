<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.spring.user.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>

</script>
<link rel="icon" 
      type="image/png" 
      href="images/lifeglueedit.jpg">
</head>
<title>LifeGlue</title>
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
.header {
   position: fixed;
   left: 0;
   top: 0;
   width: 100%;
   height: 15%;
   background-color: grey;
   color: white;
   text-align: center;
}
#shadow {
    border: 1px solid;
    padding: 10px;
    box-shadow: 5px 10px 18px red;
}
#rcorners {
    border-radius: 3px;
    background: #000000;
    padding: 5px; 
    width: 200px;
    height: 150px;    
}
.slogan{
 margin-left: 100px;
 margin-top: 10px;
}
#buttons
{
 float: right;
 background-color: red;
 margin-bottom: 50px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <body style="background-color:#E5E8E8;">
 
 <div class="header"> 

<center>
<h2 style="font-family:Lucida Handwriting;font-style: oblique;display:inline; color:white;margin-right:35px;">
<img src="images/lifeglueedit.jpg" id="rcorners" style="height:50px; width:50px;display:inline;margin-right:5px;"/>LifeGlue</h2>
<h3 class="slogan" style=" color: white;">Passion for better emergency treatment:)</h3></center>

 
 

<%
   User user = (User) request.getAttribute("user");
   //HttpSession httpsession = request.getSession();
   session.setAttribute("user",user);
%>
</div> 

  <form action="/LifeGlue/hospitalLogin.do" method="post" style="margin-top:174px;">
   <div class="col-lg-4 col-xs-4 col-sm-4 col-md-4">

</div>

 <div class="col-lg-4 col-xs-4 col-sm-4 col-md-4 form-div">
  <div id="shadow">
  <center><h2>Hospital Login</h2></center>
  <center><h4>Welcome <%=user.getUserName()%> Kindly register the hospital you work!</h4></center>
  
  <div class="form-group" >
      <label>Hospital Name </label>
      <input class = "form-control" type="text" name="hospital_name" required/>
    </div>
    
      <div class="form-group">
      <label>Hospital Address</label>
      <input placeholder="streetnumber,Area,City,State,Pincode" class="form-control" type="text" name="hospital_address"  required/>
    </div>
    
     <div class="form-group">
     <label>Hospital Email</label>
      <input class = "form-control" type="email" name="hospital_email" required/>
    </div>
    
     <div class="form-group">
     <label>Hospital Phone Number</label>
     <div id="mobile_error" style="display:none; color:red;">Invalid Mobile Number</div>
      <input class = "form-control" type="text" name="hospital_number" id="mobile" required/>
    </div>
    
    
    
  <div>
 <input type ="submit" class="btn btn-success" value = "Signup"/>
</div>
</div>
</div>
<div class="col-lg-4 col-xs-4 col-sm-4 col-md-4">
</div>
</form>    

<div class="footer">&copy;CopyRights for LifeGlue... Developed By Pavithra R</div> 
</body>

</html>





