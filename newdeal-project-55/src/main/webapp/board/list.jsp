<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>게시물</title>
</head>
<body>
<jsp:include page="/header.jsp" />
<h1>게시글</h1>
<a href="form"><button>새 글</button></a>
<table border='1'>
<tr>
  <th>번호</th><th>내용</th><th>작성일</th><th>조회수</th>
</tr>
<!-- ${list} 즉 Scope를 정해주지 않으면 순차적으로 각 영역에서 찾음 -->
<c:forEach items="${requestScope.list }" var="board">
<tr>
  <!-- board.no - Object Graph Navigation Language -->
  <!-- Expression Language 안에 OGNL 표기법 사용 -->
  <td>${board.no }</td>
  <td><a href="detail?no=${board.no}">${board.contents }</a></td>
  <td>${board.createdDate }</td>
  <td>${board.viewCount }</td>
</tr>
</c:forEach>
</table>
</body>
</html>
