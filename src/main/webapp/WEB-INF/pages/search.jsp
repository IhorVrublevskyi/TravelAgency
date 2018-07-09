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
    <fieldset>
        <form action="/search" method="post">
            <div class="input">
                <p>City</p>
                <select type="text" name="cityName" required>
                    <c:forEach items="${cities}" var="item">
                        <option value="${item.getName()}">${item.getCountry()} ${item.getName()}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="input">
                <p>Date of checkin</p>
                <input type="date" name="entryDate" placeholder="" required>
            </div>
            <div class="input">
                <p>Date of checkout</p>
                <input type="date" name="outDate" placeholder="" required>
            </div>
            <div class="submit">
                <br/>
                <input type="submit" value="Search">
            </div>
            <div class="clear"></div>
        </form>
    </fieldset>
</div>

</body>
</html>



            <%--<div class="input">--%>
                <%--<p>Select Country</p>--%>
                <%--<select id="country" name="countries" required>--%>
                    <%--&lt;%&ndash;<c:forEach var="i" items="${countries}">&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<option value="${i.name}">&ndash;%&gt;--%>
                    <%--&lt;%&ndash;&lt;%&ndash;<c:out value="${i.name}"/>&ndash;%&gt;&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</option>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</c:forEach>&ndash;%&gt;--%>
                    <%--<option>country 1</option>--%>
                    <%--<option>country 2</option>--%>
                    <%--<option>country 3</option>--%>
                <%--</select>--%>
            <%--</div>--%>
