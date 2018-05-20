package com.test.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseMetaDataTest {
	public static void main(String... arg) {
		Connection con = null;
		PreparedStatement prepStmt = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "system", "123456");
			System.out.println("Connection established successfully!");

			DatabaseMetaData dbMetaData = con.getMetaData();
			System.out.println("--Database driver name and version--");
			System.out.println("Database driver name = "
					+ dbMetaData.getDriverName());
			System.out.println("Database driver version = "
					+ dbMetaData.getDriverVersion());

			System.out.println("\n--Database product name and version--");
			System.out.println("Database product name = "
					+ dbMetaData.getDatabaseProductName());
			System.out.println("Database product version = "
					+ dbMetaData.getDatabaseProductVersion());

			System.out.println("\n--Database user name--");
			System.out.println("Database user name = "
					+ dbMetaData.getUserName());

			System.out.println("\n--Database URL--");
			System.out.println("Database URL = " + dbMetaData.getURL());

			System.out.println("\n--Database Minor and Major version--");
			System.out.println("Database Minor version = "
					+ dbMetaData.getDatabaseMinorVersion());
			System.out.println("Database Major version = "
					+ dbMetaData.getDatabaseMajorVersion());

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
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
