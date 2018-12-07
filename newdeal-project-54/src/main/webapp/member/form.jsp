<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>회원</title>
</head>
<body>
<jsp:include page="/header.jsp" />
<h1>회원 등록</h1>
<form action="add" method="post">
<table border='1'>

<tr>
  <th>이름</th>
  <td><input type="text" name="name"></td>
</tr>

<tr>
  <th>이메일</th>
  <td><input type="text" name="email"></td>
</tr>


<tr>
  <th>암호</th>
  <td><input type="password" name="password"></td>
</tr>


<tr>
  <th>사진</th>
  <td><input type="text" name="photo"></td>
</tr>


<tr>
  <th>전화</th>
  <td><input type="text" name="tel"></td>
</tr>


<tr>
  <th></th>
  <td><button>등록</button>
  <button type="button" onclick="location.href='list'">취소</button></td>
</tr>

</table>
</form>

</body>
</html>
