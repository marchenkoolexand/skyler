<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Skyler Login Page</title>
</head>
<body>
<h1>Login with Email and Password</h1>
<c:url var="loginUrl" value="/login"/>
<form action="${loginUrl}" method="post" class="form-horizontal">
    <c:if test="${param.error != null}">
        <p>Invalid username and password.</p>
    </c:if><c:if test="${param.logout != null}">
    <p>You have been logged out successfully.</p>
</c:if>
    <input type="text" class="form-control" id="email" name="email" placeholder="Enter Username" required>
    <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
    <label><input type="checkbox" id="rememberme" name="remember-me"> Remember Me</label>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" class="btn btn-block btn-primary btn-default" value="Log in">
</form>
</body>
</html>