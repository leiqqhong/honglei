package cn.bdqn.service;

import java.util.Date;
import java.util.List;

import cn.bdqn.dao.EasybuyNewsDao;
import cn.bdqn.entity.EasybuyNews;
import cn.bdqn.util.PageBean;

public class EasybuyNewsService {

	private EasybuyNewsDao easybuyNewsDao = new EasybuyNewsDao();
	
	//查询前8条新闻方法
	public List<EasybuyNews>findAll(){
		return easybuyNewsDao.findAll();
	}
	
	//根据标题ID查询新闻的方法
	public EasybuyNews findEasybuyNewsById(int enId){
		return easybuyNewsDao.findEasybuyNewsById(enId);
	}
	
	//后台查询所有新闻
	public List<EasybuyNews> findAllNews(){
		return easybuyNewsDao.findAllNews();
	}
	
	
	//增加新闻的方法
	public int addEasybuyNews(String title,String content,Date createTime){
		return easybuyNewsDao.addEasybuyNews(title,content,createTime);
	}
	
	//删除新闻的方法
	public int delEasybuyNews(int EasybuyNewsId){
		return easybuyNewsDao.delEasybuyNews(EasybuyNewsId);
	}
	
	//修改新闻
	public int updateNews(int enId, String title, String content) {
		// TODO Auto-generated method stub
		return easybuyNewsDao.updateNews(enId,title,content);
	}
	
	//分页
	public PageBean<EasybuyNews> findByPage(int pageNo,int pageSize){
		PageBean<EasybuyNews> pageBean = new PageBean<EasybuyNews>();
		//最先设置总数量
		pageBean.setPageSize(pageSize);
		//再设置总数量
		int totalCount = easybuyNewsDao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		//第三设置当前页
		pageBean.setPageNo(pageNo);
		//最后设置每页的集合
		List<EasybuyNews> pageList = easybuyNewsDao.findByPage(pageBean.getPageNo(),pageBean.getPageSize());
		pageBean.setPageList(pageList);
		return pageBean;
		
	}
}
