package com.analysis.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.framework.dao.CommonDao;

public class DBConnection {
	// private static String url = "jdbc:oracle:thin:@10.85.23.71:1521:orcl";
	// private static String url = "jdbc:mysql://localhost:3306/resource_stat";
	// private static String user = "root";
	// private static String pwd = "root";

	// static{
	// url = ReadProperties.getUrl();
	// user = ReadProperties.getUsername();
	// pwd = ReadProperties.getPassword();
	// }

	public DBConnection() {
	}

	public ResultSet getResults(String sql) throws SQLException, ClassNotFoundException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			closeConnection(con);
		}
		return rs;
	}

	public ResultSet getPrepResultSet(String sql, String[] values) throws SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			stmt = con.prepareStatement(sql);
			for (int i = 1; i <= values.length; i++) {
				stmt.setString(i, values[i - 1]);
			}
			rs = stmt.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(stmt);
			closeConnection(con);
		}

		return rs;
	}

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		// Class.forName("com.mysql.jdbc.Driver");
		// String dburl = Config.getValue("datasource", "url");//
		// ReadProperties.getUrl();
		// String username = Config.getValue("datasource", "username");//
		// ReadProperties.getUsername();
		// String password = Config.getValue("datasource", "password");//
		// ReadProperties.getPassword();
		// System.out.println(dburl + ":" + username + ":" + password);
		try {
			return CommonDao.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		// return DriverManager.getConnection(dburl, username, password);
	}

	public static void closeConnection(Connection con) {
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeResultSet(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {
		try {
			if (stmt != null)
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
