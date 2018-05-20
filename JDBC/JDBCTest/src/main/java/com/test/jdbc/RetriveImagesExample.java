package com.test.jdbc;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class RetriveImagesExample {
    public static void main(String... arg) {
           Connection con =null;
           PreparedStatement prepStmt = null;
           ResultSet rs =null;
           FileOutputStream fout =null;
           String retrievedImagePath="c:/myImgRetrieved.png";
           try {
                  // registering Oracle driver class
                  Class.forName("oracle.jdbc.OracleDriver");
 
                  // getting connection
                  con = DriverManager.getConnection(
        					"jdbc:oracle:thin:@localhost:1521:xe", "system",
        					"123456");
                  System.out.println("Connection established successfully!");
                  
                  //java.sql.Blob will be used to store file retrieved from database.
                  Blob blob = null;
           
                  prepStmt=con.prepareStatement("select ID, IMAGE_COL from TEST_IMG "
                                                                     +"where ID=1");

                  //execute select query
                  rs=prepStmt.executeQuery();
                  while(rs.next()){
                     blob=rs.getBlob("IMAGE_COL");//Now, blob contains the file retrieved from database.
                  }
                  
                  fout=new FileOutputStream(retrievedImagePath);
                  //get bytes from blob object and write those bytes in output file
                  fout.write(blob.getBytes(1,(int)blob.length() ));
 
                  System.out.println("Image retrieved from database at > " +retrievedImagePath);                                      
                  
           } catch (Exception e) {
                  e.printStackTrace();
           }
           finally{
                  try {
                        if(fout!=null) fout.close(); //close file
                        if(rs!=null) rs.close(); //close resultSet
                        if(prepStmt!=null) prepStmt.close(); //close PreparedStatement
                        if(con!=null) con.close(); // close connection
                  } catch (SQLException e) {
                        e.printStackTrace();
                  } catch (IOException e) {
                        e.printStackTrace();
                  }
           }
    }
}