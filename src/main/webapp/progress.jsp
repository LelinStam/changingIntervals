<%@include file="head-registereduser.jsp"%>
<div id="mainBody">
	<div class="container">
	<div class="row">

	<div class="span12">
    <ul class="breadcrumb">
		<li><a href="my-workouts.jsp">Home</a> <span class="divider">/</span></li>
		<li class="active">Progress</li>
    </ul>
		<h3> Total Mileage </h3>
		<form action="getGraph" method="get" >
		<div class="control-group">
			<label class="control-label" for="months">Please Enter number of recent months to view</label>
			<div class="controls">
				<select name="months" id="months" class="srchTxt">
					<option value="3">3 months </option>
					<option value="6">6 months</option>
				</select>

			</div>
			<div class="controls">
				<button type="submit" name="submit" value="submit" class="btn">Click here</button>
			</div>
		</div>
	</form>


		${image}
		${message}

	
</div>
</div>
</div>
</div>
<!-- MainBody End ============================= -->
<%@include file="footer.jsp"%>
