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
		<!-- 内容  -->
		<div class="row" style="margin-top: 10px">
			<%@include file="lf.jsp"%>
			<div class="col-lg-6">
				<form method="post" action="ReplyAction" enctype="multipart/form-data">
					<div class="card">
						<div class="card-header">来聊聊吧</div>
						<div class="card-body">
							<table class="table">
								<tbody>
									<c:forEach items="${chatList}" var="chat" varStatus="i">
										<tr>
											<th scope="row">${i.count}</th>
											<td><a type="button" href="Info?username=${chat.user}">${chat.user}</a>:</td>
											<td>${chat.content}</td>
											<td>${chat.time}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<nav aria-label="Page navigation example">
							<ul class="pagination">
								<li class="page-item"><a class="page-link" href="Chat?pageNo=1">Previous</a>
								<li class="page-item"><a class="page-link" href="Chat?pageNo=1">1</a>
								<li class="page-item"><a class="page-link" href="Chat?pageNo=2">2</a>
							</ul>
							</nav>
							<p>
								<button class="btn btn-link" type="button"
									data-toggle="collapse" data-target="#collapseExample"
									aria-expanded="false" aria-controls="collapseExample">发表回复</button>
							</p>
							<div class="collapse" id="collapseExample">
								<div class="card card-body">
									<div class="col-sm-12">
									<textarea class="form-control" rows="3" name="content" required></textarea>
								</div>
								<div class="col-sm-12">
								<br>
									<button type="submit" class="btn btn-primary">发布</button>
								</div>
								</div>
							</div>
						</div>
					</div>
				</form>

			</div>
			<%@include file="rg.jsp"%>
		</div>

	</div>


</body>
</html>