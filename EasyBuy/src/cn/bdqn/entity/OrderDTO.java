package cn.bdqn.entity;

import java.util.List;

public class OrderDTO {

	private EasybuyOrder order;
	private List<EasybuyOrderDetail> detaiList;
	public EasybuyOrder getOrder() {
		return order;
	}
	public void setOrder(EasybuyOrder order) {
		this.order = order;
	}
	public List<EasybuyOrderDetail> getDetaiList() {
		return detaiList;
	}
	public void setDetaiList(List<EasybuyOrderDetail> detaiList) {
		this.detaiList = detaiList;
	}
	
	
}
