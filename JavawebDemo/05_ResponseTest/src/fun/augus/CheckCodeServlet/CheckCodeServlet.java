package fun.augus.CheckCodeServlet;

import sun.awt.image.BufferedImageDevice;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 服务器输出字节数据到浏览器
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 50;
        //1.创建一对象，在内存中为图片（验证码图片对象）
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //2.美化图片
        //2.1 填充背景色
        Graphics graphics = image.getGraphics();//画笔对象
        graphics.setColor(Color.PINK);//设置画笔颜色
        graphics.fillRect(0,0,width,height);
        //2.2 画边框
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0,0,width - 1,height - 1);
        //2.3 写验证码
        //2.3.1 创建字符数组
        String str = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        //2.3.2生成随机角标
        Random random = new Random();
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            //2.3.3获取字符
            char charAt = str.charAt(index);
            //2.3.4 写入验证码
            graphics.drawString(charAt+"",width / 5 * i,height / 2);
        }
        //2.4 画干扰线
        graphics.setColor(Color.GREEN);
        //随机生成坐标点
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1,x2,y1,y2);
        }

        //3.将图片输出到页面展示
        ImageIO.write(image, "jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
