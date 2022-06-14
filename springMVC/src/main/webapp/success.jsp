<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lyb
  Date: 2022/6/14
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>主页</title>
</head>
<body>
    <h2 align="center">主页</h2>
<c:if test="${not empty sessionScope.userInfo.username}">
    <h1 align="center">欢迎${sessionScope.userInfo.username}登陆</h1>
    <table border="1" align="center">
    <tr>
        <th>员工编号</th>
        <th>员工姓名</th>
        <th>员工职位</th>
        <th>经理编号</th>
        <th>入职日期</th>
        <th>员工工资</th>
        <th>员工奖金</th>
        <th>部门编号</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${empList}" var = "emp">
        <tr>
            <td>${emp.empno}</td>
            <td>${emp.ename}</td>
            <td>${emp.job}</td>
            <td>${emp.mgr}</td>
            <td>${emp.hiredate}</td>
            <td>${emp.sal}</td>
            <td>${emp.comm}</td>
            <td>${emp.deptno}</td>
            <td>
                <a href="deleteController.action?empno=${emp.empno}">删除</a>
                &nbsp;&nbsp;
                <a href="">修改</a>
            </td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>
