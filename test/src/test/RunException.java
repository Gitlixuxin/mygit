package test;

import java.io.IOException;

public class RunException {
	/*
	 * public static void start() throws IOException{//�ܼ���쳣�� ���������쳣 System.out.
	 * println("Java Exception interivew question Answers for Programmers"); }
	 * public static void main(String[] args) { try{ start(); }catch(IOException
	 * ioe){ ioe.printStackTrace(); } }
	 */
	public static void start() throws RuntimeException{//���Բ��Դˣ����ܼ���쳣���쳣��������throws�����쳣
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
