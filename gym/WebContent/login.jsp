<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/login.css" />
<title>사용자 등록-헬스장 관리 시스템</title>
</head>
<body>

<div id="header">
	<div class="header_title">
		<span class="title_con">헬스장 관리 시스템</span>
	</div>
</div>

<div id="content">
    <form action="Login" method="post">
	<center>
		<div class="con">
		<div class="con_title">
			<span class="con_title_sp">헬스장 관리 시스템</span>
		</div>
		<div class="con_panel">
			<div class="con_input">
				<span>사용자：</span><input type="text" placeholder="사용자" name="username"/>
			</div>
			<div class="con_input">
				<span>비밀번호：</span><input type="password" placeholder="비밀번호" name="password"/>
			</div>
			 <div class="well well-sm" style="text-align:center;">
                
                <input type="radio" name="role" value="0" checked/> 관리자
               
            </div>
			<input type="submit" value="로그인" class="submit-btn"/>
		</div>
	</div>
	</center>
	</form>
</div>

<div id="footer">
	<center>
		헬스장 관리 시스템
	</center>
</div>

</body>
</html>