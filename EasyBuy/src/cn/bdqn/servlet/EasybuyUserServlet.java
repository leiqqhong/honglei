package cn.bdqn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bdqn.entity.EasybuyUser;
import cn.bdqn.service.EasybuyUserService;

public class EasybuyUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	EasybuyUserService userService = new EasybuyUserService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String opr = request.getParameter("opr");
		//�û���¼
		/*if(opr.equals("login")){
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");
			EasybuyUser easybuyUser = userService.doLogin(userId, password);
			if(easybuyUser!=null){
				HttpSession session = request.getSession();
				session.setAttribute("easybuyUser", easybuyUser);
				session.setMaxInactiveInterval(10*60);
				response.sendRedirect("index.jsp");
			}else{
				String msg = "�û�������������!���������!";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}*/
		if(opr.equals("checkUser")){
			String userId = request.getParameter("userId");
			EasybuyUser user = userService.checkUserId(userId);
			PrintWriter out = response.getWriter();
			if(user==null){
				out.println("false");
			}else{
				out.println("true");
			}
			out.flush();
			out.close();
			return;
		}
		if(opr.equals("login")){
			//��¼
			//1.�ж���֤��
			//��ȡ��session Number.jsp��
			HttpSession session = request.getSession();
			String numrand = (String) session.getAttribute("numrand");
			//ȡ���û������code
			String code = request.getParameter("code");
			if(numrand.equals(code)){
				//2.�жϵ�¼
				String userId = request.getParameter("userId");
				String password = request.getParameter("password");
				EasybuyUser userLogin = userService.doLogin(userId, password);
				if(userLogin!=null){
					session.setAttribute("userLogin", userLogin);
					response.sendRedirect("EasybuyHomeServlet");
				}else{
					String msg ="�û���������������!����������";
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}else{
				String msg = "��֤����������,����������";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			return;
		}
		
		
		//�û�ע��
		if(opr.equals("logout")){
			HttpSession session = request.getSession();
			session.removeAttribute("userLogin");
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
		
		//�û�ע��
		if(opr.equals("register")){
			String nickName = request.getParameter("userId");
			String userName = request.getParameter("userName");
			String userPwd = request.getParameter("password");
			String sexStr = request.getParameter("sex");
			int userSex = 0;
			if("male".equals(sexStr)){
				userSex = 1;
			}
			
			String birthdayStr = request.getParameter("birthday");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = null;
			try {
				date = sdf.parse(birthdayStr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date birthday = new java.sql.Date(date.getTime());
			String identityCode = request.getParameter("identityCode");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			String address = request.getParameter("address");
			int status =0;
			int ret = userService.addEasybuyUser(userName, nickName, userPwd, userSex, birthday, identityCode, email, mobile, address, status);
			if(ret>0){
				request.getRequestDispatcher("reg-result.jsp").forward(request, response);
			}else{
				String msg = "ע��ʧ��,������ע��";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		
	}
}
