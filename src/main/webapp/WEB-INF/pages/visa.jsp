<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <%--<link href="../styles/index.css" rel="stylesheet">--%>
    <style>
        <%@include file="../styles/index.css"%>
    </style>
</head>
<body>

<div class="form">
    <h2 class="log">Please enter your VISA info</h2>
    <c:if test="${error ne null}">
        <p>
            <span style="color:red">${error}</span>
        </p>
    </c:if>
    <fieldset>
        <form action="/addVisa" method="post">
            <div class="input">
                <p>Country</p>
                <select type="text" name="countryId" required>
                    <c:forEach items="${countries}" var="item">
                        <option value="${item.getId()}">${item.getName()}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="input">
                <p>Init Date</p>
                <input type="date" name="entryDate" placeholder="" required>
            </div>
            <div class="input">
                <p>Expired Date</p>
                <input type="date" name="outDate" placeholder="" required>
            </div>
            <div class="submit">
                <br/>
                <input type="submit" value="Add">
            </div>
            <div class="clear"></div>
        </form>
    </fieldset>
</div>

</body>
</html>
