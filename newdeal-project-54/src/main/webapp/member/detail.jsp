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
<h1>회원 상세정보</h1>
<form action="update" method="get">
<table border='1'>
<tr>
  <th>번호</th>
  <td><input type="text" name="no" readonly value="${member.no }"></td>
</tr>

<tr>
  <th>이름</th>
  <td><input type="text" readonly value="${member.name }"></td>
</tr>

<tr>
  <th>사진</th>
  <td><input type="text" readonly value="${member.photo }"></td>
</tr>

<tr>
  <th>전화</th>
  <td><input type="text" readonly value="${member.tel }"></td>
</tr>

<tr>
  <th>가입일</th>
  <td><input type="text" readonly value="${member.registeredDate }"></td>
</tr>


<tr>
  <th></th>
  <td><button>변경</button><button type="button" onclick="remove();">삭제</button></td>
</tr>

</table>
</form>

<script>
function remove() {
  location.href = "delete?no=${member.no}"; 
}
</script>

</body>
</html>
