<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Hello

<%  
	List<String> mylist = (List<String>)request.getAttribute("myownlist");
	out.println("jjjjjjjjjjj");
	out.println(mylist.size()); 
	out.println(mylist); 
	
	for (String s : mylist) {
		out.println("<br/><b>Hello!</b> "+ s);
	}
	

%>-



</body>
</html>