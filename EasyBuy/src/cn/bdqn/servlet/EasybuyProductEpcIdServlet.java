package cn.bdqn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.entity.EasybuyProduct;
import cn.bdqn.service.EasybuyProductService;

public class EasybuyProductEpcIdServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EasybuyProductService easybuyProductService = new EasybuyProductService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//¸ù¾ÝepcId²éÑ¯
		String epcIdStr = request.getParameter("epcId");
		int epcId = Integer.parseInt(epcIdStr);
		List<EasybuyProduct> list1 =easybuyProductService.findEasybuyProductByEpcId(epcId);
		
		request.setAttribute("list1",list1);
		request.getRequestDispatcher("product-list.jsp").forward(request, response);
	}

}
