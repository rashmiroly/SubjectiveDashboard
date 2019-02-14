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

import com.mysql.jdbc.Statement;

import DBCon.DBConnection;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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
		// TODO Auto-generated method stub
	
		HttpSession session=request.getSession(true);
		PrintWriter pw=response.getWriter();

		String Username=request.getParameter("username");
		String Password=request.getParameter("password");

		System.out.println("Name"+request.getParameter("username"));
		System.out.println("Password"+request.getParameter("password"));
		

			Connection con;
			try
			{
			 	DBConnection db=new DBConnection();
				   Connection conn= db.getConnection();
				   Statement stRegister=(Statement) conn.createStatement();
				ResultSet rsLogin;
				rsLogin=stRegister.executeQuery("select * from login where Name='" +Username+ "' and Password='"+Password+"'");
				if(rsLogin.next())
				{
					
					System.out.println(rsLogin.getString(2));
					pw.println("<script> alert('Login Successfully!');</script>");
					session.setAttribute("name", rsLogin.getString(2));
					session.setAttribute("email", rsLogin.getString(4));
					RequestDispatcher rd = request.getRequestDispatcher("Dashboard.html");
				
					rd.include(request, response); 
				}
				else
				{
					pw.println("<script> alert('Incorrect credentials.');</script>");
					response.sendRedirect("index.html");
			
					
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		
	}
		
	
	}


