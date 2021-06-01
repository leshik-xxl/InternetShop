<%--
  Created by IntelliJ IDEA.
  User: oleks
  Date: 01.06.2021
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <p>${users}</p>
</head>
<body>


<table>
    <thead>
    <tr>
        <th>login</th>
        <th>pass</th>
    </tr>
    </thead>

    <tr>
        <td>${users.get(0).login}</td>
        <td>${users.get(0).password}</td>
    </tr>
</table>


</body>
</html>
