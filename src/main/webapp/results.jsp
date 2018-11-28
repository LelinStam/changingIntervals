<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@include file="head-administration.jsp"%>

			<h2>Search Results: </h2>
			<table id="userTable">
				<thead>
				<th> Name </th>
				<th> User Name </th>
				<th> Age </th>
				</thead>
				<tbody>
				<c:choose>
					<c:when test="${user!=null}">
						<tr>
							<td>${user.firstName} ${user.lastName}</td>
							<td>${user.userName}</td>
							<td>${user.age}</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="user" items="${users}">
							<tr>
								<td>${user.firstName} ${user.lastName}</td>
								<td>${user.userName}</td>
								<td>${user.age}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>

				</tbody>
			</table>
<%@include file="footer.jsp"%>