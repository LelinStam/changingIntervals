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
	Dao userDao = new Dao(User.class);
	String username = request.getUserPrincipal().getName();

	// find user by session
	List<User> users = userDao.getByPropertyEqual("userName", username);
	User user = users.get(0);
	request.setAttribute("workouts", user.getWorkouts());
%>

	<div class="page-header">
		<h3>My Workouts </h3>
	</div>
	<table id="workoutResults" style="margin:20px;" class="table table-bordered table-striped">
		<thead>
		<tr>
			<th>Date Created</th>
			<th>Date Modified</th>
			<th>Workout</th>
			<th>Mileage</th>
            <th>Delete/ Edit</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="workout" items="${workouts}">
			<tr>
				<td>${workout.dateCreated} </td>
				<td>${workout.dateModified}</td>
				<td>${workout.workout}</td>
				<td>${workout.mileage}</td>
                <td><a href="delete-workout.jsp?id=${workout.id}">Delete</a> /
                <a href="editforms-workout.jsp?id=${workout.id}">Edit</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

<%@include file="footer.jsp"%>