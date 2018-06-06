<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
	<style type="text/css">  
    .btnCode {  
        background: transparent url(${pageContext.request.contextPath }/img/insert.png) no-repeat 0px 0px;  
        background-position: 3px -2px;  
    }  
</style>  
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
				<div class="panel-heading">
					<a class="panel-title">编写博客</a>
				</div>
			</div>
			<form action="${pageContext.request.contextPath }/blogAdmin/nodifyBlog.action?id=${blog.b_id}" method="post" role="form">
				<hr>
				<div class="form-group">
				<select  class="from-control selectpicker select-danger" name="b_category">
				  <c:forEach items="${categorys }" var="category">
					<c:if test="${category.c_id == blog.b_category }">
						<option value="${category.c_id }">${category.c_name }</option>
				  	</c:if>
				  </c:forEach>
				  <c:forEach items="${categorys }" var="category">
					<c:if test="${category.c_id != blog.b_category }">
						<option value="${category.c_id }">${category.c_name }</option>
				  	</c:if>
				  </c:forEach>
			    </select>
			    &nbsp;&nbsp;&nbsp;&nbsp;
				<select  class="from-control selectpicker select-danger" name="b_label">
				  <c:forEach items="${labels }" var="label">
					<c:if test="${label.labelId == blog.b_label }">
						<option value="${label.labelId }">${label.labelName }</option>
				  	</c:if>
				  </c:forEach>
				  <c:forEach items="${labels }" var="label">
					<c:if test="${label.labelId != blog.b_label }">
						<option value="${label.labelId }">${label.labelName }</option>
				  	</c:if>
				  </c:forEach>
			    </select>
				</div>
				<hr>
				<div class="form-group">
					<h4  id="basic-addon">标题</h4>
					<input class="col-lg col-lg-9" aria-describaday="basic-addon" type="username" name="b_title" value="${blog.b_title }">
				</div>
				<hr>
				<hr>
				<textarea name="b_content" id="blog">${blog.b_content }</textarea>
			   <input type="submit" class="panel-title" name="tijiao">
			</form>
		</div> 
	</div>
<script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath }/js/bootstrap-select.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/xheditor.js" type="text/javascript" ></script> 
<script src="${pageContext.request.contextPath }/xheditor_lang/zh-cn.js" type="text/javascript" ></script> 
<script type="text/javascript">  
      $(function(){  
       var plugins={  
        Code:{c:'btnCode',t:'插入代码',h:1,e:function(){  
            var _this=this;  
            var htmlCode="<div>编程语言<select id='xheCodeType'>";  
                htmlCode+="<option value='html'>HTML/XML</option>";  
                htmlCode+="<option value='js'>Javascript</option>";  
                htmlCode+="<option value='css'>CSS</option>";  
                htmlCode+="<option value='php'>PHP</option>";  
                htmlCode+="<option value='java'>Java</option>";  
                htmlCode+="<option value='py'>Python</option>";  
                htmlCode+="<option value='pl'>Perl</option>";  
                htmlCode+="<option value='rb'>Ruby</option>";  
                htmlCode+="<option value='cs'>C#</option>";  
                htmlCode+="<option value='c'>C++/C</option>";  
                htmlCode+="<option value='vb'>VB/ASP</option>";  
                htmlCode+="<option value=''>其它</option>";  
                htmlCode+="</select></div><div>";  
                htmlCode+="<textarea id='xheCodeValue' wrap='soft' spellcheck='false' style='width:300px;height:100px;' />";  
                htmlCode+="</div><div style='text-align:right;'><input type='button' id='xheSave' value='确定' /></div>";           
            var jCode=$(htmlCode),jType=$('#xheCodeType',jCode),jValue=$('#xheCodeValue',jCode),jSave=$('#xheSave',jCode);  
            jSave.click(function(){  
                _this.loadBookmark();  
                _this.pasteHTML('<pre class="brush: '+jType.val()+'">'+_this.domEncode(jValue.val())+'</pre> ');  
                _this.hidePanel();  
                return false;     
            });  
            _this.saveBookmark();  
            _this.showDialog(jCode);  
        }},  
              
        };  
        $('#blog').xheditor({  
        	tools:'full',skin:'default',
        	width:841,
            height:400,
        	plugins:plugins,//使用我们定义的插件    
            loadCSS:'<style>pre{margin-left:2em;border-left:3px solid #CCC;padding:0 1em;}</style>',  
        });  
    })  
</script> 
</body>
</html>