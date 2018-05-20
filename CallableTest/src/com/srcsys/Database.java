
package com.srcsys;

import java.io.InputStream;
import java.math.BigDecimal;
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
	
	public static Connection getOracleConnection() {
		Properties props = new Properties();
		  props.setProperty("user", "system");
	      props.setProperty("password", "123456");


	      if(connection == null ) {
				try {
					 Class.forName("oracle.jdbc.OracleDriver").newInstance();
				      connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",props);
				      System.out.println("Connected To Oracle Datasbase");
				} catch (Exception e) {
					e.printStackTrace();
				}
	      }
		return connection;
		
	}
	
	public static Connection getMysqlConnection() {
		Properties props = new Properties();
		  props.setProperty("user", "root");
	      props.setProperty("password", "");


	      if(connection == null ) {
				try {
					 Class.forName("com.mysql.jdbc.Driver").newInstance();
				      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis",props);
				      System.out.println("Connected To Mysql Datasbase");
				} catch (Exception e) {
					e.printStackTrace();
				}
	      }
		return connection;
		
	}

}

