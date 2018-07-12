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
        <form action="${pageContext.request.contextPath}/users" method="post">
            <p>User</p>
            <%--<select type="text" name="cityId" required>--%>
            <%--<c:forEach items="${cities}" var="item">--%>
            <%--<option value="${item.getId()}">${item.getCountry()} ${item.getName()}</option>--%>
            <%--</c:forEach>--%>
            <%--</select>--%>
            <%--<input type="hidden" name="action" value="${action}">--%>
            <input type="hidden" name="userId" value="${currentUser.getId()}">
            <input type="hidden" name="action" value="update">
            <p>First name</p>
            <input type="text" name="firstName" placeholder="${currentUser.getFirstName()}" required>
            <p>Last name</p>
            <input type="text" name="lastName" placeholder="${currentUser.getLastName()}" required>
            <p>Login</p>
            <input type="text" name="login" value="${currentUser.getLogin()}" readonly required>
            <p>Role</p>
            <select type="text" name="roleId" required>
                <c:forEach items="${roles}" var="item">
                    <option value="${item.getId()}">${item.getName()}</option>
                </c:forEach>
            </select>
            <p><input type="submit" value="Submit"></p>
        </form>
    </div>


</div>
</body>
</html>
