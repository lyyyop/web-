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
					<div class="card-header">用户信息</div>
					<div class="card-body">
						<div>
							<h2>用户信息如下：</h2>
							<div class="row">
								<div class="col-lg-8">
									<p>用户名：${user.username}</p>
									<p>性别：${user.sex}</p>
									<p>年龄阶段：${user.age}</p>
									<p>签名：${user.sign}</p>
									<p>kp/pl：${user.kplCn}</p>
									<c:if test="${!user.kpl==true}">
									<a class="btn btn-primary" href="AllPc2?username=${user.username}" role="button">查看其角色卡</a>									
									</c:if>
									<p>
									<a class="btn btn-primary" href="Message" role="button">私信</a>
									<p>
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
