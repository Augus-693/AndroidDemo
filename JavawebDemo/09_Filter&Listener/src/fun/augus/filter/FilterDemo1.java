package fun.augus.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author: Augus
 * @progect: JavawebDemo
 * @package: com.augus.filter
 * @FileName: FilterDemo1
 * @date 2021年11月23日 16:29
 * @version: 1.0
 */

//@WebFilter("/*")
public class FilterDemo1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterDemo1被执行了");
        //放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
