package fun.augus.ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ServletContext功能：获取文件的服务器路径
        //1.获取ServletContext对象
        ServletContext context = this.getServletContext();

        //获取文件的服务器路径
        String realPath = context.getRealPath("/location.html");//web目录下的文件
        System.out.println(realPath);

        String b = context.getRealPath("/WEB-INF/b.txt");//WEB-INF目录下的文件
        System.out.println(b);

        String a = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的文件
        System.out.println(a);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
