<!DOCTYPE html>
<html>
<head>
    <title>Adding a question</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap-theme.min.css">
    <style>
        body{padding-top:20px;}
    </style>
</head>
<body>
<div class="container">
    <div class="panel-body">
        <form name="newquestionform" action="/admin/AddQuestion" method="POST" accept-charset="UTF-8" role="form">
            <fieldset>
                <div class="form-group">
                    <input class="form-control" min=0 max=4 placeholder="Difficulty" name="difficulty" type="number" required>
                </div>
                <div class="form-group">
                    <%--<input class="form-control" placeholder="Question" name="question" type="text" required>--%>
                    <textarea placeholder="Question" name="question" type="text" rows="10" cols="40" required></textarea>
                </div>
                <div class="form-group">
                    <input class="form-control" placeholder="Correct answer" name="correct" type="text" required>
                </div>
                <div class="form-group">
                    <input class="form-control" placeholder="Answer #2" name="inc1" type="text" required>
                </div>
                <div class="form-group">
                    <input class="form-control" placeholder="Answer #3" name="inc2" type="text" required>
                </div>
                <div class="form-group">
                    <input class="form-control" placeholder="Answer #4" name="inc3" type="text" required>
                </div>
                <div class="form-group">
                    <input class="form-control" placeholder="Background info" name="background" type="text">
                </div>
                <input class="btn btn-lg btn-success btn-block" type="submit" value="Submit">
            </fieldset>
        </form>
    </div>
</div>

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