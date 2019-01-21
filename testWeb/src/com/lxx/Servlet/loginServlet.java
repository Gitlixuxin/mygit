package com.lxx.Servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public loginServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("loginServlet初始化");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String remember = request.getParameter("remember");
		String rememberAndauto = request.getParameter("rememberAndauto");
		String path = request.getContextPath();
		HttpSession session = request.getSession();
		if (userName == null || "".equals(userName)) {
			request.setAttribute("msg", "用户名不能为空！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
//			response.sendRedirect(request.getContextPath()+"/login.jsp");//不能用这个，msg会丢失；
		} else if(passWord==null||"".equals(passWord)) {
			request.setAttribute("msgpwd", "密码不能为空！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}else {
			if (!userName.equals(session.getAttribute("user"))) {
//					session.invalidate();
				session.setAttribute("user", userName);
				if("on".equals(rememberAndauto)) {
					 //表示用户需要记住用户名和密码自动登录
					Cookie c=new Cookie("userName",URLEncoder.encode(userName, "utf-8"));
					c.setMaxAge(60*60*24);
					c.setPath("/");
					response.addCookie(c);
					
					Cookie c2=new Cookie("passWord",passWord);
					c2.setMaxAge(60*60*24);
					c2.setPath("/");
					response.addCookie(c2);
					
				}else {
					//用户不需要自动登录
					Cookie c=new Cookie("userName","");
					c.setMaxAge(0);
					c.setPath("/");
					response.addCookie(c);
					
					Cookie c2=new Cookie("passWord","");
					c2.setMaxAge(0);
					c2.setPath("/");
					response.addCookie(c2);
				}
			}
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
