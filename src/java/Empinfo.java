import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Empinfo extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		PrintWriter out=response.getWriter();
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
			String q="select * from register";
			ResultSet rs=st.executeQuery(q);
				out.println("<html>");
				out.println("<body>");
				
	 out.println("<link rel='stylesheet' href='test.css'></head><body bgcolor='pink'><div id='menu'><ul><a href='ahome.html'><li> Home</li></a><a href='Register.jsp'><li> AddEmployee </li></a><a href='aregistration.html'><li> Create Admin </li></a><a href='search.html'><li>Attendence</li></a><li> <a href='search1.html'> Salary</li><a href='addsalary.html'><li> Add Salary </li></a></a><a href='Empinfo'><li> EmpInfo</li></a><a href='Logout'><li> Logout</li></a></ul></div>");
				
				out.println("<div>");
				out.println("<center>");
                                out.println("<form action='Soall' method='get'>");
				out.println("<table cellpadding='12'>");
				out.println("<tr>");
				out.println("<td> Name</td>");
				out.println("<td> ID</td>");
                               // out.println("<td> Password</td>");
				out.println("<td> Mobile</td>");
                                out.println("<td> Email ID</td>");
				out.println("<td> D.O.J</td>");
				out.println("<td> Dept</td>");
				out.println("</tr>");
			while(rs.next())
			{
						out.println("<tr>");
						out.println("<td>"+rs.getString(1)+"</td>");
						out.println("<td>"+rs.getString(2)+"</td>");
						//out.println("<td>"+rs.getString(3)+"</td>");
                                                out.println("<td>"+rs.getString(4)+"</td>");
						out.println("<td>"+rs.getString(5)+"</td>");
						out.println("<td>"+rs.getString(6)+"</td>");
                                                out.println("<td>"+rs.getString(7)+"</td>");
						out.println("</tr>");
			}
						out.println("</tables>");
                                                out.println("</form>");
						out.println("</center>");
						out.println("</div>");
			con.close();
		}
			catch(Exception e1)		
			{
				System.out.println(e1);
		}
		
		out.println("</html>");
		out.println("</body>");
		
		out.close();
	}
}
