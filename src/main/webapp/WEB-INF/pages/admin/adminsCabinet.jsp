
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>adminsCabinet</title>
    <style>
        <%@include file="../../styles/index.css"%>
    </style>
</head>
<body>
<div class="wrap">
    <h2 class = "logout float-r"><a href="/logout"><button>Logout</button></a></h2>
    <h2 class="log float-r">Hello, <span class="name">${loginDto.getLogin()}</span></h2>
    <div class="clear"/>

    <div class="form">
        <a href="/countries"> Countries</a>
        <a href="/cities"> Cities</a>
        <a href="/hotels"> Hotels</a>
        <a href="#"> Rooms</a>
        <a href="#"> Users</a>
    </div>

</div>
</body>
</html>
