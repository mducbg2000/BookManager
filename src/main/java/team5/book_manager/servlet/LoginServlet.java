package team5.book_manager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import team5.book_manager.entities.UserEntity;
import team5.book_manager.services.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		boolean result = false;

		UserEntity user = new UserEntity(username, password);
		UserService userService = new UserService();
		if (request.getParameter("submit").equalsIgnoreCase("Register")) {
			int re = userService.register(user);
			request.getRequestDispatcher("login.jsp?err=" + re).forward(request, response);
		}
		else {
			result = userService.login(user);
			if (result) {
				Cookie cookie = new Cookie("user", username);
				response.addCookie(cookie);
				response.sendRedirect("/book");
			} else {
				//out.println("Invalid Login");
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp?err=1");
				dispatcher.forward(request, response);
			}
		}
	}

}
