package cn.bdqn.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.entity.EasybuyCategory;
import cn.bdqn.entity.EasybuyProduct;
import cn.bdqn.service.EasybuyCategoryService;
import cn.bdqn.service.EasybuyProductService;

public class ProductServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2224432116157825877L;
	EasybuyProductService ProductService = new EasybuyProductService();
	EasybuyCategoryService ecService=new EasybuyCategoryService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opr = request.getParameter("opr");
		//查询所有商品
		if(opr.equals("findAllProduct")){
			/*int pageSize =4;
			int pageNo =1;
			String pageNoStr = request.getParameter("pageNo");
			if(pageNoStr!=null){
				pageNo = Integer.parseInt(pageNoStr);
			}
			PageBean<EasybuyCategory> pageBean = ecService.findByPage(pageNo, pageSize);
			request.setAttribute("pageBean", pageBean);
			request.getRequestDispatcher("product.jsp").forward(request, response);*/
			
			List<EasybuyProduct> Productlist = ProductService.findAll();
			request.setAttribute("Productlist", Productlist);
			request.getRequestDispatcher("product.jsp").forward(request, response);
		}
		//根据Id查显示修改对象
		if(opr.equals("ProductId")){
			Map<EasybuyCategory,List<EasybuyCategory>> map=ecService.findAllCategory();
			String StrepId = request.getParameter("epId");
			int epId = Integer.parseInt(StrepId);
			//查询对象
			EasybuyProduct Product = ProductService.findEasybuyProductById(epId);
			// 转发到显示页面
			if(Product!=null){
				request.setAttribute("map", map);
				request.setAttribute("Product", Product);
				request.getRequestDispatcher("product-modify.jsp").forward(request, response);
			}else{
				response.sendRedirect("error.jsp");
			}
		}
		
		//修改
		if(opr.equals("updateProduct")){
			String StrepId = request.getParameter("epId");
			int epId = Integer.parseInt(StrepId);
			String epName = request.getParameter("productName");
			String description = request.getParameter("productName");
			String Strprice = request.getParameter("productPrice");
			double price = Double.parseDouble(Strprice);
			String Strstock = request.getParameter("productName");
			int stock = Integer.parseInt(Strstock);
			String StrepcId = request.getParameter("parentId");
			int epcId = Integer.parseInt(StrepcId);
			String fileName = request.getParameter("photo");
			EasybuyProduct product = new EasybuyProduct(epId,epName, description, price, stock, epcId, fileName);
			int ret = ProductService.updateProduct(product);
			if(ret>0){
				request.getRequestDispatcher("manage-result.jsp").forward(request, response);
			}else{
				response.sendRedirect("error.jsp");
			}
			
		}
		
		//删除
		if(opr.equals("del")){
			String StrepId = request.getParameter("epId");
			int epId = Integer.parseInt(StrepId);
			int ret = ProductService.delProduct(epId);
			if(ret>0){
				request.getRequestDispatcher("manage-result.jsp").forward(request, response);
			}else{
				response.sendRedirect("error.jsp");
			}
		}
		
		//新增
		if(opr.equals("add")){
			String epName = request.getParameter("productName");
			String description = request.getParameter("productDetail");
			String StrepcId = request.getParameter("parentId");
			int epcId = Integer.parseInt(StrepcId); 
			String Strprice = request.getParameter("productPrice");
			double price = Double.parseDouble(Strprice);
			String Strstock = request.getParameter("productNumber");
			int stock = Integer.parseInt(Strstock);
			String fileName = request.getParameter("photo");
			EasybuyProduct product = new EasybuyProduct(epName, description, price, stock, epcId, fileName);
			int ret = ProductService.addProduct(product);
			if(ret>0){
				request.getRequestDispatcher("manage-result.jsp").forward(request, response);
			}else{
				response.sendRedirect("error.jsp");
			}
		}
		
	}

}
