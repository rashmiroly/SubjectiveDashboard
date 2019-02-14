package Preprocess;

import DBCon.DBConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadDataset
 */
@WebServlet("/UploadDataset")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 50, // 50MB
maxFileSize = 1024 * 2048 * 100, // 100 MB

maxRequestSize = 1024 * 2048 * 1000)

public class UploadDataset extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static long size,strat,end,totaltime;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadDataset() {
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
		HttpSession session = request.getSession(true);
		System.out.println("Welcome");
		Part filePart = request.getPart("file1");
		String username=(String)session.getAttribute("name");
		String fileName =filePart.getName();
		//getFileName(filePart);
		InputStream inputStream = filePart.getInputStream();
		 String ContentType=filePart.getContentType();
		 size=filePart.getSize();
		 String ExamName=request.getParameter("examname");
		 String SubjectName=request.getParameter("lastname");
		 BufferedReader br = null;
			StringBuilder sb = new StringBuilder();
			String line,data;
			try{
			DBConnection db=new DBConnection();
			   Connection con= db.getConnection();
				br = new BufferedReader(new InputStreamReader(inputStream));
			   while ((data = br.readLine()) != null)
	             {
			   String[] parts = data.split("#");
	             
			   System.out.println(data+"=s>"+parts.length);
			   System.out.println(data);
			   if(parts.length==1)
			   {
				   
			   }
			   else{
			   String[] ans=parts[1].split("0");
		     String sql = "insert into data (ExamName,SubjectName,Question,Answer) values (?,?,?,?)";

             PreparedStatement pdt = con.prepareStatement(sql);
             pdt.setString(1,ExamName);
             pdt.setString(2, SubjectName);
             pdt.setString(3, parts[0].replace("'", ""));
             pdt.setString(4, ans[1].replace("'", ""));
            
            
             int n1 = pdt.executeUpdate();
	             }}
	              
	}catch(Exception ex)
	{
		System.out.println(ex);
		
		}
			   }

}
