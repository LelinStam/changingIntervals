<%@include file="head-registereduser.jsp"%>
<%@ page import="com.smartystreets.api.us_street.Candidate" %>
<%
	Candidate address = (Candidate)request.getAttribute("address");
%>

<div id="mainBody">
	<div class="container">
	<div class="row">

	<div class="span12">
    <ul class="breadcrumb">
		<li><a href="my-workouts.jsp">Home</a> <span class="divider">/</span></li>
		<li class="active">New Address</li>
    </ul>
		<h3> New Address </h3>
		<p Address below successfully added! Click <a href="results.jsp"> here </a> to view all.</p>
		<form action="" method="post">
			<div class="form-group col-sm-12">
				<label for="streetAddress">*Street Address:</label>
				<input type="text" class="text form-control" id="streetAddress" name="streetAddress"
					   value="<%=address.getComponents().getPrimaryNumber() + ' ' + address.getComponents().getStreetName()
					   + ' ' +address.getComponents().getStreetSuffix() %>" required="required" />
			</div>
			<div class="form-group col-sm-4">
				<label for="city">*City:</label>
				<input type="text" class="text form-control" id="city" name="city"
					   value="<%=address.getComponents().getCityName() %>" required="required" />
			</div>
			<div class="form-group col-sm-4">
				<label for="state">*State:</label>
				<input type="text" class="text form-control" name="state" id="state" value="<%=address.getComponents().getState()%>" />
					
			</div>
			<div class="form-group col-sm-4">
				<label for="zip">*Zip Code:</label>
				<input type="text" class="text form-control" id="zip" name="zip"
					   value="<%=address.getComponents().getZipCode()%>" required="required" />
			</div>
			
        </form>
	
</div>
</div>
</div>
</div>
<!-- MainBody End ============================= -->
<%@include file="footer.jsp"%>
