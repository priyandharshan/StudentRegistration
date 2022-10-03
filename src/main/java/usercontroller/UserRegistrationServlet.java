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

import db.StudentDb;
import db.UserDuo;

/**
 * Servlet implementation class UserRegistrationServlet
 */
@WebServlet("/registerusers")
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	UserDuo userDuo;

	public UserRegistrationServlet() {
		super();
		userDuo = new UserDuo();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Users user = new Users(username, email, password);
		if (userDuo.alreadyExitsEmail(email) == false) {
			if (userDuo.insertUsers(user)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("user-login.jsp");
				dispatcher.forward(request, response);
			} else {
				PrintWriter pw = response.getWriter();
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Data Insert failed');");
				pw.println("location='user-register.jsp';");
				pw.println("</script>");
			}
		} else {
			PrintWriter pw = response.getWriter();
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('email already exits');");
			pw.println("location='user-login.jsp';");
			pw.println("</script>");

		}
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
