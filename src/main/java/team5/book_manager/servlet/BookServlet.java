package team5.book_manager.servlet;

import team5.book_manager.services.BookService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "bookServlet", value = "/book")
public class BookServlet extends HttpServlet {
    private BookService bookService;

    public void init() {bookService = new BookService();}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        List result = new ArrayList();
        if (name != null) {
            result = bookService.getListBookByName(name);
            request.setAttribute("bookName", name);
        }
        else {
            result = bookService.getAllBook();
        }

        request.setAttribute("data", result);

        RequestDispatcher view = request.getRequestDispatcher("book.jsp");
        view.forward(request, response);
    }
}
