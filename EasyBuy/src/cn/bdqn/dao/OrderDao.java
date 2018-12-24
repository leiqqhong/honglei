package cn.bdqn.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.entity.EasybuyOrder;
import cn.bdqn.entity.OrderParam;

public class OrderDao extends BaseDao{

	//分页模糊查询
	public List<EasybuyOrder>findByParam(int pageNo,int pageSize,OrderParam op){
		StringBuffer sql = new StringBuffer("SELECT*FROM easybuyorder WHERE 1=1");
		if(op.getEoId()!=null){
			sql.append(" and eoId like '%" + op.getEoId() + "%'");
		}
		if(op.getUserId() !=null){
			sql.append(" and userName like '%" + op.getUserId() + "%'");
		}
		sql.append(" Limit ?,?");
		List<EasybuyOrder> list = new ArrayList<EasybuyOrder>();
		System.out.println(sql);
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, (pageNo-1) * pageSize);
			pstmt.setInt(2, pageSize);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				String eoId = rs.getString("eoId");
				int userId = rs.getInt("userId");
				String userName = rs.getString("userName");
				String address = rs.getString("address");
				Timestamp createTime = rs.getTimestamp("createTime");
				double cost = rs.getDouble("cost");
				int status = rs.getInt("status");
				int type = rs.getInt("type");
				EasybuyOrder order = new EasybuyOrder(eoId,userId,userName,address,createTime,cost,status,type);
				list.add(order);
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeAll(rs, pstmt, conn);
		}
		return list;
	}
	
	//分页模糊查询总页数
	public  int getTotal(int pageNo,int pageSize,OrderParam op){
		int count = 0;
		StringBuffer sql = new StringBuffer("SELECT COUNT(eoId) FROM easybuyorder WHERE 1=1");
		if(op.getEoId() !=null){
			sql.append(" and eoId like '%" + op.getEoId() + "%'");
		}
		if(op.getUserId() !=null){
			sql.append(" and userId like '%" + op.getUserId() + "%'");
		}
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(rs, pstmt, conn);
		}
		return count;
	}
	
	//添加订单列表
	public int addOrder(EasybuyOrder order){
		String sql = "INSERT INTO easybuyorder (eoId, userId, userName, address, createTime, cost, STATUS, TYPE)VALUES(?,?,?,?,?,?,?,?)";
		return super.executeUpdate(sql, order.getEoId(),order.getUserId(),order.getUserName(),
				order.getAddress(),order.getCreateTime(),order.getCost(),order.getStatus(),order.getType());
	}
}
