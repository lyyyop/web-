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
						<p style="color: red"></p>
						<form method="post" action="RegAction" enctype="multipart/form-data">
							<div class="form-group row">
								<label for="username" class="col-sm-3 col-form-label">昵称</label>
								<div class="col-sm-9">
									<input type="text" name="username" class="form-control" placeholder="用户名"
									 required pattern="[A-z][0-9]{6-8}">
								</div>
							</div>
							<div class="form-group row">
								<label for="password" class="col-sm-3 col-form-label">密码</label>
								<div class="col-sm-9">
									<input type="password" name="password" class="form-control" placeholder="密码">
								</div>
							</div>
							<div class="form-group row">
								<label for="sex" class="col-sm-3 col-form-label">性别</label>
								<div class="col-sm-9">
									<select class="form-control" name="sex">
										<option value="匿">匿</option>
										<option value="男">男</option>
										<option value="女">女</option>
									</select>
								</div>
							</div>
							<div class="form-group row">
								<label for="age" class="col-sm-3 col-form-label">年龄阶段</label>
								<div class="col-sm-9">
									<select class="form-control" name="age">
										<option value="小学">小学</option>
										<option value="初中">初中</option>
										<option value="高中">高中</option>
										<option value="大学">大学</option>
										<option value="社畜">社畜</option>
										<option value="学前班">学前班(?)</option>
										<option value="反正很忙">反正很忙</option>
									</select>
								</div>
							</div>
							<div class="form-group row">
								<label for="sign" class="col-sm-3 col-form-label">签名</label>
									<div class="col-sm-9">
									<input type="text" name="sign" class="form-control" placeholder="说什么都可以" >
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-10">
									<button type="submit" class="btn btn-primary">注册</button>
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
