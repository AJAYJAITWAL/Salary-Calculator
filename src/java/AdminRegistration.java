import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AdminRegistration extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		PrintWriter out=response.getWriter();
		String s1=request.getParameter("un");
		String s2=request.getParameter("id");
                String s3=request.getParameter("up");
		String s4=request.getParameter("mn");
		String s5=request.getParameter("em");
                String s6=request.getParameter("dj");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String db_url="jdbc:mysql://localhost:3306/minor";
			String db_uname="root";
			String db_upass="sunil1137";
			
			Connection con=DriverManager.getConnection(db_url,db_uname,db_upass);
			Statement st=con.createStatement();
			String q="insert into admin_register values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"')";
			st.executeUpdate(q);
		
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
		out.println("<p>Name="+s3+"</p>");
		out.println("<p>Name="+s4+"</p>");
                out.println("<p>Name="+s5+"</p>");
		out.println("<p>Name="+s6+"</p>");
                
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
