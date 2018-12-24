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
			<li class="current"><a href="product.jsp">商品</a></li>
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
	</div>
	<div class="main">
		<h2>商品管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>编号</th>
					<th>商品名称</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${Productlist}" var="list">
				<%-- <c:forEach items="${pageBean.pageList}" var="list"> --%>
				<tr>
					<td class="first w4 c">${list.epId}</td>
					<td class="thumb"><img src="../images/product/${list.fileName}" />
					<a href="../product-view.jsp" target="_self">${list.description}</a>
					</td>
					<td class="w1 c"><a href="ProductServlet?opr=ProductId&epId=${list.epId}">修改</a>
					 <a class="manageDel" href="ProductServlet?opr=del&epId=${list.epId}">删除</a>
					 </td>
				</tr>
				</c:forEach>
				<!-- <tr>
					<td class="first w4 c">1</td>
					<td class="thumb"><img src="../images/product/0_tiny.gif" />
					<a href="../product-view.html" target="_self">铁三角 Audio-Technica ATH-EQ300M-SV 银色 挂耳式耳机</a>
					</td>
					<td class="w1 c"><a href="product-modify.html">修改</a> 
					<a class="manageDel" href="javascript:void(0)">删除</a>
					</td>
				</tr> -->
			</table>
		</div>
	</div>
	<div class="clear"></div>
    <div class="pager">
				<ul class="clearfix">
					<li><a >首页</a></li>
					<li>...</li>
					<li><a >4</a></li>
					<li class="current">5</li>
                    <li><a >6</a></li>
                    <li>...</li>
					<li><a >尾页</a></li>
				</ul>
			</div>
</div>
<div id="footer">
	Copyright &copy; 2018 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
    