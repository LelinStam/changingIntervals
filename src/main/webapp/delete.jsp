<%@include file="head-administration.jsp"%>
<div id="mainBody">
	<div class="container">
	<div class="row">

	<div class="span12">
    <ul class="breadcrumb">
		<li><a href="home-page-admin.jsp">Admin</a> <span class="divider">/</span></li>
		<li class="active">Delete User</li>
    </ul>
	<h3> Delete a User</h3>
		<p class="message">${message}</p>
		<c:remove var="message" />
		<form style="margin:20px;" id="delete" class="row" action="deleteUser" method="post">
			<div class="form-group col-sm-4">
				<label>*ID:</label>
				<input type="text" class="text form-control" name="id" required="required" />
			</div>
			<div class="form-group col-sm-6">
				<label for="firstName">*First Name:</label>
				<input type="text" class="text form-control" name="firstName" required="required" />
			</div>
			<div class="form-group col-sm-6">
				<label for="lastName">*Last Name:</label>
				<input type="text" class="text form-control" name="lastName" required="required" />
			</div>
			<div class="control-group">
				<div class="controls">
					<button type="submit" name="submit" value="delete" class="btn">Delete</button>
				</div>
			</div>

		</form>
	<hr class="soft"/>


		</div>
		</div>
	</div>

</div>
<!-- MainBody End ============================= -->
<%@include file="footer.jsp"%>