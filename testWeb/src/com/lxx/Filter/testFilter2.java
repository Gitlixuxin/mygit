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

public class testFilter2 implements Filter {
	byte i=0;
	@Override
	public void destroy() {
		System.out.println("2销毁");//需要执行tomcat的bin shutdown。bat，才能显示；
	}
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
		i++;
		HttpServletRequest request=(HttpServletRequest) arg0;
		System.out.println("2进入了过滤器UTF-8"+i);
		HttpServletResponse response=(HttpServletResponse)arg1;
		HttpSession session=request.getSession();
		Object user2 = session.getAttribute("user");
		String path = request.getContextPath();
		if(user2!=null) {
			System.out.println("已经登录，进入第2个FilterUTF-8");
			chain.doFilter(arg0, arg1);
		}else {
//			request.setAttribute("msg", "用户名不能为空！");
//			request.getRequestDispatcher("/login.jsp").forward(request, response);
			
			response.sendRedirect(path+"/login.jsp");
//			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.print("2初始化完成");
		System.out.println(fConfig.getFilterName());
	}

}
