<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://hwy.pager-tags"  prefix="hwy" %>
<html>
<head>
  <title>Hwy Blog</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="shortcut icon" type="image/ico" href="https://images-tomcat.oss-cn-hongkong.aliyuncs.com/favicon.ico"/>  
  <link rel="bookmark" href="https://images-tomcat.oss-cn-hongkong.aliyuncs.com/favicon.ico"/>  
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/pager.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
</head>
<body>
  <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
       <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#menu">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="${pageContext.request.contextPath}/blogFind/findBlogs.action" class="navbar-brand nav-title">小布丁的博客</a>
            </div>
            <div class="collapse navbar-collapse" id="menu">
                <p class="navbar-text pull-right">
                    在这里 &nbsp;&nbsp;<a href="${pageContext.request.contextPath }/jsp/login.jsp" class="navbar-link">管理</a>
                </p>
                <ul class="nav navbar-nav navbar-left ">
                    <li  class="cative"><a href="${pageContext.request.contextPath}/blogFind/findBlogs.action">网站首页</a> </li>
                    <li  class="cative"><a href="${pageContext.request.contextPath}/blogFind/findStudentNote.action?flag=1&labelId=0">资源分享</a> </li>
                    <li  class="cative"><a href="${pageContext.request.contextPath}/blogFind/findStudentNote.action?flag=2&labelId=0">学习笔记</a> </li>
                    <li  class="cative"><a href="${pageContext.request.contextPath}/blogFind/findStudentNote.action?flag=3&labelId=0">心灵鸡汤</a> </li>
                    <li  class="cative"><a href="${pageContext.request.contextPath}/blogFind/aboutme.action">关于自己</a> </li>
                </ul>
            </div>
      </div>
    </div>

    <div class="container-fluid">
      <div class="row-fluid">
        <div class="col-md-3">
          <div class="well sidebar-nav">
             <div class="widget">
                <!-- 第一个分类 -->
             	<div class="navbar-inner navbar-default">
	             	<div class="navbar-header">
			           <button class="navbar-toggle" data-toggle="collapse" data-target="#erzimenu">
			                <c:forEach items="${labels }" var="labelOne">
			                   <span class="icon-bar"></span>
			                </c:forEach>
			            </button>
			            <span class="navbar-brand nav-title">分类标签</span>
			        </div>
		            <div class="collapse navbar-collapse" id="erzimenu">
		                <br><br>
		                <ul class="nav nav-list">
		                    <c:forEach items="${labels }" var="labelOne">
		                    <li class="active"><a href="${pageContext.request.contextPath }/blogFind/findBlogs.action?labelId=${labelOne.labelId}">${labelOne.labelName }</a></li>
		                    </c:forEach>
		                </ul>
		            </div>
	            </div>
	            <!-- 第二个分类 -->
	            <div class="navbar-inner navbar-default">
		           	<div class="navbar-header">
			            <button class="navbar-toggle" data-toggle="collapse" data-target="#xiaoerzimenu">
			                <span class="icon-bar"></span>
			                <span class="icon-bar"></span>
			                <span class="icon-bar"></span>
			                <span class="icon-bar"></span>
			                <span class="icon-bar"></span>
			                <span class="icon-bar"></span>
			            </button>
			            <span class="navbar-brand nav-title">实用资料与工具</span>
			        </div>
		            <div class="collapse navbar-collapse" id="xiaoerzimenu">
		                <br><br>
		                <ul class="nav nav-list">
		                    <li class="active"><a target="view_window" href="http://tool.oschina.net/">在线工具</a></li>
		                    <li ><a target="_blank" href="https://www.oschina.net/">开源中国</a></li>
		                    <li ><a target="_blank" href="http://ife.baidu.com/"=>百度前端</a></li>
		                    <li><a target="_blank" href="http://mvnrepository.com/">Maven知识库</a></li>
		                    <li ><a target="_blank" href="http://www.uisdc.com/">UISDC优设</a></li>
		                    <li ><a target="_blank" href="http://www.alloyteam.com/nav/">web前端</a></li>
		                </ul>
		            </div>
	            </div> 
             </div>
          </div><!--/.well -->
          <div class="col-md-9 col-md-offset-1 page">
	          <br><br>
	                               您是本站第<span id="busuanzi_value_site_uv"></span>个访客<br>
		      <p>©Hwy&nbsp;&nbsp;Blog  &nbsp;&nbsp;&nbsp;&nbsp;2018</p>
	        </div>
        </div><!--/col-md-->
        <div class="col-md-9">
          <c:forEach items="${blogs }" var="blog">
          <div class="row-fluid">
            <div class="col-md-12">
              <h2>${blog.b_title}</h2>
              <a class="pull-right panel-title col-lg-2" href="#">${blog.b_date}</a><br>
              <p>${blog.b_htmlStr}</p>
              <p><a class="pull-right  col-lg-2" class="btn" href="${pageContext.request.contextPath }/blogFind/findBlogByOne.action?id=${blog.b_id}">更多内容 »</a></p>
            </div><!--/span-->
          </div><!--/row-->
          <hr color="black">
        </c:forEach>
        <div class="row-fluid">
            <c:if test="${page.recordCount > 5}">
            <div class="col-md-4 col-md-offset-4">
             	<hwy:pager pageIndex="${page.pageIndex }" 
        		   pageSize="${page.pageSize }" 
        		   recordCount="${page.recordCount }"
        		   style="digg" 
        		   submitUrl="${pageContext.request.contextPath }/blogFind/findStudentNote.action?pageIndex={0}&labelId=${labe.labelId}&flag=${fg}"/>
            </div><!--/span-->
          	</c:if>
          </div><!--/row-->
        </div><!--/span-->
        </div><!--/row-->
      <hr>
	  

    </div><!--/.fluid-container-->
<script async src="//dn-lbstatics.qbox.me/busuanzi/2.3/busuanzi.pure.mini.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript"></script>  
</body>
</html>  
    

    
