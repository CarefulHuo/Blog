<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>后台登录</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
  	<meta name="description" content="">
  	<meta name="author" content="">
	<link rel="shortcut icon" type="image/ico" href="https://images-tomcat.oss-cn-hongkong.aliyuncs.com/favicon.ico"/>  
    <link rel="bookmark" href="https://images-tomcat.oss-cn-hongkong.aliyuncs.com/favicon.ico"/>  
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/login.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal" action="${pageContext.request.contextPath }/blogAdmin/login.action" method="post">
                <span class="heading">用户登录</span>
                <span class="redWriter"><font color="red">${message}</font> </span>
                <div class="form-group">
                    <input name="b_username" type="email" class="form-control" id="inputEmail3" placeholder="用户名或电子邮件">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group help">
                    <input name="b_password" type="password" class="form-control" id="inputPassword3" placeholder="密　码">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>
                <div width="80%" border="0" cellspacing="2" class="upline">
					<tr>
						<td style="text-align: right; width: 20%">验证码：</td>
						<td style="width: 50%">
						<input type="text" class="textinput" name="b_code"/>
						</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td style="text-align: right; width: 20%;">&nbsp;</td>
						<td rowspan="2" style="width: 50%">
							<img src="${pageContext.request.contextPath}/imageCode" width="180"
								height="30" class="textinput" style="height: 30px;" id="img" />&nbsp;&nbsp;
							<a href="javascript:void(0);" onclick="changeImage()">看不清</a>
					    </td>
					</tr>
				</div>
                <div class="form-group">
                    <span class="text"></span>
                    <button type="submit" class="btn btn-default">
                    	&nbsp;&nbsp;&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;&nbsp;&nbsp;
                    </button>
                    <span class="text">
                    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                	</span>
                    <button type="resit" class="btn btn-default">
                    	&nbsp;&nbsp;&nbsp;重&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;置&nbsp;&nbsp;&nbsp;
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/form.js"></script>
<script type="text/javascript">
	function changeImage() {
		// 改变验证码图片中的文字
		document.getElementById("img").src = "${pageContext.request.contextPath}/imageCode?time="
				+ new Date().getTime();
	}
</script>
</body>
</html>