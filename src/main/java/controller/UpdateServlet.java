package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
@MultipartConfig(maxFileSize = 1617721512)
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	StudentDb studentDb;

	public UpdateServlet() {
		super();
		studentDb = StudentDb.getInstance();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String dob = request.getParameter("dob");

		String gender = request.getParameter("id");
		String grade = request.getParameter("gradecatagary");
		Part filePart = request.getPart("photo");
		int studentid = Integer.parseInt(request.getParameter("studentid"));

		
		
		
			InputStream inputStream = filePart.getInputStream();
			byte[] bytes = new byte[inputStream.available()];
		

		Students student = new Students(studentid, fname, lname, address, phone, dob, grade, gender);

		try {
			studentDb.updateUser(student,inputStream);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("list");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
