<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@include file="head.jsp"%>
<div id="mainBody">
    <div class="container">
        <div class="row">

            <div class="span12">
                <ul class="breadcrumb">
                    <li><a href="my-workouts.jsp">Home</a> <span class="divider">/</span></li>
                    <li class="active">Sign Up</li>
                </ul>
                <p class="message">${message}</p>
                <c:remove var="message" />
                <div class="row">
                    <div class="span4">
                        <div class="well">
                            <h5>CREATE YOUR ACCOUNT</h5><br/>
                            <form id="signUpForm" action="addUser" method="post">
                                <div class="control-group">
                                    <label class="control-label" for="username">Username</label>
                                    <div class="controls">
                                        <input class="span3" type="text" id="username" name="username" placeholder="username" required="required">
                                    </div>
                                    <label class="control-label" for="password">Password</label>
                                    <div class="controls">
                                        <input class="span3"  type="password" id="password" name="password" placeholder="password" required="required">
                                    </div>
                                    <label class="control-label" for="confirmPassword">Confirm Password</label>
                                    <div class="controls">
                                        <input class="span3"  type="password" id="confirmPassword" name="confirmPassword" placeholder="confirmPassword" required="required">
                                    </div>
                                    <label class="control-label" for="firstName">First Name</label>
                                    <div class="controls">
                                        <input class="span3"  type="text" id="firstName" name="firstName" placeholder="firstName" required="required">
                                    </div>
                                    <label class="control-label" for="lastName">Last Name</label>
                                    <div class="controls">
                                        <input class="span3"  type="text" id="lastName" name="lastName" placeholder="lastName" required="required">
                                    </div>
                                    <label class="control-label" for="email">Email</label>
                                    <div class="controls">
                                        <input class="span3"  type="text" id="email" name="email" placeholder="email" required="required">
                                    </div>
                                    <label class="control-label" for="dateOfBirth">Date of Birth</label>
                                    <div class="controls">
                                        <input class="span3"  type="date" id="dateOfBirth" name="dateOfBirth" placeholder="dateOfBirth" required="required">
                                    </div>
                                </div>
                                <div class="controls">
                                    <button type="submit" name="submit" value="Create Account" class="btn block">Create Account</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<%@include file="footer.jsp"%>