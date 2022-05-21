package fun.augus.servelet;

import fun.augus.DB.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * 登录
 */
@WebServlet("/login")
public class login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public login() {
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
        response.getWriter().append("Served at: ").append(request.getContextPath());
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
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        byte b1[] = request.getParameter("id").getBytes("UTF-8");
        String id = new String(b1, "UTF-8");
        byte b2[] = request.getParameter("pwd").getBytes("UTF-8");
        String pwd = new String(b2);
        byte b3[] = request.getParameter("identity").getBytes("UTF-8");
        String identity = new String(b3);
        boolean is_punished = false;
        String name = null;
        try {
            name = Database.getDatabase().checklogin(id, pwd, identity);
            //查看是否存在未缴款记录
            is_punished = Database.getDatabase().is_punished(id);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException
                | NoSuchMethodException | SQLException e) {
            e.printStackTrace();
        }

        if (name.equals("")) {
            HttpSession session = request.getSession();
            session.setAttribute("message", "登录失败！！！");
            response.sendRedirect("login.jsp");
        } else {
            HttpSession session = request.getSession();
            //登陆成功，在session中存入已经登陆用户名
            session.setAttribute("id", id);
            session.setAttribute("name", name);
            //登陆成功，在session中存入身份
            session.setAttribute("identity", identity);
            if (is_punished) {
                session.setAttribute("is_punished", true);
            } else {
                session.setAttribute("is_punished", false);
            }
            //用户名和密码存入cookie
            Cookie cookie1 = new Cookie("id", id);
            Cookie cookie2 = new Cookie("pwd", pwd);
            response.addCookie(cookie1);
            response.addCookie(cookie2);
            session.setAttribute("success", "登录成功！！！");
            session.setAttribute("message", null);
            if (identity.equals("reader")) {
                response.sendRedirect("Homepage_reader.jsp");
            } else {
                response.sendRedirect("Homepage_admin.jsp");
            }
        }

    }
}


