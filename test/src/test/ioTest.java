package test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ioTest {

	public static void main(String[] args) {
		//读取文件-字节
		FileInputStream fis=null;
		try {
			fis =new FileInputStream("C:\\Users\\Administrator\\Desktop\\21学习计划2.txt");
			byte[] bytes=new byte[1024];//读入到这里面
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
		//写入文件-字节
		
//		  FileOutputStream fos=null;
//		  try { 
//			  fos =new FileOutputStream("C:\\Users\\Administrator\\Desktop\\21学习计划3.txt",true); //true:追加
//			  byte[] bytes= new byte[1024];
//			  String str = "\r\n写入了一些数据1";
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
