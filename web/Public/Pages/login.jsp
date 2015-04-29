<!DOCTYPE html>
<html>
    <head>
        <!-- Meta -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- Style -->
        <link href="../../Public/Style/main.css" type="text/css" rel="stylesheet">
        
        <!-- Title -->
        <title>Dell</title>
        
        <!-- Js -->
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
        <script src="Library/JS/effects.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="LoginContainer">
            <div id="login_logo"><img src="../images/logo.png" /></div>
            <div class="loginForm">
                <form action="../../Servlet" method="post">
                    <input class="inputText" type="text" name="username" placeholder="Username">
                    <input class="inputText" type="password" name="password" placeholder="*********">
                    
                    <input type="hidden" name="origin" value="login" />
                    <input id="inputSubmit" type="submit" value="Login"/>
                </form>
            </div>
        </div>
    </body>
</html>
