package subjectController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Subjects;

import db.SubjectDuo;

/**
 * Servlet implementation class InsertSubjectServlet
 */
@WebServlet("/insertsubject")
public class InsertSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	SubjectDuo subjectDuo;
	SelectSubjectServlet selectSubjectServlet;
    public InsertSubjectServlet() {
        super();
        subjectDuo=SubjectDuo.getInstance();
        selectSubjectServlet=new SelectSubjectServlet();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		selectSubjectServlet.doPost(request, response);
		String subName=request.getParameter("subjectname");
		String grade=request.getParameter("subjectcat");
		if(subjectDuo.alredyExits(subName, grade)==true)
		{
			PrintWriter writer=response.getWriter();
//			writer.println("Subject Already exits");
			writer.println("<script type=\"text/javascript\">");
			   writer.println("alert('Subject Already exits ');");
			   writer.println("location='subject-form.jsp';");
			   writer.println("</script>");
			
		}
		else
		{
		Subjects subject=new Subjects(subName,grade);
		subjectDuo.insertSubject(subject);
		response.sendRedirect("subject-form.jsp");
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
