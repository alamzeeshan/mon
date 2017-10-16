<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>

<style>

table {   
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: rgb(170, 221, 212)} 

th {
    background-color: #cc2446;
    color: white;
}

.lggrn {
 	background-color: #43b217
}

</style>

</head>

<body>
	 
	
	<div>
		<h1> welcome home</h1>
		<c:url value="/resources/text.txt" var="url"/>
		<spring:url value="/resources/text.txt" htmlEscape="true" var="springUrl" />
		Spring URL: ${springUrl} at ${time}
		<br>
		JSTL URL: ${url}
		<br>
		Message: ${message} 
	</div>
	
	<table>
	  <tr>
	    <th>Firstname</th>
	    <th>Lastname</th>
	    <th>Savings</th>
	  </tr>
	  <tr>
	    <td>Peter</td>
	    <td>Griffin</td>
	    <td>$100</td>
	  </tr>
	  <tr>
	    <td>Lois</td>
	    <td>Griffin</td>
	    <td>$150</td>
	  </tr>
	  <tr>
	    <td>Joe</td>
	    <td>Swanson</td>
	    <td>$300</td>
	  </tr>
	  <tr>
	    <td>Cleveland</td>
	    <td class="lggrn">Brown</td>
	    <td>$250</td>
	</tr>
	</table>
	
</body>

</html>
