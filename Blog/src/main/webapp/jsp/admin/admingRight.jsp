<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="row">
		<div class="col-sm-2">
			<div id="search">
				<div class="input-group">
					<input class="form-control input-s" type="text" name="context">
					<div class="input-group-btn">
						<a href="#" class="btn btn-success btn-sm">
							<span class="glyphicon glyphicon-search"></span>		
						</a>
					</div>
				</div>	
			</div>
			<div class="panel-group" id="box">
				<div class="panel panel-success">
					<div class="panel-heading">
						<a href="#collapseA" data-parent="#box" data-toggle="collapse" class="panel-title">
						 用户管理</a>
					</div>
					<div class="panel-collapse collapse in" id="collapseA">
						<div class="panel-body">
							<ul class="nav nav-pills nav-stacked">
								<li><a href="#">用户列表</a></li>
								<li><a href="#">用户添加</a></li>
							</ul>	
						</div>
					</div>
				</div>
				<div class="panel panel-success">
					<div class="panel-heading">
						<a href="#collapseB" data-parent="#box" data-toggle="collapse" class="panel-title">
						 博客管理</a>
					</div>
					<div class="panel-collapse collapse" id="collapseB">
						<ul class="nav nav-pills nav-stacked">
								<li><a href="${pageContext.request.contextPath }/blogAdmin/findBlog.action">博客列表</a></li>
								<li><a href="${pageContext.request.contextPath }/blogAdmin/addBlog.action">编写博客</a></li>
						</ul>	
					</div>
				</div>
			</div>
		</div>
</body>
</html>