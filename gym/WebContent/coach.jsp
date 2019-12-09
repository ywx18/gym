<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<%@include file="head.jsp" %>
<body style="width: 100%; overflow: hidden;">

<%@include file="nav.jsp" %>

<div align="center" style="padding-top: 20px;" class="row">
                
           <%@include file="menu.jsp" %>
           
              <div class="col-md-10">
                <div class="panel panel-default ">
	              <div class="panel-heading">코치 기본 정보</div>
	              
	               <div class="panel-body">
	                  <table class="table table-bordered">
						<caption>코치 기본 정보</caption>
						<thead>
							<tr>
								<th>코치id</th>
								<th>성명</th>
								<th>성별</th>
								<th>나이</th>
								<th>전화번호</th>
								<th>담당 과정</th>
								<th>편집</th>
								<th>삭제</th>
							</tr>
						</thead>
						<tbody>
						    <c:forEach items="${coachList}" var="coach">
								<tr>
									<td>${coach.id }</td>
									<td>${coach.name }</td>
									<td>${coach.sex==0 ? "남자":"여자" }</td>
									<td>${coach.age }</td>
									<td>${coach.phone }</td>
									<td>${coach.teach }</td>
									<td><a href="Coach?action=addedit&type=edit&id=${coach.id }">편집</a></td>
									<td><a href="Coach?action=delete&id=${coach.id }">삭제</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
	               </div>
               </div>
             </div>
</div>

<%@include file="footer.jsp" %>
</body>
</html>