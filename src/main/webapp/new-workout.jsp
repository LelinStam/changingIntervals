<%@include file="head-registereduser.jsp"%>
<div id="mainBody">
	<div class="container">
	<div class="row">

	<div class="span12">
    <ul class="breadcrumb">
		<li><a href="my-workouts.jsp">Home</a> <span class="divider">/</span></li>
		<li class="active">New Workout</li>
    </ul>
		<h3> New Workout </h3>
		<p class="message">${message}</p>
		<c:remove var="message" />
		<p>Please fill out the form to create your new workout</p>
		<form action="addWorkout" method="post">
			<div class="control-group">
				<label class="control-label" for="workout">Workout</label>
				<div class="controls">
					<input class="span3"  type="text" id="workout" name="workout" placeholder="Workout" required="required">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="mileage">Total Mileage</label>
				<div class="controls">
					<input type="text" class="span3"  id="mileage" name="mileage" placeholder="Mileage" required="required">
				</div>
			</div>


			<div class="control-group">
				<div class="controls">
					<button type="submit" name="submit" value="submit" class="btn">Submit</button>
				</div>
			</div>
        </form>
</div>	
</div>
</div>
</div>
<!-- MainBody End ============================= -->
<%@include file="footer.jsp"%>
