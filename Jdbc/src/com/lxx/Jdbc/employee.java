package com.lxx.Jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Random;
import java.util.logging.SimpleFormatter;
public class employee {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement pstmt=null;
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
			String[] name=new String[] {"狗狗","海豚","北极熊","猫猫","黄牛","熊猫","袋鼠","猪","猿"};
			String[] address=new String[] {"湖南省长沙市芙蓉区","深圳市腾讯中心","北京市东城区大兴亦庄","上海市浦东新区金桥","云南昆明市"};
			String[] school=new String[] {"第一大学","第二大学","第三大学","第四大学","第五大学","第六大学","第七大学","第八大学"};
			String sql="INSERT INTO user(name,usex,address,date,person,girl,school,studentid,height,weight,gradeId) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			long begin = System.currentTimeMillis();
			System.out.println("开始插入："+begin);	
			Random r=new Random();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for(int i=0;i<1;i++) {//循环插入数据
				int index=r.nextInt(name.length);
				 int second=r.nextInt(5);
				 int three=r.nextInt(school.length);
				 int gradeId=r.nextInt(3)+1;
//				 System.out.println(name[index]+"  =="+address[second]+"  =="+school[index]);
				 pstmt.setString(1,name[index]);
				 pstmt.setString(2,"宠物");
				 pstmt.setString(3,address[second]);
				 pstmt.setString(4,sdf.format(new java.util.Date()).toString());
				 pstmt.setString(5,"生命体");
				 pstmt.setString(6,"王柳");
				 pstmt.setString(7,school[three]);
				 pstmt.setString(8, "43052319981202");
				 pstmt.setDouble(9, 11.8);
				 pstmt.setDouble(10, 3.1);
				 pstmt.setInt(11, gradeId);
				count=pstmt.executeUpdate();
			}
			//锟结交锟斤拷锟斤拷
			conn.commit();
			long end=System.currentTimeMillis();
//			System.out.println("插入完成"+end);
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
			if(pstmt!=null) {
				try {
					pstmt.close();
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
			System.out.println("success");
		}else {
			System.out.println("fail");
		}
	}

}
