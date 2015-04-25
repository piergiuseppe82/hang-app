<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="commons/header.jsp"/>
  <div class="cardsBasket">
  </div>
            
   <div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
     <a class="btn-floating btn-large waves-effect waves-light red" href="newitem"><i class="mdi-content-add"></i></a>
   
  </div>
  <script type="text/javascript">
  function createHtmlCard(objJ){
	  /* <div class="row">
      <div class="col s12 m7">
        <div class="card">
          <div class="card-image">
            <img src="images/sample-1.jpg">
            <span class="card-title">Card Title</span>
          </div>
          <div class="card-content">
            <p>I am a very simple card. I am good at containing small bits of information.
            I am convenient because I require little markup to use effectively.</p>
          </div>
          <div class="card-action">
            <a href="#">This is a link</a>
            <a href='#'>This is a link</a>
          </div>
        </div>
      </div>
    </div> */
  return  $('<div class="row">').append('<div class="col s12 m7">').append('<div class="card">');
    
  }
  $.getJSON( "posts", function( data ) {
	  $.each( data, function( key, val ) {
	  	//console.log(val);
		 
	   $(".cardsBasket").append(createHtmlCard(val));  
	      
	      
	  });
	 
	});
</script>   
 <jsp:include page="commons/footer.jsp"/>