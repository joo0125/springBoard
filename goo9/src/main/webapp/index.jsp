<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>board</title>

</head>

<body>

<h2>board list</h2>

	<table>

		<colgroup>

			<col style="width:5%;" />

			<col style="width:auto;" />

			<col style="width:15%;" />

			<col style="width:10%;" />

			<col style="width:10%;" />

		</colgroup>

		<thead>

			<tr>

				<th>NO</th>

				<th>글제목</th>

				<th>작성자</th>

				<th>조회수</th>

				<th>작성일</th>

			</tr>

		</thead>

		<tbody>

					<c:forEach var="list" items="${boardList}">

						<tr>

							<td><c:out value="${list.bid}"/></td>

							<td><c:out value="${list.title}"/></td>

							<td><c:out value="${list.reg_id}"/></td>

							<td><c:out value="${list.view_cnt}"/></td>

							<td><c:out value="${list.reg_dt}"/></td>

						</tr>

					</c:forEach>

		</tbody>

	</table>
</body>

</html>