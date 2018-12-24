package cn.bdqn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.entity.EasybuyNews;
import cn.bdqn.service.EasybuyNewsService;

public class EasybuyNewsServlet extends HttpServlet {

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

			
			//根据ID查询新闻
			request.setCharacterEncoding("UTF-8");
			String enIdStr = request.getParameter("enIdStr");
			int enId = Integer.parseInt(enIdStr);
			EasybuyNews easybuyNews = easybuyNewsService.findEasybuyNewsById(enId);
			request.setAttribute("easybuyNews", easybuyNews);
			request.getRequestDispatcher("new-view.jsp").forward(request, response);
			
			
			
			
		}			
}
