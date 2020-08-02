import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Salary extends HttpServlet
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
			String q="select * from attendence where  id='"+s1+"' ORDER BY attendence DESC";
			ResultSet rs=st.executeQuery(q);
			out.println("<html>");
			 out.println("<link rel='stylesheet' href='test.css'></head><body><div id='menu'><ul><a href='ahome.html'><li> Home</li></a><a href='Register.jsp'><li> AddEmployee </li></a><a href='search.html'><li>Attendence</li></a><li> <a href='search1.html'> Salary</li></a><a href='Empinfo'><li> EmpInfo</li></a><a href='logout.html'><li> Logout</li></a></ul></div>");
	
			if(rs.next()){
				out.println("<div>");
			
	
                int s3=Integer.parseInt(rs.getString(4));

             
			String q1="select salary from salary where id='"+s1+"'";
                        rs=st.executeQuery(q1);
                        if(rs.next()){
                            int i=Integer.parseInt(rs.getString(1));
                            
                            out.println(" <center>");
                            out.println("Your Attendence is :  "+s3);
                            out.println("<br>Your salary is  : "+i);
                            out.println("<br>This Month Amount is : ");
                            out.println((i/30)*s3);
                            out.println(" </center>");
			
                        }
                
		out.println("</tr>");
			
        out.println("</tr>");
		
		out.println("</form>");
		out.println("</table>");
		out.println("</center>");

                
    out.println("</div>");
}
else
{
out.println("Invalid Id");

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
