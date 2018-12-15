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
		<li class="active"> Address Confirmation </li>
    </ul>
		<h3> Address Confirmations </h3>
		<p>
			You have successfully added the address below: <br><br></p>
			<form>
		<input type="text" value="<%=address.getComponents().getPrimaryNumber() + " " +address.getComponents().getStreetName()
			+ ' ' + address.getComponents().getStreetSuffix()%>"/>
		<input type="text" value="<%=address.getComponents().getCityName() + " " + address.getComponents().getState()
			+ " " + address.getComponents().getZipCode()%>"/>
			<br><br>
			Click <a href="results.jsp">here</a> for full list of addresses.
		</form>

</div>
</div>
</div>
</div>
<!-- MainBody End ============================= -->
<%@include file="footer.jsp"%>