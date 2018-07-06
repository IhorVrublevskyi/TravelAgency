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
    <c:if test="${error ne null}">
        <p>
            <span style="color:red">${error}</span>
        </p>
    </c:if>
    <fieldset>
        <form action="/registration" method="post">
            <div class="input">
                <p>Login</p>
                <input type="text" name="login" placeholder="Type login" required>
            </div>
            <div class="input">
                <p>Password</p>
                <input type="password" name="password" placeholder="Type password" required>
            </div>
            <div class="input">
                <p>Retype password</p>
                <input type="password" name="retypePassword" placeholder="Retype password" required>
            </div>
            <div class="input">
                <p>First name</p>
                <input type="text" name="firstName" placeholder="Type first name" required>
            </div>
            <div class="input">
                <p>Last name</p>
                <input type="text" name="lastName" placeholder="Type last name" required>
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
