import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Attendence extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		PrintWriter out=response.getWriter();
		String s1=request.getParameter("n2");
                
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
                Date date = new Date();
		
                String s4="1";
		
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String db_url="jdbc:mysql://localhost:3306/minor";
			String db_uname="root";
			String db_upass="sunil1137";
			
			Connection con=DriverManager.getConnection(db_url,db_uname,db_upass);
			Statement st=con.createStatement();
                        
			String q1="select attendence from attendence where id='"+s1+"' ORDER BY attendence DESC";
                        ResultSet rs=st.executeQuery(q1);
                        if(rs.next()){
                            int i=Integer.parseInt(rs.getString(1))+1;
			String q="insert into attendence values('"+s1+"','"+formatter.format(date)+"','"+java.time.LocalTime.now()+"','"+i+"')";
			st.executeUpdate(q);
                        response.sendRedirect("ahome.html");
                        }
		
			con.close();
		}
			catch(Exception e1)		
			{
				System.out.println(e1);
		}
		
		out.println("<html>");
		out.println("<body>");
		
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
