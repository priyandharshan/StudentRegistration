package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.Students;

import db.StudentDb;

/**
 * Servlet implementation class InsertDataServlet
 */
@WebServlet("/insert")
@MultipartConfig(maxFileSize = 1617721512)
public class InsertDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private StudentDb studentDb;
	private StudentServlet studentServlet;
    public InsertDataServlet() {
        super();
        // TODO Auto-generated constructor stub
        
        studentDb=StudentDb.getInstance();
        studentServlet=new StudentServlet();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String dob = request.getParameter("dob");
		Part filePart=request.getPart("photo");
		
		byte[] bytes;
		
		InputStream inputStream=filePart.getInputStream();
		bytes = new byte[inputStream.available()];
		
		Students student = new Students();
	
		
		String gender = request.getParameter("id");

		String grade = request.getParameter("gradecatagary");

		

		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setAddress(address);
		student.setPhonenumber(phone);
		student.setDateOfBirth(dob);

		student.setGender(gender);
		student.setGrade(grade);
		student.setImage(bytes);
	


		if (studentDb.insertUser(student,inputStream) == true) {
			studentServlet.doPost(request, response);
			response.sendRedirect("student-list.jsp");
		} else {
			PrintWriter pw = response.getWriter();
			pw.print("Data inserted failed");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
