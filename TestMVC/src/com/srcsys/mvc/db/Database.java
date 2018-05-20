
package com.srcsys.mvc.db;

import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.LinkedHashSet;

public class Database {
	private static Connection connection = null;
	private static CallableStatement insertstat=null,selectstmt=null,deletestmt=null,updatestmt=null;
	/*public static Connection getConnection() {
		Properties props = new Properties();
		  props.setProperty("user", "system");
	      props.setProperty("password", "123456");


	      if(connection == null ) {
				try {
					 Class.forName("oracle.jdbc.OracleDriver").newInstance();
				      connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",props);
				      System.out.println("Connected To Datasbase");
				} catch (Exception e) {
					e.printStackTrace();
				}
	      }
		return connection;
		
	}*/
	
	public static Connection getConnection() {
		Properties props = new Properties();
		  props.setProperty("user", "root");
	      props.setProperty("password", "");


	      if(connection == null ) {
				try {
					 Class.forName("com.mysql.jdbc.Driver").newInstance();
				      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",props);
				      System.out.println("Connected To Mysql Datasbase");
				} catch (Exception e) {
					e.printStackTrace();
				}
	      }
		return connection;
		
	}
	
	public static boolean addEmployee(Employee emp) {
		boolean ret = false;
		try {
			Connection con = getConnection();
			/*PreparedStatement stmt = connection.prepareStatement("INSERT INTO EMP (ENO,ENAME) values (?,?)");
			stmt.setInt(1,emp.emp_no);
			stmt.setString(2,emp.emp_name);
			stmt.executeUpdate();*/
			insertstat=connection.prepareCall("{call empproc(?,?)}");
		    insertstat.setInt(1,emp.emp_no);
		    insertstat.setString(2,emp.emp_name);
		    ResultSet rs = insertstat.executeQuery();
			System.out.println("Record Added");
			Set<Employee> list = Database.showEmployees();
			  String str = "";
			  for (Iterator<Employee> iterator = list.iterator(); iterator.hasNext();) {
			  Employee emp1 = (Employee) iterator.next();
			  System.out.println(emp1.emp_no+"\t"+emp1.emp_name);
			  }
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public static Set<Employee> showEmployees() {
		Set<Employee> fields = new LinkedHashSet<Employee>();
		try {
			Connection con = getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM EMP");
			ResultSet rs = stmt.executeQuery();  
			
			while (rs.next()) {
				Employee e=new Employee();
				e.emp_no=rs.getInt("eno");
				e.emp_name=rs.getString("ename");
				fields.add(e);
				}
			
			}
		catch(Exception e){
			e.printStackTrace();
			}
		return fields;		
	}
	
	public static Set<Employee> editEmployee(int eno) {
		Set<Employee> fields = new LinkedHashSet<Employee>();
		try {
			Connection con = getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM EMP WHERE eno=?");
			stmt.setInt(1,eno);
			ResultSet rs = stmt.executeQuery();  
			
			while (rs.next()) {
				Employee e=new Employee();
				e.emp_no=rs.getInt("eno");
				e.emp_name=rs.getString("ename");
				fields.add(e);
				}
			
			}
		catch(Exception e){
			e.printStackTrace();
			}
		return fields;		
	}
	
	public static void deleteEmpoyee(int emp_no) {
		
		try {
			Connection con = getConnection();
			/*PreparedStatement stmt = con.prepareStatement("DELETE FROM EMP WHERE ENO=?");
			stmt.setInt(1,emp_no);
			stmt.executeUpdate();*/
			deletestmt=connection.prepareCall("{call empdelete(?)}");
			deletestmt.setInt(1,emp_no);
		    ResultSet rs1 = deletestmt.executeQuery();
			System.out.println("Record Deleted");
			}
		catch(Exception e) {
			e.printStackTrace();
			}
	}
	public static void updateEmpoyee(int emp_no) {
		
		try {
			Connection con = getConnection();
			PreparedStatement stmt = con.prepareStatement("UPDATE EMP SET ENO=?,ENAME=? WHERE ENO=?");
			stmt.setInt(1,emp_no);
			
			stmt.executeUpdate();
			System.out.println("Record Deleted");
			}
		catch(Exception e) {
			e.printStackTrace();
			}
	}
}

