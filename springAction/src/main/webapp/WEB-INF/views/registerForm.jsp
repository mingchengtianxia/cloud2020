<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page session="false" %>
<html>
<head>
<meta charset="UTF-8">
<title>Spittr</title>
    <link rel="stylesheet"
        type="text/css"
        href="<c:url value="/resources/style.css" />">
</head>
<body>
    <h1>Register</h1>
    <form method="post">
        First Name:<input type="text" name="firstName" /></br>
        Last Name:<input type="text" name="LastName" /></br>
        UserName:<input type="text" name="username" /></br>
        Password:<input type="password" name="password" /></br>
        <input type="submit" value="Register">
    </form>
</body>
</html>