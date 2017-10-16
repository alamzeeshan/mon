<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>My Page</title>

	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style type="text/css">
	body {

           
}
[class*="col-"] {
  border: 1px solid #ddd;
} 

.wrapper{position:relative;}
.bottom{border-top: 1px;position:absolute; bottom:0; padding: 16px;}

p.overview {
    word-wrap: break-word;
    white-space: normal;
    color: #4d4d4d;
    font-size: 0.9em;
    line-height: 1.2em;
    padding-top: 50px;
}




</style>
</head>
<body>
<div class="container-fluid">

<form action="movieSearch" method="get">
	<div class="row">	
		<div class="input-group input-group-lg">
			<span class="input-group-addon"> <a href="/index"> <span class="glyphicon glyphicon-home" aria-hidden="true"></span></a></span>
		  <input id="searchKey" name="searchKey" type="text" class="form-control" placeholder="Search" aria-describedby="sizing-addon1">
			<span class="input-group-btn">
        <button class="btn btn-default" type="submit">Search!</button>
      </span>
		</div>
	</div>
</form>
	<br>

	<div style="width:800px; margin:0 auto;">

	<div class="media wrapper" >
	    <div class="media-left">
		    <a href="#">
		      <img class="media-object" src="https://image.tmdb.org/t/p/w185_and_h278_bestv2/4PiiNGXj1KENTmCBHeN6Mskj2Fq.jpg" alt="...">
		    </a>
		</div>
		<div class="media-body" style="padding:10px;">
		   <h4 class="media-heading"><span class="pull-left">Doctor Strange</span> <span class="pull-right">6.8</span></h4>
		   <br>
		   <div><span class="glyphicon glyphicon-calendar pull-left" aria-hidden="true"></span><span class="pull-left"> 10/25/2016</span> <span class="pull-right">Action, Adventure, Fantasy, Science Fiction</span></div>
		   
		   <p class="overview">After his career is destroyed, a brilliant but arrogant surgeon gets a new lease on life when a sorcerer takes him under his wing and trains him to defend the world against evil.</p>

		   <p class="bottom">More Info</p>
		</div>
	</div>
	<br>
	<div class="media wrapper">
	    <div class="media-left">
		    <a href="#">
		      <img class="media-object" src="https://image.tmdb.org/t/p/w185_and_h278_bestv2/4PiiNGXj1KENTmCBHeN6Mskj2Fq.jpg" alt="...">
		    </a>
		</div>
		<div class="media-body" style="padding:10px;">
		   <h4 class="media-heading"><span class="pull-left"><c:out value="${movieName}"></c:out></span> <span class="pull-right">6.8</span></h4>
		   <br>
		   <div><span class="pull-left"> 10/25/2016</span> <span class="pull-right">Action, Adventure, Fantasy, Science Fiction</span></div>
		   
		   <p class="overview">After his career is destroyed, a brilliant but arrogant surgeon gets a new lease on life when a sorcerer takes him under his wing and trains him to defend the world against evil.</p>
		   
		   <p class="bottom"> More Info</p>
		</div>
	</div>
	
	<div class="media wrapper">
	    <div class="media-left">
		    <a href="#">
		      <img class="media-object" src="${movie.poster_path}" alt="...">
		    </a>
		</div>
		<div class="media-body" style="padding:10px;">
		   <h4 class="media-heading"><span class="pull-left"><c:out value="${movie.title}"></c:out></span> <span class="pull-right"><c:out value="${movie.popularity}"></c:out></span></h4>
		   <br>
		   <div><span class="pull-left"> <c:out value="${movie.release_date}"></c:out> </span> 
		   <span class="pull-right">
			   <c:forEach var="genreId" items="${movie.genre_ids}">
			        <c:out value="${genreId}"></c:out>&nbsp;
			    </c:forEach>
		   </span></div>
		   
		   <p class="overview"> <c:out value="${movie.overview}"></c:out> </p>
		   
		   <p class="bottom"> More Info</p>
		</div>
	</div>

	<br>
	<h1>Getting from REST API</h1>
	
	 <c:forEach var="movie" items="${searchResult}">
	 	<div class="media wrapper" style="background-color:#E0E0E0;">
		    <div class="media-left">
			    <a href="#">
			      <img class="media-object" src="${movie.poster_path}" alt="...">
			    </a>
			</div>
			<div class="media-body" style="padding:10px;">
			   <h4 class="media-heading"><span class="pull-left"><c:out value="${movie.title}"></c:out></span> <span class="pull-right"><c:out value="${movie.popularity}"></c:out></span></h4>
			   <br>
			   <div><span class="pull-left"> <c:out value="${movie.release_date}"></c:out> </span> 
			   <span class="pull-right">
				   <c:forEach var="genreId" items="${movie.genre_ids}">
				        <c:out value="${genreId}"></c:out>&nbsp;
				    </c:forEach>
			   </span></div>
			   
			   <p class="overview"> <c:out value="${movie.overview}"></c:out> </p>
			   
			   <p class="bottom"> More Info</p>
			</div>
		</div>
	 
	 </c:forEach>
	
	


	</div>	


	



</div>
</body>
</html>