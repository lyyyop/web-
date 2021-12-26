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
					<div class="card-header">用户注册</div>
					<div class="card-body">
						<div>
							<div class="row">
								<div class="col-lg-8">
									<p>用户名：${username}</p>
									<p>性别：${sex}</p>
									<p>年龄阶段：${age}</p>
									<p>签名：${sign}</p>
									<p>注册时间：${regTime}</p>
									<p>ip：${ip}</p>
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
