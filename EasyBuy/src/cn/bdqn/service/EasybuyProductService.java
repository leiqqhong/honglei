package cn.bdqn.service;

import java.util.List;

import cn.bdqn.dao.EasybuyProductDao;
import cn.bdqn.entity.EasybuyProduct;
import cn.bdqn.util.PageBean;

public class EasybuyProductService {

	EasybuyProductDao eastbuyProductDao = new EasybuyProductDao();
	//查询所有商品列表的方法
	public List<EasybuyProduct> findAll(){
		return eastbuyProductDao.findAll();
	}
	
	//根据ID查询商品列表的方法
	public EasybuyProduct findEasybuyProductById(int epId){
		return eastbuyProductDao.findEasybuyProductById(epId);
	}
	
	//根据epcId查询
	public List<EasybuyProduct> findEasybuyProductByEpcId(int epcId){
		return eastbuyProductDao.findEasybuyProductByEpcId(epcId);
	}
	
	//删除
	public int delProduct(int epId){
		return eastbuyProductDao.delProduct(epId);
	}
	
	//修改
	public int updateProduct(EasybuyProduct product){
		return eastbuyProductDao.updateProduct(product);
	}
	
	//新增
	public int addProduct(EasybuyProduct product){
		return eastbuyProductDao.addProduct(product);
	}
	
	//分页
	public PageBean<EasybuyProduct> findByPage(int pageNo,int pageSize){
		PageBean<EasybuyProduct> pageBean = new PageBean<EasybuyProduct>();
		//最先设置总数量
		pageBean.setPageSize(pageSize);
		//再设置总数量
		int totalCount = eastbuyProductDao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		//第三设置当前页
		pageBean.setPageNo(pageNo);
		//最后设置每页的集合
		List<EasybuyProduct> pageList = eastbuyProductDao.findByPage(pageBean.getPageNo(),pageBean.getPageSize());
		pageBean.setPageList(pageList);
		return pageBean;
		
	}
}
