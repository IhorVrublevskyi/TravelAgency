<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Search</title>

</head>
<body>
<p>Searching page</p>

<fieldset>
    <form action="/search" method="get">

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

        <div class="input">
            <p>Select City</p>
            <select id="city" name="cities" required>
                <option>city 1</option>
                <option>city 2</option>
                <option>city 3</option>
            </select>
        </div>
        <div class="input">
            <p>Entry Date</p>
            <input type="date" name="entryDate" placeholder="" required>
        </div>
        <div class="input">
            <p>Out Date</p>
            <input type="date" name="outDate" placeholder="" required>
        </div>
        <div class="submit">
            <br/>
            <input type="submit" value="Search">
        </div>
        <div class="clear"></div>
    </form>
</fieldset>

</body>
</html>
