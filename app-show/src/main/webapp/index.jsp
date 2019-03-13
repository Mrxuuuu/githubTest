<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8 ">
	<link rel="stylesheet" href="css/index.css" />
	
		<title>江岸日用化工管理系统</title>
	</head>

	<body>
		<div class="header"> 
			<span>欢迎登录后台管理界面平台</span>
            <ul>
            	<li> <a href="#">回首页</a> </li><li> <a href="#">帮助</a> </li><li> <a href="#">关于</a> </li>
            </ul>
		</div>
		<div class="body">
			<div class="system_log"></div>
			<div class="login_body">
                   <form action="Index" method="post">
                   	  <input type="text" class="loginuser" placeholder="请输入用户名"  name="user" autofocus/>
                   	  <input type="password"  class="loginpassword" placeholder="请输入密码" name="pwd"/>
                   	  <input type="submit" value="登录" class="loginsubmit"/>
                   	  <input type="checkbox" checked="checked"   /> <span>记住密码    忘记密码</span>
                   </form>	
			</div>

		</div>
	</body>

</html>