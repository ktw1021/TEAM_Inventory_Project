<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>지점 관리 시스템</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/branches.css'/>">
</head>

<body>
	<%@ include file="/WEB-INF/views/branch_includes/navigation.jsp"%>
	<div class="content">
		<h1>출고 번호: ${outId }</h1>
		<table border="1">
			<tr>
				<th>출고일</th>
				<th>교재 코드</th>
				<th>교재명</th>
				<th>수량</th>
				<th>사유</th>
			</tr>
					
			<c:forEach items="${list }" var="vo">
				<tr>
					<td>${vo.flucDate}</td>
					<td>${vo.bookCode}</td>
					<td>${vo.bookName}</td>
					<td>${vo.quantity}</td>

           			<td>${vo.comments}</td>
				</tr>
			</c:forEach>
		</table>
		<p class="parent"><a href ="<c:url value="/branch/stockout/list"/>">목록으로 돌아가기</a></p>
	</div>
	<%@ include file="/WEB-INF/views/branch_includes/footer.jsp"%>
</body>
</html>