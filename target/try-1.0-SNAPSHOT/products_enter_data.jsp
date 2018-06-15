<%--
  Created by IntelliJ IDEA.
  User: Dianochka
  Date: 13.04.2018
  Time: 19:30
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
    <form action="/Products" method="get">
        <input type="text" placeholder="Продукт" name="prod_name"/>
        <input type="text" placeholder="Количество" name="user_amount"/>
        <input type="submit" value="Add product"/>
    </form>
</body>
</html>
