package cn.bdqn.util;

import java.util.List;

public class PageBean<T> {

	private int pageNo = 1;//��ǰҳ
	private int pageSize = 8;//ÿҳ��ʾ����
	private int totalCount;//�����ݿ��в�ѯ������
	private int totalPages;//��ҳ�� ֻ����
	private List<T> pageList;//ÿҳ�ļ���
	
	public int getPageNo() {
		return pageNo;
	}
	//���õ�ǰҳ
	public void setPageNo(int pageNo) {
		//��ǰҳ����С��һҲ���ܴ�����ҳ��
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
		//�Զ�������ҳ��
		this.totalPages = totalCount%pageSize==0?
				totalCount/pageSize:totalCount/pageSize+1;
	}
	
	//ֻ����
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
