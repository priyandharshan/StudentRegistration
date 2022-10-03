package usercontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Users;

import db.UserDuo;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	UserDuo userDuo;
    public UserLoginServlet() {
        super();
        userDuo=new UserDuo();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("emaillogin");
		String password=request.getParameter("passwordlogin");
		//Users user=new Users(email,password);
		
		if(userDuo.checkUsers(email, password)==true)
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("home");
			dispatcher.forward(request, response);
		}
		else
		{
			PrintWriter pw = response.getWriter();
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('email password do not match');");
			pw.println("location='user-login.jsp';");
			pw.println("</script>");
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
