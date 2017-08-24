<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: daou
  Date: 2017-08-23
  Time: 오후 2:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MainList</title>
</head>
<body>
<%Map<String,Map<String,String>> returnBoardList= (Map<String, Map<String, String>>) request.getAttribute("totalList");%>
<tr>
    <td colspan="4"><hr></hr></td>
</tr>
<%if(returnBoardList.size() < 1){ %>
<tr>
    <td colspan="4">리스트 없음</td>
</tr>
<%}%>

<%
    for(int indexI=0; indexI < returnBoardList.size(); indexI++) {
    Map<String, String> board = returnBoardList.get(String.valueOf(indexI));
    String boardNumber=String.valueOf(indexI);
%>

<tr align="center">
    <td><a href="./readPost"<%=boardNumber%></a></td>
    <td><%=board.get("title")%></td>
    <td><%=board.get("content")%></td>
    <td><%=board.get("views")%></td>
</tr>
<tr>
    <td colspan="4"><hr></hr></td>
</tr>
<%}%>

<tr height="1" bgcolor="#D2D2D2"><td colspan="6"></td></tr>
<form method="post" action="/write">
    <input type="submit" value="게시글 등록" />
</form>
</body>
</html>
