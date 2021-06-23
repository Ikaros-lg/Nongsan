package nongsan.webmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import nongsan.webmvc.jdbc.connectDB;
import nongsan.webmvc.model.User;

public class LoginDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public User checkLogin(String username, String password) {
		try {
			String query = "select username, password from users where username = ? AND password = ?";
			new connectDB();
			conn = connectDB.getConnect();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()) {
				User u = new User(rs.getString(1), rs.getString(2));
				return u;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
        public User checkLogin2(String username) {
		try {
			String query = "select username from users where username = ?";
			new connectDB();
			conn = connectDB.getConnect();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while(rs.next()) {
				User u = new User(rs.getString(1));
				return u;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
        public User insertAccount(User user) {
		try {
			String sql = "INSERT INTO users (username,password,email,phone,name,created) values (?,?,?,?,?,?)"; 
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getName());
            ps.setString(6, user.getCreated());
            ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
