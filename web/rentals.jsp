<%@ taglib prefix="s" uri="/struts-tags" %>
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
    <title></title>
      <link href="style.css" rel="stylesheet" type="text/css">
      <script language="JavaScript">

          function rentalsByCustomerId(customerId){
              var mf=document.getElementById("mainform");
              mf.action="rentals.action";
              document.getElementById("cid").value=customerId;
              mf.submit();
          }
          function actorsByFilmId(filmId){
              var mf=document.getElementById("mainform");
              mf.action="actors.action";
              document.getElementById("fid").value=filmId;
              mf.submit();
          }
      </script>
  </head>
  <body>
  <form id="mainform" action="" method="post">
      <input id="fid" name="filmId" type="hidden" value="">
      <input id="cid" name="customerId" type="hidden" value="">
  </form>

<%@include file="header.jsp"%>

  <div id="mainList">
          <table>
              <tr>
              <td colspan="6" id ="listTitle">
                  This is a list of <s:property value="rentals.size"/> rentals<br>
                  <s:if test="%{customerId != 0}">
                      <img src="images/filter.jpg" title="filtered by customer" style="position:relative;top:6px" />
                      <s:property value="customerId" />
                  </s:if>
                  <s:if test="%{filmId != 0}">
                      <img src="images/filter.jpg" title="filtered by film" style="position:relative;top:6px" /> <s:property value="film.title" />
                  </s:if>
              </td>
              <tr>
                  <th>id</th>
                  <th>date</th>
                  <th>customer</th>
                  <th>related rentals</th>
                  <th>film</th>
                  <th>related actors</th>
              </tr>

              <s:iterator var="i" step="1" value="rentals" status="status">
                  <tr>
                  <td><s:property value="rentalId" /></td>
                  <td><s:property value="rentalDate" /></td>
                  <td><s:property value="customer.firstName" /> <s:property value="customer.lastName" /></td>
                  <td><a href="javascript:rentalsByCustomerId('<s:property value="customer.customerId"/>')">rentals</a></td>
                  <td><s:property value="film.title" /></td>
                  <td><a href="javascript:actorsByFilmId('<s:property value="filmId"/>')">actors</a></td>
                  </tr>
              </s:iterator>
          </table>
  </div>


  </body>
</html>