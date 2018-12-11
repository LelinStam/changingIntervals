<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@include file="head-registereduser.jsp"%>
<%@page import="matc.entity.Workout, matc.persistence.Dao"%>
<%@ page import="java.util.List" %>
<%@ page import="matc.entity.User" %>


<script type="text/javascript" class="init">

    $(document).ready(function() {
        $('#workoutResults').DataTable();
    });
</script>

<%
	Dao workoutDao = new Dao(Workout.class);

	request.setAttribute("workouts", workoutDao.getAll());
%>

	<div class="page-header">
		<h3>All Workouts </h3>
	</div>
	<table id="workoutResults" style="margin:20px;" class="table table-bordered table-striped">
		<thead>
		<tr>
			<th>Date Created</th>
			<th>Date Modified</th>
			<th>Workout</th>
			<th>Mileage</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="workout" items="${workouts}">
			<tr>
				<td>${workout.dateCreated} </td>
				<td>${workout.dateModified}</td>
				<td>${workout.workout}</td>
				<td>${workout.mileage}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

<%@include file="footer.jsp"%>