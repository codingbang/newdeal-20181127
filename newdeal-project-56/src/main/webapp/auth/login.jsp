<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>로그인</title>
</head>
<body>
<h1>로그인</h1>
<form action="login" method="post">
<table border='1'>

<tr>
  <th>이메일</th>
  <td><input name="email" type="text"></td>
</tr>

<tr>
  <th>암호</th>
  <td><input name="password" type="password"></td>
</tr>

<tr>
  <th></th>
  <td><button>로그인</button>
  <button type="button" onclick="location.href='/member/add'">회원가입</button>
  </td>
</tr>

</table>
</form>

</body>
</html>
