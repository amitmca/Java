import java.sql.*;

public class JdbcOdbc {
        public static void main(String args[]) {
	
	
        try {
        Connection con;
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        con = DriverManager.getConnection("jdbc:odbc:Oracle");
		}
		catch (Exception e) {
                System.out.println("Error:connection not created");
				}
       /* try {
                System.out.println("Getting All Rows from a table!");
                Statement st = con.createStatement();
                ResultSet res = st.executeQuery("SELECT * FROM  icici_bank");
                System.out.println("Accounr+: " + "\t" + "student_name: ");
                while (res.next()) {
                        int i = res.getInt("stud_code");
                        String s = res.getString("stud_name");
                        System.out.println(i + "\t\t" + s);
                }
                con.close();
			} catch (SQLException s) {
					System.out.println("SQL code does not execute.");
			}
			} catch (Exception e) {
                System.out.println("Error:connection not created");
        }
		*/

        }

}