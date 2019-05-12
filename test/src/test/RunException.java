package test;

import java.io.IOException;

public class RunException {
	/*
	 * public static void start() throws IOException{//受检查异常类 必须声明异常 System.out.
	 * println("Java Exception interivew question Answers for Programmers"); }
	 * public static void main(String[] args) { try{ start(); }catch(IOException
	 * ioe){ ioe.printStackTrace(); } }
	 */
	public static void start() throws RuntimeException{//可以不对此（非受检查异常）异常及其子类throws申明异常
	      System.out.println("Java Exception interivew question Answers for Programmers");
  }
	public static void main(String[] args) {
		try{
	           start();
	        }catch(RuntimeException ioe){
	           ioe.printStackTrace();
	        }
	}

}
