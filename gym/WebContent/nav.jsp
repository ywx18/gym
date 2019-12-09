<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<nav class="navbar navbar-default navbar-static-top" role="navigation">
	<div class="container-fluid"> 
    <div class="navbar-header">
        <a class="navbar-brand" href="#">헬스장 관리 시스템</a>
    </div>
    <div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">사용자 :${sessionScope.username}</a></li>
            
            <li><a href="exit.jsp">로그아웃을</a></li>
        </ul>
    </div>
	</div>
</nav>