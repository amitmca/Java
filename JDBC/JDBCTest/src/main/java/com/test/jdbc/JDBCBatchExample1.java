package com.test.jdbc;

import java.sql.*;

public class JDBCBatchExample1 {
	static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";
	static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	static final String USER = "system";
	static final String PASS = "123456";

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String SQL = "INSERT INTO Employees(id,age,first,last) " +
			"VALUES(?, ?, ?, ?)";
			System.out.println("Creating statement...");
			stmt = conn.prepareStatement(SQL);
			conn.setAutoCommit(false);
			printRows(stmt);
		
			stmt.setInt( 1, 400 );
			stmt.setInt( 2, 33 );
			stmt.setString( 3, "Pappu" );
			stmt.setString( 4, "Singh" );
			
			stmt.addBatch();
			stmt.setInt( 1, 401 );
			stmt.setInt( 2, 31 );
			stmt.setString( 3, "Pawan" );
			stmt.setString( 4, "Singh" );
			
			stmt.addBatch();
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

	public static void printRows(PreparedStatement stmt) throws SQLException {
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