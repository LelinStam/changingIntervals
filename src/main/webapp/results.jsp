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
	Dao locationDao = new Dao(Location.class);
	List<Location> list = locationDao.getAll();
	request.setAttribute("addresses", list);

%>

	<div class="page-header">
		<h3>All Swimmers </h3>
	</div>
	<table id="addressTable" style="margin:20px;" class="table table-bordered table-striped">
		<thead>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Street Address</th>
			<th>City</th>
			<th>State & Zip</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="address" items="${addresses}">
			<tr>
				<td>${address.user.userName} </td>
				<td>${address.user.email}</td>
				<td>${address.streetAddress}</td>
				<td>${address.city}</td>
				<td>${address.state} ${address.zip}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

<%@include file="footer.jsp"%>