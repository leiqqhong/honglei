package cn.bdqn.entity;

import java.sql.Timestamp;
import java.util.Date;

public class EasybuyOrder {

	//订单表
	private String eoId;//编号
	private int userId;//用户Id
	private String userName;
	private String address;//收货地址
	private Timestamp  createTime;//创建时间
	private double cost;//金额
	private int status;//订单状态
	private int type;//付款方式
	public String getEoId() {
		return eoId;
	}
	public void setEoId(String eoId) {
		this.eoId = eoId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp  createTime) {
		this.createTime = createTime;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public EasybuyOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EasybuyOrder(String eoId, int userId, String userName,
			String address, Timestamp  createTime, double cost, int status, int type) {
		super();
		this.eoId = eoId;
		this.userId = userId;
		this.userName = userName;
		this.address = address;
		this.createTime = createTime;
		this.cost = cost;
		this.status = status;
		this.type = type;
	}
	
}
