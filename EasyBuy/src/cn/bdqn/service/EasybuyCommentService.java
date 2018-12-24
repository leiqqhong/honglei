package cn.bdqn.service;

import java.util.Date;
import java.util.List;

import cn.bdqn.dao.EasybuyCommentDao;
import cn.bdqn.entity.EasybuyComment;
import cn.bdqn.util.PageBean;

public class EasybuyCommentService {

	EasybuyCommentDao easybuyCommentDao = new EasybuyCommentDao();
	//��ѯ���Եķ���
	public List<EasybuyComment> findAll(){
		return easybuyCommentDao.findAll();
	}
	
	//��������
	public int addEasybuyComment(String content,Date createTime,String nickName){
		return easybuyCommentDao.addEasybuyComment(content, createTime,nickName);
	}
	
	//Id��
	public EasybuyComment findById(int ecId){
		return easybuyCommentDao.findById(ecId);
	}
	
	//�޸�
	public int updateComment(int ecId,String reply,java.sql.Date replyTime){
		return easybuyCommentDao.updateComment(ecId, reply, replyTime);
	}
	
	//ɾ��
	public int delComment(int ecId){
		return easybuyCommentDao.delComment(ecId);
	}
	
	//��ҳ
	public PageBean<EasybuyComment> findByPage(int pageNo,int pageSize){
		PageBean<EasybuyComment> pageBean = new PageBean<EasybuyComment>();
		//��������������
		pageBean.setPageSize(pageSize);
		//������������
		int totalCount = easybuyCommentDao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		//�������õ�ǰҳ
		pageBean.setPageNo(pageNo);
		//�������ÿҳ�ļ���
		List<EasybuyComment> pageList = easybuyCommentDao.findByPage(pageBean.getPageNo(),pageBean.getPageSize());
		pageBean.setPageList(pageList);
		return pageBean;
		
	}
	
}
