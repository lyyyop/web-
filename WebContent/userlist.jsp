<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<%@include file="bt.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="nav.jsp"%>
		<div class="row" style="margin-top: 10px">
			<%@include file="lf.jsp"%>
			<div class="col-lg-9">
				<div class="card">
					<div class="card-header">查询结果如下</div>
					<div class="card-body">
						<table class="table">
							<thead class="thead-dark">
								<tr>
									<th scope="col">序号</th>
									<th scope="col">用户名</th>
									<th scope="col">性别</th>
									<th scope="col">年龄段</th>
									<th scope="col">kp/pl</th>
									<th scope="col">签名</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${userList}" var="user" varStatus="i">
									<tr>
										<th scope="row">${i.count}</th>
										<td><a type="button" href="Info?username=${user.username}">${user.username}</a></td>
										<td>${user.sex}</td>
										<td>${user.age}</td>
										<td>${user.kplCn}</td>
										<td>${user.sign}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
