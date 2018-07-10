<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Countries</title>
</head>
<body>

<div class="form">
    <h2 class="log">Countries</h2>
    <fieldset>
        <form action="/addCountry" method="post">
            <div class="input">
                <p>Country</p>
                    <c:forEach items="${countriesAdmin}" var="item">
                        <div class="visa-item float-l">${item.getName()}</div>
                    </c:forEach>
            </div>
            <div class="clear"></div>
        </form>
    </fieldset>
</div>

</body>
</html>
