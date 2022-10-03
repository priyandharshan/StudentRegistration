package subjectController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Subjects;

import db.SubjectDuo;

/**
 * Servlet implementation class EditSubjectServlet
 */
@WebServlet("/editsubject")
public class EditSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	SubjectDuo subjectDuo;

	public EditSubjectServlet() {
		super();
		subjectDuo = SubjectDuo.getInstance();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Subjects subject;
		int id = Integer.parseInt(request.getParameter("subjectId"));

		subject = subjectDuo.selectSubject(id);
		request.setAttribute("subject", subject);
		
		RequestDispatcher dispatcher =request.getRequestDispatcher("subject-form");
		dispatcher.forward(request, response);

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
