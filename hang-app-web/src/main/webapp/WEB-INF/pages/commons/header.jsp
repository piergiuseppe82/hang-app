<%@page import="it.piergiuseppe82.hangapp.services.bean.pojo.PersonPojo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
  <html>
    <head>
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    </head>

    <body>
    
    
      <!--Import jQuery before materialize.js-->
      <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="js/materialize.min.js"></script>
      <script type="text/javascript" src="js/hangwebapputils.js"></script>
   
  <nav>
    <div class="nav-wrapper teal lighten-2">
      <a href="#!" class="brand-logo">Hang App</a>
      <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="mdi-navigation-menu"></i></a>
      <ul class="right hide-on-med-and-down">
      	<li><a href="./">Home</a></li>      
      	<%if(request.getSession().getAttribute("user") != null){ %>
      		<li><a href="profile"><%=((PersonPojo)request.getSession().getAttribute("user")).getAccountId()%></a></li> 
	       	<li><a href="logout">Log Out</a></li>      
	    <%}else{ %>
	       	<li><a href="logon">Log On</a></li>     
	        <li><a href="register">Register</a></li>       
       	<%} %>
      </ul>
      <ul class="side-nav" id="mobile-demo">
      	<li><a href="./">Home</a></li>  
        <%if(request.getSession().getAttribute("user") != null){ %>
	       	<li><a href="profile"><%=((PersonPojo)request.getSession().getAttribute("user")).getAccountId()%></a></li> 
	       	<li><a href="logout">Log Out</a></li>      
	    <%}else{ %>
	       	<li><a href="logon">Log On</a></li>      
	       	  <li><a href="register">Register</a></li>       
       	<%} %>
      </ul>
    </div>
  </nav>
   <script type="text/javascript">
      $(".button-collapse").sideNav();
      </script>  