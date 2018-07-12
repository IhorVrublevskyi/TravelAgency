<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Country</title>
    <style>
        <%@include file="../../styles/index.css"%>
    </style>
</head>
<body>
<div class="form">
    <h2 class="log">Country</h2>

    <div class="input">
        <form action="${pageContext.request.contextPath}/hotels" method="post">
            <p>City</p>
            <select type="text" name="cityId" required>
                <c:forEach items="${cities}" var="item">
                    <option value="${item.getId()}">${item.getCountry()} ${item.getName()}</option>
                </c:forEach>
            </select>
            <input type="hidden" name="action" value="${action}">
            <c:if test="${action == 'update'}">
                <input type="hidden" name="hotelId" value="${currentHotel.getId()}">
                <p>Hotel name</p>
                <input type="text" name="hotelName" placeholder="${currentHotel.getHotelName()}" required>
                <p>Hotel address</p>
                <input type="text" name="hotelAddress" placeholder="${currentHotel.getHotelAddress()}" required>

            </c:if>
            <c:if test="${action == 'insert'}">
                <p>Hotel name</p>
                <input type="text" name="hotelName" placeholder="Name" required>
                <p>Hotel address</p>
                <input type="text" name="hotelAddress" placeholder="Address" required>
            </c:if>

            <p><input type="submit" value="Submit"></p>
        </form>
    </div>


</div>
</body>
</html>
