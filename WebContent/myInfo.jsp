<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
			<div class="col-lg-6">
				<div class="card">
					<div class="card-header">我的资料</div>
					<div class="card-body">
						<div>
							<div class="row">
								<div class="col-lg-8">
									<p>用户名：${user.username}</p>
									<p>性别：${user.sex}</p>
									<p>年龄阶段：${user.age}</p>
									<p>签名：${user.sign}</p>
									<p>注册时间：${user.regTime}</p>
									<p>ip：${user.ip}</p>
									<p>我是：${user.kplCn}</p>
									<c:if test="${user.kpl==true}">
										<a type="button" class="btn btn-info"
											href="InvalidUser?id=${user.id}">改成pl</a>
									</c:if>
									<c:if test="${!user.kpl==true}">
										<a type="button" class="btn btn-success"
											href="RestoreUser?id=${user.id}">改成kp</a>
									</c:if>
								</div>
							</div>
						</div>

					</div>
				</div>

			</div>
			<%@include file="rg.jsp"%>
		</div>
	</div>
</body>
</html>
