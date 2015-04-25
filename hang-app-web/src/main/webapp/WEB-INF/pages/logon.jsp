<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="commons/header.jsp"/>
    
    
  <div class="row">
    <form class="col s12" id="logonfrm" method="post" action="logon">
      <div class="row">
        <div class="input-field col s12">
          <input id="first_name" type="text" name="username" class="validate">
          <label for="first_name">Username</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input id="password" type="password" name="password" class="validate">
          <label for="password">Password</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">        
			<a id="buttonLogon" class="waves-effect waves-light btn">Log On</a>
        </div>
      </div>
    </form>
  </div>
  <script type="text/javascript">
		
		
		$("#buttonLogon").on("click",function(){
		   	
		    $("#logonfrm").submit();
		}); 
		
		
	</script>    
<jsp:include page="commons/footer.jsp"/>