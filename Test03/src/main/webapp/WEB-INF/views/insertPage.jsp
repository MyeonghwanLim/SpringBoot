<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작성 페이지</title>
</head>
<body>
<%
	String contextPath=request.getContextPath();
%>
<form action="<%=contextPath%>/insert" method="post">
	작성자: <input type="text" name="writer" value="${dto.writer}"> <br>
	내용: <input type="text" name="content" value="${dto.content}"> <br>
	<input type="submit" value="글 작성하기">
</form>

</body>
</html>