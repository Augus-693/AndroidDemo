package fun.augus.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo6 implements Filter {
    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Demo6执行了");
        chain.doFilter(req, resp);
        System.out.println("Demo6回来了");
    }

    public void destroy() {

    }

}
