package cn.bdqn.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.entity.EasybuyOrderDetail;

public class EasybuyOrderDetailDao extends BaseDao{

	//根据订单编号查询
	public List<EasybuyOrderDetail> findby(String eoId){
		List<EasybuyOrderDetail> list = new ArrayList<EasybuyOrderDetail>();
		String sql = "SELECT e.* ,p.epName,p.price,p.fileName FROM"
				+ " easybuyorderdetail e INNER JOIN easybuyproduct p ON (e.epid=p.epid) WHERE eoId=?";
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eoId);
			rs= pstmt.executeQuery();
			while(rs.next()){
				int eodId = rs.getInt("eodId");
				int epId = rs.getInt("epId");
				int quantity = rs.getInt("quantity");
				double cost = rs.getDouble("cost");
				String fileName = rs.getString("fileName");
				String epName = rs.getString("epName");
				double price = rs.getDouble("price");
				EasybuyOrderDetail od = new EasybuyOrderDetail(eodId, eoId, epId, quantity,
						cost, fileName, epName, price);
				list.add(od);
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
	
	//订单详情表
	public int addOrderDetail(String eoId,int epId,int quantity,double cost){
		String sql = "INSERT INTO easybuyorderdetail (eoId, epId,quantity, cost)VALUES(?,?,?,?)";
		return super.executeUpdate(sql,eoId,epId,quantity,cost );
	}
}
