<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/starter-template.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/twitter-typeahead.css" />   
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/dataTables.bootstrap.min.css" />  
 <!-- Custom styles for this template -->

 
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/typeahead.bundle.js"></script>


<script type="text/javascript">
  
$(document).ready(function() {
	
	
	$('#example').DataTable( {
        "ajax": "/cpumonitors/${server}",
        "columns": [
            { "data": "monitorId" },
            { "data": "source" },
            { "data": "monitorName" },
            { "data": "hostName" },
            { "data": "interval" },
            { "data": "condition" },
            { "data": "escalType" },
            { "data": "escalGroup" },
            { "data": "schedule" },
            { "data": "changeGroup" }
        ]
    } );
    
    
} );
    
</script>

</head>

<body>
	<%@include file="header.jsp"%>
	
	
	<div class="container-fluid">
	
		<div class="row" style="padding: 15px">
			<c:out value="${server}"></c:out>
			<a href="getCreateCPUMonitorPage/${server}" class="btn btn-primary pull-right" role="button">Create</a>
		</div>	
		
		<div class="row">
			<table id="example" class="table table-striped table-bordered nowrap" cellspacing="0" width="100%">
	        <thead>
	            <tr>
	                <th>monitorId</th>
	                <th>source</th>
	                <th>monitorName</th>
	                <th>hostName</th>
	                <th>interval</th>
	                <th>condition</th>
	                <th>escalType</th>
	                <th>escalGroup</th>
	                <th>schedule</th>
	                <th>changeGroup</th>
	            </tr>
	        </thead>
	    </table>
		</div>			

		

		
	</div>
	
	


</body>
</html>