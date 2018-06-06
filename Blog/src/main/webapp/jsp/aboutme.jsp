<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Hwy Blog</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="shortcut icon" type="image/ico" href="https://images-tomcat.oss-cn-hongkong.aliyuncs.com/favicon.ico"/>  
  <link rel="bookmark" href="https://images-tomcat.oss-cn-hongkong.aliyuncs.com/favicon.ico"/>  
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/pager.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
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
          <div class="hero-unit">
            <h1>你好，世界！</h1>
            <h3><span>博学之，审问之，慎思之，明辩之，笃行之</span></h3>
          </div>
          <hr>
            <div class="col-md-12">
              <h2>简单描述</h2>
              <hr>
              <p>&nbsp;&nbsp;一个热爱编程，目前正在饱受‘代码之苦’，的小白， 生活中除了编程以外，比较喜欢看动漫和玩游戏</p>
              <hr>
            </div><!--/span-->
            <div class="col-md-12">
              <h2>简单随笔</h2>
              <hr>
              <p>大学走上了编程的道路。在这条路上，迷茫过，颓废过，都走了过来，<br>
              	  编程不易，且行且惜，望自己能坚持下去，在这条道路上可以走的时间长一些。<br>
              </p>
              <p  align="right" style="margin: 0px 300px 0px 50px">一个奋起的小白</p>
               <hr>
            </div><!--/span-->
          </div><!--/row-->
        </div><!--/span-->
      </div><!--/row-->
      <hr>

<script async src="//dn-lbstatics.qbox.me/busuanzi/2.3/busuanzi.pure.mini.js"></script>
</body>
</html>  
    

    
