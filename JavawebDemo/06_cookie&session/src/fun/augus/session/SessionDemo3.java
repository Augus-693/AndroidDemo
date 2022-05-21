package fun.augus.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/sessionDemo3")
public class SessionDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //验证服务器不关闭，客户端关闭，两次获取的session值是否一样
        //1.获取Session
        HttpSession session = request.getSession();
        //打印session地址
        System.out.println(session);
        //客户端关闭后，session也能相同
        Cookie c = new Cookie("JSESSIONID",session.getId());
        c.setMaxAge(60*60);
        response.addCookie(c);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
