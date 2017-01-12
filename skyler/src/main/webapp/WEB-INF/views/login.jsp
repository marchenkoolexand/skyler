<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>Login Page</title>
</head>
<body>
	<div id="login-box">
		<h1>Login with Email and Password</h1>
		<h2>You can use test user .Login: "skyler@gmail.com" and, password: "skyler" </h2>
		<form name='loginForm'
			action="<c:url value='/login' />" method='POST'>
			<table>
				<tr>
					<td>Email:</td>
					<td><input type='text' name='email'></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password' /></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit"
						value="submit" /></td>
				</tr>
			</table>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
	</div>
</body>
</html>