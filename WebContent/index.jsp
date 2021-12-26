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
		<div id="carouselExampleIndicators" class="carousel slide" align="center"
				data-ride="carousel" >
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleIndicators" data-slide-to="0"
						class="active"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="photo/2.jpg" class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item">
						<img src="photo/3.jpg" class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item">
						<img src="photo/4.jpg" class="d-block w-100" alt="...">
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleIndicators"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		<!-- 内容  -->
		<div class="row" style="margin-top: 10px">
			
			<%@include file="lf.jsp"%>
			<div class="col-lg-6">
				<div class="jumbotron">
					<p style="color: green">${info}</p>
					<h1 class="display-4">OneDice</h1>
					<br />
					<p class="lead">
						（小型跑团交友网站）<br />
					</p>
					<hr class="my-4">
					<p>欢迎来玩！</p>
					<c:if test="${username==null}">
					<a class="btn btn-primary btn-lg" href="login.jsp" role="button">登录</a>
					</c:if>
				</div>
			</div>
			<%@include file="rg.jsp"%>
		</div>

	</div>


</body>
</html>