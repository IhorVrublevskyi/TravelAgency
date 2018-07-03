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

    <fieldset>
        <form action="/addVisa" method="post">
            <div class="input">
                <p>Country</p>
                <input type="text" name="fname" placeholder="Type country" required>
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
