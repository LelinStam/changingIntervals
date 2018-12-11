<%@include file="head-registereduser.jsp"%>
<%@ page import="com.smartystreets.api.us_street.Candidate" %>
<%
	Candidate address = (Candidate)request.getAttribute("address");
%>

<div id="mainBody">
	<div class="container">
	<div class="row">

	<div class="span12">
    <ul class="breadcrumb">
		<li><a href="my-workouts.jsp">Home</a> <span class="divider">/</span></li>
		<li class="active">New Address</li>
    </ul>
		<h3> New Address </h3>
		<p class="message">${message}</p>
		<c:remove var="message" />
		<form action="addAddress" method="post">
			<div class="form-group col-sm-12">
				<label for="streetAddress">*Street Address:</label>
				<input type="text" class="text form-control" id="streetAddress" name="streetAddress"
					   value="<%=address.getComponents().getStreetPostdirection()%>" required="required" />
			</div>
			<div class="form-group col-sm-4">
				<label for="city">*City:</label>
				<input type="text" class="text form-control" id="city" name="city"
					   value="<%=address.getComponents().getCityName()%>" required="required" />
			</div>
			<div class="form-group col-sm-4">
				<label for="state">*State:</label>
				<select name="state" id="state" value="<%=address.getComponents().getState()%>" class="select">
					<option value="none">Select State</option>
					<option value="Alabama">Alabama</option>
					<option value="Alaska">Alaska</option>
					<option value="Arizona">Arizona</option>
					<option value="Arkansas">Arkansas</option>
					<option value="California">California</option>
					<option value="Colorado">Colorado</option>
					<option value="Connecticut">Connecticut</option>
					<option value="Delaware">Delaware</option>
					<option value="Florida">Florida</option>
					<option value="Georgia">Georgia</option>
					<option value="Hawaii">Hawaii</option>
					<option value="Idaho">Idaho</option>
					<option value="Illinois">Illinois</option>
					<option value="Indiana">Indiana</option>
					<option value="Iowa">Iowa</option>
					<option value="Kansas">Kansas</option>
					<option value="Kentucky">Kentucky</option>
					<option value="Louisiana">Louisiana</option>
					<option value="Maine">Maine</option>
					<option value="Maryland">Maryland</option>
					<option value="Massachusetts">Massachusetts</option>
					<option value="Michigan">Michigan</option>
					<option value="Minnesota">Minnesota</option>
					<option value="Mississippi">Mississippi</option>
					<option value="Missouri">Missouri</option>
					<option value="Montana">Montana</option>
					<option value="Nebraska">Nebraska</option>
					<option value="Nevada">Nevada</option>
					<option value="New Hampshire">New Hampshire</option>
					<option value="New Jersey">New Jersey</option>
					<option value="New Mexico">New Mexico</option>
					<option value="New York">New York</option>
					<option value="North Carolina">North Carolina</option>
					<option value="North Dakota">North Dakota</option>
					<option value="Ohio">Ohio</option>
					<option value="Oklahoma">Oklahoma</option>
					<option value="Oregon">Oregon</option>
					<option value="Pennsylvania">Pennsylvania</option>
					<option value="Rhode Island">Rhode Island</option>
					<option value="South Carolina">South Carolina</option>
					<option value="South Dakota">South Dakota</option>
					<option value="Tennessee">Tennessee</option>
					<option value="Texas">Texas</option>
					<option value="Utah">Utah</option>
					<option value="Vermont">Vermont</option>
					<option value="Virginia">Virginia</option>
					<option value="Washington">Washington</option>
					<option value="West Virginia">West Virginia</option>
					<option value="Wisconsin">Wisconsin</option>
					<option value="Wyoming">Wyoming</option>
				</select>
			</div>
			<div class="form-group col-sm-4">
				<label for="zip">*Zip Code:</label>
				<input type="text" class="text form-control" id="zip" name="zip"
					   value="<%=address.getComponents().getZipCode()%>" required="required" />
			</div>
			<div class="control-group">
				<div class="controls">
					<button type="submit" name="submit" value="submit" class="btn">Submit</button>
				</div>
			</div>
        </form>
	<hr class="soft"/>
	<form class="form-horizontal span6">
		<div class="control-group">
		  <label class="control-label alignL">Sort By </label>
			<select>
              <option>Workout mileage 1-3</option>
              <option>Workout mileage 3+</option>
            </select>
		</div>
	  </form>

<div id="myTab" class="pull-right">
 <a href="#listView" data-toggle="tab"><span class="btn btn-large"><i class="icon-list"></i></span></a>
 <a href="#blockView" data-toggle="tab"><span class="btn btn-large btn-primary"><i class="icon-th-large"></i></span></a>
</div>
<br class="clr"/>
<div class="tab-content">
	<div class="tab-pane" id="listView">
		<div class="row">
			<div class="span2">
				<img src="" alt=""/>
			</div>
			<div class="span4">
				<h3>New | Available</h3>
				<hr class="soft"/>
				<h5>Product Name </h5>
				<p>
				Nowadays the lingerie industry is one of the most successful business spheres.We always stay in touch with the latest fashion tendencies -
				that is why our goods are so popular..
				</p>
				<a class="btn btn-small pull-right" href="#">View Details</a>
				<br class="clr"/>
			</div>
			<div class="span3 alignR">
			<form class="form-horizontal qtyFrm">
			<h3> $140.00</h3>
			<label class="checkbox">
				<input type="checkbox">  Adds product to compair
			</label><br/>

			  <a href="#" class="btn btn-large btn-primary"> Add to <i class=" icon-shopping-cart"></i></a>
			  <a href="#" class="btn btn-large"><i class="icon-zoom-in"></i></a>

				</form>
			</div>
		</div>
		<hr class="soft"/>
		<div class="row">
			<div class="span2">
				<img src="" alt=""/>
			</div>
			<div class="span4">
				<h3>New | Available</h3>
				<hr class="soft"/>
				<h5>Product Name </h5>
				<p>
				Nowadays the lingerie industry is one of the most successful business spheres.We always stay in touch with the latest fashion tendencies -
				that is why our goods are so popular..
				</p>
				<a class="btn btn-small pull-right" href="#">View Details</a>
				<br class="clr"/>
			</div>
			<div class="span3 alignR">
			<form class="form-horizontal qtyFrm">
				<h3> $140.00</h3>
				<label class="checkbox">
				<input type="checkbox">  Adds product to compair
				</label><br/>

				<a href="#" class="btn btn-large btn-primary"> Add to <i class=" icon-shopping-cart"></i></a>
				<a href="#" class="btn btn-large"><i class="icon-zoom-in"></i></a>

			</form>
			</div>
		</div>
		<hr class="soft"/>
		<div class="row">
			<div class="span2">
				<img src="" alt=""/>
			</div>
			<div class="span4">
				<h3>New | Available</h3>
				<hr class="soft"/>
				<h5>Product Name </h5>
				<p>
				Nowadays the lingerie industry is one of the most successful business spheres.We always stay in touch with the latest fashion tendencies -
				that is why our goods are so popular..
				</p>
				<a class="btn btn-small pull-right" href="#">View Details</a>
				<br class="clr"/>
			</div>
			<div class="span3 alignR">
			<form class="form-horizontal qtyFrm">
				<h3> $140.00</h3>
				<label class="checkbox">
					<input type="checkbox">  Adds product to compair
				</label><br/>

				  <a href="#" class="btn btn-large btn-primary"> Add to <i class=" icon-shopping-cart"></i></a>
				  <a href="#" class="btn btn-large"><i class="icon-zoom-in"></i></a>

			</form>
			</div>
		</div>
		<hr class="soft"/>
		<div class="row">
			<div class="span2">
				<img src="" alt=""/>
			</div>
			<div class="span4">
				<h3>New | Available</h3>
				<hr class="soft"/>
				<h5>Product Name </h5>
				<p>
				Nowadays the lingerie industry is one of the most successful business spheres.We always stay in touch with the latest fashion tendencies -
				that is why our goods are so popular..
				</p>
				<a class="btn btn-small pull-right" href="#">View Details</a>
				<br class="clr"/>
			</div>
			<div class="span3 alignR">
				<form class="form-horizontal qtyFrm">
				<h3> $140.00</h3>
				<label class="checkbox">
				<input type="checkbox">  Adds product to compair
				</label><br/>

				<a href="#" class="btn btn-large btn-primary"> Add to <i class=" icon-shopping-cart"></i></a>
				<a href="#" class="btn btn-large"><i class="icon-zoom-in"></i></a>

				</form>
			</div>
		</div>

		<hr class="soft"/>
		<div class="row">
			<div class="span2">
				<img src="" alt=""/>
			</div>
			<div class="span4">
				<h3>New | Available</h3>
				<hr class="soft"/>
				<h5>Product Name </h5>
				<p>
				Nowadays the lingerie industry is one of the most successful business spheres.We always stay in touch with the latest fashion tendencies -
				that is why our goods are so popular..
				</p>
				<a class="btn btn-small pull-right" href="#">View Details</a>
				<br class="clr"/>
			</div>
			<div class="span3 alignR">
				<form class="form-horizontal qtyFrm">
				<h3> $140.00</h3>
				<label class="checkbox">
				<input type="checkbox">  Adds product to compair
				</label><br/>
				<a href="#" class="btn btn-large btn-primary"> Add to <i class=" icon-shopping-cart"></i></a>
				<a href="#" class="btn btn-large"><i class="icon-zoom-in"></i></a>
				</form>
			</div>
		</div>
		<hr class="soft"/>
		<div class="row">
			<div class="span2">
				<img src="" alt=""/>
			</div>
			<div class="span4">
				<h3>New | Available</h3>
				<hr class="soft"/>
				<h5>Product Name </h5>
				<p>
				Nowadays the lingerie industry is one of the most successful business spheres.We always stay in touch with the latest fashion tendencies -
				that is why our goods are so popular..
				</p>
				<a class="btn btn-small pull-right" href="#">View Details</a>
				<br class="clr"/>
			</div>
			<div class="span3 alignR">
				<form class="form-horizontal qtyFrm">
				<h3> $140.00</h3>
				<label class="checkbox">
				<input type="checkbox">  Adds product to compair
				</label><br/>

				<a href="#" class="btn btn-large btn-primary"> Add to <i class=" icon-shopping-cart"></i></a>
				<a href="#" class="btn btn-large"><i class="icon-zoom-in"></i></a>

				</form>
			</div>
		</div>
		<hr class="soft"/>
	</div>

	<div class="tab-pane  active" id="blockView">
		<ul class="thumbnails">
			<li class="span3">
			  <div class="thumbnail">
				<a href="#"><img src="" alt=""/></a>
				<div class="caption">
				  <h5>Manicure &amp; Pedicure</h5>
				  <p>
					I'm a paragraph. Click here
				  </p>
				   <h4 style="text-align:center"><a class="btn" href="product_details.html"> <i class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i class="icon-shopping-cart"></i></a> <a class="btn btn-primary" href="#">&euro;222.00</a></h4>
				</div>
			  </div>
			</li>
			<li class="span3">
			  <div class="thumbnail">
				<a href="product_details.html"><img src="themes/images/products/3.jpg" alt=""/></a>
				<div class="caption">
				  <h5>Manicure &amp; Pedicure</h5>
				  <p>
					I'm a paragraph. Click here
				  </p>
				   <h4 style="text-align:center"><a class="btn" href="product_details.html"> <i class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i class="icon-shopping-cart"></i></a> <a class="btn btn-primary" href="#">&euro;222.00</a></h4>
				</div>
			  </div>
			</li>
			<li class="span3">
			  <div class="thumbnail">
				<a href="product_details.html"><img src="themes/images/products/3.jpg" alt=""/></a>
				<div class="caption">
				  <h5>Manicure &amp; Pedicure</h5>
				  <p>
					I'm a paragraph. Click here
				  </p>
				    <h4 style="text-align:center"><a class="btn" href="product_details.html"> <i class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i class="icon-shopping-cart"></i></a> <a class="btn btn-primary" href="#">&euro;222.00</a></h4>
				</div>
			  </div>
			</li>
			<li class="span3">
			  <div class="thumbnail">
				<a href="#"><img src="themes/images/products/3.jpg" alt=""/></a>
				<div class="caption">
				  <h5>Manicure &amp; Pedicure</h5>
				  <p>
					I'm a paragraph. Click here
				  </p>
				    <h4 style="text-align:center"><a class="btn" href="#"> <i class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i class="icon-shopping-cart"></i></a> <a class="btn btn-primary" href="#">&euro;222.00</a></h4>
				</div>
			  </div>
			</li>
			<li class="span3">
			  <div class="thumbnail">
				<a href="product_details.html"><img src="themes/images/products/3.jpg" alt=""/></a>
				<div class="caption">
				  <h5>Manicure &amp; Pedicure</h5>
				  <p>
					I'm a paragraph. Click here
				  </p>
				    <h4 style="text-align:center"><a class="btn" href="product_details.html"> <i class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i class="icon-shopping-cart"></i></a> <a class="btn btn-primary" href="#">&euro;222.00</a></h4>
				</div>
			  </div>
			</li>
			<li class="span3">
			  <div class="thumbnail">
				<a href="product_details.html"><img src="themes/images/products/3.jpg" alt=""/></a>
				<div class="caption">
				  <h5>Manicure &amp; Pedicure</h5>
				  <p>
					I'm a paragraph. Click here
				  </p>
				    <h4 style="text-align:center"><a class="btn" href="product_details.html"> <i class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i class="icon-shopping-cart"></i></a> <a class="btn btn-primary" href="#">&euro;222.00</a></h4>
				</div>
			  </div>
			</li>
		  </ul>
	<hr class="soft"/>
	</div>
</div>

	<a href="compair.html" class="btn btn-large pull-right">Compair Product</a>
	<div class="pagination">
			<ul>
			<li><a href="#">&lsaquo;</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">...</a></li>
			<li><a href="#">&rsaquo;</a></li>
			</ul>
			</div>
			<br class="clr"/>
</div>
</div>
</div>
</div>
<!-- MainBody End ============================= -->
<%@include file="footer.jsp"%>