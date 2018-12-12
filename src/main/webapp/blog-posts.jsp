
<%@include file="head-registereduser.jsp" %>
<%@ page import="matc.entity.Blog, matc.persistence.Dao" %>
<%@ page import="java.util.List" %>

<%
	Dao userDao = new Dao(Blog.class);
	List<Blog> blogs = userDao.getAll();
	request.setAttribute("blogs", blogs);
%>

<div id="mainBody">
		<div class="container">
		<div class="row">

			<div class="span12">
			<ul class="breadcrumb">
				<li><a href="my-workouts.jsp">Home</a> <span class="divider">/</span></li>
				<li class="active">Blog</li>
			</ul>

			<h1>Swim Training Pal Blog</h1>
			<p class="message">${message}</p>
			<c:remove var="message" />
			<p>Please Enter your blog post below</p>
			<form action="postBlog" method="post">
				<div class="form-group col-sm-12">
					<label for="title">*Title:</label>
					<input type="text" class="text form-control" id="title" name="title" required="required" />
				</div>
				<div class="form-group col-sm-12">
					<label for="blog">*Blog:</label>
					<textarea class="text form-control" id="blog" name="blog" required="required" ></textarea>
				</div>
				<div class="control-group">
					<div class="controls">
						<button type="submit" name="submit" value="submit" class="btn">Submit</button>
					</div>
				</div>
			</form>
			<c:forEach var="blog" items="${blogs}">
			<hr class="soft"/>
			<h5>${blog.title}</h5><br/>
			<p>
				${blog.blog}
			</p>

			</c:forEach>
		</div>
	</div>
	</div>
</div>
<!-- MainBody End ============================= -->
<%@include file="footer.jsp" %>