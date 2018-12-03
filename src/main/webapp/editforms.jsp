<%@include file="head-administration.jsp"%>
<div id="mainBody">
	<div class="container">
	<div class="row">

	<div class="span12">
    <ul class="breadcrumb">
		<li><a href="home-page-admin.jsp">Admin</a> <span class="divider">/</span></li>
		<li class="active">Delete User</li>
    </ul>
		<!DOCTYPE html>
		<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title>Edit Form</title>
		</head>
		<body>
		<%@page import="matc.persistence.Dao,matc.entity.User"%>

			<%
			Dao userDao = new Dao(User.class);
			String id=request.getParameter("id");
			User user = (User)userDao.getById(id);
			%>

		<h1>Edit Form</h1>
		<form action="edit.jsp" method="post">
			<input type="hidden" name="id" value="<%=user.getId() %>"/>
			<table>
				<tr><td>First Name:</td><td>
					<input type="text" name="firstName" value="<%= user.getFirstName()%>"/></td></tr>
				<tr><td>Last Name:</td><td>
					<input type="text" name="lastName" value="<%= user.getLastName()%>"/></td></tr>
				<tr><td>Username:</td><td>
					<input type="text" name="username" value="<%= user.getUserName()%>"/></td></tr>
				<tr><td>Password:</td><td>
					<input type="password" name="password" value="<%= user.getPassword()%>"/></td></tr>
				<tr><td>Date of Birth:</td><td>
					<input type="Date" name="dateOfBirth" value="<%= user.getDateOfBirth()%>"/></td></tr>
				<tr><td>Role:</td><td>
					<input type="password" name="password" value="<%= user.getRoles()%>"/></td></tr>

				</td></tr>
				<tr><td colspan="2"><input type="submit" value="Edit User"/></td></tr>
			</table>
		</form>
		<h3> Delete a User</h3>
		<p class="message">${message}</p>
		<c:remove var="message" />
		<form style="margin:20px;" id="delete" class="row" action="deleteUser" method="post">
			<div class="form-group col-sm-4">
				<label>*ID:</label>
				<input type="text" class="text form-control" name="id" required="required" />
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