<%--
  Created by IntelliJ IDEA.
  User: homeuser
  Date: 11/10/13
  Time: 15.16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <link href="style.css" rel="stylesheet" type="text/css">
      <style>
          #maintable{
              width:100%;
          }
          #maintable TD{
              text-align:center;
              xborder:1px solid red;
          }



      </style>
    <title></title>
  </head>
  <body>
<%@include file="header.jsp"%>
         <table id="maintable">
             <tr>
                 <td>
                     <div  class="main-content">
                         <a href="actors.action">
                         <img class="imgstyle" src="images/actors.jpg"/><br>
                         ACTORS
                         </a>
                     </div>

                 </td>

                 <td>
                     <div  class="main-content">
                         <a href="films.action">
                         <img class="imgstyle"  src="images/films.jpg"/><br>
                         FILMS
                         </a>
                     </div>
                 </td>
                 <td>
                     <div  class="main-content">
                         <a href="rentals.action">
                         <img class="imgstyle"  src="images/rentals.jpg"/><br>
                         RENTALS
                         </a>
                     </div>
                 </td>
             </tr>
         </table>
  </body>
</html>