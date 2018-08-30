<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
#display-checkbox
{
  display: block;
}
#comments
{
 width: 400px;
 height: 100px
}
#table-style
{
  width: 20px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <body style="background-color:#E5E8E8;">
<center>

  <form action="/LifeGlue/submitPatient.do" method="post">
  <div class="col-lg-3 col-xs-3 col-sm-3 col-md-3">

</div>

  <div class="col-lg-7 col-xs-7 col-sm-10 col-md-10 form-div">
  <div id="shadow">
  
  <img src="images/lifeglueedit.jpg" style="height:50px; width:50px; display:inline" id="rcorners"/>
  <h2 style = "display:inline;">Patient Details</h2>
  <h4>Please fill your medical details...</h4>
  <div class="form-group" >
      <label>Full Name</label>
      <input class = "form-control" type="text" name="fullname" />
    </div>
    
     <div class="form-group">
     <label>Date of Birth</label>
      <input class = "form-control" type="date" name="dob" />
    </div>
    
     <div class="form-group">
     <label>Patient Height (cm's) *</label>
      <input class = "form-control" type="number" name="height" placeholder="ex:165" />
    </div>
     <div class="form-group">
     <label>Patient Weight (kg's) *</label>
      <input class = "form-control" type="number" name="weight" placeholder="ex:70" />
    </div>
    
     <div class="form-group">
      <label >Blood Group *</label>
      <select class="form-control" name="bloodGroup">
      <option value = "O+ve">O+ve</option>
      <option value = "O-ve">O-ve</option>
      <option value = "A+ve">A+ve</option>
      <option value = "A-ve">A-ve</option>
      <option value = "B+ve">B+ve</option>
      <option value = "B-ve">B-ve</option>
      <option value = "AB+ve">AB+ve</option>
      <option value = "AB-ve">AB-ve</option>
      </select>
    </div>
    
    <div class="form-group">
     <label>Average Blood Cholestrol Level*</label>
      <input class = "form-control" type="number" name="cholesterol" placeholder="ex: 170 mg/dL" />
    </div>
    
     <div class="form-group">
     <label>Average Blood Pressure Level*</label>
      <input class = "form-control" type="number" name="pressure" placeholder="ex: 80" />
    </div>
    
     <div class="form-group">
     <label>Average Sugar Level*</label>
      <input class = "form-control" type="number" name="sugar" placeholder="ex: 70mg/dl." />
    </div>
    
    
    
      <div class="form-group">
      <label>Check the conditions that apply to you*</label>
      
      <table>
      <tr><td><label><input type="checkbox" name="conditions" value="Asthma"/>Asthma</td><td></label></td></tr>
      <tr><td><label><input type="checkbox" name="conditions" value="Cancer"/>Cancer</td><td></label></td></tr> 
      <tr><td><label><input type="checkbox" name="conditions" value="Cardiac disease"/>Cardiac disease</td><td></label></td></tr>
      <tr><td><label><input type="checkbox" name="conditions" value="Diabetes"/>Diabetes</td><td></label></td></tr>
      <tr><td><label><input type="checkbox" name="conditions" value="Hypertension"/>Hypertension</td><td></label></td> 
      <tr><td><label><input type="checkbox" name="conditions" value="Psychiatric disorder"/>Psychiatric disorder</td><td></label></td></tr> 
      <tr><td><label><input type="checkbox" name="conditions" value="Epilepsy"/>Epilepsy</td><td></label></td></tr>  
    </table>
    </div>
    
     <div class="form-group">
      <label>Check the symptoms that you experience during sick: *</label>
      
    
      <table>
      <tr><td><label><input type="checkbox" name="symptoms" value="Chest_pain" />Chest pain</td><td></label></td></tr>
      <tr><td><label><input type="checkbox" name="symptoms" value="Respiratory" />Respiratory</td><td></label></td></tr> 
      <tr><td><label><input type="checkbox" name="symptoms" value="Cardiac disease"/>Cardiac disease</td><td></label></td></tr>
      <tr><td><label><input type="checkbox" name="symptoms" value="Cardiovascular"/>Cardiovascular</td><td></label></td></tr>
      <tr><td><label><input type="checkbox" name="symptoms" value="Hematological"/>Hematological</td><td></label></td> 
      <tr><td><label><input type="checkbox" name="symptoms" value="Lymphatic"/>Lymphatic</td><td></label></td></tr> 
      <tr><td><label><input type="checkbox" name="symptoms" value="Neurological" />Neurological</td><td></label></td></tr>  
      <tr><td><label><input type="checkbox" name="symptoms" value="Psychiatric" />Psychiatric</td><td></label></td></tr>  
      <tr><td><label><input type="checkbox" name="symptoms" value="Gastrointestinal" />Gastrointestinal</td><td></label></td></tr>  
      <tr><td><label><input type="checkbox" name="symptoms" value="Genitourinary"/>Genitourinary</td><td></label></td></tr>  
      <tr><td><label><input type="checkbox" name="symptoms" value="Weight gain" />Weight gain</td><td></label></td></tr>  
      <tr><td><label><input type="checkbox" name="symptoms" value="Weight loss"/>Weight loss</td><td></label></td></tr>  
      <tr><td><label><input type="checkbox" name="symptoms" value="Musculoskeletal"/>Musculoskeletal</td><td></label></td></tr>  
                  
    </table></div>
   
    
     <div class="form-group">
      <label> What is your Gender? *</label><br>
       <label><input type="radio" name="Gender" value="Male"/>Male</label>
       <label><input type="radio" name="Gender" value="Female"/>Female</label>
      </div>
      
       <div class="form-group">
      <label> Do you use or do you have history of using tobacco? *</label><br>
       <label><input type="radio" name="tobacco" value="Yes"/>Yes</label>
       <label><input type="radio" name="tobacco" value="No"/>No</label>
      </div>
      
      <div class="form-group">
      <label> Do you use or do you have history of using illegal drugs? *</label><br>
       <label><input type="radio" name="drugs" value="Yes"/>Yes</label>
       <label><input type="radio" name="drugs" value="No"/>No</label>
      </div>
      
      <div class="form-group">
      <label> How often do you consume alcohol? *</label><br>
       <label><input type="radio" name="alcohol" value="Daily"/>Daily</label>
       <label><input type="radio" name="alcohol" value="Weekly"/>Weekly</label>
       <label><input type="radio" name="alcohol" value="Monthly"/>Monthly</label>
       <label><input type="radio" name="alcohol" value="Occasionally"/>Occasionally</label>
       <label><input type="radio" name="alcohol" value="Never"/>Never</label>
      </div>
     
     
     
       <div class="form-group">
      <label>Enter the medications recently taken</label>
     
       <table class="table table-bordered table-striped table-highlight">
      <tr><th>Purpose</th><th>Medications</th><th>Hospital Name</th><th>Date of Treatment</th></tr>
      <tr><td><input type="text" name="purpose1"></td><td><input type="text" name="medication1"></td><td><input type="text" name="hospital1"></td><td><input type="date" name="date1"></td></tr>
      <tr><td><input type="text" name="purpose2"></td><td><input type="text" name="medication2"></td><td><input type="text" name="hospital2"></td><td><input type="date" name="date2"></td></tr>
      <tr><td><input type="text" name="purpose3"></td><td><input type="text" name="medication3"></td><td><input type="text" name="hospital3"></td><td><input type="date" name="date3"></tr>
      <tr><td><input type="text" name="purpose4"></td><td><input type="text" name="medication4"></td><td><input type="text" name="hospital4"></td><td><input type="date" name="date4"></tr>
    </table>
      </div>
   
  
 
   <div class="form-group">
   <label>Include other comments regarding your Medical History</label>
  <textarea class="form-control" rows="5" id="comment" name="comments"></textarea>
   </div>
   <div>
 <input type="submit" class="btn btn-success" value="Submit History">
</div>
</div>
</div>
<div class="col-lg-4 col-xs-4 col-sm-4 col-md-4">
</div>

</form>    
</center>
</body>

</html>
