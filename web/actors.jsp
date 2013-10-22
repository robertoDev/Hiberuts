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
          function filmsByActorId(actorId){
              var mf=document.getElementById("mainform");
              document.getElementById("aid").value=actorId;
              mf.submit();
          }
      </script>
  </head>


  <body>
  <form id="mainform" action="films.action" method="post">
      <input id="aid" name="actorId" type="hidden" value="">
  </form>

  <%@include file="header.jsp"%>

  <div id="mainList">
          <table>
              <tr>
              <td colspan=4 id ="listTitle">
                  This is a list of <s:property value="actors.size"/> actors<br>
                  <s:if test="%{filmId != 0}">
                      <img src="images/filter.jpg" title="filtered by film" style="position:relative;top:6px" /> <s:property value="film.title" />
                  </s:if>
              </td>
              <tr>
                  <th>id</th>
                  <th>first name</th>
                  <th>last name</th>
                  <th>related films</th>
              </tr>


          <s:iterator var="i" step="1" value="actors" status="status">
              <tr>
              <td><s:property value="actorId" /></td>
              <td><s:property value="firstName" /></td>
              <td><s:property value="lastName" /></td>
              <td><a href="javascript:filmsByActorId('<s:property value="actorId"/>')">films</a></td>
              </tr>
          </s:iterator>
          </table>
  </div>

  <!--
  <div id="header"><table width="100%"><tr>

      <td width="10px">
          <img class="imgstyle2" src="images/actors.jpg"/>
      </td>
      <td>
          <span class="text1">  Hiberuts</span><br>
          Hiberuts is a simple demo application that show integration for Hibernate Struts2 MySql and Google App Engine.<br>
          <br>&copy; by Blackcat 2013. <a href> More info</a>
      </td>
  </tr></table></div>

  <div class="listTitle">
      <s:property value="actors.size"/> actors
      <s:if test="%{filmId != 0}">
          in the cast of <s:property value="film.title" />
      </s:if>
      :
  </div>


  <div class="listDiv">
    <table>
        <tr>
            <th>idx</th>
            <th>first name</th>
            <th>last name</th>
            <th>related films</th>
        </tr>


    <s:iterator var="i" step="1" value="actors" status="status">
        <tr>
        <td><s:property value="actorId" /></td>
        <td><s:property value="firstName" /></td>
        <td><s:property value="lastName" /></td>
        <td><a href="javascript:filmsByActorId('<s:property value="actorId"/>')">films</a></td>
        </tr>
    </s:iterator>
    </table>
  </div>


  <br>
  <a href="main"> main</a>
-->
  </body>
</html>