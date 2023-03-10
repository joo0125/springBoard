<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">


<!-- jQuery -->

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>



<!-- Bootstrap CSS -->

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">



<title>board</title>

<style>

body {

  padding-top: 70px;

  padding-bottom: 30px;

}



</style>

</head>

<body>

	<article>

		<div class="container" role="main">

			<h2>board Form</h2>

			<form name="updateForm" id="form" role="form" method="post" action="${pageContext.request.contextPath}/board/saveUpdate.do">

				<div class="mb-3">

					<label for="title">제목</label>

					<input value='<c:out value="${boardContent.title}"/>' type="text" class="form-control" name="title" id="title">

				</div>

				

				<div class="mb-3">

					<label for="reg_id">작성자</label>

					<input value="${sessionScope.userName}" type="text" class="form-control" name="reg_id" id="reg_id" readonly >

				</div>

				
 
				<div class="mb-3">

					<label for="content">내용</label>

					<input  value='<c:out value="${boardContent.content}"/>' class="form-control" rows="5" name="content" id="content" placeholder="내용을 입력해 주세요" ></input>

				</div>

			</form>

			<div >

				<button type="button" class="btn btn-sm btn-primary" id="btnSave" onclick="location.href='${pageContext.request.contextPath}/board/saveupdate.do'">저장</button>

				<button type="button" class="btn btn-sm btn-primary" id="btnList" onclick="location.href='${pageContext.request.contextPath}/board/getBoardList.do'">목록</button>

			</div>

		</div>

	</article>

</body>

</html>