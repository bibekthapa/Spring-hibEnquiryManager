<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="${SITE_URL}/static/js/jquery.min.js" type="text/javascript"></script>
        <script src="${SITE_URL}/static/js/bootstrap.min.js" type="text/javascript"></script>
        <link href="${SITE_URL}/static/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="${SITE_URL}/static/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body >
        <div class="container">
            <nav class="navbar navbar-inverse navbar-static-top">
   
    <ul class="nav nav-pills" role="tablist">
  <li role="presentation"><a href="${SITE_URL}/dashboard/">Home <span class="badge"></span></a></li>
  <li role="presentation"><a href="${SITE_URL}/dashboard/list">Enquiries</a></li>
  
 ${i=1}
  <li role="presentation"><a href="${SITE_URL}/dashboard/list" >Messages <span class="badge" >
              ${i=i+1}
           
             
  </span></a></li>
  
 
      <li role="presentation" class="pull-right"><a href="${SITE_URL}/dashboard/admin/">ADMIN <span class="glyphicon glyphicon-user"></span></a></li>
      <li role="presentation" class="pull-right"><a href="${SITE_URL}/dashboard/admin/logout">Logout <span class="glyphicon glyphicon-log-out"></span></a></li>

    
    
    </ul>
    
    
   
    
</nav>

       
       