<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cities</title>
    <style>
        <%@include file="../../styles/index.css"%>
    </style>
</head>
<body>
<div class="form">
    <h2 class="log">Cities</h2>
    <div class="head-button">
        <form action="${pageContext.request.contextPath}/cities" , method="post">
            <button class="insert" name="action" value="insertForm">Add</button>
        </form>
    </div>
    <div class="clear"></div>
    <table>
        <c:forEach items="${cities}" var="item">
            <tr>
                <form action="${pageContext.request.contextPath}/cities" method="post">
                    <input type="hidden" name="cityId" value="${item.getId()}">
                    <td>${item.getName()} </td>
                    <td>
                        <button class="edit" name="action" value="editForm" type="submit">Edit</button>
                    </td>
                    <td>
                        <button class="delete" name="action" value="delete" type="submit" onclick="return confirm('Are you sure?')">Delete</button>
                    </td>
                </form>
            </tr>
        </c:forEach>
    </table>
    <br>
    <div class="bottom-button">
        <a href="/adminsCabinet"><button>Back</button></a>
    </div>
    <div class="clear"></div>
</div>
</body>
</html>
