package cn.bdqn.entity;

import java.io.Serializable;

public class ShoppingCartItem implements Serializable{

	private static final long serialVersionUID = 6586239909950271578L;
	private EasybuyProduct product;//��Ʒ
	private int quantity;//����
	private double cost;//�۸�
	
	public ShoppingCartItem(EasybuyProduct product,int quantity){
		this.product = product;
		this.quantity = quantity;
		this.cost = product.getPrice()*quantity;//ÿ�м۸� = ��Ʒ����*��Ʒ����
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

	//��������ʱ�Զ�����cost
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
