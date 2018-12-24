package cn.bdqn.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.bdqn.entity.EasybuyProduct;
import cn.bdqn.service.EasybuyProductService;

public class ProductUpdateServlet extends HttpServlet {

	/**
	 * �޸�
	 */
	private static final long serialVersionUID = 1L;
	private EasybuyProductService pService = new EasybuyProductService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// ���ַ�������װ��ΪList����
		List<String> fileType = Arrays.asList("gif", "bmp", "jpg", "jpeg");
		int result = 0;
		boolean flag = true;
		EasybuyProduct product = new EasybuyProduct();
		// �ϴ��ļ��Ĵ洢·�����������ļ�ϵͳ�ϵľ����ļ�·����
		try {
			String path = request.getSession().getServletContext()
					.getRealPath("images/product");
			File file = new File(path);
			if (!file.exists()) {
				file.mkdir();
			}
			//����һ������
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(1024*1024*5);
			int childId = 0;
			@SuppressWarnings("unchecked")
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				if (item.isFormField()) {
					if (item.getFieldName().equals("productName")) {
						//��Ʒ����
						product.setEpName(item.getString("UTF-8"));
					} else if (item.getFieldName().equals("productDetail")) {
						//
						product.setDescription(item.getString("UTF-8"));
					} else if (item.getFieldName().equals("parentId")) {
						//
						childId = Integer.parseInt(item.getString("UTF-8"));
						product.setEpcId(childId);
					} else if (item.getFieldName().equals("productPrice")) {
						//��Ʒ�۸�
						product.setPrice(Double.parseDouble(item
								.getString("UTF-8")));
					} else if (item.getFieldName().equals("productNumber")) {
						//
						product.setStock(Integer.parseInt(item
								.getString("UTF-8")));
					}else if (item.getFieldName().equals("pcid")) {
						//
						product.setEpId(Integer.parseInt(item
								.getString("UTF-8")));
					}

				} else {//�ļ����ֶ�
					String fileName = item.getName();//����ϴ����ļ�
					if (!(fileName == null || fileName.equals(""))) {
						String pic = new File(fileName).getName();
						String type = pic.substring(pic.lastIndexOf(".") + 1);
						if (fileType.contains(type.toLowerCase())) {
							product.setEpId(Integer.parseInt(pic.substring(0,
									pic.lastIndexOf("."))));
							product.setFileName(pic);
							String uploadPath = path + "/" + pic;
							item.write(new File(uploadPath));
						} else {
							flag = false;
						}

					}

				}
			}
			//�޸�
			if (flag) {
				result = pService.updateProduct(product);
				if (result > 0) {
					request.getRequestDispatcher("manage-result.jsp").forward(
							request, response);
				} else {
					request.setAttribute("msg", "�޸�ʧ��!");
					request.getRequestDispatcher("product-modify.jsp").forward(
							request, response);
				}
			} else {
				request.setAttribute("msg", "�ϴ��ļ��ĸ�ʽ����ȷ��");
				request.getRequestDispatcher("product-modify.jsp").forward(
						request, response);
			}

		} catch (FileUploadException e) {
			String msg = "�ϴ�ʧ�ܣ��ϴ��ļ�����";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("product-add.jsp").forward(request,
					response);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
