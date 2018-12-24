<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>
			<li class="current"><a href="user.jsp">用户</a></li>
			<li><a href="product.jsp">商品</a></li>
			<li><a href="order.jsp">订单</a></li>
			<li><a href="guestbook.jsp">留言</a></li>
			<li><a href="news.jsp">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员pillys您好，今天是2012-12-21，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<%@include file="console_element/topList.jsp" %>
		</div>
	</div>
	<div class="main">
		<h2>用户管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>用户名</th>
					<th>真实姓名</th>
					<th>性别</th>
					<th>Email</th>
					<th>手机</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${pageBean.pageList }" var="user">
				<tr>
					<td class="first w4 c">${user.userName}</td>
					<td class="w1 c">${user.nickName}</td>
					<c:if test="${user.userSex==0}"><td class="w2 c">女</td></c:if>
					<c:if test="${user.userSex==1}"><td class="w2 c">男</td></c:if>
					<td>${user.email}</td>
					<td class="w4 c">${user.mobile}</td>
					<td class="w1 c"><a href="UserServlet?opr=findById&userId=${user.userId}">修改</a>
					 <a class="manageDel" href="UserServlet?opr=del&userId=${user.userId}">删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div class="clear"></div>
     <div class="pager">
				<p align="right">当前页数:[${pageBean.pageNo}/${pageBean.totalPages}]&nbsp;
					<a href="UserServlet?opr=userManage&pageNo=1">首页</a>
					<a href="UserServlet?opr=userManage&pageNo=${ pageBean.pageNo-1}">上一页</a>
					<a href="UserServlet?opr=userManage&pageNo=${ pageBean.pageNo+1}">下一页</a>
					<a href="UserServlet?opr=userManage&pageNo=${ pageBean.totalPages}">末页</a>
				</p>
			</div>
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
    