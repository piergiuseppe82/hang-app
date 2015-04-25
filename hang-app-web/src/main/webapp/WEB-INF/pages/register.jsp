<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<jsp:include page="commons/header.jsp"/>
    
    
  <div class="row">
    <form class="col s12" id="registerfrm" method="post" action="register">
      <div class="row">
        <div class="input-field col s12">
          <i class="mdi-action-account-circle prefix"></i>
          <input id="fullName" type="text" name="fullName" class="validate">
          <label for="fullName">Full Name</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
           <i class="mdi-action-account-box prefix"></i>
          <input id="username" type="text" name="username" class="validate">
          <label for="username">Username</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
         <i class="mdi-action-lock prefix"></i>
          <input id="password" type="password" name="password" class="validate">
          <label for="password">Password</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
         <i class="mdi-content-mail prefix"></i>
          <input id="email" type="email" name="email" class="validate">
          <label for="email">Email</label>
        </div>
      </div>
      
      <div class="row">
        <div class="input-field col s12">        
			<a id="buttonRegister" class="waves-effect waves-light btn">Create Account</a>
        </div>
      </div>
    </form>
  </div>
  <script type="text/javascript">
  		
		
			$("#buttonRegister").on("click",function(){
				if( validateRegisterForm()){
			    	$("#registerfrm").submit();
				}
			}); 
		
		
		
	</script>    
  
<jsp:include page="commons/footer.jsp"/>