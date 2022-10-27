<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 목록 페이지</title>
</head>
<body>

<c:forEach var="v" items="${datas}">
	${v.mid} | ${v.mpw} <br>
</c:forEach>

</body>
</html>