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

<p>Information about you order</p>

<div class="wrap-item float-l">
    <table>
        <tr>
            <td class="fd">Hotel:</td>
            <td class="sd">
                <input type="text" name="hotelName" value="${currentBooking.getHotelName()}" readonly
                                  required></td>
        </tr>
        <tr>
            <td class="fd">Country:</td>
            <td class="sd">
                <input type="text" name="countryName" value="${currentBooking.getCountry()}" readonly
                                  required></td>
        </tr>
        <tr>
            <td class="fd">City:</td>
            <td class="sd">
                <input type="text" name="cityName" value="${currentBooking.getCity()}" readonly required>
            </td>
        </tr>
        <tr>
            <td class="fd">Address:</td>
            <td class="sd"><
                input type="text" name="hotelAddress" value="${currentBooking.getHotelAddress()}" readonly
                required></td>
        </tr>
        <tr>
            <td class="fd">Checkin date:</td>
            <td class="sd">
                <input type="text" name="hotelAddress" value="${currentBooking.getDateCheckin()}" readonly
                                  required></td>
        </tr>
        <tr>
            <td class="fd">Checkout date:</td>
            <td class="sd">
                <input type="text" name="hotelAddress" value="${currentBooking.getDateCheckout()}" readonly
                       required></td>
        </tr>
    </table>
    <div class="item float-l">
        <form action="/book" method="post">
            <button name="bookingDto" value="${currentBooking}">Confirm</button>
        </form>
    </div>
    <div class="clear"></div>
</div>
<div class="clear"></div>

</body>
</html>
