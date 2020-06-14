<%--
  Created by IntelliJ IDEA.
  User: Лев Лосев
  Date: 13.06.2020
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Page</title>
</head>
<body>


    <h1>
        ${message}
    </h1>


<footer>
    <p>Your role is: ${sessionScope['user_role']}</p>
</footer>
</body>
</html>
