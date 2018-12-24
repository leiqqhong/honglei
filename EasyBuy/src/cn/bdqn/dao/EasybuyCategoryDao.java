package cn.bdqn.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.bdqn.entity.EasybuyCategory;

public class EasybuyCategoryDao extends BaseDao {
	
	//查询总页记录数
	public int getTotalCount(){
		int count = 0;
		String sql="SELECT COUNT(*) FROM easybuycategory";
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

	//查询每页对应的集合
	public List<EasybuyCategory> findByPage(int pageNo,int pageSize){
		List<EasybuyCategory> list = new ArrayList<EasybuyCategory>();
		String sql = "SELECT epcId,epcName,parentId FROM easybuy.easybuycategory LIMIT ?,?";
		try {
			rs = super.executeQuery(sql,(pageNo-1)*pageSize,pageSize);
			while(rs.next()){
				 int epcId = rs.getInt("epcId");
				 String epcName = rs.getString("epcName");
				 int parentId = rs.getInt("parentId");
				 list.add(new EasybuyCategory(epcId,epcName,parentId));
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
	
	//查询所有商品分类
	public List<EasybuyCategory> findAll(){
		List<EasybuyCategory> list = new ArrayList<EasybuyCategory>();
		String sql = "SELECT epcId,epcName,parentId FROM easybuy.easybuycategory";
		try {
			rs = super.executeQuery(sql);
			while(rs.next()){
				 int epcId = rs.getInt("epcId");
				 String epcName = rs.getString("epcName");
				 int parentId = rs.getInt("parentId");
				 list.add(new EasybuyCategory(epcId,epcName,parentId));
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
	
	//查询商品所有大类
	public List<EasybuyCategory> findEpcIdEqualsParentId(){
		List<EasybuyCategory> list = new ArrayList<EasybuyCategory>();
		/*String sql = "SELECT * FROM easybuy.easybuycategory WHERE epcId = parentId";*/
		String sql = "SELECT epcId,epcName,parentId FROM easybuycategory " +
				" WHERE epcId = parentId OR parentId = 0";
		try {
			rs = super.executeQuery(sql);
			while(rs.next()){
				 int epcId = rs.getInt("epcId");
				 String epcName = rs.getString("epcName");
				 int parentId = rs.getInt("parentId");
				 list.add(new EasybuyCategory(epcId,epcName,parentId));
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

	//根据大类查看所有小类
	public List<EasybuyCategory> findByParentId(int epcId) {
		List<EasybuyCategory> list = new ArrayList<EasybuyCategory>();
		/*String sql = "SELECT epcId,epcName,parentId FROM easybuycategory where parentId=? and epcId!=parentId";*/
		String sql = "SELECT epcId,epcName,parentId FROM easybuycategory WHERE parentId=? AND parentId <>epcId";
		try {
			rs = super.executeQuery(sql,epcId);
			while(rs.next()){
				 int epcIda = rs.getInt("epcId");
				 String epcName = rs.getString("epcName");
				 int parentId = rs.getInt("parentId");
				 list.add(new EasybuyCategory(epcIda,epcName,parentId));
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
	
	//后台修改,先根据Id查
	public EasybuyCategory findById(int epcId){
		EasybuyCategory easybuyCategory = null;
		String sql = "SELECT *FROM easybuycategory WHERE epcId=?";
		try {
			rs = super.executeQuery(sql, epcId);
			while(rs.next()){
			String epcName = rs.getString("epcName");
			int parentId = rs.getInt("parentId");
			easybuyCategory = new EasybuyCategory(epcId,epcName,parentId);
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
		return easybuyCategory;
	}
	
	//修改
	public int updateCategory(int epcId,int parentId,String epcName){
		String sql = "UPDATE easybuycategory SET epcName = ? , parentId = ? WHERE epcId = ?";
		return super.executeUpdate(sql, epcName,parentId, epcId);
	}
	
	//新增
	public int addCategory(int parentId,String epcName){
		String sql = "INSERT INTO easybuy.easybuycategory (epcName, parentId) VALUES (?,?)";
		return super.executeUpdate(sql, epcName,parentId);
	}
	
	//删除
	public int delCategory(int epcId){
		String sql = "DELETE FROM easybuycategory WHERE epcId = ?";
		return super.executeUpdate(sql, epcId);
	}
		
}
