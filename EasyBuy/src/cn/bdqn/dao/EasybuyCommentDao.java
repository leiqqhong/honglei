package cn.bdqn.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.bdqn.entity.EasybuyComment;

public class EasybuyCommentDao extends BaseDao {
	
	//查询总页记录数
	public int getTotalCount(){
		int count = 0;
		String sql="SELECT COUNT(*) FROM EasybuyComment";
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
	public List<EasybuyComment>findByPage(int pageNo,int pageSize){
		List<EasybuyComment> list = new ArrayList<EasybuyComment>();
		String sql = "SELECT ecId,reply,content,createTime,replyTime,nickName FROM easybuy.easybuycomment LIMIT ?, ?";
		try {
			rs = super.executeQuery(sql,(pageNo-1)*pageSize,pageSize);
			while(rs.next()){
				int ecId = rs.getInt("ecId");
				String reply = rs.getString("reply");
				String content = rs.getString("content");
				Date createTime = rs.getDate("createTime");
				Date replyTime = rs.getDate("replyTime");
				String nickName = rs.getString("nickName");
				list.add(new EasybuyComment(ecId,reply,content,createTime,replyTime,nickName));
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
	
	//查询留言
	public List<EasybuyComment> findAll(){
		List<EasybuyComment> list = new ArrayList<EasybuyComment>();
		String sql = "SELECT ecId,reply,content,createTime,replyTime,nickName FROM easybuy.easybuycomment";
		try {
			rs = super.executeQuery(sql);
			while(rs.next()){
				int ecId = rs.getInt("ecId");
				String reply = rs.getString("reply");
				String content = rs.getString("content");
				Date createTime = rs.getDate("createTime");
				Date replyTime = rs.getDate("replyTime");
				String nickName = rs.getString("nickName");
				list.add(new EasybuyComment(ecId,reply,content,createTime,replyTime,nickName));
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
	
	//新增留言
	public int addEasybuyComment(String content,Date createTime,String nickName){
		String sql = "INSERT INTO easybuy.easybuycomment(content,createTime,nickName)VALUES(?,?,?)";
		return super.executeUpdate(sql,content,createTime,nickName);
	}
	
	//修改 先根据Id查
	public EasybuyComment findById(int ecId){
		EasybuyComment easybuyComment = null;
		String sql = "SELECT *FROM easybuycomment WHERE ecId=?";
		try {
			rs = super.executeQuery(sql, ecId);
			if(rs.next()){
				String reply = rs.getString("reply");
				String content = rs.getString("content");
				Date createTime = rs.getDate("createTime");
				Date replyTime = rs.getDate("replyTime");
				String nickName = rs.getString("nickName");
				easybuyComment = new EasybuyComment(ecId,reply,content,createTime,replyTime,nickName);
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
		return easybuyComment;
	}
	
	//修改
	public int updateComment(int ecId,String reply,java.sql.Date replyTime){
		String sql = "UPDATE easybuycomment SET reply = ? , replyTime = ? WHERE ecId = ?";
		return super.executeUpdate(sql,reply,replyTime,ecId);
	}
	
	//删除
	public int delComment(int ecId){
		String sql = "DELETE FROM easybuycomment WHERE ecId = ? ";
		return super.executeUpdate(sql, ecId);
	}
	
}

	
