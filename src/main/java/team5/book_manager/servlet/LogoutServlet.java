package team5.book_manager.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        for (Cookie c: request.getCookies()){
            if (c.getName().equalsIgnoreCase("user")) {
                c.setMaxAge(0);
                response.addCookie(c);
            }
        }
        response.sendRedirect("/login");
    }
}
