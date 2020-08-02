import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Logout extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
	  PrintWriter out = response.getWriter();
	  Cookie ck = new Cookie("id","");
	  ck.setMaxAge(0);
	  response.addCookie(ck);
	  response.sendRedirect("info.html");
	}
} 