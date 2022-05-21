package fun.augus.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: Augus
 * @progect: JavawebDemo
 * @package: com.augus.web.servlet
 * @FileName: DemoServlet
 * @date 2021年11月30日 11:32
 * @version: 1.0
 */

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello MavenServlet");
    }
}
