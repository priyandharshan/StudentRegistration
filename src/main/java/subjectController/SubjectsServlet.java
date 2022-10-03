package subjectController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Subjects;

import db.SubjectDuo;

/**
 * Servlet implementation class SubjectsServlet
 */
@WebServlet("/subjects")
public class SubjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	SelectSubjectServlet selectSubjectServlet;
	SubjectDuo subjectDuo;
    public SubjectsServlet() {
        super();
        subjectDuo=SubjectDuo.getInstance();
       // selectSubjectServlet=new SelectSubjectServlet();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//selectSubjectServlet.doPost(request, response);
List<Subjects> listSubject = subjectDuo.selectAllSubjects();
		
		//System.out.println(listSubject);
		request.setAttribute("listSubject", listSubject);
	RequestDispatcher dispatcher=request.getRequestDispatcher("subject-form.jsp");
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
