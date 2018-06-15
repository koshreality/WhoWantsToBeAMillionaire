<%--
  Created by IntelliJ IDEA.
  User: Dianochka
  Date: 14.06.2018
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!DOCTYPE html>

<title>Game</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<table>
    <tr>
        <td style="color:Orange;">15</td>
        <td style="color:Orange;"><i class="fa fa-usd" style="font-size:18px"></i>  1 Million</td>
        <td>
            <c:if test="${q_num==14}">
                <i class="fa fa-star" style="font-size:18px"></i>
            </c:if>
        </td>
    </tr>
    <tr>
        <td>14</td>
        <td><i class="fa fa-usd" style="font-size:18px"></i>  500.000</td>
        <td>
            <c:if test="${q_num==13}">
                <i class="fa fa-star" style="font-size:18px"></i>
            </c:if>
        </td>
    </tr>
    <tr>
        <td>13</td>
        <td><i class="fa fa-usd" style="font-size:18px"></i>  250.000</td>
        <td>
            <c:if test="${q_num==12}">
                <i class="fa fa-star" style="font-size:18px"></i>
            </c:if>
        </td>
    </tr>
    <tr>
        <td>12</td>
        <td><i class="fa fa-usd" style="font-size:18px"></i>  125.000</td>
        <td>
            <c:if test="${q_num==11}">
                <i class="fa fa-star" style="font-size:18px"></i>
            </c:if>
        </td>
    </tr>
    <tr>
        <td>11</td>
        <td><i class="fa fa-usd" style="font-size:18px"></i>  64.000</td>
        <td>
            <c:if test="${q_num==10}">
                <i class="fa fa-star" style="font-size:18px"></i>
            </c:if>
        </td>
    </tr>
    <tr>
        <td style="color:Orange;">10</td>
        <td style="color:Orange;"><i class="fa fa-usd" style="font-size:18px"></i>  32.000</td>
        <td>
            <c:if test="${q_num==9}">
                <i class="fa fa-star" style="font-size:18px"></i>
            </c:if>
        </td>
    </tr>
    <tr>
        <td>9</td>
        <td><i class="fa fa-usd" style="font-size:18px"></i>  16.000</td>
        <td>
            <c:if test="${q_num==8}">
                <i class="fa fa-star" style="font-size:18px"></i>
            </c:if>
        </td>
    </tr>
    <tr>
        <td>8</td>
        <td><i class="fa fa-usd" style="font-size:18px"></i>  8.000</td>
        <td>
            <c:if test="${q_num==7}">
                <i class="fa fa-star" style="font-size:18px"></i>
            </c:if>
        </td>
    </tr>
    <tr>
        <td>7</td>
        <td><i class="fa fa-usd" style="font-size:18px"></i>  4.000</td>
        <td>
            <c:if test="${q_num==6}">
                <i class="fa fa-star" style="font-size:18px"></i>
            </c:if>
        </td>
    </tr>
    <tr>
        <td>6</td>
        <td><i class="fa fa-usd" style="font-size:18px"></i>  2.000</td>
        <td>
            <c:if test="${q_num==5}">
                <i class="fa fa-star" style="font-size:18px"></i>
            </c:if>
        </td>
    </tr>
    <tr>
        <td style="color:Orange;">5</td>
        <td style="color:Orange;"><i class="fa fa-usd" style="font-size:18px"></i>  1.000</td>
        <td>
            <c:if test="${q_num==4}">
                <i class="fa fa-star" style="font-size:18px"></i>
            </c:if>
        </td>
    </tr>
    <tr>
        <td>4</td>
        <td><i class="fa fa-usd" style="font-size:18px"></i>  500</td>
        <td>
            <c:if test="${q_num==3}">
                <i class="fa fa-star" style="font-size:18px"></i>
            </c:if>
        </td>
    </tr>
    <tr>
        <td>3</td>
        <td><i class="fa fa-usd" style="font-size:18px"></i>  300</td>
        <td>
            <c:if test="${q_num==2}">
                <i class="fa fa-star" style="font-size:18px"></i>
            </c:if>
        </td>
    </tr>
    <tr>
        <td>2</td>
        <td><i class="fa fa-usd" style="font-size:18px"></i>  200</td>
        <td>
            <c:if test="${q_num==1}">
                <i class="fa fa-star" style="font-size:18px"></i>
            </c:if>
        </td>
    </tr>
    <tr>
        <td style="color:Orange;">1</td>
        <td style="color:Orange;"><i class="fa fa-usd" style="font-size:18px"></i>  100</td>
        <td>
            <c:if test="${q_num==0}">
                <i class="fa fa-star" style="font-size:18px"></i>
            </c:if>
        </td>
    </tr>
</table>

<%--<div class="w3-container">--%>
<title>Game</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<head>
    <script type='text/javascript' src='http://code.jquery.com/jquery.min.js'></script>
    <script type="text/javascript">
        function do_change(count) {
            document.getElementById("nextq").style.display = "block";
            document.getElementById("backg").style.display = "block";
            document.getElementById("friend").setAttribute("class", "help_disabled");
            document.getElementById("help").setAttribute("class", "help_disabled");
            document.getElementById("fifty").setAttribute("class", "help_disabled");
            document.getElementById("friend").setAttribute("disabled", "true");
            document.getElementById("help").setAttribute("disabled", "true");
            document.getElementById("fifty").setAttribute("disabled", "true");
            document.getElementById("friend").style.display = "none";
            document.getElementById("help").style.display = "none";
            document.getElementById("fifty").style.display = "none";
            $("friend").prop("disabled",true);
            $("help").prop("disabled",true);
            $("fifty").prop("disabled",true);
            if (count != 1) document.getElementById("answer1").setAttribute("disabled", "true");
            if (count != 2) document.getElementById("answer2").setAttribute("disabled", "true");
            if (count != 3) document.getElementById("answer3").setAttribute("disabled", "true");
            if (count != 4) document.getElementById("answer4").setAttribute("disabled", "true");
        }
    </script>


<style>
    #nextq {
        display: none;
    }
    table, td, th {
        border: 5px solid #1982a5;
        text-align: center;
        color: #ffffff;
        background-color: #005072;
    }
    table {
        border-collapse: collapse;
        width: 20%;
    }

    th, td {
        padding: 8px;
    }
</style>

<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
    .button {
        background-color: #005072;
        border: none;
        color: white;
        padding: 20px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin: 4px 2px;
        cursor: pointer;
    }
    .help_button {border-radius: 100%;}
</style>
    <title>Test</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Add some nice styling and functionality by using Twitter Bootstrap -->
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/w3css/4/w3.css">
    <link rel="stylesheet" href="test.css">
    <style>
        .btn {
            background-color: #005072;
            border:solid 15px #3BA4C7;
            color: white;
            padding: 5px 5px;
            font-size: 5px;
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
        top: 30%;
        width: 100%;
        text-align: center;
        font-size: 18px;
    }

    .container {
        position: relative;
    }

    .bottomright {
        position: absolute;
        bottom: 8px;
        right: 16px;
        font-size: 18px;
    }
    .center_none{
        bottom: 10px;
        left: 50%;
        font-size: 18px;
        display: none;
    }
    body {
        background-image: url("background.jpg");
    }
    .topcorner{
        position:absolute;
        top:0;
        right:0;
    }
    /*.input-radio{*/
        /*-webkit-border-radius:50px;*/
        /*-moz-border-radius:50px;*/
        /*padding:11px 32px;*/
        /*border:solid 4px #005072;*/
        /*display: inline-block;*/
        /*margin-right: 10px;*/
        /*margin-top: 30px;*/
        /*font:20px Arial, Helvetica, sans-serif;*/
        /*font-weight:bold;*/
        /*color:#E5FFFF;*/
        /*background-color:#3BA4C7;*/
        /*background-image: -moz-linear-gradient(top, #3BA4C7 0%, #1982A5 100%);*/
        /*background-image: -webkit-linear-gradient(top, #3BA4C7 0%, #1982A5 100%);*/
        /*background-image: -o-linear-gradient(top, #3BA4C7 0%, #1982A5 100%);*/
        /*background-image: -ms-linear-gradient(top, #3BA4C7 0% ,#1982A5 100%);*/
        /*filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#1982A5', endColorstr='#1982A5',GradientType=0 );*/
    /*}*/
    /*input[type=radio] {*/
        /*display: none;*/
    /*}*/
    /*input[type=radio] + label {*/
        /*color: White;*/
        /*padding: 20px;*/
        /*border-radius: 40px;*/
        /*border: 1px solid #ddd;*/
    /*}*/
    /*input[type=radio] + label:hover {*/
        /*border: 1px solid #ddd;*/
    /*}*/
    /*input[type=radio][value=false]:checked + label {*/
        /*-webkit-border-radius:50px;*/
        /*-moz-border-radius:50px;*/
        /*padding:11px 32px;*/
        /*border:solid 4px #72060b;*/
        /*display: inline-block;*/
        /*margin-right: 10px;*/
        /*margin-top: 30px;*/
        /*font:20px Arial, Helvetica, sans-serif;*/
        /*font-weight:bold;*/
        /*color:#E5FFFF;*/
        /*background-color: #c72722;*/
        /*background-image: -moz-linear-gradient(top, #c72722 0%, #a52520 100%);*/
        /*background-image: -webkit-linear-gradient(top, #c72722 0%, #a52520 100%);*/
        /*background-image: -o-linear-gradient(top, #c72722 0%, #a52520 100%);*/
        /*background-image: -ms-linear-gradient(top, #c72722 0%, #a52520 100%);*/
        /*background-image: linear-gradient(top, #c72722 0%, #a52520 100%);*/
        /*filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#1982A5', endColorstr='#1982A5',GradientType=0 );*/
    /*}*/
    /*input[type=radio][value=true]:checked + label {*/
        /*-webkit-border-radius:50px;*/
        /*-moz-border-radius:50px;*/
        /*padding:11px 32px;*/
        /*border:solid 4px #08720f;*/
        /*display: inline-block;*/
        /*margin-right: 10px;*/
        /*margin-top: 30px;*/
        /*font:20px Arial, Helvetica, sans-serif;*/
        /*font-weight:bold;*/
        /*color:#E5FFFF;*/
        /*background-color: #47c719;*/
        /*background-image: -moz-linear-gradient(top, #47c719 0%, #19a52a 100%);*/
        /*background-image: -webkit-linear-gradient(top, #47c719 0%, #19a52a 100%);*/
        /*background-image: -o-linear-gradient(top, #47c719 0%, #19a52a 100%);*/
        /*background-image: -ms-linear-gradient(top, #47c719 0%, #19a52a 100%);*/
        /*background-image: linear-gradient(top, #47c719 0%, #19a52a 100%);*/
        /*filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#1982A5', endColorstr='#1982A5',GradientType=0 );*/
    /*}*/

    .input-radio{
    display: inline-block;
    margin-right: 10px;
    margin-top: 30px;
    }
    input[type=radio] {
        display: none;
    }
    input[type=radio] + label {
        color: White;
        padding: 20px;
        border-radius: 40px;
        border: 1px solid #ddd;
    }
    input[type=radio] + label:hover {
        border: 1px solid #ddd;
    }
    input[type=radio][data-color=false]:checked + label {
        border: 1px solid red;
    }
    input[type=radio][data-color=true]:checked + label {
        border: 1px solid green;
    }
</style>

</head>

<body>

<form action="game" method="post">
    <div class="center">
            <%--<h1  style="color:#ffffff;">${question}</h1>--%>
        <p style="color:#ffffff;">${question}</p>
        <br><br>
        <c:set var="count" value="1" scope="page"/>
        <c:forEach items="${answers}" var="answer">
            <c:if test="${count==3}"><br></c:if>
            <div class="input-radio"><input type="radio" id="answer${count}" name="answer" data-color="${answer.correct}" value="${answer.text}" onclick="do_change(${count})"><label for="answer${count}">${answer.text} ${answer.add}</label></div>
            <%--<input value="${answer.text}" onclick="do_change()" class="answer_button" type="radio" name="answer">--%>
            <c:set var="count" value="${count + 1}" scope="page"/>
        </c:forEach>
        <%--<input type="button" value="Abraham Lincoln" onclick="do_change()" class="answer_button" type="radio" name="answer"></input>--%>
        <%--<input type="button" value="George Washington" onclick="do_change()" class="answer_button" type="radio" name="answer"></input>--%>
        <%--<br>--%>
        <%--<input type="button" value="William J. Clinton" onclick="do_change()" class="answer_button" type="radio" name="answer"></input>--%>
        <%--<input type="button" value="Thomas Jefferson" onclick="do_change()" class="answer_button" type="radio" name="answer"></input>--%>
        <div id = "backg" class="center_none">
            <h3 style="color:#ffffff;">${background}</h3>
        </div>
    </div>
    <div class="bottomright">
        <button id="nextq" type="submit" class="btn"><h2><i class="fa fa-arrow-right"></i> Continue </h2></button>
    </div>
</form>

    <%--<div class="bottomright">--%>
        <%--<button class="btn"><h2><i class="fa fa-arrow-right"></i> Next question </h2> </button>--%>
    <%--</div>--%>
    <form action="game" method="post">
        <div class="topcorner">
            <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
            <button style="font-size:30px" type="submit" id="fifty" name="fifty" value="default"
            <c:if test="${fifty==false}">
                class="help_disabled" disabled
            </c:if>
            <c:if test="${fifty==true}">
                class="help_button"
            </c:if>
            >50/50</button>
        </div>
    </form>

    <form action="game" method="post">
        <div class="topcorner">
            <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
            <button style="font-size:30px" type="submit" id="friend" name="friend" value="friend"
            <c:if test="${friend==false}">
                class="help_disabled" disabled
            </c:if>
            <c:if test="${friend==true}">
                class="help_button"
            </c:if>
            ><i class="fa fa-mobile-phone"></i></button>
        </div>
    </form>

    <form action="game" method="post">
        <div class="topcorner">
            <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
            <button style="font-size:30px" type="submit" id="help" name="help" value="help"
            <c:if test="${help==false}">
                class="help_disabled" disabled
            </c:if>
            <c:if test="${help==true}">
                class="help_button"
            </c:if>
            ><i class="fa fa-group"></i></button>
        </div>
    </form>

<form action="game" method="post">
    <div class="topcorner">
        <br><br><br><br>        <br><br><br><br>
        <button style="font-size:35px" class="save_money" type="submit" name="money" value="money"> <i class="fa fa-money"></i></button>
    </div>
</form>

<form action="/logout" method="get">
    <div class="topcorner">
        <br><br><br><br>
        <button style="font-size:35px" class="log_out" type="submit" name="action" value="default"><i class="fa fa-sign-out"></i></button>
    </div>
</form>

<form action="/" method="get">
    <div class="topcorner">
        <button style="font-size:35px" class="log_out" type="submit" name="action" value="default"><i class="fa fa-home"></i></button>
    </div>
</form>

</body>
</html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
