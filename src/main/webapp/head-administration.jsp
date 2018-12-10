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
    <!-- jQuery slim -->
    <script src="https://code.jquery.com/jquery-3.1.1.slim.js" integrity="sha256-5i/mQ300M779N2OVDrl16lbohwXNUdzL/R2aVUXyXWA="   crossorigin="anonymous"></script>
    <!-- The next two items are to support jQuery datatables. Learn more about datatables here:https://datatables.net -->
    <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.13/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.13/js/jquery.dataTables.js"></script>
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
            <div class="span6">Welcome!<strong> Administrator</strong></div>
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
            <a class="brand" href="user.jsp"><img src="themes/images/pal.png" alt="pal" width="50px"/></a>
            <form class="form-inline navbar-search" action="/searchWorkouts" >
                <input id="searchTerm" name="searchTerm" class="srchTxt" type="text" />
                <select name="searchType" class="srchTxt">
                    <option>Workout </option>
                    <option>Date Created </option>
                    <option>Date Modified </option>
                </select>
                <button type="submit" id="submitButton" class="btn btn-primary">Go</button>
            </form>
            <ul id="topMenu" class="nav pull-right">
                <li class=""><a href="user.jsp">Edit Users</a></li>
                    <a href="logout.jsp" role="button" ><span class="btn btn-large btn-success">Logout</span></a>

                </li>
            </ul>
        </div>
    </div>
</div>
</div>
<!-- Header End====================================================================== -->