package fun.augus.responseTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *  服务器输出字符数据到浏览器
 */
@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取流之前，设置流的默认编码：ISO-8859-1 设置为 GBK
        //response.setCharacterEncoding("utf-8");   //有下面一行这一行可以不需要
        //告诉浏览器，服务器发送的消息体数据的编码。建议浏览器使用该编码解码
        //response.setHeader("content-type","text/html;charset=utf-8");
        //简单的形式设置编码
        response.setContentType("text/html;charset=utf-8");

        //获取字符输出流
        PrintWriter printWriter = response.getWriter();
        //输出数据
        //printWriter.println("<h1>HelloResponse</h1>");
        printWriter.write("你好  Response");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
