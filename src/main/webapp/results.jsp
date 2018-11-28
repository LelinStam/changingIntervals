<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@include file="head-administration.jsp"%>
<div class="span9">
	<div class="page-header">
		<h3>Search Results </h3>
	</div>
	<table class="table table-bordered table-striped">
		<thead>
		<tr>
			<th>Name</th>
			<th>UserName</th>
			<th>Password</th>
			<th>Age</th>
		</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${user!=null}">
					<tr>
						<td>${user.firstName} ${user.lastName}</td>
						<td>${user.userName}</td>
						<td>${user.password}</td>
						<td>${user.age}</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="user" items="${users}">
						<tr>
							<td>${user.firstName} ${user.lastName}</td>
							<td>${user.userName}</td>
							<td>${user.password}</td>
							<td>${user.age}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>

		</tbody>
	</table>
</div>
<%@include file="footer.jsp"%>