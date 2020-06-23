<%--
  Created by IntelliJ IDEA.
  User: Лев Лосев
  Date: 08.05.2020
  Time: 2:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/admin/update?id=${col.id}" method="POST">
    <input required type="text" name="name" placeholder="New name">
    <input required type="text" name="login" placeholder="New login">
    <input required type="password" name="password" placeholder="New password">
    <select name="role">
        <option>user</option>
        <option>admin</option>
    </select>
    <input type="submit" value="Update user">
</form>
</form>
</body>
</html>
