package User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBCon.*;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
	

	    response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
	    
	    try{
	    	DBConnection db=new DBConnection();
	   Connection con= db.getConnection();
	   String Name=request.getParameter("name");
	   System.out.println("Name "+Name); 
	   String address=request.getParameter("address");
	   System.out.println("address "+ address); 
	    String email=request.getParameter("email");
		   System.out.println("email "+ email); 
	    String mobile=request.getParameter("mobile");
		   System.out.println("mobile "+ mobile );
		   String SeatNo=request.getParameter("seat");
		   System.out.println("seatno "+ SeatNo );
		   String password=request.getParameter("password");
		   System.out.println("password "+password);
 
		   Statement pst= (Statement) con.createStatement();

	    
	   pst.executeUpdate("insert into login(Name,Address,Email,Mobile,Seatno,Password,Status,otpcode) values('"+Name+"','"+address+"','"+email+"','"+mobile+"','"+SeatNo+"','"+password+"','null','null')"); 		
	    out.println("<script type=\"text/javascript\">");
	    out.println("alert('User Register sucessfully...');");
	    out.println("location='index.html';");
	    out.println("</script>");
	    con.close();
	    }
	    catch(Exception ex)
	    {  	
	    	ex.printStackTrace();
	    }
		
	}
	}


