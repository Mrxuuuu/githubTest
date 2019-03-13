<%@ page language="java" contentType="text/html; charset=utf-8 "
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8">
		<title>信息管理系统页面</title>
	</head>
	<frameset rows="88,*,31" frameborder="0">
		<frame src="top.jsp"  name="top_fram" noresize="noresize"/>
		<frameset cols="187,*" frameborder="1" framespacing="0">
			 <frame src="left.jsp"  name="left_fram" scrolling="no" noresize="noresize"/> 
			 <frame src="right1.jsp" name="rightFrame" id="rightFrame"
				title="rightFrame"  frameborder="1" framespacing="0" noresize="noresize"/>
		</frameset>
		<frame src="footer.jsp" name="footer_fram" frameborder="1" framespacing="0" />
	</frameset>
</html>