package test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ioTest2 {

	public static void main(String[] args) {
		//�ļ���ȡ-�ַ�
		FileReader fr=null;
		try {
			fr=new FileReader("C:\\Users\\Administrator\\Desktop\\21ѧϰ�ƻ�3.txt");
			char[] chars=new char[1024];
			int read = fr.read(chars);
			System.out.println(new String (chars,0,read));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fr!=null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		//�ļ�д��-�ַ�
		FileWriter fw=null;
		try {
			fw=new FileWriter("C:\\Users\\Administrator\\Desktop\\21ѧϰ�ƻ�3.txt",true);
			String str = "FileWriter--��������2";
			fw.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fw!=null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
