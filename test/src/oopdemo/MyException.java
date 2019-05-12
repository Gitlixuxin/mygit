package oopdemo;

public class MyException extends Exception {
	private static final long serialVersionUID = 1441729756553646934L;
	
	
	public String execpMessage() {
		String str="出现异常，此数字不符合我的要求啊，不给通过！";
		return str;
	}
}
