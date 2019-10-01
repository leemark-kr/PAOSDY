<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function value_check() {
	if(!document.ask_form.category.value){
		alert("구분을 선택해주세요.");
		return false;
	}
	if(document.ask_form.category.selectedIndex==0){
		alert("문의 사항을 입력해주세요.");
		return false;
	}
	if(!document.ask_form.title.value){
		document.ask_form.value="상품 관련 문의 입니다.";
	}
}

//이미지만 업로드 가능
function chk_file_type(obj) {
	var ask_file_kind = obj.value.lastIndexOf('.');
	var ask_file_name = obj.value.substring(file_kind+1,obj.length);
	var ask_file_type = ask_file_name.toLowerCase();

	var ask_check_file_type = new Array();​
	 
	ask_check_file_type = ['jpg','gif','png','jpeg','bmp'];
	 
	if(ask_check_file_type.indexOf(file_type)==-1){
	  alert('이미지 파일만 선택할 수 있습니다.');
	  var parent_Obj=obj.parentNode
	  var node=parent_Obj.replaceChild(obj.cloneNode(true),obj);
	  return false;
	 }
}
</script>
</head>
<body>
<h1>PRODUCT Q & A</h1>
<table>
	<tr>
		<td rowspan="2">이미지 <img alt="" src=""></td>
		<td>상품명  <% %></td>
	</tr>
	<tr>
		<td>가격 <% %></td>
	</tr>
</table>
<form action="./AskWriteAction.qa" method="post" name="ask_form" onsubmit="return value_check();">
구분  
<select>
	<option name="ask_category">문의사항 선택</option>
	<option name="ask_category" value="크기">크기</option>
	<option name="ask_category" value="배송">배송</option>
	<option name="ask_category" value="교환">교환</option>
	<option name="ask_category" value="환불">환불</option>
	<option name="ask_category" value="취소">취소</option>
	<option name="ask_category" value="주문결제">주문결제</option>
	<option name="ask_category" value="상품/재입고">상품/재입고</option>
	<option name="ask_category" value="적립금">적립금</option>
	<option name="ask_category" value="회원 관련">회원 관련</option>
	<option name="ask_category" value="기타문의">기타문의</option>
</select>
<br><br>
제목 <input type="text" name="ask_title" placeholder="15자 이내 입력" value="">
	
	<label><input type="checkbox" name="open" value="1">비밀글</label>

<br><br>
내용<br>
<textarea rows="10" cols="70" placeholder="문의사항을 입력해주세요."></textarea>
<br><br>
<input type="file" name="ask_file" accept='image/jpeg,image/gif,image/png' onchange='chk_file_type(this)'>
<br><br>
개인정보보호와 관련된 피해를 방지하기 위해 주민번호, 이메일, 연락처, 계좌번호 등의 개인정보와 관련된 내용의 기입은 삼가해 주시기 바랍니다. 확인 시 비밀글 전환이 될 수 있으며, 관련 피해는 binu에서 책임지지 않습니다.
<br><br>
＊용량이 2MB를 넘는 이미지는 업로드가 되지 않습니다.<br>
＊파일명이 한/영문,숫자를 제외한 특수문자, 공백이나 다른 나라 언어가 있을 경우 첨부가 불가능합니다.<br>
<input type="submit" value="등록하기">
<input type="reset" value="다시쓰기">
</form>
</body>
</html>