<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <style>
        <%@include file="../../styles/index.css"%>
    </style>
</head>
<body>
<div class="form">
    <h2 class="log">Users</h2>
    <table border="1">
        <tr>
            <td>First name</td>
            <td>Last name</td>
            <td>Login</td>
            <td>Role</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach items="${users}" var="item">
            <tr>
                <form action="${pageContext.request.contextPath}/users" method="post">
                    <input type="hidden" name="userId" value="${item.getId()}">
                    <td> ${item.getFirstName()} </td>
                    <td>${item.getLastName()} </td>
                    <td>${item.getLogin()} </td>
                    <td>${item.getRole()} </td>
                    <td>
                        <button class="edit" name="action" value="editForm" type="submit">Edit</button>
                    </td>
                    <td>
                        <button class="delete" name="action" value="delete" type="submit">Delete</button>
                    </td>
                </form>
            </tr>

        </c:forEach>
        <div class="clear"></div>
    </table>
    <br>
    <div class="bottom-button">
        <a href="/adminsCabinet"><button>Back</button></a>
    </div>
    <div class="clear"></div>
    <%--<br><br>--%>
    <%--<div> Insert a new user--%>
        <%--<form action="${pageContext.request.contextPath}/users" , method="post">--%>
            <%--<button class="insert" name="action" value="insertForm">Insert</button>--%>
        <%--</form>--%>
    <%--</div>--%>
</div>
</body>
</html>
