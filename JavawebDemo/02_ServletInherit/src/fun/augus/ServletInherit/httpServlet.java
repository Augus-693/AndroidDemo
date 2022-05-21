package fun.augus.ServletInherit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.HttpCookie;

/**
 * @author: Augus
 * @progect: JavawebDemo
 * @package: com.augus.ServletInherit
 * @FileName: httpServlet
 * @date 2021年11月03日 13:44
 * @version: 1.0
 */


public class httpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet方法被访问");
        System.out.println(req);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost方法被访问");
    }
}
