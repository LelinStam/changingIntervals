<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@include file="head-registereduser.jsp"%>
<%@page import="matc.entity.Location, matc.persistence.Dao"%>
<%@ page import="java.util.List" %>
<%@ page import="matc.entity.User" %>


<script type="text/javascript" class="init">

    $(document).ready(function() {
        $('#addressTable').DataTable();
    });
</script>

<%
	Dao userDao = new Dao(User.class);
	List<User> list = userDao.getAll();
	request.setAttribute("users", list);

%>

	<div class="page-header">
		<h3>All Swimmers </h3>
	</div>
	<table id="addressTable" style="margin:20px;" class="table table-bordered table-striped">
		<thead>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Address</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.userName} </td>
				<td>${user.email}</td>
                <td>${user.location.streetAddress}<br> ${user.location.city}, &nbsp ${user.location.state} &nbsp ${user.location.zip}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

<%@include file="footer.jsp"%>