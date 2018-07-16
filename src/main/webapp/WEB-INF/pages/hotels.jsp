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
<div class="form">
    <p>Please, choose hotel</p>
    <table border="1">
        <thead>
        <tr>
            <td>Hotel</td>
            <td>Country</td>
            <td>City</td>
            <td>Address</td>
            <td>Checkin date</td>
            <td>Checkout date</td>
            <td>Room number</td>
            <td>Book</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${bookings}" var="item">
            <tr>
                <form action="/book" method="get">
                    <input type="hidden" name="userId" value="${item.getUserId()}">
                    <input type="hidden" name="hotelName" value="${item.getHotelName()}">
                    <input type="hidden" name="hotelId" value="${item.getHotelId()}">
                    <input type="hidden" name="cityName" value="${item.getCity()}">
                    <input type="hidden" name="countryName" value="${item.getCountry()}">
                    <input type="hidden" name="hotelAddress" value="${item.getHotelAddress()}">
                    <input type="hidden" name="entryDate" value="${item.getDateCheckin()}">
                    <input type="hidden" name="outDate" value="${item.getDateCheckout()}">
                    <td>${item.getHotelName()}</td>
                    <td>${item.getCountry()}</td>
                    <td>${item.getCity()}</td>
                    <td>${item.getHotelAddress()}</td>
                    <td>${item.getDateCheckin()}</td>
                    <td>${item.getDateCheckout()}</td>
                    <td>
                        <select type="text" name="roomId" required>
                            <c:forEach items="${item.getAvailableRooms()}" var="item">
                                <option value="${item.getId()}">${item.getNumber()}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <button class="insert" type="submit" onclick="getConfirmation();">Book</button>

                        <script type="text/javascript">
                            function getConfirmation() {
                                var retVal = confirm("Do you want to continue ?");
                            }
                        </script>
                    </td>
                </form>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="clear"></div>
</div>
</body>
</html>
