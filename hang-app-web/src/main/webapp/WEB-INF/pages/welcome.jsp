<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="commons/header.jsp"/>
 
            
   <div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
     <a class="btn-floating btn-large waves-effect waves-light red" href="newitem"><i class="mdi-content-add"></i></a>
   
  </div>
  
  	<div class='container postCardsBasket'>
		
	</div>
  
  <script type="text/javascript">
  function createPostCard(objJ){
	 var item = "";
	 item = item + "<div class='row'>";
	 item = item + "	<div class='card'>";
	 item = item + "		<div class='row valign-wrapper'>";
	 item = item + "			<div class='col s2' style='margin:0.3rem'>";
	 item = item + "				<img src='media/image/"+objJ["photoPath"]+"' alt=''";
	 item = item + "					class='circle responsive-img'>";
	 item = item + "				<!-- notice the 'circle' class -->";
	 item = item + "			</div>";
	 item = item + "			<div class='col s10'>";
	 item = item + "				<span class='black-text'> <a href='#'>"+objJ["accountId"]+"</a> - "+objJ["postName"]+"</span>";
	 item = item + "			</div>";
	 item = item + "		</div>";
	 item = item + "		<div class='card-action col s8 offset-s2'>";
	 item = item + "			<img class='responsive-img' src='media/image/"+objJ["photoPath"]+"'>";
	 item = item + "		</div>";
	 
	 item = item + "		<div class='col s12 card-action'>";
	 item = item + "              <p style='color:silver'>"+getFormattedDHMS(getDHMSDifferenceBetween(objJ["postCreationTime"]))+"</p>";
	 item = item + "              <p id='position_post_"+objJ["id"]+"' style='color:silver'></p>";	 
	 item = item + "         </div>";
	 item = item + "	</div>";
	 item = item + "</div>";
  	 return  item;    
  }
  $.getJSON( "posts", function( data ) {
	  geocoder = new google.maps.Geocoder();
	  $.each( data, function( key, val ) {
	  	//console.log(val);
		 
	   $(".postCardsBasket").append(createPostCard(val));  
	   var point = new google.maps.LatLng(val["latitude"],val["longitude"]);	 
	   	geocoder.geocode({'latLng': point}, function(results, status) {
	      if (status == google.maps.GeocoderStatus.OK) {
	        if (results[1]) {
	        	$("#position_post_"+val["id"]).html(results[1].formatted_address);
	        }
	      } else {
	    	  $("#position_post_"+val["id"]).html("Unknow position");
	      }
	    });   
	      
	  });
	 
	});
</script>   
 <jsp:include page="commons/footer.jsp"/>