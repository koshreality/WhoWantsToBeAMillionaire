<%--
  Created by IntelliJ IDEA.
  User: Dianochka
  Date: 13.04.2018
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products confirm</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Add some nice styling and functionality by using Twitter Bootstrap -->
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap-theme.min.css">
    <style>
        body{padding:0 20px;}
    </style>
</head>
<body>
    <form action="/Products" method="post">
        <p>${msg}</p>
        <button class="button" type="submit" name="action" value="save">Save</button>
        <button class="button" type="submit" name="action" value="cancel">Cancel</button>
    </form>
</body>
</html>
