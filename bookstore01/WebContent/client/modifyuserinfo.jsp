<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电子书城</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/client/css/main.css"	type="text/css" />
<script type="text/javascript"	src="${pageContext.request.contextPath}/client/js/form.js"></script>
<script type="text/javascript"	src="${pageContext.request.contextPath}/client/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function test1() {
		alert("sss");
	}
	function checkPassword() { // 验证密码
		var regex = /^.{6,16}$/; // 任意字符, 6到16位
		var value = passwordObj.value;
		var msg = "";
		if (!value)
			msg = "密码必须填写：";
		else if (!regex.test(value))
			msg = "密码不合法：";
		passwordMsg.innerHTML = msg;
		passwordObj.parentNode.parentNode.style.color = msg == "" ? "black"
				: "red";
		return msg == "";
	}

	function checkConfirm() {		// 验证确认密码
		var passwordValue = passwordObj.value;
		var confirmValue = confirmObj.value;
		var msg = "";

	    if(!confirmValue){
		    msg = "确认密码必须填写";
		}
		else	if (passwordValue != confirmValue){
			msg = "密码必须保持一致";
	    }
		confirmMsg.innerHTML = msg;
		confirmObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
		return msg == "";
	}
	</script>


</head>

<body class="main">
	<%-- <p:user /> --%>
	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />
	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td width="25%">
					<table width="100%" border="0" cellspacing="0"
						style="margin-top: 30px">
						<tr>
							<td class="listtitle">我的帐户</td>
						</tr>
						<tr>
							<td class="listtd"><img
								src="${pageContext.request.contextPath }/client/images/miniicon.gif"
								width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="${pageContext.request.contextPath }/client/modifyuserinfo.jsp">用户信息修改</a>
							</td>
						</tr>
						<tr>
							<td class="listtd"><img
								src="${pageContext.request.contextPath }/client/images/miniicon.gif"
								width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="${pageContext.request.contextPath}/client/user/findOrderByUser.do">订单查询</a>
							</td>
						</tr>
						<tr>
							<td class="listtd"><img
								src="${pageContext.request.contextPath }/client/images/miniicon.gif"
								width="9" height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="${pageContext.request.contextPath}/client/user/logout.do">用戶退出</a>
							</td>
						</tr>
					</table>
				</td>
				<td>
					<div style="text-align: right; margin: 5px 10px 5px 0px">
						<a href="${pageContext.request.contextPath }/index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath }/client/myAccount.jsp">&nbsp;我的帐户</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;用户信息修改
					</div>
					<form
						action="${pageContext.request.contextPath }/client/user/userInfoModify.do" method="post">
						<table cellspacing="0" class="infocontent">
							<tr>
								<td>
									<table width="100%" border="0" cellspacing="2" class="upline">
									 <tr>
										<td colspan="3"> ${errors} </td>
									</tr>
										<tr>
											<td style="text-align: right; width: 20%">会员邮箱：</td>
											<td style="width: 40%; padding-left: 20px">${login_user.email }</td>
											<td>&nbsp;</td>
										</tr>
										<tr>
											<td style="text-align: right">会员名：</td>
											<td style="padding-left: 20px">${login_user.username }</td>
											<td>&nbsp;</td>
										</tr>
										<tr>
											<td style="text-align: right">修改密码：</td>
											<td><input type="password" id="password" name="password"
												class="textinput" onkeyup="checkPassword();"/></td>
											<td><span id="passwordMsg"></span><font color="#999999">密码设置至少6位，请区分大小写</font></td>
										</tr>
										<tr>
										<td style="text-align:right">重复密码：</td>
										<td><input type="password" id="repassword" class="textinput" onkeyup="checkConfirm();" /></td>
										<td><span id="confirmMsg"></span>&nbsp;</td>
									</tr>
										<tr>
											<td style="text-align: right">性别：</td>
											<td colspan="2">&nbsp;&nbsp; <input type="radio"
												name="gender" value="男" ${user.gender=='男'?'checked':'' } />
												男 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
												type="radio" name="gender" value="女"
												${user.gender=='女'?'checked':'' } /> 女
											</td>
										</tr>
										<tr>
											<td style="text-align: right">联系方式：</td>
											<td colspan="2"><input name="telephone" type="text"
												value="${user.telephone}" class="textinput" /></td>
										</tr>
										<tr>
											<td style="text-align: right">&nbsp;</td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
										</tr>
									</table> <%-- <p style="text-align: center">
										<td colspan="2" style="padding-top: 10px; text-align: center">
											<input name="image" type="image" onclick="return formcheck()"
												src="${pageContext.request.contextPath }/client/images/botton_gif_025.gif"
											width="83" height="22" />
															
										</td>
									</p>
									<p style="text-align: center">&nbsp;</p> 
									<inputtype="submit" value="确定修改" onclick="test1();">--%> 

									<p style="text-align: center">
									<input type="image" src="${pageContext.request.contextPath }/client/images/botton_gif_025.gif">
									</p>
									<p style="text-align: center">&nbsp;</p> <%-- <p style="text-align:center">
									<a href="success.html">
										<img src="${pageContext.request.contextPath }/client/images/botton_gif_025.gif" border="0" />
									</a>
								</p>
								<p style="text-align:center">&nbsp;</p>  --%>
								</td>

							</tr>
						</table>
				</td>
			</tr>
		</table>
		</form>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>
