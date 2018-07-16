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
        <form action="${pageContext.request.contextPath}/countries" method="post">
            <p>Country name</p>
            <input type="hidden" name="action" value="${action}">
            <c:if test="${action == 'update'}">
                <input type="text" name="countryName" placeholder="${currentCountry.getName()}" required>
                <input type="hidden" name="countryId" value="${currentCountry.getId()}">
            </c:if>
            <c:if test="${action == 'insert'}">
                <input type="text" name="countryName" placeholder="Country name" required>
            </c:if>

            <input type="submit" value="Submit">
            <input type="button" value="Cancel" onclick="back()" formnovalidate>
        </form>
    </div>
</div>
<script>
    function back() {
        window.location.replace("${pageContext.request.contextPath}/countries");
    }
</script>
</body>
</html>
