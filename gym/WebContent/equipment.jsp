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
	              <div class="panel-heading">기구 기본 정보</div>
	              
	               <div class="panel-body">
	                  <table class="table table-bordered">
						<caption>기구 기본 정보</caption>
						<thead>
							<tr>
								<th>기구id</th>
								<th>기구이름</th>
								<th>상태</th>
								<th>편집</th>
								<th>삭제</th>
							</tr>
						</thead>
						<tbody>
						    <c:forEach items="${equipmentList}" var="equipment">
								<tr>
									<td>${equipment.id }</td>
									<td>${equipment.name }</td>
									<td>${equipment.states }</td>
									<td><a href="Equipment?action=addedit&type=edit&id=${equipment.id }">편집</a></td>								
									<td><a href="Equipment?action=delete&id=${equipment.id }">삭제</a></td>
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