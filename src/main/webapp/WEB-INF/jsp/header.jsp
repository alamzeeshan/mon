<nav class="navbar navbar-default navbar-fixed-top" style="background-color: #286090;border-color: #204d74;">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#" style="color:white">Monitoring</a>
        </div>
        <ul class="nav navbar-nav">
	      <li style="color:white"><a href="/">Home</a></li>
	    </ul>
        <div id="navbar" class="navbar-collapse collapse">
          <form class="navbar-form navbar-right" action="homesearchresults" method="get">        
            <div class="form-group">
                <div class="form-group">
				  <select class="form-control" id="maindropdown" name="maindropdown">
				    <option value="">-- Search By --</option>
				    <option value="server">Server</option>
				    <option value="escalation">Escalation</option>
				  </select>
				</div>
            </div>
            <div class="form-group">
              <input type="text" id="searchTextbox" name="searchTextbox" placeholder="Search" class="form-control" disabled>
            </div>
            <button type="submit" id="homeSearchSubmit" class="btn btn-success" disabled>Submit</button>
          </form>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>
    <script type="text/javascript">    
  
    $( document ).ready(function() {
        
    	$("#maindropdown").change(function () {
    		$("#searchTextbox").val("");
            var selected = $('#maindropdown option:selected').val();
            console.log(selected);
            
            if (selected == "server" || selected == "escalation") {
            	$("#searchTextbox").prop('disabled', false);
            	$("#homeSearchSubmit").prop('disabled', false);            	
            } else { // selected back -- Search By --
            	$("#searchTextbox").prop('disabled', true);            	
            	$("#homeSearchSubmit").prop('disabled', true);  
            }
            
            
        });
    	
    	
    	// searchByServerTypeAhead : START
        
      var serverNames = new Bloodhound({
  	  datumTokenizer: Bloodhound.tokenizers.obj.whitespace('vval'),	  
  	  queryTokenizer: Bloodhound.tokenizers.whitespace,
  	  remote: {
  	    url: 'searchText/server_name/%QUERY',
  	    filter: function(x) {
                  return $.map(x, function(item) {
                      return {vval: item};
                  });
           },
  	    wildcard: '%QUERY'	    
  	  }
  	});
      
   // Initialize the Bloodhound suggestion engine
      serverNames.initialize();
  	
      
      $('#searchTextbox').typeahead(null, {
  	  name: 'vval',
        displayKey: 'vval',
  	  source: serverNames
  	});

      
   // searchByServerTypeAhead : END
    	
    	
        
        
    });
    
    </script>