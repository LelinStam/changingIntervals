<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@include file="head.jsp"%>
<body>
	<div class="content-w3ls">
		<div class="left-grid">
			<header>
				<h1 class="Flick-grid">
					<a href="#">Flick</a>
				</h1>
				<ul class="nav">
					<li>
						<a href="#">home</a>
					</li>
					<li>
						<a href="#">about</a>
					</li>
					<li>
						<a href="#">contact</a>
					</li>
				</ul>
			</header>
			<h2>Search Results: </h2>
			<table id="userTable">
				<thead>
				<th> Name </th>
				<th> User Name </th>
				<th> Age </th>
				</thead>
				<tbody>
				<c:forEach var="user" items="${users}">
					<tr>
						<td>${user.firstName} ${user.lastName}</td>
						<td>${user.userName}</td>
						<td>${user.age}</td>
						<td>
						<c:forEach var="workout" items="${user.workouts}">
							${workout.workout} ${workout.id} <br />
						</c:forEach>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<div class="sub-grid">
				<h2>lets stay in touch</h2>
				<p>Join us for FREE to get instant email updates!</p>
				<div class="subscribe-w3ls">
					<form action="#" method="post">
						<div class="form-group1">
							<input type="email" id="" name="email" placeholder="Enter Your Email Address" required>
						</div>
						<div class="form-group2">
							<button type="submit" class="btn btn-outline btn-lg">
								<i class="fa fa-paper-plane" aria-hidden="true"></i>
							</button>
						</div>
						<div class="clear"></div>
					</form>
				</div>
				<ul class="social-icons3">

					<li>
						<a href="#" class="s-iconfacebook">
							<span class="fa fa-facebook" aria-hidden="true"></span>
						</a>
					</li>
					<li>
						<a href="#" class="s-icontwitter">
							<span class="fa fa-twitter" aria-hidden="true"></span>
						</a>
					</li>
					<li>
						<a href="#" class="s-icondribbble">
							<span class="fa fa-dribbble" aria-hidden="true"></span>
						</a>
					</li>
					<li>
						<a href="#" class="s-iconbehance">
							<span class="fa fa-behance" aria-hidden="true"></span>
						</a>
					</li>
				</ul>
				<div class="agileits-w3layouts-copyright">
					<p class="w3ls-copyright">© 2018 &nbsp;Flick. All rights reserved | Design by
						<a href="//w3layouts.com/">W3layouts</a>
					</p>
				</div>
			</div>
		</div>
		<div class="right-grid">
		</div>
	</div>

</body>

</html>