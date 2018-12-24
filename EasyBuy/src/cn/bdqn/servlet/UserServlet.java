package cn.bdqn.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.entity.EasybuyUser;
import cn.bdqn.service.EasybuyUserService;
import cn.bdqn.util.PageBean;

public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EasybuyUserService userService = new EasybuyUserService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opr = request.getParameter("opr");
		// 后台 用户管理
		if (opr.equals("userManage")) {
			/*List<EasybuyUser> easybuyUserList = userService.findAllEasybuyUser();
			request.setAttribute("easybuyUserList", easybuyUserList);
			request.getRequestDispatcher("user.jsp").forward(request, response);*/
			int pageSize =4;
			int pageNo =1;
			String pageNoStr = request.getParameter("pageNo");
			if(pageNoStr!=null){
				pageNo = Integer.parseInt(pageNoStr);
			}
			PageBean<EasybuyUser> pageBean = userService.findByPage(pageNo, pageSize);
			request.setAttribute("pageBean", pageBean);
			request.getRequestDispatcher("user.jsp").forward(request, response);
		}

		// 根据Id查
		// 显示修改对象
		if (opr.equals("findById")) {
			String StrUserId = request.getParameter("userId").trim();
			int userId = Integer.parseInt(StrUserId);
			// 查询对象
			EasybuyUser easybuyUserId = userService.findById(userId);
			// 转发到显示页面
			if (easybuyUserId != null) {
				request.setAttribute("easybuyUserId", easybuyUserId);
				request.getRequestDispatcher("user-modify.jsp").forward(
						request, response);
			} else {
				response.sendRedirect("error.jsp");
			}
		}

		// 修改
		if (opr.equals("updateUser")) {
			String StrUserId = request.getParameter("userId").trim();
			int userId = Integer.parseInt(StrUserId);
			String userName = request.getParameter("userName");
			String nickName = request.getParameter("name");
			String userPwd = request.getParameter("passWord");
			String strSex = request.getParameter("sex");
			int userSex = Integer.parseInt(strSex);
			String birthdayStr = request.getParameter("birthday");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = null;
			try {
				date = sdf.parse(birthdayStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			java.sql.Date birthday = new java.sql.Date(date.getTime());
			String identityCode = request.getParameter("identityCode");
			String mobile = request.getParameter("mobile");
			String address = request.getParameter("address");
			EasybuyUser Userupdate = new EasybuyUser(userId, userName,
					nickName, userPwd, userSex, birthday, identityCode, mobile,
					address);
			int ret = userService.updateUser(Userupdate);
			if (ret > 0) {
				request.getRequestDispatcher("manage-result.jsp").forward(
						request, response);
			} else {
				response.sendRedirect("error.jsp");
			}
		}

		// 删除
		if (opr.equals("del")) {
			String tidStr = request.getParameter("userId");
			int userId = Integer.parseInt(tidStr);
			int ret = userService.delUser(userId);
			if (ret > 0) {
				request.getRequestDispatcher("user-modify.jsp").forward(
						request, response);
			} else {
				response.sendRedirect("error.jsp");
			}
		}
	}

}
