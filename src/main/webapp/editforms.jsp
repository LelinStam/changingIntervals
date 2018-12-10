<%@include file="head-administration.jsp"%>
<div id="mainBody">
	<div class="container">
	<div class="row">

	<div class="span12">
    <ul class="breadcrumb">
		<li><a href="user.jsp">Admin</a> <span class="divider">/</span></li>
		<li class="active">Edit User</li>
    </ul>


		<%@page import="matc.persistence.Dao,matc.entity.User"%>

			<%
			Dao userDao = new Dao(User.class);
			String id=request.getParameter("id");
			User user = (User)userDao.getById(id);
			%>

		<h1>Edit Form</h1>
		<form action="editUser" method="post">
			<input type="hidden" name="id" value="<%=user.getId() %>"/>
			<table>
				<tr><td>First Name:</td><td>
					<input type="text" name="firstName" value="<%= user.getFirstName()%>" /></td></tr>
				<tr><td>Last Name:</td><td>
					<input type="text" name="lastName" value="<%= user.getLastName()%>" /></td></tr>
				<tr><td>Username:</td><td>
					<input type="text" name="userName" value="<%= user.getUserName()%>" required="required"/></td></tr>
				<tr><td>Password:</td><td>
					<input type="password" name="password" value="<%= user.getPassword()%>" required="required"/></td></tr>
				<tr><td>Date of Birth:</td><td>
					<input type="Date" name="dateOfBirth" value="<%= user.getDateOfBirth().toString()%>"/></td></tr>

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