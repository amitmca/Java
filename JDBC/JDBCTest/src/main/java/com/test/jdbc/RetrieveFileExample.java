package com.test.jdbc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrieveFileExample {
	public static void main(String... arg) {
		Connection con = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		Reader reader = null;
		FileOutputStream fout = null;
		String retrievedFilePath = "c:\\myTxtRetrieved.txt";
		try {
			// registering Oracle driver class
			Class.forName("oracle.jdbc.OracleDriver");

			// getting connection
			con = DriverManager.getConnection(
 					"jdbc:oracle:thin:@localhost:1521:xe", "system",
 					"123456");
			System.out.println("Connection established successfully!");

			// java.sql.Clob will be used to store file retrieved from database.
			Clob clob = null;

			prepStmt = con
					.prepareStatement("select ID, FILE_COL from TEST_FILES "
							+ "where ID = 1");
			// execute select query
			rs = prepStmt.executeQuery();
			while (rs.next()) {
				clob = rs.getClob("FILE_COL");// Now, clob contains the file
												// retrieved from database.
			}

			// Obtain STREAM OF CHARACTERS from clob into java.Io.Reader object
			reader = clob.getCharacterStream();
			fout = new FileOutputStream(retrievedFilePath);

			// now read characters one by one from Reader object
			int ch;
			while ((ch = reader.read()) != -1) {
				fout.write(ch); // write characters in output file
			}

			System.out.println("File retrieved from database at > "
					+ retrievedFilePath);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fout != null)
					fout.close(); // close file
				if (reader != null)
					reader.close(); // close reader
				if (rs != null)
					rs.close(); // close resultSet
				if (prepStmt != null)
					prepStmt.close(); // close PreparedStatement
				if (con != null)
					con.close(); // close connection
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
