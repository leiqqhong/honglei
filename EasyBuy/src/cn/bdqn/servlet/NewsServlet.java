package cn.bdqn.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.entity.EasybuyNews;
import cn.bdqn.service.EasybuyNewsService;
import cn.bdqn.util.PageBean;

public class NewsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EasybuyNewsService easybuyNewsService = new EasybuyNewsService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opr = request.getParameter("opr");
		//后台查询所有新闻
		if(opr.equals("findAllNews")){
			/*List<EasybuyNews> easybuyNewsHt = easybuyNewsService.findAllNews();
			request.setAttribute("easybuyNewsHt", easybuyNewsHt);
			request.getRequestDispatcher("news.jsp").forward(request, response);*/
			int pageSize =4;
			int pageNo =1;
			String pageNoStr = request.getParameter("pageNo");
			if(pageNoStr!=null){
				pageNo = Integer.parseInt(pageNoStr);
			}			PageBean<EasybuyNews> pageBean = easybuyNewsService.findByPage(pageNo, pageSize);
			request.setAttribute("pageBean", pageBean);
			request.getRequestDispatcher("news.jsp").forward(request, response);
		}
	
		//根据Id查显示修改对象
		if(opr.equals("findById")){
			String StrenId = request.getParameter("enId");
			int enId = Integer.parseInt(StrenId);
			//查询对象
			EasybuyNews easybuyNewsId = easybuyNewsService.findEasybuyNewsById(enId);
			// 转发到显示页面
			if(easybuyNewsId!=null){
				request.setAttribute("easybuyNewsId", easybuyNewsId);
				request.getRequestDispatcher("news-modify.jsp").forward(request, response);
			}else{
				response.sendRedirect("error.jsp");
			}
		}
		
		//修改
		if(opr.equals("updateNew")){
			String StrenId = request.getParameter("enId");
			int enId = Integer.parseInt(StrenId);
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int ret=easybuyNewsService.updateNews(enId,title,content);
			if(ret>0){
				request.getRequestDispatcher("manage-result.jsp").forward(request, response);
			}else{
				response.sendRedirect("error.jsp");
			}
		}
		
		//删除
		if(opr.equals("delNew")){
			String StrenId = request.getParameter("enId");
			int enId = Integer.parseInt(StrenId);
			int ret = easybuyNewsService.delEasybuyNews(enId);
			if(ret>0){
				request.getRequestDispatcher("news.jsp").forward(request, response);
			}else{
				response.sendRedirect("error.jsp");
			}
		}
		
		//新增新闻
		if(opr.equals("newsAdd")){
			String title = request.getParameter("title");
			String content = request.getParameter("content"); 
			Date createTime = new Date(System.currentTimeMillis()); 
			int ret = easybuyNewsService.addEasybuyNews(title, content, createTime);
			if (ret > 0) {
				// 新增成功
				request.getRequestDispatcher("manage-result.jsp").forward(request,
						response);
			} else {
				// 失败
				response.sendRedirect("error.jsp");
			}
		}
		
	}

}
