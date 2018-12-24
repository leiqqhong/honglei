package cn.bdqn.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bdqn.entity.EasybuyComment;
import cn.bdqn.entity.EasybuyUser;
import cn.bdqn.service.EasybuyCommentService;
import cn.bdqn.util.PageBean;

public class EasybuyCommentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	EasybuyCommentService easybuyCommentService = new EasybuyCommentService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String opr = request.getParameter("opr");
		//查询留言
		if(opr.equals("findAllComment")){
			
			/*List<EasybuyComment> list = easybuyCommentService.findAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("guestbook.jsp").forward(request, response);*/
			int pageSize =5;
			int pageNo =1;
			String pageNoStr = request.getParameter("pageNo");
			if(pageNoStr!=null){
				pageNo = Integer.parseInt(pageNoStr);
			}
			PageBean<EasybuyComment> pageBean = easybuyCommentService.findByPage(pageNo, pageSize);
			request.setAttribute("pageBean", pageBean);
			request.getRequestDispatcher("guestbook.jsp").forward(request, response);
		}
		
		//新增留言
		
		if(opr.equals("addEasybuyComment")){
			List<EasybuyComment> list = easybuyCommentService.findAll();
			request.setAttribute("list", list);
			String content = request.getParameter("guestContent");
			Date createTime = new Date(System.currentTimeMillis());
			EasybuyUser user = (EasybuyUser)session.getAttribute("userLogin");
			String guestName = user.getUserName();
			int ret = easybuyCommentService.addEasybuyComment(content, createTime, guestName);
			request.getRequestDispatcher("guestbook.jsp").forward(request, response);
		}
		
		//根据Id查显示修改对象
		if(opr.equals("findById")){
			String StrecId = request.getParameter("ecId");
			int ecId = Integer.parseInt(StrecId);
			//查询对象
			EasybuyComment comment = easybuyCommentService.findById(ecId);
			//转发到显示页面
			if(comment!=null){
				request.setAttribute("comment", comment);
				request.getRequestDispatcher("guestbook-modify.jsp").forward(request, response);
			}else{
				response.sendRedirect("error.jsp");
			}
		}
		
		//修改
		if(opr.equals("updateComment")){
			String StrecId = request.getParameter("ecId");
			int ecId = Integer.parseInt(StrecId);
			Date replyTime = new Date(System.currentTimeMillis());
			java.sql.Date time = new java.sql.Date(replyTime.getTime());
			String reply = request.getParameter("replyContent");
			int ret = easybuyCommentService.updateComment(ecId, reply,time);
			if(ret>0){
				request.getRequestDispatcher("manage-result.jsp").forward(request, response);
			}else{
				response.sendRedirect("error.jsp");
			}
		}
		
		//删除
		if(opr.equals("delComment")){
			String StrecId = request.getParameter("ecId");
			int ecId = Integer.parseInt(StrecId);
			int ret = easybuyCommentService.delComment(ecId);
			if(ret>0){
				request.getRequestDispatcher("manage-result.jsp").forward(request, response);
			}else{
				response.sendRedirect("error.jsp");
			}
		}
		
	}

}
