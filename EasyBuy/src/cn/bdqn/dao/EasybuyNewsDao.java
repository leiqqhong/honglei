package cn.bdqn.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.bdqn.entity.EasybuyNews;

public class EasybuyNewsDao extends BaseDao {
	
	//��ѯ��ҳ��¼��
	public int getTotalCount(){
		int count = 0;
		String sql="SELECT COUNT(*) FROM EasybuyNews";
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
	public List<EasybuyNews>findByPage(int pageNo,int pageSize){
		List<EasybuyNews> list = new ArrayList<EasybuyNews>();
		String sql = "SELECT enId,title,content,createTime FROM easybuynews LIMIT ?,?";
		try {
			rs = super.executeQuery(sql,(pageNo-1)*pageSize,pageSize);
			while (rs.next()) {
				int enId = rs.getInt("enId");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Date createTime = rs.getDate("createTime");
				list.add(new EasybuyNews(enId, title, content, createTime));
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
		return list;
	}
	// ��ѯǰ8������
	public List<EasybuyNews> findAll() {
		List<EasybuyNews> list = new ArrayList<EasybuyNews>();
		String sql = "SELECT enId,title,content,createTime FROM easybuynews ORDER BY createTime DESC LIMIT 8";
		try {
			rs = super.executeQuery(sql);
			while (rs.next()) {
				int enId = rs.getInt("enId");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Date createTime = rs.getDate("createTime");
				list.add(new EasybuyNews(enId, title, content, createTime));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(rs, pstmt, conn);
		}
		return list;
	}

	// ���ݱ���ID��ѯ����
	public EasybuyNews findEasybuyNewsById(int enId) {
		EasybuyNews easybuyNews = null;
		String sql = "SELECT * FROM `easybuynews` WHERE `enId`=?";
		try {
			rs = super.executeQuery(sql, enId);
			if (rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				Date createTime = rs.getDate("createTime");
				easybuyNews = new EasybuyNews(enId, title, content, createTime);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(rs, pstmt, conn);
		}
		return easybuyNews;

	}
	
	//��̨ ��ѯ��������
	public List<EasybuyNews> findAllNews() {
		List<EasybuyNews> list = new ArrayList<EasybuyNews>();
		String sql = "SELECT enId, title, content, createTime FROM easybuynews ";
		try {
			rs = super.executeQuery(sql);
			while (rs.next()) {
				int enId = rs.getInt("enId");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Date createTime = rs.getDate("createTime");
				list.add(new EasybuyNews(enId, title, content, createTime));
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
		return list;
	}
	
		//����Id��,���������findEasybuyNewsById
	 
		//�޸�����
		public int updateNews(int enId, String title, String content) {
			String sql = "UPDATE easybuynews SET title = ?, content = ? WHERE enId = ?";
			return super.executeUpdate(sql, title,content,enId);
		}
		
		// ɾ������
		public int delEasybuyNews(int EasybuyNewsId) {
			String sql = "DELETE FROM easybuy.easybuynews WHERE enId = ?";
			return super.executeUpdate(sql, EasybuyNewsId);
		}

		// ��������
		public int addEasybuyNews(String title, String content, Date createTime) {
			String sql = "INSERT INTO easybuy.easybuynews (title,content,createTime)VALUES( ?, ?, ?)";
			return super.executeUpdate(sql, title, content, createTime);
		}

	
	
}
