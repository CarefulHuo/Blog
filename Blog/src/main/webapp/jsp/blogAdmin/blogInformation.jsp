<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://hwy.pager-tags"  prefix="hwy"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge , chrome=1">
	<title>后台管理</title>
	<link rel="shortcut icon" type="image/ico" href="https://images-tomcat.oss-cn-hongkong.aliyuncs.com/favicon.ico"/>  
    <link rel="bookmark" href="https://images-tomcat.oss-cn-hongkong.aliyuncs.com/favicon.ico"/>  
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap-select.min.css">
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
	<!-- 页面部分 -->
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
		<div class="col-sm-10">
		    <div class="panle panel-success">
				<h2 class="">${blog.b_title }</h2>
				<a class="pull-right panel-title col-lg-1" href="${pageContext.request.contextPath}/blogAdmin/findNodifyBlog.action?blogId=${blog.b_id}">修改</a>
				<a class="pull-right panel-title col-lg-1" href="${pageContext.request.contextPath}/blogAdmin/deleteBlog.action?blog_Id=${blog.b_id}">删除</a>
				<a class="pull-right panel-title col-lg-1" href="${pageContext.request.contextPath }/blogAdmin/findBlog.action">返回</a>
			</div>	
            <hr>
          <div class="row-fluid">
            <div class="col-md-12">
              <p>
              	${blog.b_content}
              </p>
             </div>
          </div>
         </div><!--/span-->
	</div>
<script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath }/js/bootstrap-select.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/xheditor.js" type="text/javascript" ></script> 
<script src="${pageContext.request.contextPath }/xheditor_lang/zh-cn.js" type="text/javascript" ></script> 
</body>
</html>