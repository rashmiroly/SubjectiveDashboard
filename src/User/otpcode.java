package User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBCon.DBConnection;

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class otpcode
 */
@WebServlet("/otpcode")
public class otpcode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public otpcode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		PrintWriter pw=response.getWriter();
String name=(String)session.getAttribute("name");
String email=(String)session.getAttribute("email");
		
		
		String otpcode=request.getParameter("otpcode");
		Connection con;
		try
		{
		 	DBConnection db=new DBConnection();
			   Connection conn= db.getConnection();
			   Statement stRegister=(Statement) conn.createStatement();
			ResultSet rsLogin;
			rsLogin=stRegister.executeQuery("select * from login where Name='" +name+ "' and Email='"+email+"'");
			if(rsLogin.next())
			{
				if(otpcode.toLowerCase().equals(rsLogin.getString(10).toLowerCase()))
				{
				System.out.println(rsLogin.getString(2));
				pw.println("<script> alert('Login Successfully!');</script>");
				session.setAttribute("name", rsLogin.getString(2));
				RequestDispatcher rd = request.getRequestDispatcher("MessDashboard.html");
			
				rd.include(request, response); 
				}
				else
				{
					pw.println("<script> alert('Incorrect credentials.');</script>");
					//response.sendRedirect("otp.html");
					RequestDispatcher rd = request.getRequestDispatcher("otp.html");
					
					rd.include(request, response); 
			
					
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}

}
