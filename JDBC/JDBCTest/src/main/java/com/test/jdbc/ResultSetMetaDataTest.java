package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetMetaDataTest {
	public static void main(String... arg) {
		Connection con = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "system", "123456");
			System.out.println("Connection established successfully!");

			prepStmt = con.prepareStatement("select * from EMPLOYEES");
			rs = prepStmt.executeQuery();

			ResultSetMetaData rsmd = rs.getMetaData();
			int totalNumberOfColumnsInTable = rsmd.getColumnCount();

			System.out.println("\nTotal number of columns in table = "
					+ totalNumberOfColumnsInTable);

			System.out
					.println("\nDisplay table's column name and column type - ");
			for (int i = 1; i <= totalNumberOfColumnsInTable; i++) {
				System.out.println(" Column no = " + i + ", column name = "
						+ rsmd.getColumnName(i) + ", column type = "
						+ rsmd.getColumnTypeName(i));
			}

			rs.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close(); // close resultSet
				if (prepStmt != null)
					prepStmt.close(); // close PreparedStatement
				if (con != null)
					con.close(); // close connection
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}