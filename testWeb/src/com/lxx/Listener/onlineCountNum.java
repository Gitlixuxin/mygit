package com.lxx.Listener;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class onlineCountNum implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent arg0) {
//    	 Timer timers = new Timer();
//    	 timers.schedule(new TimerTask() {
//			
//			@Override
//			public void run() {
//				System.out.println(new Date().toLocaleString());//2019-1-19 17:24:09
//				System.out.println(new Date().toString());//Sat Jan 19 17:24:09 CST 2019
//			}
//		},0, 1000);
		System.out.println("创建了session"+arg0.getSession().getId());
		ServletContext application = arg0.getSession().getServletContext();
		Integer count = (Integer) application.getAttribute("nums");
		count++;
		application.setAttribute("nums", count);
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		ServletContext application = arg0.getSession().getServletContext();
		Integer count = (Integer) application.getAttribute("nums");
		count--;
		System.out.println("销毁后还有：" + count);
		application.setAttribute("nums", count);
	}

}
