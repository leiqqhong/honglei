package cn.bdqn.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.entity.EasybuyCategory;
import cn.bdqn.entity.EasybuyNews;
import cn.bdqn.entity.EasybuyProduct;
import cn.bdqn.service.EasybuyCategoryService;
import cn.bdqn.service.EasybuyNewsService;
import cn.bdqn.service.EasybuyProductService;
import cn.bdqn.util.PageBean;

public class EasybuyHomeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	EasybuyCategoryService easybuyCategoryService = new EasybuyCategoryService();
	EasybuyNewsService easybuyNewsService = new EasybuyNewsService();
	EasybuyProductService easybuyProductService = new EasybuyProductService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		//查询前8条新闻
		List<EasybuyNews> easybuyNews = easybuyNewsService.findAll();
		request.setAttribute("easybuyNews", easybuyNews);
		
		//查询商品分类
		Map<EasybuyCategory,List<EasybuyCategory>> mapCategory = easybuyCategoryService.findAllCategory();
		request.getSession().setAttribute("mapCategory", mapCategory);
		
		
		//查询商品列表
		List<EasybuyProduct> easybuyProduct = easybuyProductService.findAll();
		request.setAttribute("easybuyProduct", easybuyProduct);
		
		//读cookie
		List<EasybuyProduct> proList = new ArrayList<EasybuyProduct>();
		Cookie ckproList = null;
		Cookie[] cks = request.getCookies();
		for (Cookie cookie : cks) {
			if("ckproList".equals(cookie.getName())){
				ckproList = cookie;//找到了
				break;
			}
		}
		if(ckproList!=null){
			String value = ckproList.getValue();
			String[] pidList = value.split(",");
			int end = 0;
			if(pidList.length>3){
				end = pidList.length-3;
			}
			for (int i = pidList.length-1; i >= end; i--) {
				int enId = Integer.parseInt(pidList[i]);
				EasybuyProduct product = easybuyProductService.findEasybuyProductById(enId);
				proList.add(product);
			}
		}
		
		//分页
		int pageSize =8;
		int pageNo =1;
		String pageNoStr = request.getParameter("pageNo");
		if(pageNoStr!=null){
			pageNo = Integer.parseInt(pageNoStr);
		}
		PageBean<EasybuyProduct> pageBean = easybuyProductService.findByPage(pageNo, pageSize);
		request.setAttribute("proList", proList);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
}
