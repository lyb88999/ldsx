<%--
  Created by IntelliJ IDEA.
  User: lyb
  Date: 2022/6/13
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>登陆</title>
</head>
<body>
<center>
    <h3>用户登录</h3>
<form action="userLogin.action" method="post">
    <input type="text" name="uname" placeholder="账号"><br>
    <input type="password" name="pwd" placeholder="密码"><br>
    <input type="submit" value="登陆">
</form>
    <span style="color:red">${msg}</span>
</center>
</body>
</html>
