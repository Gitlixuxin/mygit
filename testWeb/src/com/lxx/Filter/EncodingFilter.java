package com.lxx.Filter;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/EncodingFilter")
public class EncodingFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		System.out.println("设置编码为utf-8");
		HttpSession session=request.getSession();
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			String userName="";
			String passWord="";
			for(Cookie c:cookies) {
				if("userName".equals(c.getName())) {
					userName=URLEncoder.encode(c.getValue(),"utf-8");
				}
				if("passWord".equals(c.getName())) {
					passWord=c.getValue();
				}
			}
			if(!userName.equals("")&&!passWord.equals("")) {
				session.setAttribute("user", userName);
				session.setAttribute("passWord", passWord);
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
