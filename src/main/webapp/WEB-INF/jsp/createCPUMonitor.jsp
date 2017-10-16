<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Monitoring Home</title>
   
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
	     <!-- Custom styles for this template -->
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/starter-template.css" />
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/twitter-typeahead.css" />    
	    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	    <script src="${pageContext.request.contextPath}/js/typeahead.bundle.js"></script>


  </head>
	
  <body>
	<%@include file="header.jsp"%>
	
	
	<div class="container-fluid">
	 <h2>Create CPU Monitor</h2>
	 <br>
	 
	 <form:form class="form-horizontal" method="post" modelAttribute="monitorRequest" action="/createCPUMonitor">
	 
		 <spring:bind path="hostname">
			  <div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Server</label>
				<div class="col-sm-3">
					<form:input path="hostname" type="text" class="form-control" id="hostname" readonly="true" value="${monitorRequest.hostname}" />
					<form:errors path="hostname" class="control-label" />
				</div>
			  </div>
			</spring:bind>
			
			<spring:bind path="condition">
			  <div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Condition</label>
				<div class="col-sm-3">
					<!-- <input class="form-control input-sm" id="condition" name="condition" type="text"> -->
					<form:input path="condition" class="form-control" id="condition" placeholder="Condition" />
					<form:errors path="condition" class="control-label" />
				</div>
			  </div>
			</spring:bind>
			
			<spring:bind path="interval">
			  <div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Interval</label>
				<div class="col-sm-3">
					<%-- <form:input path="condition" class="form-control" id="condition" placeholder="Condition" /> --%>
                    <form:select path="interval" class="form-control" id="interval">
                    	<form:option value="5m">5 minute</form:option>
                    	<form:option value="10m">10 minute</form:option>
                    	<form:option value="15m">15 minute</form:option>
                    </form:select>
					<form:errors path="condition" class="control-label" />
				</div>
			  </div>
			</spring:bind>
			
			<spring:bind path="escalType">
			  <div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Escalation Type</label>
				<div class="col-sm-3">
					<%-- <form:input path="condition" class="form-control" id="condition" placeholder="Condition" /> --%>
                    <form:select path="escalType" class="form-control" id="escalType">
                    	<form:option value="ticket">Ticket</form:option>
                    	<form:option value="email">Email</form:option>
                    </form:select>
					<form:errors path="escalType" class="control-label" />
				</div>
			  </div>
			</spring:bind>
			
			<spring:bind path="escalGroup">
			  <div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Escalation Group</label>
				<div class="col-sm-3">
					<form:input path="escalGroup" class="form-control" id="escalGroup" placeholder="Escalation Group" />
					<form:errors path="escalGroup" class="control-label" />
				</div>
			  </div>
			</spring:bind>
			
			<spring:bind path="schedule">
			  <div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Schedule</label>
				<div class="col-sm-3">
					<%-- <form:input path="condition" class="form-control" id="condition" placeholder="Condition" /> --%>
                    <form:select path="schedule" class="form-control" id="schedule">
                    	<form:option value="DAILY">Everyday All day</form:option>
                    	<form:option value="BUSINESS_HOURS">Business Hours Only</form:option>
                    	<form:option value="WEEKENDS">Weekdays Only</form:option>
                    	<form:option value="WEEKDAYS">Weekends Only</form:option>
                    </form:select>
					<form:errors path="schedule" class="control-label" />
				</div>
			  </div>
			</spring:bind>
			
			<spring:bind path="chgGroup">
			  <div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Change Group</label>
				<div class="col-sm-3">
					<form:input path="chgGroup" class="form-control" id="chgGroup" placeholder="Change Group" />
					<form:errors path="chgGroup" class="control-label" />
				</div>
			  </div>
			</spring:bind>
			
			
		<div class="form-group">
		  <div class="col-sm-offset-2 col-sm-3">
			<div class="btn-group" role="group" aria-label="...">	  
			  <button type="button" class="btn btn-primary">cancel</button>
			  <button type="submit" class="btn btn-primary">submit</button>
			</div>
		  </div>
		</div>

	 
		<%-- <form:input path="name" type="text" /> <!-- bind to user.name-->
		<form:errors path="name" /> --%>
	</form:form>
	
	<%-- 
	<form action="/createCPUMonitor" method="post">
	
	 <div class="form-inline">
	    <label for="inputlg">Server</label>
	    <input class="form-control input-sm" readonly="readonly" type="text" id="hostname" name="hostname" value="${serverName}"> 
	  </div>
	  <br>
	  <div class="form-inline">
	    <label for="inputlg">Condition</label>
	    <input class="form-control input-sm" id="condition" name="condition" type="text">
	  </div>
	  <br>
	  <div class="form-inline">
	    <label for="inputlg">Interval</label>
	    <!-- <input class="form-control input-sm" id="interval" name="interval" type="text"> -->
	    <select class="form-control" id="interval" name="interval">
		    <option value="5m">5 minute</option>
		    <option value="10m">10 minute</option>
		    <option value="15m">15 minute</option>
		</select>
	 </div>
	 <br>
	  <div class="form-inline">
	    <label for="inputlg">Escalation Type</label>
	    <!-- <input class="form-control input-sm" id="escalType" name="escalType" type="text"> -->
	    <select class="form-control" id="escalType" name="escalType">
		    <option value="ticket">Ticket</option>
		    <option value="email">Email</option>
		</select>
	 </div>
	 <br>
	  <div class="form-inline">
	    <label for="inputlg">Escalation Group</label>
	    <input class="form-control input-sm" id="escalGroup" name="escalGroup" type="text">
	 </div>
	 <br>
	  <div class="form-inline">
	    <label for="inputlg">Schedule</label>
	   <!--  <input class="form-control input-sm" id="schedule" name="schedule" type="text"> -->
	    <select class="form-control" id="schedule" name="schedule">
		    <option value="DAILY">Everyday All day</option>
		    <option value="BUSINESS_HOURS">Business Hours Only</option>
		    <option value="WEEKENDS">Weekdays Only</option>
		    <option value="WEEKDAYS">Weekendss Only</option>
		</select>
	 </div>
	 <br>
	  <div class="form-inline">
	    <label for="inputlg">Change Group</label>
	    <input class="form-control input-sm" id="chgGroup" name="chgGroup" type="text">
	 </div>
	<br>
	
			
	<div class="btn-group" role="group" aria-label="...">
	  
	  <button type="button" class="btn btn-primary">cancel</button>
	  <button type="submit" class="btn btn-primary">submit</button>
	</div>
	
	  
	</form> --%>
	</div>

<!--  <div class="form-inline">
	    <label for="inputsm">Server</label>
	    <input class="form-control input-sm" id="inputsm" type="text">
	  </div>
	  <div class="form-inline">
	    <label for="inputlg">Condition</label>
	    <input class="form-control input-sm" id="inputlg" type="text">
	  </div>
	  <div class="form-inline">
	    <label for="inputlg">Interval</label>
	    <input class="form-control input-sm" id="inputlg" type="text">
	  </div>
	  <div class="form-inline">
	    <label for="inputlg">Automated Actions</label>
	    <input class="form-control input-sm" id="inputlg" type="text">
	  </div>
	  <div class="form-inline">
	    <label for="inputlg">FSC Instructions(OpDocs)</label>
	    <input class="form-control input-sm" id="inputlg" type="text">
	  </div>
	  <div class="form-inline">
	    <label for="inputlg">Monitor Schedule</label>
	    <input class="form-control input-sm" id="inputlg" type="text">
	  </div>
	   <div class="form-inline">
	    <label for="inputlg">Change Group(for logging updates)</label>
	    <input class="form-control input-sm" id="inputlg" type="text">
	  </div> -->
	
	


</body>
</html>
