<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.spring.user.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>LifeGlue</title>
 <link rel="icon" 
      type="image/png" 
      href="images/lifeglueedit.jpg">
      <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">

function callTextBox()
{
	//document.getElementById("id").style.display = 'none';
	document.getElementById("date").style.display = 'none';
	document.getElementById("name").style.display = 'block';
	}
function callByDate()
{
//	document.getElementById("id").style.display = 'none';
	document.getElementById("name").style.display = 'none';
	document.getElementById("date").style.display = 'block';
	}


function show(nr) {
    document.getElementById("table1").style.display="none";
    document.getElementById("table2").style.display="none";
    document.getElementById("table3").style.display="none";
    document.getElementById("table4").style.display="none";
    document.getElementById("table"+nr).style.display="block";
}</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <body style="background-color:#E5E8E8;">

<style>

ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    width: 300px;
    background-color: #f1f1f1;
    border: 1px solid #555;
}

li a {
    display: block;
    color: #000;
    padding: 8px 16px;
    text-decoration: none;
}

li {
    text-align: center;
    border-bottom: 1px solid #555;
}

li:last-child {
    border-bottom: none;
}

li a.active {
    background-color: #4CAF50;
    color: white;
}

li a:hover:not(.active) {
    background-color:  #4CAF50;
    color: white;
}
#name
{
  width:500px;
  text-align:center;
}
#date
{
  width:500px;
  text-align:center;
}
#id
{
  width:500px;
  text-align:center;
}
#rcorners {
    border-radius: 3px;
    background: #000000;
    padding: 5px; 
    width: 200px;
    height: 150px;    
}
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
   text-align: center;
}
.slogan{
 margin-right: 10px;
 margin-top: 10px;
 text-align: center;
}
#rcorners {
    border-radius: 3px;
    background: #000000;
    padding: 5px; 
    width: 200px;
    height: 150px;    
}
#logout
{
  margin-left: 700px;
  margin-bottom: 15px;
  color: black;
}
.container
{
  font-color:black;
}
</style>
<link rel="icon" 
      type="image/png" 
      href="images/lifeglueedit.jpg">
</head>
<body>


 


<div class="header">

<center>
<h2 style="font-family:Lucida Handwriting;font-style: oblique;display:inline; color:white;">
<img src="images/lifeglueedit.jpg" id="rcorners" style="height:50px; width:50px;display:inline;margin-right:5px;"/>LifeGlue</h2>
<h3 class="slogan" style=" color: white;">Passion for better emergency treatment:)</h3></center>

 <% Hospital hospital = (Hospital) request.getAttribute("Hospital"); 
 session.setAttribute("Hospital",hospital);%>
 <a href="/LifeGlue/logout.do" style="display:inline;" id="logout"><span id="logout" class="glyphicon glyphicon-log-in"></span> Logout</a>
<div class="container">
<center><h2>Welcome  <%=hospital.getUser().getUserName() %></h2> 
<h3><p>Thank you for registering <b><%=hospital.getHospitalName()%></p></b></h3>
<ul style="margin-top:70px">
  <li><a class="active" href="/LifeGlue/getAllPatients.do"  onclick='show(1);'>All Patients</a></li>
  <li><a href="/LifeGlue/getEmergencyRequest.do" >Emergency Requests</a></li>
  <li><a href="#contact" onclick = 'callByDate();'> Patient By Date</a></li>
  <li><a href="#about" onclick=' callTextBox();'>Patient By Name</a></li>
</ul>
</center>
</center>
  <br><br><br>
    
    <center><div class="form-group" id="date" style="display:none;">
      <form action="/LifeGlue/getPatientByDate.do">
      <label>Enter the date to search</label>
      <input class = "form-control" type="date" name="date" placeholder="Enter date in dd-mm-yyyy format" required/><br>
      <input type ="submit" class="btn btn-success" value = "Get Details"/>
    </form></div></center>
    
    <center><div class="form-group" id="name" style="display:none;">
      <form action="/LifeGlue/getPatientByName.do">
      <label>Enter the patient name you want to search</label>
      <input class = "form-control" type="text" name="name" required/><br>
      <input type ="submit" class="btn btn-success" value = "Get Details"/>
    </form></div></div></center>
   
    </div>
<div class="footer"><p style="margin-bottom: 105px;">&copy;CopyRights for LifeGlue... Developed By Pavithra R</p></div>   
</body>
</html>
