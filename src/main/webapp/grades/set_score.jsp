<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dianochka
  Date: 16.04.2018
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products data</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Add some nice styling and functionality by using Twitter Bootstrap -->
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap-theme.min.css">
    <style>
        body{padding:0 20px;}
    </style>
</head>
<body>
<form action="/Grades" method="post">
    <select class="selectpicker" name="student" required>
        <c:forEach items="${students}" var="student">
            <option value = "${student}">${student}</option>
        </c:forEach>
    </select>
    <input type="number" name="grade" min="1" max="5" placeholder="Grade (1 to 5)" required>
    <input type="text" name="comment" placeholder="Comment"/>
    <input type="submit" value="Give response"/>
</form>
</body>
</html>