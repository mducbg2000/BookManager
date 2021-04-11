package team5.book_manager.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import team5.book_manager.entities.BookEntity;
import team5.book_manager.services.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private BookService bookService;
    private static final Logger logger = LoggerFactory.getLogger(UpdateServlet.class);
    @Override
    public void init() throws ServletException {
        super.init();
        bookService = new BookService();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response){
        logger.info(request.getQueryString());
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String publisher = request.getParameter("publisher");
        int price = Integer.parseInt(request.getParameter("price"));
        BookEntity bookEntity = new BookEntity(name, publisher, price);
        int result = 0;
        if (bookService.getBookById(id) == null) {
            result = bookService.insertBook(bookEntity);
        } else {
            bookEntity.setId(id);
            result = bookService.updateBook(id, bookEntity);
        }
        try {
            if (result != 0) response.sendRedirect("/book");
        } catch (Exception e){

        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int result = bookService.deleteBook(id);
        try {
            if (result != 0) request.getRequestDispatcher("/book").forward(request, response);
        } catch (Exception e){

        }
    }

}
