package com.test.jdbc;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableStatementExampleFunction {
  public static void main(String... arg) {
      Connection con = null;
      CallableStatement callableStmt = null;
      try {
           // registering Oracle driver class
           Class.forName("oracle.jdbc.driver.OracleDriver");
 
           // getting connection
           con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "system",
					"123456");
           System.out.println("Connection established successfully!");
           
  
           callableStmt = con.prepareCall("{ ? = call MYFUNCTION(?)}");
 
           //Database function will return value as OUT parameter
           callableStmt.registerOutParameter(1, java.sql.Types.NUMERIC);
           
           //IN parameter -
           //set methods are used for setting IN parameter values of Stored procedure
           callableStmt.setInt(2, 12);
           
           //Execute database Function,
           callableStmt.executeUpdate();
 
           // Then retrieve values returned by method using using get methods.
           System.out.println("salary = " + callableStmt.getInt(1));
           
           System.out.println("Function executed successfully, "
                    + "salary has been fetched from Employee table");
 
      } catch (ClassNotFoundException e) {
           e.printStackTrace();
      } catch (SQLException e) {
           e.printStackTrace();
      }
      finally{
           try {
               if(callableStmt!=null) callableStmt.close(); //close CallableStatement
               if(con!=null) con.close(); // close connection
           } catch (SQLException e) {
               e.printStackTrace();
           }
      }
  }
}
 