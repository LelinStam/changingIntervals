<%@include file="head-administration.jsp"%>
<div id="mainBody">
	<div class="container">
	<div class="row">

	<div class="span12">
    <ul class="breadcrumb">
		<li><a href="home-page.jsp">Home</a> <span class="divider">/</span></li>
		<li class="active">Login</li>
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

			<div class="form-group col-sm-3">
				<input type="submit" class="button btn-block" name="submit" value="delete" />
			</div>
		</form>
	<hr class="soft"/>

	<div class="row">
		<div class="span4">
			<div class="well">
			<h5>CREATE YOUR ACCOUNT</h5><br/>
			Enter your e-mail address to create an account.<br/><br/><br/>
			<form action="register.html">
			  <div class="control-group">
				<label class="control-label" for="inputEmail0">E-mail address</label>
				<div class="controls">
				  <input class="span3"  type="text" id="inputEmail0" placeholder="Email">
				</div>
			  </div>
			  <div class="controls">
			  <button type="submit" class="btn block">Create Your Account</button>
			  </div>
			</form>
		</div>
		</div>
		<div class="span1"> &nbsp;</div>
		<div class="span4">
			<div class="well">
			<h5>ALREADY REGISTERED ?</h5>
			<form>
			  <div class="control-group">
				<label class="control-label" for="inputEmail1">Email</label>
				<div class="controls">
				  <input class="span3"  type="text" id="inputEmail1" placeholder="Email">
				</div>
			  </div>
			  <div class="control-group">
				<label class="control-label" for="inputPassword1">Password</label>
				<div class="controls">
				  <input type="password" class="span3"  id="inputPassword1" placeholder="Password">
				</div>
			  </div>
			  <div class="control-group">
				<div class="controls">
				  <button type="submit" class="btn">Sign in</button> <a href="forgetpass.html">Forget password?</a>
				</div>
			  </div>
			</form>
		</div>
		</div>
	</div>

</div>
</div></div>
</div>
<!-- MainBody End ============================= -->
<%@include file="footer.jsp"%>