<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <c:if test="${error ne null}">
        <p>
            <span style="color:red">${error}</span>
        </p>
    </c:if>
    <fieldset>
        <form action="/login" method="post">
            <div class="input">
                <p>Login</p>
                <input type="text" name="login" placeholder="Type login" required>
            </div>
            <div class="input">
                <p>Password</p>
                <input type="password" name="password" placeholder="Type password" required>
            </div>
            <div class="submit">
                <input type="submit" value="Login"></a>
            </div>
            <div class="clear"></div>
        </form>
    </fieldset>
    <div class="register">
        <b>*</b> If you have not already registered, please <a href="/registration">register</a>
    </div>
</div>

</body>
</html>
