<%--
  Created by IntelliJ IDEA.
  User: daou
  Date: 2017-08-23
  Time: 오후 4:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LoginResult</title>
</head>
<body>
<form >
<%
    String id=(String)request.getAttribute("id");
    String password=(String)request.getAttribute("password");
%>
    <h2>로그인에 성공하셨습니다.</h2>
    <h1>${id}</h1>
    <h1>${password}</h1>
    <a href="./list">게시판 입장</a>
</body>
</html>
