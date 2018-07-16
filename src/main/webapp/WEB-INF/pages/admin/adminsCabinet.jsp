<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>adminsCabinet</title>
    <style>
        <%@include file="../../styles/index.css"%>
    </style>
</head>
<body>
<div class="wrap">
    <h2 class="logout float-r"><a href="/logout">
        <button>Logout</button>
    </a></h2>
    <h2 class="log float-r">Hello, <span class="name">${loginDto.getLogin()}</span></h2>
    <div class="clear"/>

    <div class="wrap">
        <p>Please, choose what do you want to edit</p>
        <div class="float-l mt">
            <a href="/countries">
                <button>Countries</button>
            </a>
        </div>
        <div class="float-l ml">You can <span class="insert">insert</span> new country and <span
                class="edit">edit</span> or <span class="delete">delete</span> already exists.
        </div>
        <div class="clear"/>

        <div class="float-l mt">
            <a href="/cities">
                <button>Cities</button>
            </a>
        </div>
        <div class="float-l ml">You can <span class="insert">insert</span> new country and <span
                class="edit">edit</span> or <span class="delete">delete</span> already exists.
        </div>
        <div class="clear"/>

        <div class="float-l mt">
            <a href="/hotels">
                <button>Hotels</button>
            </a>
        </div>
        <div class="float-l ml">You can <span class="insert">insert</span> new country and <span
                class="edit">edit</span> or <span class="delete">delete</span> already exists.
        </div>
        <div class="clear"/>
        <div class="float-l mt">
            <a href="/users">
                <button>Users</button>
            </a>
        </div>
        <div class="float-l ml">You can <span class="insert">insert</span> new country and <span
                class="edit">edit</span> or <span class="delete">delete</span> already exists.
        </div>
        <div class="clear"/>
    </div>
    <br>
    <div class="float-l mt">
        <a href="/users">
            <a href="/roomStatistics"><button>Statistic</button></a>
        </a>
    </div>
    <div class="float-l ml register"><b>*</b> Room load statistic.
    </div>

</div>
</body>
</html>
