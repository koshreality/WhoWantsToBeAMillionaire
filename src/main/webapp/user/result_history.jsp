<%--
  Created by IntelliJ IDEA.
  User: Dianochka
  Date: 15-Jun-18
  Time: 1:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<!DOCTYPE html>
<html>
<head>
    <title>Top players</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Add some nice styling and functionality by using Twitter Bootstrap -->
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap-theme.min.css">
    <style>
        body{padding:0 20px;}
    </style>
</head>
<body>
<h2>Top-10 players</h2>
<c:set var="count" value="1" scope="page" />
<table class="table">
    <thead class="thead-inverse">
    <tr>
        <th>#</th>
        <th>Date & time</th>
        <th>Prize</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var = "row" items = "${fgs}">
        <tr>
            <td><c:out value = "${count}"/></td>
            <td><c:out value = "${row.ts}"/></td>
            <td><c:out value = "${row.prize}"/></td>
            <c:set var="count" value="${count + 1}" scope="page"/>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="<c:url value="index.jsp"/>">Back</a></p>
<p><a href="/">Home</a></p>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://code.jquery.com/jquery.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<![endif]-->
</body>
</html>