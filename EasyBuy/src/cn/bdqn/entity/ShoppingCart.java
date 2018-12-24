package cn.bdqn.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//���ﳵ��
public class ShoppingCart implements Serializable {
	
	private static final long serialVersionUID = 7114866748667793827L;
	public List<ShoppingCartItem> items = new ArrayList<ShoppingCartItem>();
	//��ȡ���ﳵ��������Ʒ
	public List<ShoppingCartItem> getItems(){
		return items;
	}
	
	//���һ��
	public void addItem(EasybuyProduct product,int quantity){
		for (int i = 0; i < items.size(); i++) {
			//�жϹ��ﳵ���Ƿ����д���Ʒ,��������ۼ�����
			if((items.get(i).getProduct().getEpId()==product.getEpId())){
				items.get(i).setQuantity(items.get(i).getQuantity()+quantity);
				return;
			}
		}
		items.add(new ShoppingCartItem(product,quantity));
	}
	
	//�Ƴ�һ��
	public void removeItem(int epId){
		int index = -1;
		for (int i = 0; i < items.size(); i++) {
			//�жϹ��ﳵ���Ƿ����д���Ʒ,��������ۼ�����
			if((items.get(i).getProduct().getEpId()==epId)){
				index = i;//�����±�
				break;
			}
		}
		items.remove(index);
	}
	
	//�޸�����
	public void modifyQuantity(int epId,int num){
		int index = -1;
		for (int i = 0; i < items.size(); i++) {
			//�жϹ��ﳵ���Ƿ����д���Ʒ,��������ۼ�����
			if((items.get(i).getProduct().getEpId()==epId)){
				index = i;//�����±�
				break;
			}
		}
		items.get(index).setQuantity(items.get(index).getQuantity()+num);
	}
	
	//�����ܼ۸�--�ṩҳ����{totalCost}
	public double getTotalCost(){
		double sum = 0;
		for (ShoppingCartItem item : items) {
			sum = sum + item.getCost();
		}
		return sum;
	}
}
