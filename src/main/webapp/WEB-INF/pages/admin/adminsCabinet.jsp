
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>adminsCabinet</title>
    <style>
        <%@include file="../../styles/index.css"%>
    </style>
</head>
<body>
<h2>Hello ${loginDto.getLogin()}</h2>
<div class="form">
    <a href="/countries"> Countries</a>
    <a href="/cities"> Cities</a>
    <a href="/hotels"> Hotels</a>
    <a href="#"> Rooms</a>
    <a href="#"> Users</a>
</div>
</body>
</html>
