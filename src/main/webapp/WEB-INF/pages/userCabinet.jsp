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
    <h2 class="log">Hello, <span class="name">${loginDto.getLogin()}</span></h2>
    <p>There is information about your visas:</p>
    <div>
        <div class="addButton float-r">
            <a href="/visa">
                <button>Add visa</button>
            </a>
        </div>
        <div class="clear"/>
    </div>
    <div>
        <div class="visa-item float-l">Country</div>
        <div class="visa-item float-l">Date of init</div>
        <div class="visa-item float-l">Date of expired</div>
        <div class="clear"></div>
        <c:forEach items="${userVisas}" var="item">
            <div class="visa-item float-l">${item.getCountry()}</div>
            <div class="visa-item float-l">${item.getDateOfInit()}</div>
            <div class="visa-item float-l">${item.getDateOfExpired()}</div>
            <div class="clear"></div>
        </c:forEach>
    </div>
    <br><br>
    <div class="search">
        <a href="/search">
            <button>Search Hotel</button>
        </a></div>


</div>
</body>
</html>
