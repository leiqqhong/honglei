package cn.bdqn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {

	private String url = "jdbc:mysql://localhost:3306/easybuy?useUnicode=true&" +
			"characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull";
	private String user = "root";
	private String password = "root";
	private String driverName = "com.mysql.jdbc.Driver";
	
	protected Connection conn = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;
	
	//�������
	public Connection getConnection() throws ClassNotFoundException,SQLException{
		Connection conn = null;
		//��������
		Class.forName(driverName);
		//�������
		conn = DriverManager.getConnection(url,user,password);
		return conn;
	}
	
	//�ر���Դ
	public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection conn){
		if(null!=rs){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(null!=pstmt){
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(null!=conn){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//ͨ�ò�ѯ
	public ResultSet executeQuery(String sql,Object...param) throws ClassNotFoundException,SQLException{
		ResultSet rs = null;
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		if(param!=null){
			for (int i=0;i<param.length;i++){
				pstmt.setObject(i+1, param[i]);
			}
		}
		rs = pstmt.executeQuery();
		return rs;
	}
	
	//ͨ����ɾ�Ĳ�
	public int executeUpdate(String sql,Object...param){
		int ret = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			if(param!=null){
				//ռλ
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject((i+1), param[i]);
				}
			}
			ret = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(rs, pstmt, conn);
		}
		return ret;
	}
}
