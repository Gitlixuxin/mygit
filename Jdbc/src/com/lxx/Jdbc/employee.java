package com.lxx.Jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.PreparedStatement;
public class employee {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
//		PreparedStatement ps=null;Statement的子类
		int count=0;
		try {
		FileReader reader=new FileReader("conf/server.properties");
		Properties properties=new Properties();
		properties.load(reader);
		reader.close();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名：");
		String name=br.readLine();
		System.out.println("请输入密码：");		
		String pwd=br.readLine();
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String password = properties.getProperty("password");
		String user = properties.getProperty("user");
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
			//开启事务
			conn.setAutoCommit(false);
			stmt=conn.createStatement();
			String sql="insert into employee(name,pwd) value('"+name+"','"+pwd+"')";
			count=stmt.executeUpdate(sql);
			//提交事务
			conn.commit();
		} catch (Exception e) {
			//回滚事务
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
			System.out.println("恭喜，注册成功！");
		}else {
			System.out.println("很遗憾，注册失败！");
		}
	}

}
