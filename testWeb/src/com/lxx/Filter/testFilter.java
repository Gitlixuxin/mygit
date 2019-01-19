package com.lxx.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class testFilter implements Filter {
	byte i=0;
	@Override
	public void destroy() {
		System.out.println("1销毁");//需要执行tomcat的bin shutdown。bat，才能显示；
	}
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
		i++;
			System.out.println("1进入了过滤器"+i);
			System.out.println("已经登录，进入第1个Filter");
			HttpServletRequest request=(HttpServletRequest)arg0;
			HttpServletResponse response=(HttpServletResponse)arg1;
			String path=request.getContextPath()+"/index.jsp";
			request.setCharacterEncoding("UTF-8");
			String url = request.getRequestURI();
			if(path.equals(url)) {
				chain.doFilter(arg0, arg1);
			}else {
				response.sendRedirect(path);
			}
			
	}
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.print("1初始化完成");
		System.out.println(fConfig.getFilterName());
	}

}
