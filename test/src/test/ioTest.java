package test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ioTest {

	public static void main(String[] args) {
		//��ȡ�ļ�-�ֽ�
		FileInputStream fis=null;
		try {
			fis =new FileInputStream("C:\\Users\\Administrator\\Desktop\\21ѧϰ�ƻ�2.txt");
			byte[] bytes=new byte[1024];//���뵽������
			int read = fis.read(bytes);
			System.out.println(new String(bytes,0,read));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		//д���ļ�-�ֽ�
		
//		  FileOutputStream fos=null;
//		  try { 
//			  fos =new FileOutputStream("C:\\Users\\Administrator\\Desktop\\21ѧϰ�ƻ�3.txt",true); //true:׷��
//			  byte[] bytes= new byte[1024];
//			  String str = "\r\nд����һЩ����1";
//			  bytes =str.getBytes();
//			  fos.write(bytes);
//		  } catch(Exception e) {
//			  e.printStackTrace(); 
//		  }finally {
//			  if(fos!=null) {
//				  try {
//					fos.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			  }
//		  }
//		 
//		
	}

}
