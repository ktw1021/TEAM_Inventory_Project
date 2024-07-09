<%@ page language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 리스트</title>

</head>
<body>
	<div id="container">
		<div id="wrapper">
			<div id="content">
				<h1>User List</h1>
				<p>유저리스트</p>
				<table border="1">
					<tr>
						<th>번호</th>
						<th>이름</th>
						<th>지점 번호</th>
						<th>auth code</th>
					</tr>
					
					<c:forEach items="${list }" var="vo">
						<tr>
							<td>${vo.no }</td>
							<td>${vo.name }</td>
							<td>${vo.branchId }</td>
							<td>${vo.authCode }</td>
						</tr>
					</c:forEach>
				</table>
				<a href="<c:url value="/admins"/>">admin 홈으로 돌아가기</a>
			</div>
		</div>
	</div>
</body>
</html>