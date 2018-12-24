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
			<li><a href="user.jsp">用户</a></li>
			<li><a href="product.jsp">商品</a></li>
			<li><a href="order.jsp">订单</a></li>
			<li class="current"><a href="guestbook.jsp">留言</a></li>
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
		<%@include file="console_element/topList.jsp" %>
	</div>
	<div class="main">
		<h2>留言管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>留言内容</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${pageBean.pageList }" var="message">
				<tr>
					<td class="first w4 c">${message.ecId}</td>
					<td class="w1 c">${message.nickName}</td>
					<td>${message.content}</td>
					<td class="w1 c">${message.reply}</td>
					<td class="w1 c">
					<a href="EasybuyCommentServlet?opr=findById&ecId=${message.ecId}">修改</a> 
					<a class="manageDel" href="EasybuyCommentServlet?opr=delComment&ecId=${message.ecId}">删除</a>
					</td>
				</tr>
				</c:forEach>
				<!-- <tr>
					<td class="first w4 c">1</td>
					<td class="w1 c">张三丰</td>
					<td>北京的货发了没？</td>
					<td class="w1 c"></td>
					<td class="w1 c"><a href="guestbook-modify.html">回复</a> <a class="manageDel" href="javascript:void(0)">删除</a></td>
				</tr> -->
			</table>
			<div class="pager">
				<p align="right">当前页数:[${pageBean.pageNo}/${pageBean.totalPages}]&nbsp;
					<a href="EasybuyCommentServlet?opr=findAllComment&pageNo=1">首页</a>
					<a href="EasybuyCommentServlet?opr=findAllComment&pageNo=${ pageBean.pageNo-1}">上一页</a>
					<a href="EasybuyCommentServlet?opr=findAllComment&pageNo=${ pageBean.pageNo+1}">下一页</a>
					<a href="EasybuyCommentServlet?opr=findAllComment&pageNo=${ pageBean.totalPages}">末页</a>
				</p>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
    