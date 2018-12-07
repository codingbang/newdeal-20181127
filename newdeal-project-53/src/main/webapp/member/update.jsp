<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<meta http-equiv="Refresh" content="1;url=list">
<title>회원</title>
</head>
<body>
<h1>회원 삭제</h1>

<c:choose>
  <c:when test="${count == 0 }">
    <script>
      location.href = "/member/login";
    </script>
  </c:when>
  <c:when test="${count == -1 }">
    <p>로그인정보와 일치하지 않아 수정 불가능</p>
  </c:when>
  <c:when test="${count == -2 }">
    <script>
      location.href = "/auth/login";
    </script>
  </c:when>
  <c:otherwise>
    <p>수정을 완료하였습니다.</p>
  </c:otherwise>
</c:choose>

</body>
</html>
