package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Results;
import com.Students;

import db.StudentDb;
import db.SubjectDuo;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/showprofile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	StudentDb studentDb;
	SubjectDuo subjectDuo;
    public ProfileServlet() {
        super();
        studentDb=StudentDb.getInstance();
        subjectDuo=SubjectDuo.getInstance();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("studentId"));
		Students student=studentDb.selectAllProfile(id);
		List<Results> list=subjectDuo.selectProfileResult(id);
		request.setAttribute("list", list);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("student-profile.jsp");
		request.setAttribute("student", student);
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
