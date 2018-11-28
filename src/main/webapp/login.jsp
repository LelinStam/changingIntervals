<%@include file="head.jsp"%>
<div id="mainBody">
	<div class="container">
	<div class="row">

	<div class="span12">
    <ul class="breadcrumb">
		<li><a href="home-page.jsp">Home</a> <span class="divider">/</span></li>
		<li class="active">Sign Up</li>
    </ul>
		<p class="message">${message}</p>
		<c:remove var="message" />
		<div class="span1"> &nbsp;</div>
		<div class="span4">
			<div class="well">
				<h5>LOG IN</h5>
				<form ACTION="j_security_check" METHOD="POST">
					<div class="control-group">
						<label class="control-label" for="username">Username</label>
						<div class="controls">
							<input class="span3"  type="text" id="username" name="j_username" placeholder="username">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputPassword1">Password</label>
						<div class="controls">
							<input type="password" class="span3"  id="inputPassword1" name="j_password" placeholder="Password">
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<button type="submit" value="Log In" class="btn">Sign in</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
</div>
</div>
<!-- MainBody End ============================= -->
<%@include file="footer.jsp"%>