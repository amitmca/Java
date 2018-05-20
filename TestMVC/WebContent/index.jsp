<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="com.srcsys.mvc.db.*,java.io.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MVC Architecture</title>
</head>
<body>
<form name="dataform" action="insert.jsp" method="post">
 <table border=0>    
                        
		
			<tr>
				<td></td>
				<td align="right" valign="top">
				<font face="calibri" color=green size=2>
				<b>Employee No </b>
				</font>
				</td>	
				<td align="center" valign="top"><b>:</b></td>
				<td height="51" valign="top">
				<input type="text" name="empno">
				</td>
			</tr>
			<tr>
				<td></td>
				<td align="right" valign="top">
				<font face="calibri" color=green size=2>
				<b>Employee Name</b>  				</font>
				</td>
				<td align="center" valign="top"><b>:</b></td>
				<td height="56" valign="top">
				<input type="text" name="empnm">
				</td>
			</tr>
			<tr>
				<td height="60" colspan="4" align="center">
				<input name='insert' type=submit value="Insert">
				</td>
			
			</tr>
			
			<tr>
				<td><br><br>
				<%
				
				  Set<Employee> list = Database.showEmployees();
				  String str = "";
				  for (Iterator<Employee> iterator = list.iterator(); iterator.hasNext();) {
				  Employee emp = (Employee) iterator.next();
				  	out.println("<table border=0><tr>");
				  	%>
				  	 <td><% out.println(emp.emp_no); %></td>
				  	 <td><% out.println(emp.emp_name); %></td>
				  	 <td><a href="edit.jsp?id=<%=emp.emp_no%>">Edit</a></td>
				  	 <td><a href="delete.jsp?id=<%=emp.emp_no%>">Delete</a></td>
				  	<%
				  }
				  out.println("</tr></table>");
				%>
				</td>
			</tr>		
                      
          </table>

</form>
</body>
</html>
