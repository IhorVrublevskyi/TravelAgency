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
    <h2 class="log">City</h2>

    <div class="input">
        <form action="${pageContext.request.contextPath}/cities" method="post">
            <p>Country name</p>
            <select type="text" name="countryName" required>
                <c:forEach items="${countries}" var="item">
                    <option value="${item.getId()}">${item.getName()}</option>
                </c:forEach>
            </select>
            <p>City name</p>
            <input type="hidden" name="action" value="${action}">
            <c:if test="${action == 'update'}">
                <input type="text" name="cityName" placeholder="${currentCity.getName()}" required>
                <%--<input type="text" name="cityName" placeholder="${currentCity.getName()}" required>--%>
                <input type="hidden" name="cityId" value="${currentCity.getId()}">
            </c:if>
            <c:if test="${action == 'insert'}">
                <%--<input type="text" name="cityName" placeholder="CityName" required>--%>
                <input type="text" name="cityName" placeholder="CityName" required>
            </c:if>
            <input type="submit" value="Submit">
            <input type="button" value="Cancel" onclick="back()" formnovalidate>
        </form>
    </div>
</div>
<script>
    function back() {
        window.location.replace("${pageContext.request.contextPath}/cities");
    }
</script>
</body>
</html>
