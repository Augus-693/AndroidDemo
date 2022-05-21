package fun.augus.servelet;

import fun.augus.DB.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 删除
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
        super();
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ArrayList a = null;
        HttpSession session = request.getSession();
        //删除用户
        if (request.getParameter("id") != null) {
            String id = request.getParameter("id");

            try {
                Database.getDatabase().delete(id);
                a = Database.getDatabase().search_reader("");
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException
                    | SQLException e) {
                e.printStackTrace();
            }
            session.setAttribute("result", a);
            response.sendRedirect("search?id=0");
            return;
        }
        //删除书籍
        if (request.getParameter("delete_book_id") != null) {
            byte b1[] = request.getParameter("delete_book_id").getBytes("UTF-8");
            String book_id = new String(b1, "UTF-8");
            try {
                Database.getDatabase().delete_book(book_id);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException
                    | SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("search?all_book=true");
            return;
        }
        //搜索借阅记录
        if (request.getParameter("book_id") == null) {
            PrintWriter out = response.getWriter();

            try {
                a = Database.getDatabase().search_borrowed((String) session.getAttribute("id"));
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException
                    | SQLException e) {
                e.printStackTrace();
            }
            session.setAttribute("borrowed_book", a);
            response.sendRedirect("returnbook.jsp");
        } else {
            byte b1[] = request.getParameter("book_id").getBytes("UTF-8");
            String book_id = new String(b1, "UTF-8");
            PrintWriter out = response.getWriter();

            try {
                Database.getDatabase().return_book((String) session.getAttribute("id"), book_id);//����
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException
                    | SQLException e) {
                e.printStackTrace();
            }

            response.sendRedirect("delete");
        }

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ArrayList a = null;
        HttpSession session = request.getSession();
        //还书
        if (request.getParameter("book_id") == null) {
            byte b1[] = request.getParameter("book_id").getBytes("UTF-8");
            String book_id = new String(b1, "UTF-8");
            PrintWriter out = response.getWriter();
            try {
                Database.getDatabase().return_book((String) session.getAttribute("id"), book_id);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException
                    | SQLException e) {
                e.printStackTrace();
            }

            response.sendRedirect("delete");
        }
    }

}
