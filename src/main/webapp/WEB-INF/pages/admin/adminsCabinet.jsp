
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>adminsCabinet</title>
    <style>
        .form {
            width: 500px;
            margin: 50px auto;
        }
    </style>
</head>
<body>
<h2>Hello ${loginDto.getLogin()}</h2>
<div class="form">
    <a href="/countries"> Countries</a>
    <a href="/cities"> Cities</a>
    <a href="#"> Hotels</a>
    <a href="#"> Rooms</a>
    <a href="#"> Users</a>
</div>
</body>
</html>
