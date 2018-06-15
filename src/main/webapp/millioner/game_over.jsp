<%--
  Created by IntelliJ IDEA.
  User: Dianochka
  Date: 15.06.2018
  Time: 2:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!DOCTYPE html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<head>
    <title>Game over</title>
</head>
<body>
<title>Game over</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Add some nice styling and functionality by using Twitter Bootstrap -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="/w3css/4/w3.css">
<link rel="stylesheet" href="test.css">
<style>
    body {
        background-image: url("background.jpg");
    }
</style>
<style>
    .container {
        position: relative;
        text-align: center;
        font-size: 100px;
    }
    .center {
        position: absolute;
        left: 0;
        top: 50%;
        width: 100%;
        text-align: center;
        font-size: 25px;
    }

</style>

<div class="container">
    <div class="center"><h1 style="color:#ffffff;"><br><br><br><br><br><br>Game over! You won $${money}!</h1> </div>
</div>

<div>
    <form action="game" method="get">
        <div class="center">
            <button class="try_again" type="submit" name="action" value="turn_down"><h1>Try again</h1></button>
        </div>
    </form>
</div>


</body>
</html>
