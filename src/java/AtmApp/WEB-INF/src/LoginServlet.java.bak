import java.io.*;
import javax.servlet.*;
import java.sql.*;
import javax.servlet.http.*;
public class LoginServlet extends HttpServlet
{
	Connection con;
	PreparedStatement ps;
	public void init(ServletConfig cfg)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/major","root","root");
			ps=con.prepareStatement("select * from login where name=? and password=?");

		}
		catch (Exception ee)
		{
			ee.printStackTrace();
		}
		System.out.println("inside init()method");
	}//init()
	
	public void destroy()
	{
		try
		{
			con.close();
			ps.close();
		}
		catch (Exception ee)
		{
			ee.printStackTrace();
		}
}//destroy()

	public void doPost(HttpServletRequest req,HttpServletResponse res)
	{
		String name=req.getParameter("card_no");
		String password=req.getParameter("pin_no");
		try
		{
			res.setContentType("text/html");
			PrintWriter out=res.getWriter();
			out.println("<html><body bgcolor=wheat><h1>");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				out.println("<font color=green>Login Successfully</font>");
			}
			else
			{
				out.println("<font color=red>Login Fail</font>");
			}
			rs.close();
			out.println("</h1></body></html>");
		}
		catch (Exception ee)
		{
			ee.printStackTrace();
		}
		System.out.println("inside doPost()method");
	}//doPost()
}