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
<form action="/book" method="post">
    <p>Hotels</p>

    <div class="row">
        <%--<div class="item float-l">Країна</div>--%>
        <%--<div class="item float-l">Місто</div>--%>
        <%--<div class="item float-l">Назва</div>--%>
        <%--<div class="item float-l">Адреса</div>--%>
        <%--<div class="item float-l">Вільні кімнати</div>--%>
        <%--<div class="item float-l"></div>--%>
        <%--<div class="clear"></div>--%>
        <c:forEach items="${hotels}" var="item">
            <div class="wrap-item float-l">
                <table>
                    <tr>
                        <td class="fd">Готель:</td>
                        <td class="sd">${item.getHotelName()}</td>
                    </tr>
                    <tr>
                        <td class="fd">Країна:</td>
                        <td class="sd">${item.getCountry()}</td>
                    </tr>
                    <tr>
                        <td class="fd">Місто:</td>
                        <td class="sd">${item.getCity()}</td>
                    </tr>
                    <tr>
                        <td class="fd">Адреса:</td>
                        <td class="sd">${item.getHotelAddress()}</td>
                    </tr>
                    <tr>
                        <td class="fd">Кількість вільних кімнат:</td>
                        <td class="sd">${item.getFreeHotelRooms()}</td>
                    </tr>
                </table>
                <%--<div class="item">Готель: ${item.getHotelName()}</div>--%>
                <%--<div class="item">Країна: ${item.getCountry()}</div>--%>
                <%--<div class="item">Місто: ${item.getCity()}</div>--%>
                <%--<div class="item">Адреса: ${item.getHotelAddress()}</div>--%>
                <%--<div class="item">Кількість вільних кімнат: ${item.getFreeHotelRooms()}</div>--%>
                    <%--<div class="item float-l"><input type="submit" value="${item.getId()}"></div>--%>
                <div class="item">
                    <a href="/book">
                        <button>Book</button>
                    </a>
                </div>
                <div class="clear"></div>
            </div>
        </c:forEach>
        <div class="clear"></div>
    </div>
</form>
</body>
</html>
