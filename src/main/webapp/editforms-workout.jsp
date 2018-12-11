<%@include file="head-registereduser.jsp"%>
<div id="mainBody">
	<div class="container">
	<div class="row">

	<div class="span12">
    <ul class="breadcrumb">
		<li><a href="user.jsp">Admin</a> <span class="divider">/</span></li>
		<li class="active">Edit User</li>
    </ul>


		<%@page import="matc.persistence.Dao,matc.entity.Workout"%>

			<%
			Dao workoutDao = new Dao(Workout.class);
			String id=request.getParameter("id");
			Workout workout = (Workout)workoutDao.getById(id);
			%>

		<h1>Edit Form</h1>
		<form action="editWorkout" method="post">
			<input type="hidden" name="id" value="<%=workout.getId() %>"/>
			<table>
				<tr><td>Date Created:</td><td>
					<input type="Date" name="dateCreated" value="<%= workout.getDateCreated().toString()%>"/></td></tr>
				<tr><td>Date Modified:</td><td>
					<input type="Date" name="dateModified" value="<%= workout.getDateModified().toString()%>"/></td></tr>
				<tr><td>Workout:</td><td>
					<input type="text" name="workout" value="<%= workout.getWorkout()%>" required="required"/></td></tr>
				<tr><td>Mileage:</td><td>
					<input type="number" name="mileage" value="<%= workout.getMileage()%>"/></td></tr>

				<tr><td colspan="2"><input type="submit" value="Save"/></td></tr>
			</table>
		</form>

	<hr class="soft"/>


		</div>
		</div>
	</div>

</div>
<!-- MainBody End ============================= -->
<%@include file="footer.jsp"%>