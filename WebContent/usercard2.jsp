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
					<div class="card-header">角色卡</div>
					<div class="card-body">
						<table class="table">
							<thead class="thead-dark">
								<tr>
									<th scope="col">序号</th>
									<th scope="col">PC名</th>
									<th scope="col">性别</th>
									<th scope="col">年龄</th>
									<th scope="col">职业</th>
									<th scope="col">总点数</th>
									<th scope="col">经历的模组</th>
									<th scope="col">目前状态</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${pcList}" var="pc" varStatus="i">
									<tr>
										<th scope="row">${i.count}</th>
										<td>${pc.pcname}</td>
										<td>${pc.sex}</td>
										<td>${pc.age}</td>
										<td>${pc.major}</td>
										<td>${pc.sum}</td>
										<td>${pc.exp}</td>
										<td>${pc.now}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<p></p>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
