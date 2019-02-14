<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="DBCon.*"%>
<%@page import="java.sql.Connection"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Admin Dashboard</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css1/bootstrap.min.css" />
<link rel="stylesheet" href="css1/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css1/uniform.css" />
<link rel="stylesheet" href="css1/select2.css" />
<link rel="stylesheet" href="css1/matrix-style.css" />
<link rel="stylesheet" href="css1/matrix-media.css" />
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
<body>

<!--Header-part-->
<div id="header">
  <h4>Admin Dashboard</h4>
  <!-- <h1><a href="dashboard.html">Admin Dashboard</a></h1> -->
</div>
<!--close-Header-part--> 

<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
  <ul class="nav">
    
    
    <li class=""><a title="" href="index.html"><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
  </ul>
</div>


<!--sidebar-menu-->

<div id="sidebar"> <a href="#" class="visible-phone"><i class="icon icon-th"></i>User</a>
  <ul>
     
    <li class="active"><a href="AdminDashboard.html"><i class="icon icon-th"></i> <span>User</span></a></li>
    <hr> 
    
     <li class="active"><a href="AddExam.jsp"><i class="icon icon-th"></i> <span>Add Exam</span></a></li>
    
    
  </ul>
</div>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">User</a> </div>
    <h1>Students</h1>
  </div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span12">
        
        
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>Students table </h5>
            <!-- <span class="label label-info"> </span> --> </div>
          <div class="widget-content ">
            <table class="table table-bordered table-striped with-check">
              <thead>
                <tr>
                  
                  <th>User Name</th>
                  <th>Address</th>
                  <th>Email</th>
                  <th>Mobile</th>
                   <th>Seat No</th>
                </tr>
              </thead>
              <tbody>
              <%
             try{ 
              Connection con;
  				DBConnection db=new DBConnection();
  				   Connection conn= db.getConnection();
  				   Statement stRegister=(Statement) conn.createStatement();
  				ResultSet rsLogin;
  				rsLogin=stRegister.executeQuery("select * from login");
  				while(rsLogin.next())
  				{
             
              %>
                <tr>
                   <td><%=rsLogin.getString("Name") %></td>
                   <td><%=rsLogin.getString("Address") %></td>
                    <td><%=rsLogin.getString("Email") %></td>
                     <td><%=rsLogin.getString("Mobile") %></td>
                     <td><%=rsLogin.getString("Seatno") %></td>
                   <!--<td> <a href="AcceptFile?filenamedb=<%=rsLogin.getString("Email")%>,<%= rsLogin.getString("Name")%>"></a></td>
               <td> <a href="rejectfileauthor?filenamedb=<%=rsLogin.getString("Email")%>,<%=rsLogin.getString("Name")%>" ></a></td>
                   --!>
                </tr>
                <%
                }
             }
              catch(Exception e){}
  				%>
              </tbody>
            </table>
          </div>
        </div>
       
        </div>
      </div>
    </div>
  </div>

<!--Footer-part-->
<div class="row-fluid">
  <div id="footer" class="span12">  </div>
</div>
<!--end-Footer-part-->
<script src="js/jquery.min.js"></script> 
<script src="js/jquery.ui.custom.js"></script> 
<script src="js/bootstrap.min.js"></script> 
<script src="js/jquery.uniform.js"></script> 
<script src="js/select2.min.js"></script> 
<script src="js/jquery.dataTables.min.js"></script> 
<script src="js/matrix.js"></script> 
<script src="js/matrix.tables.js"></script>
</body>
</html>
