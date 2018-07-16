<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userCabinet</title>
    <style>
        <%@include file="../styles/index.css"%>
    </style>
</head>
<body>
<div class="wrap">
    <h2 class="logout float-r"><a href="/logout">
        <button>Logout</button>
    </a></h2>
</div>
<div class="form">
    <table class="wrap">
        <h2 class="log float-r">Hello, <span class="name">${loginDto.getLogin()}</span></h2>

        <br>
        <div >
            <a href="/visa">
                <button class="insert addButton float-r">Add visa</button>
            </a>
        </div>
        <table border="1">
            <p>Information about your visas:</p>
            <thead>
            <tr>
                <td>Country</td>
                <td>Date of init</td>
                <td>Date of expired</td>
            </tr>
            </thead>
            <c:forEach items="${userVisas}" var="item">
            <tr>
                <td>${item.getCountry()}</td>
                <td>${item.getDateOfInit()}</td>
                <td>${item.getDateOfExpired()}</td>
            </tr>
                <div class="clear"></div>
            </c:forEach>
        </table>
    </table>
    <br><br>
    <p>Visited countries:</p>
    <c:forEach items="${countries}" var="item">
        <div class="visa-item float-l">${item.getName()}</div>
        <div class="clear"></div>
    </c:forEach>
    <div class="search">
        <a href="/search">
            <button>Search hotel</button>
        </a></div>
</div>
</body>
</html>
