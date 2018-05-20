package com.test.jdbc;

import java.sql.*;

public class JDBCBatchExample {
	static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";
	static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	static final String USER = "system";
	static final String PASS = "123456";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			printRows(stmt);
			String SQL = "INSERT INTO Employees (id, first, last, age) "
					+ "VALUES(200,'Zia', 'Ali', 30)";
			stmt.addBatch(SQL);
			SQL = "INSERT INTO Employees (id, first, last, age) "
					+ "VALUES(201,'Raj', 'Kumar', 35)";
			stmt.addBatch(SQL);
			SQL = "UPDATE Employees SET age = 35 " + "WHERE id = 109";
			stmt.addBatch(SQL);
			int[] count = stmt.executeBatch();
			conn.commit();
			printRows(stmt);
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	System.out.println("Goodbye!");
	}

	public static void printRows(Statement stmt) throws SQLException {
		System.out.println("Displaying available rows...");
		String sql = "SELECT id, first, last, age FROM Employees";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt("id");
			int age = rs.getInt("age");
			String first = rs.getString("first");
			String last = rs.getString("last");
			System.out.print("ID: " + id);
			System.out.print(", Age: " + age);
			System.out.print(", First: " + first);
			System.out.println(", Last: " + last);
		}
		System.out.println();
		rs.close();
	}
}