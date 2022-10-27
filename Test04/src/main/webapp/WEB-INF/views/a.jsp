<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록 페이지</title>
</head>
<body>

<c:forEach var="v" items="${datas}">
	<a href="e?bid=${v.bid}">${v.bid}</a> | ${v.writer} | ${v.title} | <a href="d?bid=${v.bid}">❌❌❌</a> <br>
</c:forEach>

</body>
</html>