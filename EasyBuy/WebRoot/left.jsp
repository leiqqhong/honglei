<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- <div id="main" class="wrap"> -->
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
				<c:forEach items="${mapCategory }" var = "item">
					<dt>${item.key.epcName}</dt>
					<c:forEach items="${item.value }" var="category">
						<dd><a href="EasybuyProductEpcIdServlet?epcId=${category.epcId}">${category.epcName }</a></dd>
					</c:forEach>
				</c:forEach>
			</dl>
		</div>
		<div class="spacer"></div>
		<div class="last-view">
			<h2>最近浏览</h2>
			<dl class="clearfix">
			<c:forEach items="${proList}" var="easybuyProduct">
				<dt>
				<a href="EasybuyProductServlet?action=findById&epId=${easybuyProduct.epId}"  target="_self">
				<img src="images/product/${easybuyProduct.fileName}" width="54" height="54" />
				</a>
				</dt>
				<dd>
					<a href="product-viem.jsp" target="_self">${easybuyProduct.epName}</a>
				</dd>
			</c:forEach>
		  </dl>
	  </div>
	</div>
<!-- </div> -->	