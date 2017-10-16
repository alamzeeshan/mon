<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="com.capcom.monitoring.model.Employee" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1> employee.jsp </h1>
 <br/>
 
 <%
 	List<Employee> emplist = (List<Employee>)request.getAttribute("employeeList");
 
 	for (Employee e : emplist)
 	{
 		out.print(e);
 		out.print("<br/>");
 		
 	}
 
 
 %>
 
  <br/>
  
  
  <table border="1px">
  <tr>
  	<th>EMPNO</th>
  	<th>ENAME</th>
  	<th>JOB</th>
  	<th>MGR</th>
  	<th>HIREDATE</th>
  	<th>SAL</th>
  	<th>DEPTNO</th>
  </tr>
  
  <% 
  
  
	for (Employee e : emplist)
	{
		out.print("<tr>");
		
		out.print("<td>");
		out.print(e.getEmpNo());
		out.print("</td>");
		
		out.print("<td>");
		out.print(e.getEmpName());
		out.print("</td>");
		
		out.print("<td>");
		out.print(e.getJob());
		out.print("</td>");
		
		out.print("<td>");
		out.print(e.getManagerId());
		out.print("</td>");
		
		out.print("<td>");
		out.print(e.getHireDate());
		out.print("</td>");
		
		out.print("<td>");
		out.print(e.getSalary());
		out.print("</td>");
		
		out.print("<td>");
		out.print(e.getDeptNo());
		out.print("</td>");
		
		out.print("</tr>");
	}
  %>
  
  </table>
 
</body>
</html>