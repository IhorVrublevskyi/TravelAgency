<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Countries</title>
    <style>
        <%@include file="../../styles/index.css"%>
    </style>
</head>
<body>
<div class="form">
    <h2 class="log">Countries</h2>
    <table>
        <c:forEach items="${countries}" var="item">
            <tr>
                <form action="${pageContext.request.contextPath}/countries" method="post">
                    <input type="hidden" name="countryId" value="${item.getId()}">
                    <td>${item.getName()} </td>
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
    <div class="clear"></div>

    <br><br>
    <div> Insert a new country
        <form action="${pageContext.request.contextPath}/countries", method="post">
            <button class="insert" name="action" value="insertForm">Insert</button>
        </form>
    </div>
</div>
</body>
</html>
