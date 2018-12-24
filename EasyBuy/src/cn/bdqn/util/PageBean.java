package cn.bdqn.util;

import java.util.List;

public class PageBean<T> {

	private int pageNo = 1;//当前页
	private int pageSize = 8;//每页显示数量
	private int totalCount;//从数据库中查询总数量
	private int totalPages;//总页数 只读的
	private List<T> pageList;//每页的集合
	
	public int getPageNo() {
		return pageNo;
	}
	//设置当前页
	public void setPageNo(int pageNo) {
		//当前页不能小于一也不能大于总页数
		if(pageNo<1){
			this.pageNo=1;
		}else if(pageNo>totalPages && totalPages!=0){
			this.pageNo = totalPages;
		}else{
			this.pageNo = pageNo;
		}
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		//自动计算总页数
		this.totalPages = totalCount%pageSize==0?
				totalCount/pageSize:totalCount/pageSize+1;
	}
	
	//只读的
	public int getTotalPages() {
		return totalPages;
	}
	
	public List<T> getPageList() {
		return pageList;
	}
	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageBean(int pageNo, int pageSize, int totalCount, int totalPages,
			List<T> pageList) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPages = totalPages;
		this.pageList = pageList;
	}
	
	
}
