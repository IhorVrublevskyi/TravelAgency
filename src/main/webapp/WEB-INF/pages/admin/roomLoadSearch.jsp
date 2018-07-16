<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
    <%--<link href="../styles/index.css" rel="stylesheet">--%>
    <style>
        <%@include file="../../styles/index.css"%>
    </style>
</head>
<body>
<div class="form">
    <h2 class="log">Statistics search page</h2>
    <fieldset>
        <div class="input">
            <p>Country</p>
            <form action="/roomStatistics" method="post">
                <div class="input">
                    <p>Begin date</p>
                    <input type="date" name="entryDate" placeholder="" required>
                </div>
                <div class="input">
                    <p>End date</p>
                    <input type="date" name="outDate" placeholder="" required>
                </div>
                <br>
                <div class="submit">
                    <br>
                    <input type="submit" value="Get Stats">
                </div>
                <div class="clear"></div>
            </form>
        </div>
        </form>
    </fieldset>
</div>
</body>
</html>