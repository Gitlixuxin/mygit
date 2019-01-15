package com.lxx.Jdbc;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class employee2 {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			FileReader reader=new FileReader("conf/server.properties");//字符流
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
			String sqlsel="select * from employee where id=? for update";
			ps=conn.prepareStatement(sqlsel);
			ps.setInt(1, 3);
			rs=ps.executeQuery();
			conn.commit();
			while(rs.next()) {
				String name = rs.getString("name");
				int id = rs.getInt("id");
				String pwd = rs.getString("pwd");
				System.out.println(id+name+pwd);
			}
		} catch (Exception e) {
			if(conn!=null) {
				conn.rollback();
			}else {
				System.out.println("连接数据库失败！");
			}
		}finally {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}
	}

}
