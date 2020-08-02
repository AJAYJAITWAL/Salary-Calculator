import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AddSalary extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		PrintWriter out=response.getWriter();
		String s1=request.getParameter("id");
		String s2=request.getParameter("sal");
                
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String db_url="jdbc:mysql://localhost:3306/minor";
			String db_uname="root";
			String db_upass="sunil1137";
			
			Connection con=DriverManager.getConnection(db_url,db_uname,db_upass);
			Statement st=con.createStatement();
			String q="insert into salary values('"+s1+"','"+s2+"')";
			st.executeUpdate(q);
		response.sendRedirect("ahome.html");
			con.close();
		}
			catch(Exception e1)		
			{
				System.out.println(e1);
		}
		
		out.println("<html>");
		out.println("<body>");
		out.println("<p>Name="+s1+"</p>");
		out.println("<p>Name="+s2+"</p>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
