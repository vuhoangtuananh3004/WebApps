<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up An Account</title>
<link rel = "stylesheet" href = "css/signup.css">
</head>
<body>

<div align = "left">
<form:form action = "SignUp" method = "post" modelAttribute="userForm">
Email:<form:input type ="email" path="email"/> <font color="red">${error}</font> <br>
Password  :<form:password  path="password" /><br>
First Name:<form:input path="fname" /><br>
Last Name :<form:input path="lname" /><br>
Sex       :<form:radiobutton path="sex" value = "M" /> Male &nbsp;
<form:radiobutton path="sex" value = "F" /> Female<br>
<form:hidden path="date" value = "<%= new Date() %>"/><br>
<input type = "submit" value ="Sign up" class = "signupButton">
</form:form>
</div>

 
</body>
</html>