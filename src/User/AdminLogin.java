package User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
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
	
		String username= request.getParameter("name");
		String password= request.getParameter("password");
		
		System.out.println(username +"  "+password);
		
		if(username.equals("admin") && password.equals("admin"))
		{
	//		session.setAttribute("name", "admin");
			pw.println("<script> alert('Login Successfully!!!');</script>");
			RequestDispatcher rd = request.getRequestDispatcher("/Adminhome.jsp");
			rd.include(request, response);
			}
		else
		{
			pw.println("<script> alert(' Incorrect credentials');</script>");
			
//			 response.sendRedirect("Admin.html");
			RequestDispatcher rd=request.getRequestDispatcher("Admin.html");
			rd.include(request, response);
		
		}
			   
		}
	}


