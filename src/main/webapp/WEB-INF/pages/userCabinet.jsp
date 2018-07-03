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
<h2>Hello ${user}</h2>
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
            <%--<c:forEach var="i" items="${countries}">--%>
            <%--<option value="${i.name}">--%>
            <%--&lt;%&ndash;<c:out value="${i.name}"/>&ndash;%&gt;--%>
            <%--</option>--%>
            <%--</c:forEach>--%>
            <div class="item float-l">Country</div>
            <div class="item float-l">From Date</div>
            <div class="item float-l">To Date</div>
            <div class="clear"></div>
        </div>

        <div class="search"><a href="/search">
            <button>Search hotel</button>
        </a></div>
    </div>



</div>
</body>
</html>
