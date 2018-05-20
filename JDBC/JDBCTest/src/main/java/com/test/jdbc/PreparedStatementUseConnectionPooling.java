package com.test.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class PreparedStatementUseConnectionPooling {
    public static void main(String... arg) throws SQLException {
 
           ConnectionPool connectionPool = new ConnectionPool(
                        "com.mysql.jdbc.Driver",
                        "jdbc:mysql://localhost/jdbc", "root", "",
                        5, 10, true);
 
           Connection con = connectionPool.getConnection();
           System.out.println("We have got connection from ConnectionPool class");
           
           PreparedStatement prepStmt = con
                        .prepareStatement("select ID, first from Employees");
           
           ResultSet rs = prepStmt.executeQuery();
           while (rs.next()) {
                  System.out.print(rs.getInt("ID") + " ");
                  System.out.println(rs.getString("first"));
           }
 
           if (rs != null)
                  rs.close(); // close resultSet
           if (prepStmt != null)
                  prepStmt.close(); // close PreparedStatement
 
           connectionPool.free(con);
           System.out.println("We have free/released connection to ConnectionPool class");
    }
}
 