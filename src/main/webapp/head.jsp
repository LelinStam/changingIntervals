<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Swim Training Pal</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Bootstrap style -->
    <link id="callCss" rel="stylesheet" href="themes/bootshop/bootstrap.min.css" media="screen"/>
    <link href="themes/css/base.css" rel="stylesheet" media="screen"/>
    <!-- Bootstrap style responsive -->
    <link href="themes/css/bootstrap-responsive.min.css" rel="stylesheet"/>
    <link href="themes/css/font-awesome.css" rel="stylesheet" type="text/css">
    <!-- Google-code-prettify -->
    <link href="themes/js/google-code-prettify/prettify.css" rel="stylesheet"/>
    <!-- fav and touch icons -->
    <link rel="shortcut icon" href="themes/images/products/pal.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="themes/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="themes/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="themes/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="themes/images/ico/apple-touch-icon-57-precomposed.png">
    <style type="text/css" id="enject"></style>
</head>
<body>
<div id="header">
    <div class="container">
        <div id="welcomeLine" class="row">
            <div class="span6">Welcome!<strong> User</strong></div>
        </div>
    </div>
    <!-- Navbar ================================================== -->
    <div id="logoArea" class="navbar">
        <a id="smallScreen" data-target="#topMenu" data-toggle="collapse" class="btn btn-navbar">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </a>
        <div class="navbar-inner">
            <a class="brand" href="index.jsp"><img src="themes/images/pal.png" alt="pal" width="50px"/></a>
            <form class="form-inline navbar-search" method="post" action="index.jsp" >
                <input id="srchFld" class="srchTxt" type="text" />
                <select class="srchTxt">
                    <option>All</option>
                    <option>Sprint Workouts </option>
                    <option>Group Workouts </option>
                    <option>Distance Workouts </option>
                    <option>Open Water Workouts </option>
                </select>
                <button type="submit" id="submitButton" class="btn btn-primary">Go</button>
            </form>
            <ul id="topMenu" class="nav pull-right">
                <li class=""><a href="my-workouts.jsp">My Workouts</a></li>
                <li class=""><a href="#">Find a Workout</a></li>
                <li class=""><a href="signup.jsp">Sign Up!</a></li>
                    <a href="login.jsp" role="button" data-toggle="modal" style="padding-right:0"><span class="btn btn-large btn-success">Login</span></a>
                    <div id="login" class="modal hide fade in" tabindex="-1" role="dialog" aria-labelledby="login" aria-hidden="false" >
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h3>Login Block</h3>
                        </div>
                        <div class="modal-body">
                            <form class="form-horizontal loginFrm">
                                <div class="control-group">
                                    <input type="text" id="inputEmail" placeholder="Email">
                                </div>
                                <div class="control-group">
                                    <input type="password" id="inputPassword" placeholder="Password">
                                </div>
                                <div class="control-group">
                                    <label class="checkbox">
                                        <input type="checkbox"> Remember me
                                    </label>
                                </div>
                            </form>
                            <button type="submit" class="btn btn-success">Sign in</button>
                            <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>
</div>
<!-- Header End====================================================================== -->