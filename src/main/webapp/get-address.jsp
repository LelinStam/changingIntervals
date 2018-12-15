<%@include file="head-registereduser.jsp"%>
<%@page import="matc.entity.User"%>
<%@ page import="matc.persistence.Dao" %>

<%
    Dao userDao = new Dao(User.class);
    String id=request.getParameter("id");
    User user = (User)userDao.getById(id);
    request.setAttribute("address", user.getLocation());
%>

<div id="mainBody">
	<div class="container">
		<div class="row">

			<div class="span12">
				<ul class="breadcrumb">
					<li><a href="my-workouts.jsp">Home</a> <span class="divider">/</span></li>
					<li class="active">Address Display</li>
				</ul>

				<h1>Address Display</h1>
				<p>${user} ${address.streetAddress}</p>
				<p>${address.city}, ${address.state} ${address.zip} ${address.toString()}</p>

	<hr class="soft"/>


		</div>
		</div>
	</div>

</div>
<!-- MainBody End ============================= -->
<%@include file="footer.jsp"%>