<%--
  Created by IntelliJ IDEA.
  User: lisac
  Date: 10/22/2018
  Time: 7:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="head-registereduser.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>Error</h1>
<p class="message">${message}</p>
<c:remove var="message" />
<p> Sorry, your search terms for your workout were invalid. Please enter a digit <a href="my-workouts.jsp">here</a></p>
<%@include file="footer.jsp"%>
