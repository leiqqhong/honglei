package cn.bdqn.entity;

import java.io.Serializable;

public class EasybuyProduct implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public EasybuyProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int epId;
	private String epName;
	private String description;
	private double price;
	private int stock;
	private int epcId;
	private String fileName;
	public int getEpId() {
		return epId;
	}
	public void setEpId(int epId) {
		this.epId = epId;
	}
	public String getEpName() {
		return epName;
	}
	public void setEpName(String epName) {
		this.epName = epName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getEpcId() {
		return epcId;
	}
	public void setEpcId(int epcId) {
		this.epcId = epcId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public EasybuyProduct(int epId, String epName, String description,
			double price, int stock, int epcId, String fileName) {
		super();
		this.epId = epId;
		this.epName = epName;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.epcId = epcId;
		this.fileName = fileName;
	}
	
	public EasybuyProduct(String epName, String description, double price,
			int stock, int epcId, String fileName) {
		super();
		this.epName = epName;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.epcId = epcId;
		this.fileName = fileName;
	}
	
	
	
}
