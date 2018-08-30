<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function validate() {
	var flag=true;
	var role = document.getElementById("role").value;
	var mobile = document.getElementById("mobile").value;
	var password = document.getElementById("password").value;
	var cpassword = document.getElementById("cpassword").value;
	if(password!=cpassword){
		flag = false;
		document.getElementById("password_error").style.display = 'block';
		} 
	else{
			document.getElementById("password_error").style.display = 'none';
			}
	if(isNaN(mobile))
		{
		flag=false;
		document.getElementById("mobile_error").style.display= 'block';
		}
	else
		document.getElementById("mobile_error").style.display= 'none';
		if(mobile.length!=10)
			{
			document.getElementById("mobile_error").style.display= 'block';
			flag=false;
			}
			
		else
			document.getElementById("mobile_error").style.display= 'none';
			
	
	if(role=="0")
		{
		flag=false;
		document.getElementById("role_error").style.display= 'block';
		}
	else
		document.getElementById("role_error").style.display= 'none';

	return flag;
		
	}
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
   height: 5%;
   background-color: grey;
   color: white;
   text-align: center;
}
#buttons
{
 float: right;
 background-color: red;
 margin-bottom: 50px;
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
 margin-left: 200px;
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
<center>

<div class="header"><center> <a class="btn btn-success" id="buttons" href="/LifeGlue/signup.do" style="margin-top: 15px;">Signup</a>
<a class="btn btn-success" id="buttons" href="/LifeGlue/login.do" style="margin-top: 15px;margin-right:8px;">Login</a></center>
<h2 style="font-family:Lucida Handwriting;font-style: oblique;font-color:blue;display:inline font-color:white;margin-left:175px;">
<img src="images/lifeglueedit.jpg" id="rcorners" style="height:50px; width:50px;display:inline;margin-right:10px;"/>LifeGlue</h2>
<h3 class="slogan">Passion for better emergency treatment:)</h3>
</div> 


  <form action="/LifeGlue/insertUser.do" onsubmit="return validate()" method="post" style="margin-bottom:114px;">
  <div class="col-lg-4 col-xs-4 col-sm-4 col-md-4">

</div>

  <div class="col-lg-4 col-xs-4 col-sm-4 col-md-4 form-div">
  <div id="shadow">
  <h2 style = "display:inline;">SignUp</h2>
  
  <div class="form-group" >
      <label>UserName</label>
       <div id="user_error" style="display:none; color:red;">Username does not match</div>
      <input class = "form-control" type="text" name="name" required/>
    </div>
      <div class="form-group" >
      <label>Password</label>
      <div id="password_error" style="display:none; color:red;">Password and Confirm Password does not match</div>
      <input class = "form-control" type="password" name="password" id="password" required/>
    </div>
    
      <div class="form-group" >
      <label>Confirm Password</label>
      <input class = "form-control" type="password" name="cpassword" id="cpassword" required/>
    </div>
    
    <div class="form-group">
      <label>EmailId</label>
      <input class="form-control" type="email" name="email" required/>
    </div>
   
    
      <div class="form-group">
      <label>Mobile</label>
        <div id="mobile_error" style="display:none; color:red;">Invalid Mobile Number</div>
      <input class="form-control" type="text" name="mobile" required id="mobile"/>
    </div>
    
    <div class="form-group">
      <label >Role</label>
       <div id="role_error" style="display:none; color:red;">Role cannot be empty</div>
      <select class="form-control" name="role" id="role" required>
      <option value = "0">Select your role</option>
      <option value = "patient">Patient</option>
      <option value = "medical_staff">Medical Staff</option>
      </select>
    </div>
    <div class="form-group">
      <label>Address</label>
      <input placeholder="streetnumber,Area,City,State,Pincode" class="form-control" type="text" name="address"  required/>
    </div>
  <div>
 <input type ="submit" class="btn btn-success" value = "Signup"/>
</div>
</div>
</div>
<div class="col-lg-4 col-xs-4 col-sm-4 col-md-4"></div>
</form>    
</center>
<div class="footer">&copy;CopyRights for LifeGlue... Developed By Pavithra R</div> 
</body>

</html>

