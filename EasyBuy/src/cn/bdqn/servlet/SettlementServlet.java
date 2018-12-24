package cn.bdqn.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bdqn.entity.EasybuyOrder;
import cn.bdqn.entity.EasybuyUser;
import cn.bdqn.entity.ShoppingCart;
import cn.bdqn.entity.ShoppingCartItem;
import cn.bdqn.service.EasybuyOrderDetailService;

public class SettlementServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	EasybuyOrderDetailService odService = new EasybuyOrderDetailService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
		String eoId = UUID.randomUUID().toString().replace("-", "");
		EasybuyUser easybuy = new EasybuyUser();
		int userId = easybuy.getUserId();
		String address = easybuy.getAddress();
		Date date = new Date();
		Timestamp createTime = new Timestamp(date.getTime());
		//通过cart 计算总价格
		double sum = 0;
		for (ShoppingCartItem item : shoppingCart.items) {
			sum = sum + item.getCost();
		}
		int status = 1;
		int type = 1;
		String userName = easybuy.getUserName();
		EasybuyOrder order = new EasybuyOrder(eoId, userId, userName, address, createTime, sum, status, type);
		int ret1 = odService.addOrder(order);
		//先遍历购物车,逐个添加商品
		for (ShoppingCartItem item : shoppingCart.items) {
			double cost = item.getCost();
			int epId = item.getProduct().getEpId();
			int quantity = item.getQuantity();
			int ret = odService.addOrderDetail(eoId, epId, quantity, cost);
			if(ret>0){
				continue;
			}
		}
		//移除购物车
		session.removeAttribute("cart");
		if(ret1>0){
			request.getRequestDispatcher("shopping-result.jsp").forward(request, response);
		}
	}

}
