package examcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Examination;
import com.Results;
import com.Students;
import com.Subjects;

import db.StudentDb;
import db.SubjectDuo;

/**
 * Servlet implementation class ShowResultsServlet
 */
@WebServlet("/showresults")
public class ShowResultsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	SubjectDuo subjectDuo;
	StudentDb studentDb;
    public ShowResultsServlet() {
        super();
        subjectDuo=SubjectDuo.getInstance();
        studentDb=StudentDb.getInstance();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		List<Students> listStudents=studentDb.selectFirstLastName();
		request.setAttribute("listStudents", listStudents);
		
		List<Results> listResults=subjectDuo.selectALLResults();
		request.setAttribute("listResults", listResults);
		
		List<Subjects> subjectList=subjectDuo.selectAllSubjects();
		request.setAttribute("subjectList", subjectList);
		
		List<Examination> examList=subjectDuo.selectAllExam();
		request.setAttribute("examList", examList);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("results.jsp");
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
