package com.lxx.Listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class applicationNums implements ServletContextListener {

	public applicationNums() {
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		servletContext.setAttribute("nums", 0);
	}

}
