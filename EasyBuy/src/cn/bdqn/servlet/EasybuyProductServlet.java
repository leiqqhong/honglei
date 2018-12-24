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

		//根据Id查询商品列表
		
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
		//购物车
		if("shoppingCart".equals(action)){
			String opr = request.getParameter("opr");
			String epIdStr = request.getParameter("epId").trim();
			int epId = Integer.parseInt(epIdStr);
			ShoppingCart cart =  (ShoppingCart)request.getSession().getAttribute("cart");
			if(cart==null){//如果为空,还要将你所要添加的商品加入进去.
				cart = new ShoppingCart();
				EasybuyProduct easybuyProduct1 = easybuyProductService.findEasybuyProductById(epId);
				cart.addItem(easybuyProduct1, 1);	
			}
			if("add".equals(opr)){
					//新增
					EasybuyProduct easybuyProduct = easybuyProductService.findEasybuyProductById(epId);
					//判断session中是否有cart
					int quantity = 1;//添加数量
					cart.addItem(easybuyProduct, quantity);		
			}
			if("del".equals(opr)){
				//删除
				cart.removeItem(epId);
			}
			if("update".equals(opr)){
				//修改
				String numStr = request.getParameter("num");
				int num = Integer.parseInt(numStr);
				cart.modifyQuantity(epId, num);
			}
			request.getSession().setAttribute("cart", cart);
			/*request.getRequestDispatcher("shopping.jsp").forward(request, response);*/
			response.sendRedirect("shopping.jsp");
			
		}
		//根据Id查询商品列表
		if("findById".equals(action)){
			String epIdStr = request.getParameter("epId").trim();
			if(epIdStr!=null){
				int epId = Integer.parseInt(epIdStr);
				EasybuyProduct easybuyProduct = easybuyProductService.findEasybuyProductById(epId);
				//把商品放入cookie 命名ckproList
				Cookie ckproList = null;
				//先找到之前的cookie
				Cookie[] cks = request.getCookies();
				for (Cookie cookie : cks) {
					if("ckproList".equals(cookie.getName())){
						ckproList = cookie;//找到了
						//把新的id拼接到value
						ckproList.setValue(ckproList.getValue()+epId+",");
						break;
					}
				}
				if(ckproList == null){
					//以前没有放过
					ckproList = new Cookie("ckproList",epId+",");
				}
				//通过response添加cookie
				response.addCookie(ckproList);
				
				request.setAttribute("easybuyProduct", easybuyProduct);
				request.getRequestDispatcher("product-view.jsp").forward(request, response);
			}
		}
	}

}
