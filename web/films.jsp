<%@ taglib prefix="s" uri="/struts-tags" %>
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
    <title>Hiberuts - films</title>
      <link href="style.css" rel="stylesheet" type="text/css">
      <script language="JavaScript">
          function actorsByFilmId(filmId){
              var mf=document.getElementById("mainform");
              mf.action="actors.action";
              document.getElementById("fid").value=filmId;
              mf.submit();
          }

          function rentalsByFilmId(filmId){
              var mf=document.getElementById("mainform");
              mf.action="rentals.action";
              document.getElementById("fid").value=filmId;
              mf.submit();
          }
      </script>
  </head>
  <body>
  <form id="mainform" action="actors" method="post">
      <input id="fid" name="filmId" type="hidden" value="">
  </form>

<%@include file="header.jsp"%>

  <div id="mainList">
          <table>
              <tr>
              <td colspan="6" id ="listTitle">
                  This is a list of <s:property value="films.size"/> films<br>
                  <s:if test="%{actorId != 0}">
                      <img src="images/filter.jpg" title="filtered by actor" style="position:relative;top:6px" /> <s:property value="actor.firstName" /> <s:property value="actor.lastName" />
                  </s:if>
              </td>
              <tr>
                  <th>id</th>
                  <th>title</th>
                  <th>rating</th>
                  <th>length</th>
                  <th>related actors</th>
                  <th>related rentals</th>
              </tr>

          <s:iterator var="i" step="1" value="films" status="status">
              <tr>
                  <td><s:property value="filmId" /></td>
                  <td><s:property value="title" /></td>
                  <td><s:property value="rating" /></td>
                  <td><s:property value="length" /></td>
                  <td><a href="javascript:actorsByFilmId('<s:property value="filmId"/>')">actors</a></td>
                  <td><a href="javascript:rentalsByFilmId('<s:property value="filmId"/>')">rentals</a></td>
              </tr>
          </s:iterator>
          </table>
  </div>



  </body>
</html>