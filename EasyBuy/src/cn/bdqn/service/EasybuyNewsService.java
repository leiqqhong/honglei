package cn.bdqn.service;

import java.util.Date;
import java.util.List;

import cn.bdqn.dao.EasybuyNewsDao;
import cn.bdqn.entity.EasybuyNews;
import cn.bdqn.util.PageBean;

public class EasybuyNewsService {

	private EasybuyNewsDao easybuyNewsDao = new EasybuyNewsDao();
	
	//��ѯǰ8�����ŷ���
	public List<EasybuyNews>findAll(){
		return easybuyNewsDao.findAll();
	}
	
	//���ݱ���ID��ѯ���ŵķ���
	public EasybuyNews findEasybuyNewsById(int enId){
		return easybuyNewsDao.findEasybuyNewsById(enId);
	}
	
	//��̨��ѯ��������
	public List<EasybuyNews> findAllNews(){
		return easybuyNewsDao.findAllNews();
	}
	
	
	//�������ŵķ���
	public int addEasybuyNews(String title,String content,Date createTime){
		return easybuyNewsDao.addEasybuyNews(title,content,createTime);
	}
	
	//ɾ�����ŵķ���
	public int delEasybuyNews(int EasybuyNewsId){
		return easybuyNewsDao.delEasybuyNews(EasybuyNewsId);
	}
	
	//�޸�����
	public int updateNews(int enId, String title, String content) {
		// TODO Auto-generated method stub
		return easybuyNewsDao.updateNews(enId,title,content);
	}
	
	//��ҳ
	public PageBean<EasybuyNews> findByPage(int pageNo,int pageSize){
		PageBean<EasybuyNews> pageBean = new PageBean<EasybuyNews>();
		//��������������
		pageBean.setPageSize(pageSize);
		//������������
		int totalCount = easybuyNewsDao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		//�������õ�ǰҳ
		pageBean.setPageNo(pageNo);
		//�������ÿҳ�ļ���
		List<EasybuyNews> pageList = easybuyNewsDao.findByPage(pageBean.getPageNo(),pageBean.getPageSize());
		pageBean.setPageList(pageList);
		return pageBean;
		
	}
}
