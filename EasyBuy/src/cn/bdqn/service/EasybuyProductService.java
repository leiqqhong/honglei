package cn.bdqn.service;

import java.util.List;

import cn.bdqn.dao.EasybuyProductDao;
import cn.bdqn.entity.EasybuyProduct;
import cn.bdqn.util.PageBean;

public class EasybuyProductService {

	EasybuyProductDao eastbuyProductDao = new EasybuyProductDao();
	//��ѯ������Ʒ�б�ķ���
	public List<EasybuyProduct> findAll(){
		return eastbuyProductDao.findAll();
	}
	
	//����ID��ѯ��Ʒ�б�ķ���
	public EasybuyProduct findEasybuyProductById(int epId){
		return eastbuyProductDao.findEasybuyProductById(epId);
	}
	
	//����epcId��ѯ
	public List<EasybuyProduct> findEasybuyProductByEpcId(int epcId){
		return eastbuyProductDao.findEasybuyProductByEpcId(epcId);
	}
	
	//ɾ��
	public int delProduct(int epId){
		return eastbuyProductDao.delProduct(epId);
	}
	
	//�޸�
	public int updateProduct(EasybuyProduct product){
		return eastbuyProductDao.updateProduct(product);
	}
	
	//����
	public int addProduct(EasybuyProduct product){
		return eastbuyProductDao.addProduct(product);
	}
	
	//��ҳ
	public PageBean<EasybuyProduct> findByPage(int pageNo,int pageSize){
		PageBean<EasybuyProduct> pageBean = new PageBean<EasybuyProduct>();
		//��������������
		pageBean.setPageSize(pageSize);
		//������������
		int totalCount = eastbuyProductDao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		//�������õ�ǰҳ
		pageBean.setPageNo(pageNo);
		//�������ÿҳ�ļ���
		List<EasybuyProduct> pageList = eastbuyProductDao.findByPage(pageBean.getPageNo(),pageBean.getPageSize());
		pageBean.setPageList(pageList);
		return pageBean;
		
	}
}
