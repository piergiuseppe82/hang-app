<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<jsp:include page="commons/header.jsp"/>
	
  <script type="text/javascript">
      function initialize() {
    	  
    	  if (navigator.geolocation) { 
    		  navigator.geolocation.getCurrentPosition(function(position) {  

    		    var point = new google.maps.LatLng(position.coords.latitude, 
    		                                       position.coords.longitude);
    		    

    		    // Initialize the Google Maps API v3
    		    var map = new google.maps.Map(document.getElementById('map-canvas'), {
    		      zoom: 15,
    		      center: point,
    		      panControl: false,
    		      zoomControl: false,
    		      scaleControl: false,
    		      mapTypeControl: true,
    		      streetViewControl: false,
    		      overviewMapControl: false
    		    });

    		    // Place a marker
    		    new google.maps.Marker({
    		      position: point,
    		      map: map,
    		      title:"My Position"
    		    });
    		    $("#lat").val(position.coords.latitude);
    		    $("#long").val(position.coords.longitude);
    		    
    		    geocoder = new google.maps.Geocoder();
    		    geocoder.geocode({'latLng': point}, function(results, status) {
    		      if (status == google.maps.GeocoderStatus.OK) {
    		        if (results[1]) {
    		        	$("#npL").html(results[1].formatted_address);
    		        }
    		      } else {
    		        alert("Geocoder failed due to: " + status);
    		      }
    		    });
    		    
    		  }); 
    		} 
        
      }
      google.maps.event.addDomListener(window, 'load', initialize);
    </script>
    
  <div class="row">
    <form class="col s12" id="newitemfrm"  enctype="multipart/form-data" method="post" action="newitem">
      <div class="row">
        <div class="input-field col s12">
          <i class="mdi-editor-mode-edit prefix"></i>
          <input id="title" type="text" name="title" class="validate">
          <label for="title">Title</label>
        </div>
      </div>
      <div class="row">
            <div class="input-field col s12">
      			<i class="mdi-maps-place prefix"></i>
	      		<input id="np" type="text" name="np" disabled="disabled" >
	      		<label id="npL" for="np">Position</label>
		   		<div id="map-canvas" class="card small" style="height: 200px">
		               
		        </div>
		        <input id="lat" type="hidden" name="latitude">
	      		<input id="long" type="hidden" name="longitude">
      		</div>
      </div>
       <div class="row">
        <div class="card">        
	   		<img id="loadImage" class="responsive-img" />
	   	</div>
      </div>
      <div class="row">        
        <div class="file-field input-field col s12">     
          <input class="file-path validate" type="text"/>
	      <div class="btn">
	      	<i class="mdi-image-photo-camera large"></i>
	      	<input id="imageFile" name="imageFile" type="file">
	      </div>
    	</div>
      </div>
      <div class="row">
        <div class="input-field col s12">        
			<a id="buttonAddItem" class="waves-effect waves-light btn">Add Post</a>
        </div>
      </div>
    </form>
  </div>
  <script type="text/javascript">
  		
		
			$("#buttonAddItem").on("click",function(){
				$("#newitemfrm").submit();
				
			}); 

			function readURL(input) {
		        if (input.files && input.files[0]) {
		            var reader = new FileReader();

		            reader.onload = function (e) {
		                $('#loadImage').attr('src', e.target.result);
		            }

		            reader.readAsDataURL(input.files[0]);
		        }
		    }

		    $("#imageFile").change(function(){
		        readURL(this);
		    });
			
	</script>    
  
<jsp:include page="commons/footer.jsp"/>