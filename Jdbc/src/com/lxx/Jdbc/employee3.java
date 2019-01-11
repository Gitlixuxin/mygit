package com.lxx.Jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
public class employee3 {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
		FileReader reader=new FileReader("conf/server.properties");
		Properties properties=new Properties();
		properties.load(reader);
		reader.close();
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
			String sql="update employee set pwd=? where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, "lxx123");
			ps.setInt(2, 3);
			int count=ps.executeUpdate();
			conn.commit();
			System.out.println("count="+count);
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			if(ps!=null) {
				try {
					ps.close();
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
	}

}
