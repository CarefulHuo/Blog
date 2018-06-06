<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 导航栏部分-->
	<div class="navbar navbar-inverse">
		 <div class="container-fluid">
		 	<div class="navbar-header">
		 		<div class="navbar-brand">
		 			<small class="glyphicon glyphicon-fire"></small>
		 			小布丁博客后台管理
		 		</div>
		 	</div>
		 	<ul class="nav navbar-nav nav-stacked navbar-right">
		 		<li>
		 			<a href="#" class="dropdown-toggle" data-toggle="dropdown" id="dropdownMenu">
		 				<small>欢迎您</small>
		 				${login_user.b_name}
						<span class="caret"></span>
		 			</a>
			 		<ul class="nav nav-pills nav-stacked dropdown-menu" aria-labelledby="dropdownMenu">
			 			<li class="active">
			 				<a href="#" >
			 					<span class="glyphicon glyphicon-cog"></span>用户设置				
			 				</a>
			 			</li>
			 			<li class="divider"></li>
			 			<li>
			 				<a href="#" >
			 					<span class="glyphicon glyphicon-user"></span>用户信息				
			 				</a>	
			 			</li>
			 			<li class="divider"></li>
			 			<li>
			 				<a href="${pageContext.request.contextPath }/blogAdmin/loginOut.action" >
			 					<span class="glyphicon glyphicon-off"></span>退出				
			 				</a>	
			 			</li>
			 		</ul>
		 		</li>
		 	</ul>
		 </div>
	</div>
</body>
</html>