<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <%--<link href="../styles/index.css" rel="stylesheet">--%>
    <style>
        <%@include file="../styles/index.css"%>
    </style>
</head>
<body>

<div class="form">
    <h2 class="log">Please enter your personal info</h2>

    <fieldset>
        <form action="/userCabinet" method="post">
            <div class="input">
                <p>First name</p>
                <input type="text" name="fname" placeholder="Type first_name" required>
            </div>
            <div class="input">
                <p>Last name</p>
                <input type="text" name="lname" placeholder="Type last_name" required>
            </div>
            <div class="input">
                <p>Login</p>
                <input type="text" name="uname" placeholder="Type login" required>
            </div>
            <div class="input">
                <p>Password</p>
                <input type="password" name="login" placeholder="Type password" required>
            </div>
            <div class="submit">
                <input type="submit" value="Register">
            </div>
            <div class="clear"></div>
        </form>
    </fieldset>
</div>

</body>
</html>
