<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hotels</title>
    <style>
        <%@include file="../styles/index.css"%>
    </style>
</head>
<body>
<div class="wrap">
    <p>Please, choose hotel</p>
    <table>
        <thead>
        <tr>
            <td>Hotel</td>
            <td>Country</td>
            <td>City</td>
            <td>Address</td>
            <td>Number of free rooms</td>
            <td>Book</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${hotels}" var="item">
            <tr>
                <td>${item.getHotelName()}</td>
                <td>${item.getCountry()}</td>
                <td>${item.getCity()}</td>
                <td>${item.getHotelAddress()}</td>
                <td>${item.getFreeHotelRooms()}</td>
                <td><a href="/book">
                    <button>Book</button>
                </a></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>
</body>
</html>
