<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>City</title>
    <style>
        <%@include file="../../styles/index.css"%>
    </style>
</head>
<body>
<div class="form">
    <h2 class="log">City</h2>

    <div class="input">
        <form action="${pageContext.request.contextPath}/cities" method="post">
            <input type="hidden" name="action" value="${action}">
            <c:if test="${action == 'update'}">
                <input type="text" name="countryName" placeholder="${currentCity.getCountry()}" required>
                <input type="text" name="cityName" placeholder="${currentCity.getName()}" required>
                <input type="hidden" name="cityId" value="${currentCity.getId()}">
            </c:if>
            <c:if test="${action == 'insert'}">
                <input type="text" name="countryName" placeholder="Country name" required>
                <input type="text" name="cityName" placeholder="City name" required>
            </c:if>

            <input type="submit" value="Submit">
        </form>
    </div>


</div>
</body>
</html>
