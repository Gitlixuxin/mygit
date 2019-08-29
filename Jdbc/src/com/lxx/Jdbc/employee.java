package com.lxx.Jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
public class employee {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
//		PreparedStatement ps=null;Statement锟斤拷锟斤拷锟斤拷
		int count=0;
		try {
		FileReader reader=new FileReader("conf/server.properties");
		Properties properties=new Properties();
		properties.load(reader);
		reader.close();
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("锟斤拷锟斤拷锟斤拷锟矫伙拷锟斤拷锟斤拷");
//		String name=br.readLine();
//		System.out.println("锟斤拷锟斤拷锟斤拷锟斤拷锟诫：");		
//		String pwd=br.readLine();
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String password = properties.getProperty("password");
		String user = properties.getProperty("user");
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
			//锟斤拷锟斤拷锟斤拷锟斤拷
			conn.setAutoCommit(false);
			stmt=conn.createStatement();
//			String sql="insert into employee(name,pwd) value('"+name+"','"+pwd+"')";
			String sql="INSERT INTO user(name,usex,address,date,person,girl,school,studentid,height,weight)\r\n" + 
					"VALUES('狗狗','宠物','湖南省长沙市芙蓉区东方新城H区5456街道'\r\n" + 
					",NOW(),'李四哇','王雪阳','邵阳市第一中学',43052319981202,20.00,10.38);";
			long begin = System.currentTimeMillis();
			System.out.println("开始插入："+begin);
			for(int i=0;i<20000000;i++) {
				count=stmt.executeUpdate(sql);
			}
			//锟结交锟斤拷锟斤拷
			conn.commit();
			long end=System.currentTimeMillis();
			System.out.println("插入完成"+end);
			System.out.println("所用时间："+(end-begin)/1000+"秒");
		} catch (Exception e) {
			//锟截癸拷锟斤拷锟斤拷
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}
		if(count==1) {
			System.out.println("锟斤拷喜锟斤拷注锟斤拷晒锟斤拷锟�success");
		}else {
			System.out.println("锟斤拷锟脚猴拷锟斤拷注锟斤拷失锟杰ｏ拷fail");
		}
	}

}
