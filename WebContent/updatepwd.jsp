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
		<!-- 导航条 -->
		<%@include file="nav.jsp"%>
		<div class="row" style="margin-top: 10px">
			<%@include file="lf.jsp"%>
			<div class="col-lg-6">
				<div class="card">
					<div class="card-header">修改密码</div>
					<div class="card-body">
						
						<p style="color:red">${info}</p>

						<form method="post" action="UpdatePwd">
							<div class="form-group row">
								<label for="inputEmail3" class="col-sm-3 col-form-label">用户名</label>
								<div class="col-sm-9">
									<input type="text" name="username" class="form-control" id="inputEmail3"
										placeholder="用户名">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputPassword3" class="col-sm-3 col-form-label">原密码</label>
								<div class="col-sm-9">
									<input type="password" name="oldPwd" class="form-control" id="inputPassword3"
										placeholder="旧密码">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputPassword3" class="col-sm-3 col-form-label">新密码</label>
								<div class="col-sm-9">
									<input type="password" name="newPwd" class="form-control" id="inputPassword3"
									placeholder="新密码">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputPassword3" class="col-sm-3 col-form-label">校验码</label>
								<div class="col-sm-5">
									<input type="text" name="code" class="form-control" id="inputPassword3"
									placeholder="请输入">
								</div>
								<div class="col-sm-4">
									<img src="VerCode"onclick="this.src='VerCode?'+Math.random()">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-10">
									<button type="submit" class="btn btn-primary">确认修改</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<%@include file="rg.jsp"%>
		</div>

	</div>


</body>
</html>