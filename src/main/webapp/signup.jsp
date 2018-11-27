<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@include file="head.jsp"%>

    <form style="margin:20px;" id="signUpForm" action="addUser" method="post">

        <label>Username:</label>
        <input type="text"  name="username" required="required" />
        <label for="password">*Password:</label>
        <input type="password"  id="password" name="password" />
        <label for="confirmPassword">*Confirm Password:</label>
        <input type="password" id="confirmPassword" name="confirmPassword" />
        <label for="firstName">*First Name:</label>
        <input type="text" id="firstName" name="firstName" required="required" />
        <label for="lastName">*Last Name:</label>
        <input type="text"  id="lastName" name="lastName" required="required" />
        <label for="email">*Email:</label>
        <input type="text" id="email" name="email" required="required" /><br>
        <input type="submit" name="submit" value="Create Account" />

    </form>

<%@include file="footer.jsp"%>