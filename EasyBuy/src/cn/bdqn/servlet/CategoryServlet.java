package cn.bdqn.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.entity.EasybuyCategory;
import cn.bdqn.service.EasybuyCategoryService;

public class CategoryServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EasybuyCategoryService CategoryService = new EasybuyCategoryService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//查询所有商品分类,分类管理
		String opr = request.getParameter("opr");
		if(opr.equals("findAll")){
			List<EasybuyCategory> Categorylist = CategoryService.findAll();
			
			request.setAttribute("Categorylist", Categorylist);
			request.getRequestDispatcher("productClass.jsp").forward(request, response);
		}
		
		//根据Id查显示修改对象
		if(opr.equals("findAllById")){
			String StrepcId = request.getParameter("epcId");
			int epcId = Integer.parseInt(StrepcId);
			EasybuyCategory CategoryId = CategoryService.findById(epcId);
			//加
			List<EasybuyCategory> plist=CategoryService.findEpcIdEqualsParentId();
			if(CategoryId!=null){
				request.setAttribute("CategoryId", CategoryId);
				request.setAttribute("plist", plist);
				request.getRequestDispatcher("productClass-modify.jsp").forward(request, response);
			}else{
				response.sendRedirect("errpr.jsp");
			}
		}
		
		//修改
		if(opr.equals("updateCategory")){
			String StrepcId = request.getParameter("epcId").trim();
			int epcId = Integer.parseInt(StrepcId);
			String StrparentId = request.getParameter("parentId");
			int parentId = Integer.parseInt(StrparentId);
			String epcName = request.getParameter("className");
			int ret = CategoryService.updateCategory(epcId, parentId, epcName);
			if(ret>0){
				request.getRequestDispatcher("manage-result.jsp").forward(request, response);
			}else{
				response.sendRedirect("error.jsp");
			}
		}
		//新增的根栏目遍历
		if(opr.equals("addCategory")){
			EasybuyCategoryService easybuyCategoryService=new EasybuyCategoryService();
			Map<EasybuyCategory,List<EasybuyCategory>> mapCategory = easybuyCategoryService.findAllCategory();
			request.getSession().setAttribute("mapCategory", mapCategory);
			request.getRequestDispatcher("productClass-add.jsp").forward(request, response);
		}
		//新增
		if(opr.equals("addCategory1")){
			String StrparentId = request.getParameter("parentId");
			int parentId = Integer.parseInt(StrparentId);
			String epcName = request.getParameter("className");
			int ret = CategoryService.addCategory(  parentId,epcName);
			if(ret>0){
				request.getRequestDispatcher("manage-result.jsp").forward(request, response);
			}else{
				response.sendRedirect("error.jsp");
			}
		}
		
		//删除
		if(opr.equals("delCategory")){
			String StrepcId = request.getParameter("epcId");
			int epcId = Integer.parseInt(StrepcId);
			int ret = CategoryService.delCategory(epcId);
			if(ret>0){
				request.getRequestDispatcher("manage-result.jsp").forward(request, response);
			}else{
				response.sendRedirect("error.jsp");
			}
		}
		
	}

}
