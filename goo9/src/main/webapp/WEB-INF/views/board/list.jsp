<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<head>


<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-latest.min.js"></script> 
<title>board</title>

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

<c:choose>
    <c:when test="${sessionScope.userId == null}">
    </c:when>
    <c:otherwise>
        ${sessionScope.userName}님이 로그인중입니다.
    </c:otherwise>
</c:choose>

<script>
	String sId = (String)session.getAttribute("userId");	
</script>


</head>

<body>

 	<c:set var="sId" value="${sId}"/>
 	
 	<c:if test="${sessionScope.userId eq null }">
		<button type="button" onclick="location.href='${pageContext.request.contextPath}/member/login.do'">로그인</button>
		<button type="button" onclick="location.href='${pageContext.request.contextPath}/member/register.do'">회원가입</button>

 	</c:if>
 	
 	<c:if test="${sessionScope.userId ne null}">
		<button type="button" onclick="location.href='${pageContext.request.contextPath}/member/logout.do'">로그아웃</button>			
 	</c:if>
	
	<h2>board list</h2>

	<table>

		<colgroup>

			<col style="width: 5%;" />

			<col style="width: auto;" />

			<col style="width: 15%;" />

			<col style="width: 10%;" />

			<col style="width: 10%;" />

		</colgroup>

		<thead>

			<tr>

				<th>NO</th>

				<th>글제목</th>
				
				<th>내용</th>

				<th>작성자</th>

				<th>조회수</th>

				<th>작성일</th>

			</tr>

		</thead>

		<tbody>

			<c:forEach var="list" items="${boardList}">
				<tr>
					<td><c:out value="${list.bid}" /></td>
					<c:if test="${sessionScope.userId ne null}">
					<td><a href="#"
						onClick="fn_contentView(<c:out value="${list.bid}"/>)"> <c:out
								value="${list.title}" />

					</a></td></c:if>
					
					<td><c:out value="${list.content}" /></td>

					<td><c:out value="${list.reg_id}" /></td>

					<td><c:out value="${list.view_cnt}" /></td>

					<td><c:out value="${list.reg_dt}" /></td>

				</tr>

			</c:forEach>

		</tbody>

	</table>
	<c:if test="${sessionScope.userId ne null}">
		<button type="button" onclick="location.href='${pageContext.request.contextPath}/board/getBoardForm.do'">글쓰기</button>			
 	</c:if>
	<script>

	$(document).on('click', '#btnWriteForm', function(e){

		e.preventDefault();

		

		location.href = "${pageContext.request.contextPath}/board/boardForm";

	});

	

	function fn_contentView(bid){

		var url = "${pageContext.request.contextPath}/board/boardContent.do";

		url = url + "?bid="+bid;

		location.href = url;

	}

</script>

</body>

</html>