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
					<div class="card-header">添加角色卡</div>
					<div class="card-body">
						<form method="post" action="AddAction" enctype="multipart/form-data">
							<div class="form-group row">
								<label for="name" class="col-sm-3 col-form-label">pc名</label>
								<div class="col-sm-9">
									<input type="text" name="name" class="form-control">
								</div>
							</div>
							<div class="form-group row">
								<label for="sex" class="col-sm-3 col-form-label">性别</label>
								<div class="col-sm-9">
									<select class="form-control" name="sex">
										<option value="男">男</option>
										<option value="女">女</option>
										<option value="呃">呃</option>
									</select>
								</div>
							</div>
							<div class="form-group row">
								<label for="age" class="col-sm-3 col-form-label">年龄</label>
								<div class="col-sm-9">
									<input type="text" name="age" class="form-control">
								</div>
							</div>
							<div class="form-group row">
								<label for="major" class="col-sm-3 col-form-label">职业</label>
								<div class="col-sm-9">
									<input type="text" name="major" class="form-control">
								</div>
							</div>
							<div class="form-group row">
								<label for="sum" class="col-sm-3 col-form-label">总点数</label>
								<div class="col-sm-9">
									<input type="text" name="sum" class="form-control" required
										pattern="{0-9}">
								</div>
							</div>
							<div class="form-group row">
								<label for="exp" class="col-sm-3 col-form-label">经历模组</label>
								<div class="col-sm-9">
									<input type="text" name="exp" class="form-control" >
								</div>
							</div>
							<div class="form-group row">
								<label for="now" class="col-sm-3 col-form-label">目前状态</label>
								<div class="col-sm-9">
									<input type="text" name="now" class="form-control" placeholder="他们最后都疯了或者死了">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-10">
									<button type="submit" class="btn btn-primary">添加</button>
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
