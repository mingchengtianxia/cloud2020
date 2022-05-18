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
    <h1>welcome to Spittr</h1>
    <a href="<c:url value="/spittles" />">Spittles</a>
    <a href="<c:url value="/spitter/register" />">Register</a>
</body>
</html>