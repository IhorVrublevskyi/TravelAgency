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
        <table>
            <c:forEach items ="${usersAdmin}" var="item">
                    <tr>
                        <td > ${item.getFirstName()} ${item.getLastName()} ${item.getLogin()} ${item.getPassword()} ${item.getRole()} </td>
                        <td >
                            <button class="edit" name="edit">Edit</button>
                        </td>
                        <td >
                            <button class="delete" name="delete">Delete</button>
                        </td>
                    </tr>
            </c:forEach>
            <div class="clear"></div>
        </table>
        <br><br>
        <div> Insert a new user <button class="insert">Insert</button></div>
    </div>
</body>
</html>
