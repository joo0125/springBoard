<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인페이지</title>
<%-- <%@ include file="../member/header.jsp" %> --%>

<script src="https://code.jquery.com/jquery-latest.min.js"></script> 
 <script>
    $(document).ready(function(){
        $("#btnLogin").click(function(){
            // 태크.val() : 태그에 입력된 값
            // 태크.val("값") : 태그의 값을 변경 
            var userId = $("#userId").val();
            var userPw = $("#userPw").val();
            if(userId == ""){
                alert("아이디를 입력하세요.");
                $("#userId").focus(); // 입력포커스 이동
                return; // 함수 종료
            }
		     if(userPw == ""){
		         alert("비밀번호를 입력하세요.");
		   	     $("#userPw").focus();
		     return;   
            }

		     	
            // 폼 내부의 데이터를 전송할 주소
            document.form1.action="http://localhost:8080/goo9/member/loginCheck.do"
            // 제출
            document.form1.submit();
        });
    });
 
</script>

</head>

<body>
<%--  <%@ include file="../include/menu.jsp" %> --%>
<h2>로그인</h2>
    <form name="form1" method="post">
        <table border="1" width="400px">
            <tr>
                <td>아이디</td>
                <td><input name="userId" id="userId"></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="userPw" id="userPw"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="button" id="btnLogin">로그인</button>
               
                </td>
            </tr>
        </table>
    </form>
   
</body>
</html>
