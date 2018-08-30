<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.spring.user.*" %>
    <%@page import="java.util.*" %>
    <%@page import="java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>LifeGlue</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LifeGlue</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
#patients {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 90%;
    align: center;
}

#patients td, #patients th {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: center;
}
#rcorners {
    border-radius: 3px;
    background: #000000;
    padding: 5px; 
    width: 200px;
    height: 150px;    
}
#patients tr:nth-child(even){background-color: #f2f2f2;}

#patients tr:hover {background-color: #ddd;}
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
#patients th {
    padding-top: 10px;
    padding-bottom: 10px;
    text-align: center;
    background-color: #4CAF50;
    color: white;
}
.header {
   position: fixed;
   left: 0;
   top: 0;
   width: 100%;
   height: 12%;
   background-color: grey;
   text-align: center;
}
.slogan{

 text-align: center;
}
table
{
  width: 600px;
}
.himage
{
  margin-left: 500px;
}
</style>
<link rel="icon" 
      type="image/png" 
      href="images/lifeglueedit.jpg">
</head>
 <body style="background-color:#E5E8E8;">
 
 

<div class="header">

<center>
<h2 style="font-family:Lucida Handwriting;font-style: oblique;display:inline; color:white;">
<img src="images/lifeglueedit.jpg" id="rcorners" style="height:50px; width:50px;display:inline;margin-right:5px;"/>LifeGlue</h2>
<h3 class="slogan" style=" color: white;margin-top:5px;">Passion for better emergency treatment:)</h3></center>

  
<%
UserDAO userDAO = new UserDAO();
int i=0;
int year = Calendar.getInstance().get(Calendar.YEAR);
List<MedicalHistory> list = (List<MedicalHistory>) request.getAttribute("list"); %>
<div style="overflow-x:auto;">
<table id="patients" align="center">
             <%
             out.println("<tr><th>S.No</th><th>Patient Name</th><th>Blood Group</th><th>Alcohol</th>"
             +"<th>Cholesterol</th><th>Gender</th><th>Age</th><th>Drug</th><th>Mobile</th>"+
             "<th>Height</th><th>Weight</th><th>Pressure</th><th>Sugar</th><th>Tobacco</th><th>Conditions</th><th>Symptoms</th><th>Address</th>"+
             "<th>Status</th></tr>");
             if(list.isEmpty())
             {
            	 out.println("<center><h3>Patient Details</h3></center>");
            	 out.println("<tr><td colspan='19'><h3>No such patient records found...</h3></td></tr>");
             }
    	  
       else
       {
    	   out.println("<center><h4>Patient History Details</h4></center>");
    		   for(MedicalHistory mh:list){
    			   %>
    			      <form action='/LifeGlue/deleteEmergency.do' method='POST'>
    			      <%
    			   i++;
    	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
    	   int y = Integer.parseInt(new SimpleDateFormat("yyyy").format(mh.getDateOfBirth()));
    	  // int y = medication.getMedicalHistory().getDateOfBirth().getTime().getYear();
    	   %>
      <tr><td><%=i %></td><td><%=mh.getFullName() %></td><td><%=mh.getBloodGroup() %></td><td><%=mh.getAlcohol() %></td>
     <td><%=mh.getCholestrol() %></td>
      <td><%=mh.getGender() %></td><td><%=  year-y %></td>
      <td><%=mh.getDrug()%></td>
      <td><%=mh.getUser().getMobile() %></td><td><%=mh.getHeight() %></td><td><%=mh.getWeight() %></td><td><%=mh.getPressure() %></td>
      <td><%=mh.getSugar() %></td><td><%= mh.getTobacco() %></td><td><%=mh.getConditions() %></td><td><%=mh.getSymptoms() %></td> 
     <td> <%=mh.getUser().getAddress().getStreetNumber()+","+mh.getUser().getAddress().getArea()+","+ mh.getUser().getAddress().getCity()+","+
      mh.getUser().getAddress().getLocation()+","+ mh.getUser().getAddress().getPincode() %></td>
     <input type="hidden" value="<%= mh.getUser().getId()%>" name="id" />
    		  <td><input type ="submit" class="btn btn-success" value = "Update Status as Attended"/></td>
      </tr>
        </form> 
       <%}} %>
     
       
</table>
</div>
<br><br>
 <center> <a class="btn btn-success" href="/LifeGlue/hospitalHome.do">Back</a></center></div>
 <div class="footer"><p style="margin-bottom: 105px;">&copy;CopyRights for LifeGlue... Developed By Pavithra R</p></div>   

</body>
</html>



