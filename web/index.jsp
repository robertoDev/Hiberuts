<%--
  Created by IntelliJ IDEA.
  User: homeuser
  Date: 11/10/13
  Time: 15.16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
      <link href="style.css" rel="stylesheet" type="text/css">
      <script type="text/javascript">
          function go(){
              location.href="init.action";
          }
      </script>
    <title>Hiberuts - info</title>
  </head>
  <body onload="go()">
  <%@include file="header.jsp"%>
    <br/>
  <div class="loadingDiv">
      Initializing Hibernate EntityManagerFactory<br><br> <img src="images/loading.gif" />
  </div>

  <br/>
  </body>
</html>