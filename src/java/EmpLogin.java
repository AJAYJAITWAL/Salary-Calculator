import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.http.Cookie;

public class EmpLogin extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		PrintWriter out=response.getWriter();
		String s1=request.getParameter("id");
		String s2=request.getParameter("upass");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String db_url="jdbc:mysql://localhost:3306/minor";
			String db_uname="root";
			String db_upass="sunil1137";
			
			Connection con=DriverManager.getConnection(db_url,db_uname,db_upass);
			Statement st=con.createStatement();
			String q="select * from register where id='"+s1+"' AND upass='"+s2+"' ";
                        //String q1="select * from register where id='"+s1+"' AND upass='"+s2+"' ";
			ResultSet rs=st.executeQuery(q);
                       // ResultSet rs1=st.executeQuery(q);
			if(rs.next()){
                           Cookie ck=new Cookie("id",s1);
                            ck.setMaxAge(60*60);
                            response.addCookie(ck);
				response.sendRedirect("ehome.html");
                                
			}
			else
			{
					response.sendRedirect("emplogin.html");
			}
		
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