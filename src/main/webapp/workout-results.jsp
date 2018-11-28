<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@include file="head-registereduser.jsp"%>

	<div class="page-header">
		<h3>Search Results </h3>
	</div>
	<table style="margin:20px;" class="table table-bordered table-striped">
		<thead>
		<tr>
			<th>Date Created</th>
			<th>Date Modified</th>
			<th>Workout</th>
		</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${workout!=null}">
					<tr>
						<td>${workout.dateCreated} </td>
						<td>${workout.dateModified}</td>
						<td>${workout.workout}</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="workout" items="${workouts}">
						<tr>
							<td>${workout.dateCreated} </td>
							<td>${workout.dateModified}</td>
							<td>${workout.workout}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			</tbody>
		</table>

<%@include file="footer.jsp"%>