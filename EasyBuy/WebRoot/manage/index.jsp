<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
			<li class="current"><a href="index.jsp">首页</a></li>
			<li><a href="user.jsp">用户</a></li>
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
		<%@include file="console_element/topList.jsp" %>
		<!-- <div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><a href="UserServlet?opr=userManage">用户管理</a></dd>
			  <dt>商品信息</dt>
				<dd><em><a href="CategoryServlet?opr=addCategory">新增</a></em>
				<a href="CategoryServlet?opr=findAll">分类管理</a></dd>
				<dd><em><a href="product-add.jsp">新增</a></em>
				<a href="ProductServlet?opr=findAllProduct">商品管理</a></dd> 
				<dt>订单管理</dt>
				<dd><a href="OrderServlet">订单管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="EasybuyCommentServlet?opr=findAllComment">留言管理</a></dd>
				<dt>新闻管理</dt>
				<dd><em><a href="NewsServlet?opr=newsAdd">新增</a></em>
				<a href="NewsServlet?opr=findAllNews">新闻管理</a></dd>
			</dl>
		</div> -->
	</div>
	
	<div class="main">
		<h2>管理首页</h2>
		<div id="welcome" class="manage">
			<div class="shadow">
				<em class="corner lb"></em>
				<em class="corner rt"></em>
				<div class="box">
					<div class="msg">
						<p>欢迎回来</p>
					</div>
				</div>
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
    