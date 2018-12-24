package cn.bdqn.entity;

public class EasybuyCategory {

	private int epcId;
	private String epcName;
	private int parentId;
	
	public EasybuyCategory(int epcId, String epcName, int parentId) {
		super();
		this.epcId = epcId;
		this.epcName = epcName;
		this.parentId = parentId;
	}
	public EasybuyCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEpcId() {
		return epcId;
	}
	public void setEpcId(int epcId) {
		this.epcId = epcId;
	}
	public String getEpcName() {
		return epcName;
	}
	public void setEpcName(String epcName) {
		this.epcName = epcName;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
	
}
