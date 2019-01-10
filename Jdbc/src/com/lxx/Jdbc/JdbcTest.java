package com.lxx.Jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JdbcTest {
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			Driver driver=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			String url="jdbc:mysql://localhost:3306/lxx";
			String user="root";
			String pwd="admin";
			conn=DriverManager.getConnection(url,user,pwd);
			stmt=conn.createStatement();
			String sql ="select id,name,author from bookmange";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				 String name = rs.getString("name");
				System.out.println(id+"  "+name);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			if(rs !=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt !=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
