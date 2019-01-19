package com.lxx.Jdbc;
public final  class MyException extends Exception {//final 静态绑定，不允许被继承，优化此类。

	/**
	 * 自定义异常。
	 */
	private static final long serialVersionUID = 2013552282365739606L;
	
	public MyException() {
		System.out.println("出现自定义异常，密码的长度至少为5位！");
	}
	
	

}
