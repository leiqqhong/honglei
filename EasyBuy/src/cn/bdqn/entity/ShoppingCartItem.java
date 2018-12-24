package cn.bdqn.entity;

import java.io.Serializable;

public class ShoppingCartItem implements Serializable{

	private static final long serialVersionUID = 6586239909950271578L;
	private EasybuyProduct product;//商品
	private int quantity;//数量
	private double cost;//价格
	
	public ShoppingCartItem(EasybuyProduct product,int quantity){
		this.product = product;
		this.quantity = quantity;
		this.cost = product.getPrice()*quantity;//每行价格 = 商品单价*商品数量
	}

	public EasybuyProduct getProduct() {
		return product;
	}

	public void setProduct(EasybuyProduct product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	//设置数量时自动计算cost
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		this.cost = product.getPrice()*quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
}
