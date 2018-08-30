<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <style>
            #white-background{
                display: none;
                width: 100%;
                height: 100%;
                position: fixed;
                top: 0px;
                left: 0px;
                background-color: #fefefe;
                opacity: 0.7;
                z-index: 9999;
            }
            
            #dlgbox{
                /*initially dialog box is hidden*/
                display: none;
                position: fixed;
                width: 480px;
                z-index: 9999;
                border-radius: 10px;
                background-color: #7c7d7e;
            }
            
            #dlg-header{
                background-color: #6d84b4;
                color: white;
                font-size: 20px;
                padding: 10px;
                margin: 10px 10px 0px 10px;
            }
            
            #dlg-body{
                background-color: white;
                color: black;
                font-size: 14px;
                padding: 10px;
                margin: 0px 10px 0px 10px;
            }
            
            #dlg-footer{
                background-color: #f2f2f2;
                text-align: right;
                padding: 10px;
                margin: 0px 10px 10px 10px;
            }
            
            #dlg-footer button{
                background-color: #6d84b4;
                color: white;
                padding: 5px;
                border: 0px;
            }
            .btn btn-success{
             background-color: #6d84b4;
            }
            
        </style>
</head>
<body>
 <body>
        <!-- dialog box -->
        <div id="white-background">
        </div>
        <div id="dlgbox">
            <div id="dlg-header">Already Uploaded!!</div>
            <div id="dlg-body">It seems you have already uploaded your medical history....Do you want to update</div>
            <div id="dlg-footer">
             <a class="btn btn-success" href="/LifeGlue/patientform.do">Yes</a>                 
             <a class="btn btn-success" href="/LifeGlue/home.do">No</a>

            </div>
        </div>
        
       
        
        <!-- script of dialog -->
        <script>

     
            
           window.onload =   function showDialog(){
                var whitebg = document.getElementById("white-background");
                var dlg = document.getElementById("dlgbox");
                whitebg.style.display = "block";
                dlg.style.display = "block";
                
                var winWidth = window.innerWidth;
                var winHeight = window.innerHeight;
                
                dlg.style.left = (winWidth/2) - 480/2 + "px";
                dlg.style.top = "150px";
            }
        </script>
    </body>
</body>
</html>