package cn.bdqn.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.entity.EasybuyProduct;

public class EasybuyProductDao extends BaseDao {

	//��ѯ��ҳ��¼��
	public int getTotalCount(){
		int count = 0;
		String sql="SELECT COUNT(*) FROM EasybuyProduct";
		try {
			rs = super.executeQuery(sql);
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	//��ѯÿҳ��Ӧ�ļ���
	public List<EasybuyProduct> findByPage(int pageNo,int pageSize){
		List<EasybuyProduct> list = new ArrayList<EasybuyProduct>();
		String sql = "SELECT epId,epName,description,price,stock,epcId,fileName FROM easybuy.easybuyproduct LIMIT ?,? ";
		try {
			rs = super.executeQuery(sql, (pageNo-1)*pageSize,pageSize);
			while(rs.next()){
				int epId = rs.getInt("epId");
				String epName = rs.getString("epName");
				String description = rs.getString("description");
				double price = rs.getDouble("price");
				int stock = rs.getInt("stock");
				int epcId = rs.getInt("epcId");
				String fileName = rs.getString("fileName");
				list.add(new EasybuyProduct(epId,epName,description,price,stock,epcId,fileName));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//��ѯ������Ʒ�б�
	public List<EasybuyProduct> findAll(){
		List<EasybuyProduct> list = new ArrayList<EasybuyProduct>();
		String sql = "SELECT epId,epName,description,price,stock,epcId,fileName FROM easybuy.easybuyproduct ";
		try {
			rs = super.executeQuery(sql);
			while(rs.next()){
				int epId = rs.getInt("epId");
				String epName = rs.getString("epName");
				String description = rs.getString("description");
				double price = rs.getDouble("price");
				int stock = rs.getInt("stock");
				int epcId = rs.getInt("epcId");
				String fileName = rs.getString("fileName");
				list.add(new EasybuyProduct(epId,epName,description,price,stock,epcId,fileName));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll(rs, pstmt, conn);
		}
		return list;
	}
	
	//����ID��ѯ��Ʒ�б�
	public EasybuyProduct findEasybuyProductById(int epId){
		EasybuyProduct easybuyProduct = null;
		String sql = "SELECT * FROM `easybuyproduct` WHERE `epId`=?";
		try {
			rs = super.executeQuery(sql, epId);
			if(rs.next()){
			String epName = rs.getString("epName");
			String description = rs.getString("description");
			double price = rs.getDouble("price");
			int stock = rs.getInt("stock");
			int epcId = rs.getInt("epcId");
			String fileName = rs.getString("fileName");
			easybuyProduct = new EasybuyProduct(epId,epName,description,price,stock,epcId,fileName);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeAll(rs, pstmt, conn);
		}
		return easybuyProduct;
	}
	
	//����epcId��ѯ
	public List<EasybuyProduct> findEasybuyProductByEpcId(int epcId){
		List<EasybuyProduct> list = new ArrayList<EasybuyProduct>();
		String sql = "SELECT * FROM `easybuyproduct` WHERE `epcId`=?";
		try {
			rs = super.executeQuery(sql, epcId);
			while(rs.next()){
				int epId = rs.getInt("epId");
				String epName = rs.getString("epName");
				String description = rs.getString("description");
				double price = rs.getDouble("price");
				int stock = rs.getInt("stock");
				String fileName = rs.getString("fileName");
				list.add(new EasybuyProduct(epId, epName, description, price, stock, epcId, fileName));
				}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			super.closeAll(rs, pstmt, conn);
		}
		return list;	
	}
	
	//ɾ��
	public int delProduct(int epId){
		String sql = "DELETE FROM easybuyproduct WHERE epId = ?";
		return super.executeUpdate(sql, epId);
	}
	
	//�޸�
	public int updateProduct(EasybuyProduct product){
		String sql = "UPDATE easybuyproduct SET epName = ? ,description = ? ,price = ? ,stock = ? ,epcId = ? ,fileName = ? WHERE epId = ?";
		return super.executeUpdate(sql, product.getEpName(),product.getDescription(),
				product.getPrice(),product.getStock(),product.getEpcId(),
				product.getFileName(),product.getEpId());
	}
	
	//����
	public int addProduct(EasybuyProduct product){
		String sql = "INSERT INTO easybuyproduct epName, description, price, stock, epcId, fileName VALUES ?,?,?,?,?,?";
		return super.executeUpdate(sql, product);
	}
}
