
<%@include file="head-administration.jsp"%>
<div id="mainBody">
	<div class="container">
		<div class="row">

			<div class="span12">
				<ul class="breadcrumb">
					<li><a href="my-workouts.jsp">Home</a> <span class="divider">/</span></li>
					<li class="active">Search Nearby Swimmers</li>
				</ul>


				<h1>Search for Nearby Swimmers</h1>
				<form action="searchAddress" method="post">
					<div class="control-group">
						<label class="control-label" for="searchTerm">Search by City</label>
						<div class="controls">
							<input class="span3"  type="text" id="searchTerm" name="searchTerm" placeholder="City">
						</div>
					</div>
					<button type="submit" name ="submit" value="search">Search</button>
					<button type="submit" name="submit" value="viewAll">View All</button>
				</form>

				<hr class="soft"/>


			</div>
		</div>
	</div>

</div>
<!-- MainBody End ============================= -->
<%@include file="footer.jsp"%>


