<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
    <%--<link href="../styles/index.css" rel="stylesheet">--%>
    <style>
        <%@include file="../styles/index.css"%>
    </style>
</head>
<body>
<div class="form">
    <h2 class="log">Searching page</h2>
    <c:if test="${error ne null}">
        <p>
            <span style="color:red">${error}</span>
        </p>
    </c:if>
    <fieldset>
        <div class="input">
            <p>Country</p>
            <form action="/search" method="get">
                <select type="text" name="countryId" value="${countryId}" onchange="this.form.submit()" required>
                    <c:forEach items="${countries}" var="item">
                        <c:choose>
                            <c:when test="${countryId == item.getId()}">
                                <option value="${item.getId()}" selected="selected">${item.getName()}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${item.getId()}">${item.getName()}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </form>
        </div>
        <form action="/search" method="post">
            <input type="hidden" , name="loginDto" value="${loginDto}">
            <div class="input">
                <c:if test="${cities != null}">
                    <p>City</p>
                    <select type="text" name="cityId" required>
                        <c:forEach items="${cities}" var="item">
                            <option value="${item.getId()}">${item.getName()}</option>
                        </c:forEach>
                    </select>
                </c:if>
            </div>
            <div class="input">
                <p>Date of checkin</p>
                <input type="date" name="entryDate" placeholder="" required>
            </div>
            <div class="input">
                <p>Date of checkout</p>
                <input type="date" name="outDate" placeholder="" required>
            </div>
            <br>
            <br>
            <div class="input">
                <label><input type="checkbox" name="onlyAvailable" value="true"> Only available countries  </label>
            </div>

            <div class="submit">
                <br>
                <input type="submit" value="Search">
            </div>
            <div class="clear"></div>
        </form>
    </fieldset>
</div>
</body>
</html>