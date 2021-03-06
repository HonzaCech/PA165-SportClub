<%@ tag pageEncoding="utf-8" dynamic-attributes="dynattrs" trimDirectiveWhitespaces="true" %>
<%@ attribute name="title" required="false" %>
<%@ attribute name="head" fragment="true" %>
<%@ attribute name="body" fragment="true" required="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="${pageContext.request.locale}">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><c:out value="${title}"/></title>
    <!-- bootstrap loaded from content delivery network -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css"  crossorigin="anonymous">
    <jsp:invoke fragment="head"/>
</head>
<body>
<!-- navigation bar -->
<div class="container">

    <div class="row">
        <div class="pull-right">
            <sec:authorize access="isAuthenticated()">
                <p style="margin: 0 10px 0 0">You are logged in as <b><sec:authentication property="principal.username" /></b></p>
            </sec:authorize>
        </div>
    </div>
<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}"><f:message key="navigation.project"/></a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <sec:authorize access="isAuthenticated()">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><f:message key="navigation.admin"/><b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><my:a href="/coach/list"><f:message key="navigation.admin.coaches"/></my:a></li>
                        <li><my:a href="/team/list"><f:message key="navigation.admin.teams"/></my:a></li>
                        <li><my:a href="/player/list"><f:message key="navigation.admin.players"/></my:a></li>
                    </ul>
                    </sec:authorize>
                </li>
                <li>
                    <sec:authorize access="isAuthenticated()">
                        <form action="${pageContext.request.contextPath}/logout" method="get">
                            <button type="submit" class="btn btn-default navbar-btn">
                                <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
                                Log out
                            </button>
                        </form>
                    </sec:authorize>
                    <sec:authorize access="isAnonymous()">
                        <form action="${pageContext.request.contextPath}/login" method="get">
                            <button type="submit" class="btn btn-default navbar-btn">
                                <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>
                                Log in
                            </button>
                        </form>
                    </sec:authorize>
                </li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<div class="container">

    <!-- page title -->
    <c:if test="${not empty title}">
        <div class="page-header">
            <h1><c:out value="${title}"/></h1>
        </div>
    </c:if>



    <!-- alerts -->
    <c:if test="${not empty alert_danger}">
        <div class="alert alert-danger" role="alert">
            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
            <c:out value="${alert_danger}"/></div>
    </c:if>
    <c:if test="${not empty alert_info}">
        <div class="alert alert-info" role="alert"><c:out value="${alert_info}"/></div>
    </c:if>
    <c:if test="${not empty alert_success}">
        <div class="alert alert-success" role="alert"><c:out value="${alert_success}"/></div>
    </c:if>
    <c:if test="${not empty alert_warning}">
        <div class="alert alert-warning" role="alert"><c:out value="${alert_warning}"/></div>
    </c:if>

    <!-- page body -->
    <jsp:invoke fragment="body"/>

    <!-- footer -->
    <footer class="footer">
        <p>&copy;&nbsp;<%=java.time.Year.now().toString()%>&nbsp;Team Pink</p>
    </footer>
</div>
<!-- javascripts placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
