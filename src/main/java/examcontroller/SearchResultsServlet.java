package examcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Results;

import db.SubjectDuo;

/**
 * Servlet implementation class SearchResultsServlet
 */
@WebServlet("/searchresults")
public class SearchResultsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	SubjectDuo subjectDuo;
    public SearchResultsServlet() {
        super();
        subjectDuo=SubjectDuo.getInstance();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int studentId=Integer.parseInt(request.getParameter("studentlist"));
//		int subjectId=Integer.parseInt(request.getParameter("subjectlist"));
//		String examId=request.getParameter("examlist");
		List<Results> list=subjectDuo.searchResults(studentId);
		request.setAttribute("list", list);
		
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
