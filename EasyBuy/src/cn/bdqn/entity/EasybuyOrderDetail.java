package cn.bdqn.entity;

public class EasybuyOrderDetail {

	//���������
	private int eodId; //���
	private String eoId; //�������
	private int epId; //��Ʒ���
	private int quantity; //����
	private double cost; //���
	
	
	private String fileName;//ͼƬ·��
	private String epName; //����
	private double price;//��Ʒ�۸�


	public EasybuyOrderDetail() {
		super();
	}

	public int getEodId() {
		return eodId;
	}

	public void setEodId(int eodId) {
		this.eodId = eodId;
	}

	
	public String getEoId() {
		return eoId;
	}

	public void setEoId(String eoId) {
		this.eoId = eoId;
	}

	public int getEpId() {
		return epId;
	}

	public void setEpId(int epId) {
		this.epId = epId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getEpName() {
		return epName;
	}

	public void setEpName(String epName) {
		this.epName = epName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public EasybuyOrderDetail(int eodId, String eoId, int epId, int quantity,
			double cost, String fileName, String epName, double price) {
		super();
		this.eodId = eodId;
		this.eoId = eoId;
		this.epId = epId;
		this.quantity = quantity;
		this.cost = cost;
		this.fileName = fileName;
		this.epName = epName;
		this.price = price;
	}
	
	
	
	
}
