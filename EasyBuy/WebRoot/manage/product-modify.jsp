<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
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
	<div class="help"><a href="../index.html">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.html">首页</a></li>
			<li><a href="user.html">用户</a></li>
			<li class="current"><a href="product.html">商品</a></li>
			<li><a href="order.html">订单</a></li>
			<li><a href="guestbook.html">留言</a></li>
			<li><a href="news.html">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员pillys您好，今天是2012-12-21，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.html">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<%@include file="console_element/topList.jsp" %>
	</div>
	<div class="main">
		<h2>修改商品</h2>
		<div class="manage">
			<form action="ProductUpdateServlet" method="post" enctype="multipart/form-data">
				<table class="form">
					<tr>
						<td class="field">商品名称(*)：</td>
						<td><input type="hidden" name="pcid" value="${Product.epId }">
						<input type="text" class="text" name="productName" value="${Product.epName}" /></td>
					</tr>
                    <tr>
						<td class="field">描述：</td>
						<td><input type="text" class="text" name="productDetail" value="${Product.description}" /></td>
					</tr>
					<tr>
						<td class="field">所属分类：</td>
						<td>
							<select name="parentId">
							<c:forEach items="${map}" var="dailei">
								<option value="${dailei.key.epcId }">${dailei.key.epcName}</option>
								<c:forEach items="${dailei.value}" var="xiaolei" varStatus="oo">
								<option value="${xiaolei.epcId}">├ ${xiaolei.epcName}</option>
								<c:if test="${fn:length(dailei.value)==oo.count}">
								<option value="${xiaolei.epcId}">└${xiaolei.epcName} </option>
								</c:if>
								</c:forEach>
							</c:forEach>	
							</select>
							<%-- <select name="parentId">
								<c:forEach items="${map}" var="dalei" >
								<option value="${dalei.id }">${dalei.name }</option>
								<c:forEach items="${dalei.value}" var="xiaolei" varStatus="oo">
								<option value="${xiaolei.id }">├ 电器</option>
								<c:if test="${ fn:length(dalei.value)==oo.count}">
								<option value="${xiaolei.id }">└ 电器</option>
								</c:if>
								</c:forEach>
								</c:forEach>
								<!-- <option value="2">衣服</option>
								<option value="3">├ 电器</option>
								<option value="3">└ 电器</option> -->
							</select> --%>
						</td>
					</tr>					
					<tr>
						<td class="field">商品价格(*)：</td>
						<td><input type="text" class="text tiny" name="productPrice" value="${Product.price}" /> 元</td>
					</tr>
					
					<tr>
						<td class="field">库存(*)：</td>
						<td><input type="text" class="text tiny" name="productNumber" value="${Product.stock}" /></td>
					</tr>
					<tr>
						<td class="field">商品图片：</td>
						<td><input type="file" class="text" name="photo" value="${Product.fileName}"/></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="确定" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
