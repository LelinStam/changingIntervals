<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@include file="head-administration.jsp"%>
<div id="mainBody">
    <div class="container">
        <div class="row">

            <div class="span12">
                <ul class="breadcrumb">
                    <li><a href="home-page-admin.jsp">Home</a> <span class="divider">/</span></li>
                    <li class="active">Login</li>
                </ul>
                <div class="span1"> &nbsp;</div>
                <div class="span4">
                    <div class="well">
                        <h5>Search User</h5>
                        <p>View all users or search for user by ID</p>
                        <form action="searchUser">
                            <div class="control-group">
                                <div class="controls">
                                    <input class="span3"  type="text" id="searchTerm" name="searchTerm" placeholder="user id">
                                </div>
                            </div>
                            <div class="control-group">
                                <div class="controls">
                                    <button type="submit" name="submit" value="search" class="btn">Search</button>
                                </div>
                            </div>
                            <div class="control-group">
                                <div class="controls">
                                    <button type="submit" name="submit" value="viewAll" class="btn">View All Users</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp"%>