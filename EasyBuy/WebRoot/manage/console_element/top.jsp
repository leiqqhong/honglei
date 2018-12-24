<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help">
		<a href="shopping.jsp" id="shoppingBag" class="shopping">购物车X件</a>
		<c:if test="${empty userLogin}">
		<a href="login.jsp">登录</a>
		<a href="register.jsp ">注册</a>
		</c:if>
		<c:if test="${not empty userLogin}">
			用户名:${userLogin.nickName}
			<a class="button" id="logout" href="EasybuyUserServlet?opr=logout">注销</a>
			<a href="EasybuyCommentServlet?opr=findAllComment">留言</a>
			<c:if test="${userLogin.nickName=='管理员'}">
				<a href="manage/index.jsp">后台管理</a>
			</c:if>
		</c:if>
	</div>
	
    <div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="index.jsp">首页</a></li>
			<li><a href="#">图书</a></li>
			<li><a href="#">百货</a></li>
			<li><a href="#">品牌</a></li>
			<li><a href="#">促销</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			<li class="first"><a href="#">音乐</a></li>
			<li><a href="#">影视</a></li>
			<li><a href="#">少儿</a></li>
			<li><a href="#">动漫</a></li>
			<li><a href="#">小说</a></li>
			<li><a href="#">外语</a></li>
			<li><a href="#">数码相机</a></li>
			<li><a href="#">笔记本</a></li>
			<li><a href="#">羽绒服</a></li>
			<li><a href="#">秋冬靴</a></li>
			<li><a href="#">运动鞋</a></li>
			<li><a href="#">美容护肤</a></li>
			<li><a href="#">家纺用品</a></li>
			<li><a href="#">婴幼奶粉</a></li>
			<li><a href="#">饰品</a></li>
			<li class="last"><a href="#">Investor Relations</a></li>
		</ul>
	</div>
</div>