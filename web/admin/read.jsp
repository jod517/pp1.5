<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Лев Лосев
  Date: 30.04.2020
  Time: 1:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Таблицы</title>
<style type="text/css">
    body {
        background: #080; /* Цвет фона */
        color: #fff; /* Цвет текста */
    }
    TABLE {
        width: 60%; /* Ширина таблицы */
        border: 1px solid #399; /* Граница вокруг таблицы */
        border-collapse: collapse;
    }
    TD {
        background: #fc0; /* Цвет фона */
        border: 1px solid #333; /* Граница вокруг ячеек */
        padding: 5px; /* Поля в ячейках */
    }
    TH {
           background: #fc0; /* Цвет фона */
           border: 1px solid #333; /* Граница вокруг ячеек */
           padding: 5px; /* Поля в ячейках */
       }


</style>
</head>
<body>
<h3>Таблица</h3>

<form action="/admin/create">
    <input type="submit" value="Create the New User" />
</form>

<br>
<form method="post" action="/admin/delete">
    <input type="submit" value="Удалить выбранное"/>
<table border="3">
    <tr>

        <td>Chose for delete</td>
        <td>Click to update / id</td>
        <td>Name</td>
        <td>Login</td>
        <td>Password</td>
        <td>Role</td>

    </tr>
    <c:forEach items="${col}" var="col">


        <tr>

            <td><input type="checkbox" name="id" value="${col.id}"/></td>
            <th scope="row">
                <a href="${pageContext.request.contextPath}/admin/update?id=${col.getId()}">
                        ${col.getId()}
                </a>

            <td> ${col.name} </td>
            <td> ${col.login} </td>
            <td> ${col.password} </td>
            <td> ${col.role} </td>

            </th>
            </th>


        </tr>
    </c:forEach>
</table>

</body>
</html>
