package cn.bdqn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.entity.EasybuyProduct;
import cn.bdqn.entity.ShoppingCart;
import cn.bdqn.service.EasybuyProductService;

public class EasybuyProductServlet extends HttpServlet {

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

		//����Id��ѯ��Ʒ�б�
		
		/*request.setCharacterEncoding("UTF-8");
		String epIdStr = request.getParameter("epIdStr");
		int epId = Integer.parseInt(epIdStr);
		EasybuyProduct easybuyProduct = easybuyProductService.findEasybuyProductById(epId);
		if(easybuyProduct!=null){
			request.setAttribute("easybuyProduct", easybuyProduct);
			request.getRequestDispatcher("product-view.jsp").forward(request, response);
		}else{
			response.sendRedirect("index.jsp");
		}*/
		String action = request.getParameter("action");
		//���ﳵ
		if("shoppingCart".equals(action)){
			String opr = request.getParameter("opr");
			String epIdStr = request.getParameter("epId").trim();
			int epId = Integer.parseInt(epIdStr);
			ShoppingCart cart =  (ShoppingCart)request.getSession().getAttribute("cart");
			if(cart==null){//���Ϊ��,��Ҫ������Ҫ��ӵ���Ʒ�����ȥ.
				cart = new ShoppingCart();
				EasybuyProduct easybuyProduct1 = easybuyProductService.findEasybuyProductById(epId);
				cart.addItem(easybuyProduct1, 1);	
			}
			if("add".equals(opr)){
					//����
					EasybuyProduct easybuyProduct = easybuyProductService.findEasybuyProductById(epId);
					//�ж�session���Ƿ���cart
					int quantity = 1;//�������
					cart.addItem(easybuyProduct, quantity);		
			}
			if("del".equals(opr)){
				//ɾ��
				cart.removeItem(epId);
			}
			if("update".equals(opr)){
				//�޸�
				String numStr = request.getParameter("num");
				int num = Integer.parseInt(numStr);
				cart.modifyQuantity(epId, num);
			}
			request.getSession().setAttribute("cart", cart);
			/*request.getRequestDispatcher("shopping.jsp").forward(request, response);*/
			response.sendRedirect("shopping.jsp");
			
		}
		//����Id��ѯ��Ʒ�б�
		if("findById".equals(action)){
			String epIdStr = request.getParameter("epId").trim();
			if(epIdStr!=null){
				int epId = Integer.parseInt(epIdStr);
				EasybuyProduct easybuyProduct = easybuyProductService.findEasybuyProductById(epId);
				//����Ʒ����cookie ����ckproList
				Cookie ckproList = null;
				//���ҵ�֮ǰ��cookie
				Cookie[] cks = request.getCookies();
				for (Cookie cookie : cks) {
					if("ckproList".equals(cookie.getName())){
						ckproList = cookie;//�ҵ���
						//���µ�idƴ�ӵ�value
						ckproList.setValue(ckproList.getValue()+epId+",");
						break;
					}
				}
				if(ckproList == null){
					//��ǰû�зŹ�
					ckproList = new Cookie("ckproList",epId+",");
				}
				//ͨ��response���cookie
				response.addCookie(ckproList);
				
				request.setAttribute("easybuyProduct", easybuyProduct);
				request.getRequestDispatcher("product-view.jsp").forward(request, response);
			}
		}
	}

}
