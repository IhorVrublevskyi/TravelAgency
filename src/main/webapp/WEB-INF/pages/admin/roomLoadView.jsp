<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Countries</title>
    <style>
        <%@include file="../../styles/index.css"%>
    </style>
</head>
<body>
<table>
    <caption>Room load statistics</caption>
    <tr>
        <td>Hotel name</td>
        <td>Room number</td>
        <td>Room load</td>
    </tr>
    <c:forEach items="${rooms}" var="item">
        <tr>
            <td>${item.getHotelName()}</td>
            <td>${item.getRoomNumber()}</td>
            <td>${item.getRoomLoad()}</td>
        </tr>
    </c:forEach>
</table>
<br>
<div class="bottom-button">
    <a href="/adminsCabinet">
        <button>Back</button>
    </a>
</div>
<div class="clear"></div>
</div>
</body>
</html>
