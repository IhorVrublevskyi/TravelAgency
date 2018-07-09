<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hotels</title>
    <style>
        <%@include file="../styles/userCabinet.css"%>
    </style>
</head>
<body>
<form action="/book" method="post">
    <p>Hotels</p>

    <div class="row">
        <div class="item float-l">Країна</div>
        <div class="item float-l">Місто</div>
        <div class="item float-l">Назва</div>
        <div class="item float-l">Адреса</div>
        <div class="item float-l">Вільні кімнати</div>
        <div class="item float-l"></div>
        <div class="clear"></div>
        <c:forEach items="${hotels}" var="item">
            <div class="item float-l">${item.getCountry()}</div>
            <div class="item float-l">${item.getCity()}</div>
            <div class="item float-l">${item.getHotelName()}</div>
            <div class="item float-l">${item.getHotelAddress()}</div>
            <div class="item float-l">${item.getFreeHotelRooms()}</div>
            <div class="item float-l"><input type="submit" value="${item.getId()}"></div>
            <div class="clear"></div>
        </c:forEach>
    </div>
</form>
</body>
</html>
