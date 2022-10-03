package controller;

import java.io.IOException;
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
 * Servlet implementation class StudentPageServlet
 */
@WebServlet( "/students")
public class StudentPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//	StudentServlet studentServlet;
	StudentDb studentDb;
    public StudentPageServlet() {
        super();
        studentDb=StudentDb.getInstance();
//        studentServlet= new StudentServlet();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		List<Students> listStudent = studentDb.selectStudents();
		
//		System.out.println(listStudent);
		request.setAttribute("listStudent", listStudent);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("student-list.jsp");
		//response.sendRedirect("list");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
