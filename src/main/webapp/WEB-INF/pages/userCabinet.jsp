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
<h2>Hello ${loginSession}, </h2>
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
            <%--<c:forEach var="i" items="${visaDto}">--%>
            <%--<option value="${i.name}">--%>
            <%--<c:out value="${i.name}"/>--%>
            <%--</option>--%>
            <%--</c:forEach>--%>

           <%--// TODO view for all visas--%>
            <div class="item float-l">${country}</div>
            <div class="item float-l">${entryDate}</div>
            <div class="item float-l">${outDate}</div>
            <div class="clear"></div>
            <%--//--%>

        </div>
        <div class="search"><a href="/search">
            <button>Search hotel</button>
        </a></div>
    </div>



</div>
</body>
</html>
