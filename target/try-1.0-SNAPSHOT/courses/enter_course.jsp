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
<form action="/Courses" method="post">
    <select class="selectpicker" name="selected_course" required>
        <c:forEach items="${courses}" var="course">
            <option value = "${course}">${course}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Enter course"/>
</form>
</body>
</html>