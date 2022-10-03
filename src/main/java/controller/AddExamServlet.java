package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Examination;
import com.Students;
import com.Subjects;

import db.SubjectDuo;

/**
 * Servlet implementation class AddExamServlet
 */
@WebServlet("/addmarks")
public class AddExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddExamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Students student;
		int id=Integer.parseInt(request.getParameter("studentId"));
		student=new Students(id);
		SubjectDuo subjectDuo =SubjectDuo.getInstance();
		List<Examination> examList=subjectDuo.selectAllExam();
		request.setAttribute("examList", examList);
		List<Subjects> subjectList=subjectDuo.selectAllSubjects();
		request.setAttribute("subjectList", subjectList);
		RequestDispatcher dispatcher =request.getRequestDispatcher("exam-form.jsp");
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
