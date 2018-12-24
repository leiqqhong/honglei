package cn.bdqn.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.bdqn.dao.EasybuyCategoryDao;
import cn.bdqn.entity.EasybuyCategory;
import cn.bdqn.util.PageBean;

public class EasybuyCategoryService {

	private EasybuyCategoryDao easybuyCategorydao = new EasybuyCategoryDao();
	
	//��ѯ������Ʒ����ķ���
	public List<EasybuyCategory> findAll(){
		return easybuyCategorydao.findAll();
	}
	
	//��ѯ��Ʒ���д���
	public List<EasybuyCategory> findEpcIdEqualsParentId(){
		return easybuyCategorydao.findEpcIdEqualsParentId();
	}
		
	//���ݴ���鿴����С��
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
	
	//��̨
	//����Id��
	public EasybuyCategory findById(int epcId){
		return easybuyCategorydao.findById(epcId);
	}
	
	//�޸�
	public int updateCategory(int epcId,int parentId,String epcName){
		return easybuyCategorydao.updateCategory(epcId, parentId, epcName);
	}
	
	//����
	public int addCategory(int parentId,String epcName){
		return easybuyCategorydao.addCategory(parentId,epcName);
	}
	
	//ɾ��
	public int delCategory(int epcId){
		return easybuyCategorydao.delCategory(epcId);
	}
	
	//��ҳ
	public PageBean<EasybuyCategory> findByPage(int pageNo,int pageSize){
		PageBean<EasybuyCategory> pageBean = new PageBean<EasybuyCategory>();
		//��������������
		pageBean.setPageSize(pageSize);
		//������������
		int totalCount = easybuyCategorydao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		//�������õ�ǰҳ
		pageBean.setPageNo(pageNo);
		//�������ÿҳ�ļ���
		List<EasybuyCategory> pageList = easybuyCategorydao.findByPage(pageBean.getPageNo(),pageBean.getPageSize());
		pageBean.setPageList(pageList);
		return pageBean;
		
	}
	
}
