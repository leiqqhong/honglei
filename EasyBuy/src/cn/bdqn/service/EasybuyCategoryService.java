package cn.bdqn.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.bdqn.dao.EasybuyCategoryDao;
import cn.bdqn.entity.EasybuyCategory;
import cn.bdqn.util.PageBean;

public class EasybuyCategoryService {

	private EasybuyCategoryDao easybuyCategorydao = new EasybuyCategoryDao();
	
	//查询所有商品分类的方法
	public List<EasybuyCategory> findAll(){
		return easybuyCategorydao.findAll();
	}
	
	//查询商品所有大类
	public List<EasybuyCategory> findEpcIdEqualsParentId(){
		return easybuyCategorydao.findEpcIdEqualsParentId();
	}
		
	//根据大类查看所有小类
	public List<EasybuyCategory> findByParentId(int parentId){
		return easybuyCategorydao.findByParentId(parentId);
	}
	
	public Map<EasybuyCategory,List<EasybuyCategory>> findAllCategory(){
	EasybuyCategoryService easybuyCategoryService = new EasybuyCategoryService();
	Map<EasybuyCategory,List<EasybuyCategory>> mapCategory = new LinkedHashMap<EasybuyCategory,List<EasybuyCategory>>();
	List<EasybuyCategory> eaCategory = easybuyCategoryService.findEpcIdEqualsParentId();
	for (EasybuyCategory easybuyCategory : eaCategory) {
		List<EasybuyCategory> list = easybuyCategoryService.findByParentId(easybuyCategory.getEpcId());
		mapCategory.put(easybuyCategory, list);
		}
	return mapCategory;
	}
	
	//后台
	//根据Id查
	public EasybuyCategory findById(int epcId){
		return easybuyCategorydao.findById(epcId);
	}
	
	//修改
	public int updateCategory(int epcId,int parentId,String epcName){
		return easybuyCategorydao.updateCategory(epcId, parentId, epcName);
	}
	
	//新增
	public int addCategory(int parentId,String epcName){
		return easybuyCategorydao.addCategory(parentId,epcName);
	}
	
	//删除
	public int delCategory(int epcId){
		return easybuyCategorydao.delCategory(epcId);
	}
	
	//分页
	public PageBean<EasybuyCategory> findByPage(int pageNo,int pageSize){
		PageBean<EasybuyCategory> pageBean = new PageBean<EasybuyCategory>();
		//最先设置总数量
		pageBean.setPageSize(pageSize);
		//再设置总数量
		int totalCount = easybuyCategorydao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		//第三设置当前页
		pageBean.setPageNo(pageNo);
		//最后设置每页的集合
		List<EasybuyCategory> pageList = easybuyCategorydao.findByPage(pageBean.getPageNo(),pageBean.getPageSize());
		pageBean.setPageList(pageList);
		return pageBean;
		
	}
	
}
