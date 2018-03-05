<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商户信息</title>
<!-- <script type="text/javascript" src="./pay/web/js/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="../resources/bootstrap-3.3.7.js"></script>
<link rel="stylesheet" type="text/css" href="../resources/bootstrap-3.3.7.css">
 -->
 

<link rel="stylesheet" type="text/css" href="/party_building/resources/login.css">
 <link rel="stylesheet" type="text/css" href="/party_building/resources/main.css">

<script type="text/javascript">
</script>
</head>
<body>
<%@ include file="../CommonHeader.jsp"%>
<div class="page">
	<div class="c1003">
		<div class="container">
			<div class="row">
			
			<!-- 主内容 -->
				<div class="col-md-10">
					<div class="content">
						<div class="container white">
							<div class="row">
								<div class="col-md-12">
									<!-- 账户信息 -->
									<div class="row bdbottom">
										<div class="seg">
											<h4>商户信息</h4>
											<table class="table actable">
											  <tbody>
											    <tr>
											      <td>商户名称</td>
											      <td>${merchantInfo.name }</td>
											      <td><a href="${pageContext.request.contextPath}/toEditMerchantInfo.do">修改商户信息</a></td>
											    </tr>
											     <tr>
											    <td>商户位置</td>
											    <td>${merchantInfo.location}</td>
											    </tr>
											     <tr>
											    <td>商户简介</td>
											    <td>${merchantInfo.introduction}</td>
											    </tr>
											    <tr>
											    <td>商户状态</td>
											    <td>${merchantInfo.status }</td>
											    </tr>
											  </tbody>
											</table>
										</div>
									</div>
									<!-- 客户信息 -->
									<div class="row bdbottom">
										<div class="seg">
											<h4></h4>
											<table class="table actable">
											  <tbody>
											    <tr>
											      <td>操作用户</td>
											      <td>${merchantInfo.username}</td>
											    </tr>
											    <tr>
											      <td>操作员</td>
											      <td>${merchantInfo.realname}</td>
											    </tr>
											    <tr>
											      <td>手机号</td>
											      <td>${merchantInfo.mobile}</td>
											      <td></td>
											    </tr>
											    
											  </tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>