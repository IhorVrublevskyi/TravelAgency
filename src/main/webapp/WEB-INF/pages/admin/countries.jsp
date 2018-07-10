<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Countries</title>
    <style>
        .form {
            width: 500px;
            margin: 50px auto;
        }
        b {
            color: red;
        }
    </style>
</head>
<body>
    <div class="form">
        <table>
            <c:forEach items ="${countriesAdmin}" var="item">
                    <tr>
                        <td >${item.getName()} </td>
                        <td >
                            <button name="edit">Edit</button>
                        </td>
                        <td >
                            <button name="delete">Delete</button>
                        </td>
                    </tr>
            </c:forEach>
            <div class="clear"></div>
        </table>
        <br><br>
        <div> <b>*</b> Insert a new country <button>Insert</button></div>
    </div>
</body>
</html>
