<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User List</title>
</head>
<body>

<c:forEach items="${users}" var="user">
    <c:out value="${user.username}"/>
    <br/>
    <c:out value="${user.age}"/>
    <br/>
</c:forEach>

</body>
</html>
