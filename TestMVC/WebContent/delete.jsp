<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="com.srcsys.mvc.db.*,java.io.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String no=request.getParameter("id");
int emp_id=Integer.parseInt(no);
Database.deleteEmpoyee(emp_id);
%>
<script type="text/javascript">
alert("Record Deleted");
</script>
<%
response.sendRedirect("index.jsp");
%>
</body>
</html>
