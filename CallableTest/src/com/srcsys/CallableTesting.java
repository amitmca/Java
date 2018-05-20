package com.srcsys;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.srcsys.*; 

public class CallableTesting 
{
	public static void main(String args[])
	{
		Connection connection = null;
		CallableStatement insertstat=null,selectstmt=null,deletestmt=null,updatestmt=null;
		try {
			    connection = Database.getOracleConnection();
				CallableStatement stmt=null;
				
				// Code for displaying data from Oracle table using Stored Procedure
				
				String sql="{call getEmpName(?,?) }";
				stmt=connection.prepareCall(sql);
				stmt.setInt(1,700);
				stmt.registerOutParameter(2,java.sql.Types.VARCHAR);
				stmt.execute();
				String name=stmt.getString(2);
				System.out.println(name);
				
				// Code for inserting data into Oracle table using Stored Procedure
				
			    insertstat=connection.prepareCall("{call insertEmployee(?,?,?,?)}");
			    insertstat.setInt(1,600);
			    insertstat.setString(2,"Kasturi");
			    insertstat.setString(3,"Bhalerao");
			    insertstat.setInt(4,500);
			    insertstat.executeUpdate();
				
				
				// Code for deleting data from Oracle table using Stored Procedure
				 
				deletestmt=connection.prepareCall("{call deleteEmployee(?)}");
				deletestmt.setInt(1,700);
			    deletestmt.executeUpdate();
			    
			    // Code for updating data of Oracle table using Stored Procedure
				
			   /* updatestmt=connection.prepareCall("{call updateEmployee(?,?,?,?)}");
			    updatestmt.setInt(1,700);
			    updatestmt.setString(2,"Mrs.Kasturi");
			    updatestmt.setString(3,"Bhalerao");
			    updatestmt.setInt(4,500);
			    updatestmt.executeUpdate();*/
			   connection.close();
		    }
		catch(Exception e) 
			{
				System.out.println("my message:"+e.getMessage());
	     	}
	}
	
}
