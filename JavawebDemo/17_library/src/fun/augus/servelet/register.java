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

/**
 * 注册
 */
@WebServlet("/register")
public class register extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public register() {
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
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        byte b1[] = request.getParameter("name").getBytes("UTF-8");
        String name = new String(b1, "UTF-8");
        byte b2[] = request.getParameter("pwd").getBytes("UTF-8");
        String pwd = new String(b2);
        byte b3[] = request.getParameter("tel").getBytes("UTF-8");
        String tel = new String(b3, "UTF-8");
        byte b4[] = request.getParameter("sex").getBytes("UTF-8");
        String sex = new String(b4, "UTF-8");
        int id = 0;
        HttpSession session = request.getSession();
        if (request.getParameter("id") != null) {
            byte b5[] = request.getParameter("id").getBytes("UTF-8");
            id = Integer.parseInt(new String(b5, "UTF-8"));
        }
        //修改个人信息
        if (id > 0) {
            session = request.getSession();

            try {
                Database.getDatabase().modify_info(String.valueOf(id), pwd, name, sex, tel, (String) session.getAttribute("identity"));
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException
                    | NoSuchMethodException | SQLException e) {
                e.printStackTrace();
                session.setAttribute("message", "修改信息失败！！！密码需要4位字符以上，电话需要11位数字！！！");
                response.sendRedirect("search?search_user=" + id);
                return;
            }


            response.sendRedirect("search?search_user=" + id);
        }
        //注册
        else {

            try {
                id = Database.getDatabase().insertreader(pwd, name, sex, tel);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException
                    | SQLException e) {
                e.printStackTrace();
                session.setAttribute("message", "注册失败！！！密码需要4位字符以上，电话需要11位数字！！！");
                response.sendRedirect("login.jsp");
                return;
            }


            out.print("注册成功，您的id是：" + id + "<br>请妥善保管您的id");
            response.setHeader("Refresh", "2;login.jsp");
        }
    }

}
