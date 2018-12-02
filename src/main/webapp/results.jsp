<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@include file="head-administration.jsp"%>

	<div class="page-header">
		<h3>Search Results </h3>
	</div>
	<table style="margin:20px;" class="table table-bordered table-striped">
		<thead>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>UserName</th>
			<th>Password</th>
			<th>Age</th>
		</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${user!=null}">
					<c:set var="id" value="${user.id}"
					<tr>
						<td>${user.id}</td>
						<td>${user.firstName} ${user.lastName}</td>
						<td>${user.userName}</td>
						<td>${user.password}</td>
						<td><c:if test="${user.age eq 0}">
							no data
						</c:if>
							<c:if test="${user.age ne 0}">
								${user.age}
							</c:if></td>
						<a><a href="/deleteUser?id=" + ${user.id} +"</a></td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="user" items="${users}">
						<c:set var="id" value="${user.id}"
						<tr>
							<td>${user.id}</td>
							<td>${user.firstName} ${user.lastName}</td>
							<td>${user.userName}</td>
							<td>${user.password}</td>
							<td><c:if test="${user.age eq 0}">
								no data
							</c:if>
								<c:if test="${user.age ne 0}">
									${user.age}
								</c:if>
							</td>
							<td><a href="/deleteUser?id=" + <c: +"/></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>

		</tbody>
	</table>

<%@include file="footer.jsp"%>