package cn.bdqn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.entity.OrderDTO;
import cn.bdqn.entity.OrderParam;
import cn.bdqn.service.EasybuyOrderDetailService;
import cn.bdqn.util.PageBean;

public class OrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EasybuyOrderDetailService orderDetailService = new EasybuyOrderDetailService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//模糊查询的两个参数
		String eoId = request.getParameter("entityId");
		String userId = request.getParameter("userName");
		OrderParam op = new OrderParam();
		op.setEoId(eoId);
		op.setUserId(userId);
		
		//分页的参数
		int pageNo = 1;
		int pageSize = 2;
		String pageStr = request.getParameter("pageNo");
		if(pageStr!=null){
			pageNo = Integer.parseInt(pageStr);
		}
		PageBean<OrderDTO> pageBean = orderDetailService.findBypage(pageNo,pageSize,op);
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("op", op);
		request.getRequestDispatcher("order.jsp").forward(request, response);
	}

}
