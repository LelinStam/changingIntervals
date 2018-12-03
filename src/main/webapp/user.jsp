<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@include file="head-administration.jsp"%>
<%@page import="matc.entity.User, matc.persistence.Dao"%>
<%@ page import="java.util.List" %>
<%
	Dao userDao = new Dao(User.class);
	List<User> list = userDao.getAll();
	request.setAttribute("list", list);
%>

<div class="page-header">
		<h3>All Users </h3>
	</div>
	<table style="margin:20px;" class="table table-bordered table-striped">
		<thead>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>UserName</th>
			<th>Password</th>
			<th>Age</th>
			<th>Delete/ Edit</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="user" items="${list}">
			<tr>
				<td>${user.getId()}</td>
				<td>${user.getFirstName()} ${user.getLastName()}</td>
				<td>${user.getUserName()}</td>
				<td>${user.getPassword()}</td>
				<td><c:if test="${(user.getAge()) eq 0}">
					no data
				</c:if>
					<c:if test="${(user.getAge()) ne 0}">
						${user.getAge()}
					</c:if>
				</td>
				<td><a href="delete.jsp?id=${user.id}">Delete</a> /
					<a href="editforms.jsp?id=${user.id}">Edit</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

<%@include file="footer.jsp"%>