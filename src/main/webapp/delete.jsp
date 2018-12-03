<%@include file="head-administration.jsp"%>

<%@page import="matc.persistence.Dao,matc.entity.User"%>
<jsp:useBean id="user" class="matc.entity.User"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>
<%
	Dao userDao = new Dao(User.class);
	userDao.delete(user);
	response.sendRedirect("user.jsp");
%>
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