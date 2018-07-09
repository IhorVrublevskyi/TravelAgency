<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>infoAboutSelectedHotel</title>
    <style>
        <%@include file="../styles/index.css"%>
    </style>
</head>
<body>

<p>infoAboutSelectedHotel</p>

<%--Необхідно сформувати на сторінці hotels.jsp об'єкт dto,--%>
<%--який буде передавати інфу про даний вибраний готель,--%>
<%--і з нього тягнути всю інфу:--%>
<%--request.setAttribute("hotel", hotel)--%>

<div class="wrap-item float-l">
    <table>
        <tr>
            <td class="fd">Готель:</td>
            <td class="sd">${hotel.getHotelName()}</td>
        </tr>
        <tr>
            <td class="fd">Країна:</td>
            <td class="sd">${hotel.getCountry()}</td>
        </tr>
        <tr>
            <td class="fd">Місто:</td>
            <td class="sd">${hotel.getCity()}</td>
        </tr>
        <tr>
            <td class="fd">Адреса:</td>
            <td class="sd">${hotel.getHotelAddress()}</td>
        </tr>
        <tr>
            <td class="fd">Кількість вільних кімнат:</td>
            <td class="sd">${hotel.getFreeHotelRooms()}</td>
        </tr>
    </table>
    <%--<div class="item float-l"><a href="">--%>
        <%--<button>Edit</button>--%>
    <%--</a></div>--%>
    <%--Має вести назад до переліку готелів--%>
    <div class="item float-l"><a href="/confirm">
        <button>Confirm</button>
    </a></div>
    <div class="clear"></div>
</div>
<div class="clear"></div>

</body>
</html>
