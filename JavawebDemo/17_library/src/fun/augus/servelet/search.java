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
 * 搜索
 */
@WebServlet("/search")
public class search extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public search() {
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
        String punish_record_id = request.getParameter("punish_record_id");
        ArrayList a = null;
        HttpSession session = request.getSession();
        //查找书籍
        if (request.getParameter("search_book_id") != null) {
            byte b1[] = request.getParameter("search_book_id").getBytes("ISO-8859-1");
            String id = new String(b1, "UTF-8");

            try {
                a = Database.getDatabase().search_book(id);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException
                    | NoSuchMethodException | SQLException e) {
                e.printStackTrace();
            }

            session.setAttribute("searched_book", a.get(0));
            response.sendRedirect("book_info.jsp");
        }
        //查询单个用户
        if (request.getParameter("search_user") != null) {
            byte b1[] = request.getParameter("search_user").getBytes("ISO-8859-1");
            String id = new String(b1, "UTF-8");


            try {
                if (session.getAttribute("identity").equals("reader")) {
                    a = Database.getDatabase().search_reader(id);
                } else {
                    a = Database.getDatabase().search_admin(Integer.parseInt(id));
                }
            } catch (NumberFormatException | InstantiationException | IllegalAccessException
                    | InvocationTargetException | NoSuchMethodException | SQLException e) {
                e.printStackTrace();
            }

            session.setAttribute("person_info", a.get(0));
            response.sendRedirect("person_info.jsp");
        }
        //查找所有读者
        if (request.getParameter("id") != null) {

            try {
                a = Database.getDatabase().search_reader("");
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException
                    | NoSuchMethodException | SQLException e) {
                e.printStackTrace();
            }
            session.setAttribute("result", a);
            response.sendRedirect("managereader.jsp");
        }
        //查找读者的借阅历史
        if (request.getParameter("borrow_record") != null) {
            try {
                a = Database.getDatabase().search_borrow_record((String) session.getAttribute("id"), "");
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException
                    | NoSuchMethodException | SQLException e) {
                e.printStackTrace();
            }

            session.setAttribute("borrow_record", a);
            response.sendRedirect("history.jsp");
        }
        //查找所有图书
        if (request.getParameter("all_book") != null) {

            try {
                a = Database.getDatabase().search_book("");
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException
                    | NoSuchMethodException | SQLException e) {
                e.printStackTrace();
            }

            session.setAttribute("book", a);
            response.sendRedirect("searchbook.jsp");
        }
        //查找处罚记录
        if (request.getParameter("reader_id") != null) {
            byte b1[] = request.getParameter("reader_id").getBytes("ISO-8859-1");
            String reader_id = new String(b1, "UTF-8");

            try {
                a = Database.getDatabase().search_punish_record(reader_id);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException
                    | SQLException e) {
                e.printStackTrace();
            }


            session.setAttribute("punishment", a);
            session.setAttribute("reader_id", reader_id);
            response.sendRedirect("punishment.jsp");
        }
        //恢复借还书权利
        if (punish_record_id != null) {
            try {
                Database.getDatabase().recover_rights(punish_record_id);
                a = Database.getDatabase().search_punish_record((String) session.getAttribute("reader_id"));
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException
                    | NoSuchMethodException | SQLException e) {
                e.printStackTrace();
            }

            session.setAttribute("punishment", a);
            response.sendRedirect("punishment.jsp");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ArrayList a = null;
        HttpSession session = request.getSession();
        request.getParameter("reader_id");
        //查找借阅历史
        if (request.getParameter("history_info") != null) {
            byte b1[] = request.getParameter("history_info").getBytes("ISO-8859-1");
            String s = new String(b1, "UTF-8");

            try {
                a = Database.getDatabase().search_borrow_record((String) session.getAttribute("id"), s);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException
                    | NoSuchMethodException | SQLException e) {
                e.printStackTrace();
            }

            session.setAttribute("borrow_record", a);
            response.sendRedirect("history.jsp");
        }
        //查找处罚记录
        if (request.getParameter("reader_id") != null) {
            byte b1[] = request.getParameter("reader_id").getBytes("ISO-8859-1");
            String reader_id = new String(b1, "UTF-8");
            try {
                a = Database.getDatabase().search_punish_record(reader_id);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException
                    | SQLException e) {
                e.printStackTrace();
            }


            session.setAttribute("punishment", a);
            session.setAttribute("reader_id", reader_id);
            response.sendRedirect("punishment.jsp");
        }
        //查找图书
        if (request.getParameter("book_id_name") != null) {
            byte b1[] = request.getParameter("book_id_name").getBytes("ISO-8859-1");
            String s = new String(b1, "UTF-8");
            PrintWriter out = response.getWriter();

            try {
                a = Database.getDatabase().search_book(s);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException
                    | SQLException e) {
                e.printStackTrace();
            }

            session.setAttribute("book", a);
            response.sendRedirect("searchbook.jsp");
        }
        //查找读者
        if (request.getParameter("_reader_id") != null) {
            byte b2[] = request.getParameter("_reader_id").getBytes("ISO-8859-1");
            String _reader_id = new String(b2, "UTF-8");
            PrintWriter out = response.getWriter();
            try {
                a = Database.getDatabase().search_reader(_reader_id);
            } catch (NumberFormatException | InstantiationException | IllegalAccessException
                    | InvocationTargetException | NoSuchMethodException | SQLException e) {
                e.printStackTrace();
            }

            session.setAttribute("result", a);
            response.sendRedirect("managereader.jsp");
        }


    }

}
