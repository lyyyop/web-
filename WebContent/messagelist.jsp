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
				<form method="post" action="SendAction" enctype="multipart/form-data">
					<div class="card">
					<div class="card-header">私信列表</div>
						<div class="card-header"></div>
						<div class="card-body">
							<table class="table">
								<tbody>
									<c:forEach items="${messageList}" var="message" varStatus="i">
										<tr>
											<td><a type="button" href="Message?user1=${message.suser}">${message.suser}</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</form>

			</div>
			<%@include file="rg.jsp"%>
		</div>

	</div>


</body>
</html>