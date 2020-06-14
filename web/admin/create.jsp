<%--
  Created by IntelliJ IDEA.
  User: Лев Лосев
  Date: 23.04.2020
  Time: 6:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style type="text/css">
    body {
        background: #080; /* Цвет фона */
        color: #fff; /* Цвет текста */
    }
</style>
<head>
    <title>Title</title>
</head>
<body>
<form action="/admin/read">
    <input type="submit" value="Start page" />
</form>
    <form method="POST" action="/admin/create">


        <p> <input type="text" name="name"/></p>
        <p> <input type="text" name="login"/></p>
        <p> <input type="password" name="password"/></p>
        <select name="Role">
            <option>user</option>
            <option>admin</option>
        </select>

            <input type="submit" value="Добавить пользователя" >
    </form>



</div>
</body>
</html>
