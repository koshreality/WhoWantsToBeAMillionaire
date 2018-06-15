<%--
  Created by IntelliJ IDEA.
  User: Dianochka
  Date: 14.06.2018
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">    <title>Test</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/w3css/4/w3.css">
    <link rel="stylesheet" href="test.css">
<style>
    .btn {
        background-color: #005072;
        border:solid 5px #3BA4C7;
        color: white;
        padding: 0px 10px;
        cursor: pointer;
    }
    /* Darker background on mouse-over */
    .btn:hover {
        background-color: #005072;
    }
    .container {
        position: relative;
    }
    .center {
        position: absolute;
        left: 0;
        top: 50%;
        width: 100%;
        text-align: center;
        font-size: 18px;
    }
    body {
        background-image: url("background.jpg");
    }
</style>
<body>

<div class="container">
    <div class="center"><h1 style="color:#ffffff;"><br><br>Welcome to the game <em>"Who wants to be a millionaire?"</em>!</h1> <br><br><h3 style="color:#ffffff;"> Press "Start" to start the game or click "Home" to return to regisrtation-page</h3></div>
</div>


<div>
<form action="game" method="post">
    <div class="center">
    <button class="start_button" type="submit" name="start" value="start"><h1>Start!</h1></button>
    </div>
</form>
</div>
<div class="leftTop">
    <form action="/" method="get">
        <button class="btn"><h1>Home<i class="fa fa-home"></i></h1></button>
    </form>
</div>


</body>
</html>
