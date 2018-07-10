<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Countries</title>
</head>
<body>
<div class="wrap-item">
    <form action="/book" method="post">
        <div class="row">
            <c:forEach items ="${countriesAdmin}" var="item">
                <div class="wrap-item float-l">
                    <table>
                        <tr>
                            <td class="sd">${item.getName()}
                            </td>
                            <td>
                                <button name="edit">Edit</button>
                            </td>
                            <td>
                                <button name="delete">Delete</button>
                            </td>
                        </tr>
                    <div class="clear"></div>
                    </table>
                </div>
            </c:forEach>
        </div>
    </form>
</div>
</body>
</html>
