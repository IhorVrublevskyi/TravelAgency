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
    <div class="head-button">
        <form action="${pageContext.request.contextPath}/hotels" , method="post">
            <button class="insert" name="action" value="insertForm">Add</button>
        </form>
    </div>
    <div class="clear"></div>
    <table border="1">
        <thead>
        <tr>
            <td>Country</td>
            <td>City</td>
            <td>Name</td>
            <td>Address</td>
            <td>Edit</td>
            <td>Delete</td>
            <div class="clear"></div>
        </tr>
        <thead>
        <tbody>
        <c:forEach items="${hotels}" var="item">
            <tr>
                <td>${item.getCountry()}</td>
                <td>${item.getCity()}</td>
                <td>${item.getHotelName()}</td>
                <td>${item.getHotelAddress()}</td>
                <form action="${pageContext.request.contextPath}/hotels" method="post">
                    <input type="hidden" name="hotelId" value="${item.getId()}">
                    <td>
                        <button class="edit" class="submit" name="action" value="editForm" type="submit">Edit</button>
                    </td>
                    <td>
                        <button class="delete" name="action" value="delete" type="submit" onclick="return confirm('Are you sure?')">
                            Delete
                        </button>
                    </td>
                </form>
            </tr>
        </c:forEach>
    </tbody>
    </table>
    <br>
    <div class="bottom-button">
        <a href="/adminsCabinet"><button>Back</button></a>
    </div>
    <div class="clear"></div>
</div>
</body>
</html>
