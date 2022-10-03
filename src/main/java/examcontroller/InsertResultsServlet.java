package examcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Results;

import db.SubjectDuo;

/**
 * Servlet implementation class InsertResultsServlet
 */
@WebServlet("/insertresults")
public class InsertResultsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	SubjectDuo subjectDuo;
	ShowResultsServlet showResultsServlet;
    public InsertResultsServlet() {
        super();
        subjectDuo=SubjectDuo.getInstance();
        showResultsServlet=new ShowResultsServlet();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		int studentId=Integer.parseInt(request.getParameter("name"));
		int subjectId=Integer.parseInt(request.getParameter("subject"));
		String examId=(request.getParameter("exam"));
		int marks=Integer.parseInt(request.getParameter("mark"));
		
		Results result=new Results(studentId,subjectId,examId,marks);
		if(subjectDuo.insertResults(result)==false)
		{
			PrintWriter pw = response.getWriter();
			pw.println("<script type=\"text/javascript\">");
			   pw.println("alert('Data Insert failed');");
			   pw.println("location='exam-form.jsp';");
			   pw.println("</script>");
		}
		else {
			showResultsServlet.doPost(request, response);
		RequestDispatcher dispatcher=request.getRequestDispatcher("results.jsp");
		dispatcher.forward(request, response);
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
