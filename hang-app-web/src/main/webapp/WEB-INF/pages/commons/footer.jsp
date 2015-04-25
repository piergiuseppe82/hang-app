 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <footer class="page-footer  teal lighten-2">
          <div class="container">
            <div class="row">
              <div class="col l6 s12">
                <h5 class="white-text">Footer Content</h5>
                <p class="grey-text text-lighten-4">You can use rows and columns here to organize your footer content.</p>
              </div>
              <div class="col l4 offset-l2 s12">
                <h5 class="white-text">Links</h5>
                <ul>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 1</a></li>
                </ul>
              </div>
            </div>
          </div>
          <div class="footer-copyright">
            <div class="container">
            © 2014 Copyright Hang App
            
            </div>
          </div>
        </footer>  
     	 <%if(request.getAttribute("toast") != null){%>
   	
	   		<script type="text/javascript">
	   			Materialize.toast('<%=request.getAttribute("toast")%>', 4000) // 4000 is the duration of the toast
			</script>
   	
   		
   		<%} %>
    </body>
  </html>