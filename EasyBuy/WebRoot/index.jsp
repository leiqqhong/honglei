<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<c:if test="${empty easybuyNews }">
		<script type="text/javascript">
			location.href = "EasybuyHomeServlet";
		</script>
</c:if>
<div id="welcomeImage">
    <img width="100%" height="150" src="images/banner.jpg" alt="welcome">
</div>
<%@include file="manage/console_element/top.jsp" %>
<div id="main" class="wrap">
	<div class="lefter">
		<%@include file="left.jsp" %>
	</div>
	<div class="main">
		<div class="price-off">
            <div class="slideBox">
                <ul id="slideBox">
                    <li><img src="images/product/banner_1.jpg"/></li>
                    <li><img src="images/product/banner_2.jpg"/></li>
                    <li><img src="images/product/banner_3.jpg"/></li>
                    <li><img src="images/product/banner_4.jpg"/></li>
                </ul>
            </div>
			<h2>商品列表</h2>
			<ul class="product clearfix">
				<c:forEach items="${pageBean.pageList}" var="easybuyProduct">
				<li>
					<dl>
						<dt><a href="EasybuyProductServlet?action=findById&epId=${easybuyProduct.epId }"  target="_self">
						<img src="images/product/${easybuyProduct.fileName}" /></a>
						</dt>
						<dd class="title"><a href="EasybuyProductServlet?action=findById&epId=${easybuyProduct.epId }"  target="_self">${easybuyProduct.description}</a></dd>
						<dd class="price">${easybuyProduct.price}</dd>
					</dl>
				</li>
				</c:forEach>
			</ul>
				<p align="right">当前页数:[${pageBean.pageNo}/${pageBean.totalPages}]&nbsp;
					<a href="EasybuyHomeServlet?pageNo=1">首页</a>
					<a href="EasybuyHomeServlet?pageNo=${ pageBean.pageNo-1}">上一页</a>
					<a href="EasybuyHomeServlet?pageNo=${ pageBean.pageNo+1}">下一页</a>
					<a href="EasybuyHomeServlet?pageNo=${ pageBean.totalPages}">末页</a>
				</p>
		</div>
		<div class="side">			
			<div class="spacer"></div>
			<div class="news-list">
				<h4>新闻动态</h4>
				 <ul>
				 <c:forEach items="${easybuyNews}" var="news">
					<li><a href="EasybuyNewsServlet?enIdStr=${news.enId}" target="_self">${news.title }</a></li>
					</c:forEach>
				</ul> 
			</div>
		</div>
		<div class="spacer clear"></div>
    </div>
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>

