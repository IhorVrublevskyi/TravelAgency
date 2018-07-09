<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userCabinet</title>
    <style>
        <%@include file="../styles/userCabinet.css"%>
    </style>
</head>
<body>
<h2>Hello ${login}</h2>
<div class="visa">
    <p>Information about visas:</p>
    <div class="wrap">
        <div class="row">
            <div class="addButton float-r">
                <a href="/visa"><button>Add visa</button></a>
            </div>
            <div class="clear"/>
        </div>
        <div class="row">
           <%--// TODO view for all visas--%>
                <c:forEach items="${userVisas}" var="item">
                    <div class="item float-l">${item.getCountry()}</div>
                    <div class="item float-l">${item.getDateOfInit()}</div>
                    <div class="item float-l">${item.getDateOfExpired()}</div>
                    <div class="clear"></div>
                </c:forEach>
        </div>
        <br><br>
        <div class="search">
            <a href="/search"><button>Search Hotel</button></a></div>
    </div>



</div>
</body>
</html>
