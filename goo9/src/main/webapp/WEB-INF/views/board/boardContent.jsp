<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  --%>



<!DOCTYPE html>

<html>

<head>
<style>
  table {
    width: 100%;
    max-width: 1280px;
    border-top: 1px solid black;
    border-collapse: collapse;
  }
  th, td {
    border-bottom: 1px solid black;
    border-left: 1px solid black;
    padding: 10px;
  }
  th:first-child, td:first-child {
    border-left: none;
  }
</style>

<meta charset="UTF-8">



<title>board</title>

</head>

<body>

	<article>

		<div class="container" role="main ">

			<h2>board Content</h2>



			<div class="bg-white rounded shadow-sm">
			
				<div class="board_bid">
					<c:out value="${boardContent.bid}" />
				</div>

				<div class="board_title">
					<c:out value="${boardContent.title}" />
				</div>

				<div class="board_info_author">

					<span class="board_author">
						<c:out value="${boardContent.reg_id}" />
					</span>
				</div>
				<div class="board_info_date">	
					<span class="board_date">
						<c:out value="${boardContent.reg_dt}" />
					</span>
				</div>
				<div class="board_view_count">
					<span class="board_viewcont">
						<c:out value="${boardContent.view_cnt}"></c:out>
					</span>
				</div>

				<div class="board_content">${boardContent.content}</div>
<%-- 
				<div class="board_tag">
					TAG :
					<c:out value="${boardContent.tag}" />
				</div> --%>

			</div>



			<div style="margin-top: 20px">
			 	<form action="${pageContext.request.contextPath}/board/updateForm.do">
			 	<input type = "text" name = "bid" value="${boardContent.bid}" hidden="false" /> 
				<button type="submit" class="btn btn-sm btn-primary" id="btnUpdate">수정</button>
				</form>
		<form action="${pageContext.request.contextPath}/board/deleteForm.do">
				<%-- <c:if test="${sessionScope.userId eq ${boardContent.reg_id}}"> --%>
				<input type = "text" name = "bid" value="${boardContent.bid}" hidden="false" /> 
				<button type="submit" class="btn btn-sm btn-primary" id="btnDelete">삭제</button>
				
		</form>

				<button type="button" class="btn btn-sm btn-primary" id="btnList" onclick="location.href='${pageContext.request.contextPath}/board/getBoardList.do'">목록</button>
			</div>

			<!-- Reply Form {s} -->

			<!-- Reply Form {e} -->



			<!-- Reply List {s}-->

			<div class="my-3 p-3 bg-white rounded shadow-sm"
				style="padding-top: 10px">

				<h2 class="border-bottom pb-2 mb-0">댓글</h2>

				<div id="replyList"></div>

			</div>

			<!-- Reply List {e}-->
			<table>
				<thead>
					<tr>
						<th>내용</th>
						<th>작성자</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list" items="${replyVO}">
		
						<tr>
				
							<td><c:out value="${list.content}" /></td>
		
							<td><c:out value="${list.reg_id}" /></td>
							
							<td><c:out value="${list.reg_dt}" /></td>
		
						</tr>
		
					</c:forEach>
				</tbody>
			</table>

		</div>



	</article>


</body>

</html>