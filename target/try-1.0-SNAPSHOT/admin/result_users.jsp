<%--
  Created by IntelliJ IDEA.
  User: Dianochka
  Date: 13.04.2018
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users set</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Add some nice styling and functionality by using Twitter Bootstrap -->
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap-theme.min.css">
    <style>
        body{padding:0 20px;}
    </style>
</head>
<body>
<table class="table">
    <thead class="thead-inverse">
    <tr>
        <th>Username</th>
        <th>Password</th>
        <th>Active</th>
        <th>Change status</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td>${user.active}</td>
            <td>
                <form action="ChangeActive" method="post">
                    <c:if test="${user.active == true}">
                        <button type="submit" name="username" value="${user.name}">Ban</button>
                    </c:if>
                    <c:if test="${user.active == false}">
                        <button type="submit" name="username" value="${user.name}">Unban</button>
                    </c:if>
                </form>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>

<p><a href="index.jsp">Back</a></p>
<p><a href="/">Home</a></p>
</body>
</html>
