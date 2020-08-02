import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Search extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		PrintWriter out=response.getWriter();
		String s1=request.getParameter("u1");
		
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String db_url="jdbc:mysql://localhost:3306/minor";
			String db_uname="root";
			String db_upass="sunil1137";
			
			Connection con=DriverManager.getConnection(db_url,db_uname,db_upass);
			Statement st=con.createStatement();
			String q="select * from register where  id='"+s1+"'";
			ResultSet rs=st.executeQuery(q);
			out.println("<html>");
			 out.println("<link rel='stylesheet' href='test.css'></head><body bgcolor='wheat'><div id='menu'><ul><a href='ahome.html'><li> Home</li></a><a href='registration.html'><li> AddEmployee </li></a><a href='Attendence'><li>Attendence</li></a><li> <a href='salary.html'> Salary</li></a><a href='Empinfo'><li> EmpInfo</li></a><a href='logout.html'><li> Logout</li></a></ul></div>");
	
			if(rs.next()){
				out.println("<div>");
				out.println("<center>");
				out.println("<form action='Attendence' method='get'>");
				out.println("<table cellpadding='12'>");
				out.println("<tr>");
				//out.println("<td> rollno</td>");
				// out.println("</tr>");
				out.println("<tr>");
		out.println("<td>Name </td>");
		out.println("<td><input type='text' name='n1' value='"+rs.getString(1)+"'> </td>");
                out.println("</tr>");
                
                out.println("<td>Id </td>");
		out.println("<td><input type='text' name='n2' value='"+rs.getString(2)+"'> </td>");
                out.println("</tr>");
		
	out.println("<tr>");
		out.println("<td>Mob_no </td>");
		out.println("<td><input type='text' name='n4' value='"+rs.getString(4)+"'> </td>");
out.println("</tr>");
		
	
	
			out.println("<th colspan='2'><input type='submit' class='B' value='Attendance'> </th>");
       
                        out.println("</tr>");
		
		out.println("</form>");
		out.println("</table>");
		out.println("</center>");

                
    out.println("</div>");
    
}
else
{
out.println("Invalid RNO..");

}
	//6. close connection
	con.close();
	}
	catch(Exception e1)
	{
		out.println(e1);
	}
	 
        out.close();
    }

   
}
