<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">

//비밀글로 작성자만 볼 수 있습니다.



</script>
</head>
<body>
<span>Q & A 상품문의 <b>(총 n건)</b></span>
<br>

<select name="item_name">
	<option value="" selected="selected">전체 상품문의</option>
	<c:forTokens var="size" items="${askdto.item_name }" delims=",">
		<option value="${item_name }">${item_name }</option>
	</c:forTokens>
</select>

<table>
	<tr>
		<th>번호</th>
		<th>답변여부</th>
		<th>구분</th>
		<th>내용</th>
		<th>작성자</th>
		<th>등록일자</th>
		
		<%//관리자만 볼 수 있음 %>
		<th>삭제</th>
		<% %>
		
	</tr>
	
	<% %>
	<tr>
		<td>번호</td>
		<td>답변여부<% //0 답변예정 or 1답변완료 %></td>
		<td>구분</td>
		<td>내용</td>
		<td>작성자</td>
		<td>등록일자</td>
		<%//관리자만 볼 수 있음 %>
		<th>삭제</th>
		<% %>
		
	</tr>
	<% %>
	
	
	
	
	
	<tr>
		<td> 1/n 페이지</td>
	</tr>
	<tr>
		<td>
			페이지처리
		</td>
	</tr>
</table>
<input type="button" value="작성하기" onclick="window.open('./AskWrite.qa','문의사항 작성','width=550,height=700,location=no,status=no,scrollbars=yes');">
</body>
</html>