<%-- 
    Document   : reg
    Created on : 31 Mar, 2019, 12:36:22 PM
    Author     : dell
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title> Employee Registration </title>
	<link rel="stylesheet" href="test.css">
	<style type="text/css">
	body
	
	{
	background-image:url('p12.jpg'); 
	background-repeat:no-repeat;
	background-size:100%; 
	}
table
	{
		margin-top:100px;
		background-color:rgba(0,10,0,0.5);
	}	
	.B
	{
		width: 100px;
		height: 25px;
		color: white;
		background:linear-gradient(red,black);
		border-radius: 20px 0px 20px;
	}
	.B:hover
	{
		width:100px;
		height: 25px;
		color: white;
		background: linear-gradient(blue,green);
		border-radius: 30px 0px 30px;
	}
</style>
</head>
<body>
    <%
    String r=request.getParameter("Register");
        
        if(r!=null){
    String s1=request.getParameter("un");
		String s2=request.getParameter("id");
                String s3=request.getParameter("up");
		String s4=request.getParameter("mn");
		String s5=request.getParameter("em");
                String s6=request.getParameter("dj");
                String s7=request.getParameter("dept");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String db_url="jdbc:mysql://localhost:3306/minor";
			String db_uname="root";
			String db_upass="sunil1137";
			
			Connection con=DriverManager.getConnection(db_url,db_uname,db_upass);
			Statement st=con.createStatement();
			String q="insert into register values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"')";
			st.executeUpdate(q);
            
			 q="insert into attendence values('"+s2+"','null','null','0')";
			st.executeUpdate(q);
                        %> <script>alert("Registration Succesfully");</script><%
                           response.sendRedirect("Register.jsp");
			con.close();
		}
			catch(Exception e1)		
			{
				out.println(e1);
		}
    
        }
    %>
<div id="menu">
<ul>
   
	<li><a href="ahome.html"> Home </a></li>
	<li><a href="Register.jsp"> Add Employee  </a></li>
        <li><a href="aregistration.html"> Create Admin  </a></li>
	<li><a href="search.html">  Attendence </a></li>
	<li><a href="search1.html"> Salary </a></li>
        <li><a href="addsalary.html"> Add_Salary </a></li>
        <li><a href="Empinfo">  EmpInfo </a></li>
        <li><a href="Logout"> Logout </a></li>
</ul>
</div>	
		<div>
			<center>
			<form action="" method="post">
				<table cellpadding="20px">
					<tr>
						<td style="font-weight: bold;" >Enter name</td>
						<td> <input type="text" placeholder="Enter name" name="un"></td>
					</tr>
					<tr>
					<td style="font-weight: bold;">Enter User_ID</td>
					<td> <input type="text" placeholder="Enter User_ID" name="id" ></td>
					</tr>
			
					<tr>
						<td style="font-weight: bold;">Enter Password</td>
						<td> <input type="Password" placeholder="Enter Password" name="up"></td>
					</tr>
					
					<tr>
					<td style="font-weight: bold;">Enter Mobile-no</td>
					<td> <input type="number" placeholder="Mobile-no" name="mn"></td>
			</tr>
			<tr>
			
					<td style="font-weight: bold;">Enter Email-id</td>
					<td> <input type="email" placeholder="Enter Email-id" name="em"></td>
			</tr>
			
			<tr>
			
					<td style="font-weight: bold;">Date of Joining</td>
					<td> <input type="text" placeholder="Date of Joining" name="dj"></td>
			</tr>
                        
                        <tr>
			
					<td style="font-weight: bold;">Department</td>
					<td> <input type="text" placeholder="Department" name="dept"></td>
			</tr>
					<tr>
                                            <th colspan="2"><input type="submit" class="B" value="Register" name="Register"></th>
					</tr>
					
					
					
				</table>
				</form>
			</center>
		</div>
</body>
</html>