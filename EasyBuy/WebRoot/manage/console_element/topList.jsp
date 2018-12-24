<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<div class="box">
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
				<dd><em><a href="news-add.jsp">新增</a></em>
				<a href="NewsServlet?opr=findAllNews">新闻管理</a></dd>
			</dl>
		</div>