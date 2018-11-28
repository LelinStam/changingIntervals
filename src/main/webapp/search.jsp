<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@include file="head.jsp"%>

        <p>View all users or search for user by ID</p>
        <form action="searchUser">
            <input type="text" id="searchTerm" name="searchTerm">

            <button type="submit" name="submit" value="search">Search</button>
            <button type="submit" name="submit" value="viewAll">View All</button>
        </form>

<%@include file="footer.jsp"%>