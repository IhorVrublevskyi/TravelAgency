<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hotels</title>
    <style>
        <%@include file="../../styles/index.css"%>
    </style>
</head>
<body>
<div class="form">
    <h2 class="log">Hotels</h2>
    <table border="1">
        <tr>
            <td>Country</td>
            <td>City</td>
            <td>Name</td>
            <td>Address</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach items="${hotels}" var="item">
            <tr>
                <td>${item.getCountry()}</td>
                <td>${item.getCity()}</td>
                <td>${item.getHotelName()}</td>
                <td>${item.getHotelAddress()}</td>
                <form action="${pageContext.request.contextPath}/hotels" method="post">
                    <input type="hidden" name="hotelId" value="${item.getId()}">
                    <td>
                        <button name="action" value="editForm" type="submit">Edit</button>
                    </td>
                    <td>
                        <button name="action" value="delete" type="submit">Delete</button>
                    </td>
                </form>
            </tr>
        </c:forEach>
    </table>
    <br><br>
    <div> Insert a new hotel
        <form action="${pageContext.request.contextPath}/hotels", method="post">
            <button class="insert" name="action" value="insertForm">Insert</button>
        </form>
    </div>
</div>
</body>
</html>
