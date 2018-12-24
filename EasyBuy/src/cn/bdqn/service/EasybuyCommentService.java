package cn.bdqn.service;

import java.util.Date;
import java.util.List;

import cn.bdqn.dao.EasybuyCommentDao;
import cn.bdqn.entity.EasybuyComment;
import cn.bdqn.util.PageBean;

public class EasybuyCommentService {

	EasybuyCommentDao easybuyCommentDao = new EasybuyCommentDao();
	//查询留言的方法
	public List<EasybuyComment> findAll(){
		return easybuyCommentDao.findAll();
	}
	
	//新增留言
	public int addEasybuyComment(String content,Date createTime,String nickName){
		return easybuyCommentDao.addEasybuyComment(content, createTime,nickName);
	}
	
	//Id查
	public EasybuyComment findById(int ecId){
		return easybuyCommentDao.findById(ecId);
	}
	
	//修改
	public int updateComment(int ecId,String reply,java.sql.Date replyTime){
		return easybuyCommentDao.updateComment(ecId, reply, replyTime);
	}
	
	//删除
	public int delComment(int ecId){
		return easybuyCommentDao.delComment(ecId);
	}
	
	//分页
	public PageBean<EasybuyComment> findByPage(int pageNo,int pageSize){
		PageBean<EasybuyComment> pageBean = new PageBean<EasybuyComment>();
		//最先设置总数量
		pageBean.setPageSize(pageSize);
		//再设置总数量
		int totalCount = easybuyCommentDao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		//第三设置当前页
		pageBean.setPageNo(pageNo);
		//最后设置每页的集合
		List<EasybuyComment> pageList = easybuyCommentDao.findByPage(pageBean.getPageNo(),pageBean.getPageSize());
		pageBean.setPageList(pageList);
		return pageBean;
		
	}
	
}
