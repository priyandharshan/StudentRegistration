package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Students;

import db.StudentDb;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/list")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	private StudentDb studentDb;

	public StudentServlet() {
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

	
			List<Students> listStudent = studentDb.selectStudents();
			
//			System.out.println(listStudent);
			request.setAttribute("listStudent", listStudent);
			RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
			dispatcher.forward(request, response);
		

	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request,response);
		
		// response.sendRedirect("stdentdetails.jsp");
		// RequestDispatcher
		// patcher=request.getRequestDispatcher("/studentregister.jsp");
		// patcher.include(request, response);
	}

}
