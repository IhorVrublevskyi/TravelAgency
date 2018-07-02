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
    <h2 class="log">Please login to your cabinet</h2>

    <fieldset>
        <form action="/login" method="post">
            <div class="input">
                <p>Login</p>
                <input type="text" name="login" placeholder="Type login" required>
            </div>
            <div class="input">
                <p>Password</p>
                <input type="password" name="login" placeholder="Type password" required>
            </div>
            <div class="submit">
                <input type="submit" value="Login">
            </div>
            <div class="clear"></div>
        </form>
    </fieldset>
</div>

</body>
</html>
