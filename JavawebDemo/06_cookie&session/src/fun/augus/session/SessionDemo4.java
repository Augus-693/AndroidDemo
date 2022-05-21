package fun.augus.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/sessionDemo4")
public class SessionDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //验证客户端不关闭，服务器关闭，两次获取的session值是否一样
        //1.获取Session
        HttpSession session = request.getSession();
        //打印session地址
        System.out.println(session);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
