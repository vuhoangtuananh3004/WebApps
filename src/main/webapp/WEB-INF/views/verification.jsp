<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation</title>
</head>
<body>


<div align = "center">
Account Detail: 
<div align = "left">
Email: <font color = "blue">${user.getEmail()}</font><br>
First Name: <font color = "blue">${user.getFname()}</font><br>
Last Name: <font color = "blue">${user.getLname()}</font><br>
PassWord: <font color = "blue">${user.getPassword()}</font><br>
Date: <font color = "blue">${user.getDate()}</font><br>
<font color = "red"> Please check your email for verification code</font>
</div>

<form action = "verification" method = "post">
<input type = "text" placeholder = "Verification Code" name = "codeInput">
<input type = "submit" value = "Confirm">
</form>
</div>

</body>
</html>