<%@include file="head-registereduser.jsp"%>


<div id="mainBody">
	<div class="container">
	<div class="row">

	<div class="span12">
    <ul class="breadcrumb">
		<li><a href="my-workouts.jsp">Home</a> <span class="divider">/</span></li>
		<li class="active">New Address</li>
    </ul>
		<h3> New Address </h3>
		<p class="message">${message}</p>
		<c:remove var="message" />
		<p>Please fill out the form to create your new address</p>
		<form action="verifyAddress" method="post">
			<div class="form-group col-sm-12">
				<label for="streetAddress">*Street Address:</label>
				<input type="text" class="text form-control" id="streetAddress" name="streetAddress" required="required" />
			</div>
			<div class="form-group col-sm-4">
				<label for="city">*City:</label>
				<input type="text" class="text form-control" id="city" name="city" required="required" />
			</div>
			<div class="form-group col-sm-4">
				<label for="state">*State:</label>
				<select name="state" id="state" class="select">
					<option value="none">Select State</option>
					<option value="Alabama">Alabama</option>
					<option value="Alaska">Alaska</option>
					<option value="Arizona">Arizona</option>
					<option value="Arkansas">Arkansas</option>
					<option value="California">California</option>
					<option value="Colorado">Colorado</option>
					<option value="Connecticut">Connecticut</option>
					<option value="Delaware">Delaware</option>
					<option value="Florida">Florida</option>
					<option value="Georgia">Georgia</option>
					<option value="Hawaii">Hawaii</option>
					<option value="Idaho">Idaho</option>
					<option value="Illinois">Illinois</option>
					<option value="Indiana">Indiana</option>
					<option value="Iowa">Iowa</option>
					<option value="Kansas">Kansas</option>
					<option value="Kentucky">Kentucky</option>
					<option value="Louisiana">Louisiana</option>
					<option value="Maine">Maine</option>
					<option value="Maryland">Maryland</option>
					<option value="Massachusetts">Massachusetts</option>
					<option value="Michigan">Michigan</option>
					<option value="Minnesota">Minnesota</option>
					<option value="Mississippi">Mississippi</option>
					<option value="Missouri">Missouri</option>
					<option value="Montana">Montana</option>
					<option value="Nebraska">Nebraska</option>
					<option value="Nevada">Nevada</option>
					<option value="New Hampshire">New Hampshire</option>
					<option value="New Jersey">New Jersey</option>
					<option value="New Mexico">New Mexico</option>
					<option value="New York">New York</option>
					<option value="North Carolina">North Carolina</option>
					<option value="North Dakota">North Dakota</option>
					<option value="Ohio">Ohio</option>
					<option value="Oklahoma">Oklahoma</option>
					<option value="Oregon">Oregon</option>
					<option value="Pennsylvania">Pennsylvania</option>
					<option value="Rhode Island">Rhode Island</option>
					<option value="South Carolina">South Carolina</option>
					<option value="South Dakota">South Dakota</option>
					<option value="Tennessee">Tennessee</option>
					<option value="Texas">Texas</option>
					<option value="Utah">Utah</option>
					<option value="Vermont">Vermont</option>
					<option value="Virginia">Virginia</option>
					<option value="Washington">Washington</option>
					<option value="West Virginia">West Virginia</option>
					<option value="Wisconsin">Wisconsin</option>
					<option value="Wyoming">Wyoming</option>
				</select>
			</div>
			<div class="form-group col-sm-4">
				<label for="zip">*Zip Code:</label>
				<input type="text" class="text form-control" id="zip" name="zip" required="required" />
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
