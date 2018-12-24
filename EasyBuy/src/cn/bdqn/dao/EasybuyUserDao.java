package cn.bdqn.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.bdqn.entity.EasybuyUser;

public class EasybuyUserDao extends BaseDao {

	//查询总记录数
	public int getTotalCount(){
		int count = 0;
		String sql="SELECT COUNT(*) FROM EasybuyUser";
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
	public List <EasybuyUser> findByPage(int pageNo,int pageSize){
		List<EasybuyUser> list = new ArrayList<EasybuyUser>();
		String sql = "SELECT userId,userName,nickName,userPwd,userSex,birthday,identityCode,email,mobile,address, STATUS FROM easybuyuser LIMIT ?,?";
		try {
			 rs = super.executeQuery(sql,(pageNo-1)*pageSize,pageSize);
			 while(rs.next()){
			 int userId = rs.getInt("userId");
			 String userName = rs.getString("userName");
			 String nickName = rs.getString("nickName");
			 String userPwd = rs.getString("userPwd");
			 int userSex = rs.getInt("userSex");
			 Date birthday = rs.getDate("birthday");
			 String identityCode = rs.getString("identityCode");
			 String email = rs.getString("email");
			 String mobile = rs.getString("mobile");
			 String address = rs.getString("address");
			 int status = rs.getInt("status");
			 list.add(new EasybuyUser(userId, userName, nickName, userPwd, userSex, birthday, identityCode, email, mobile, address, status));
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
	
	//用户登录,根据用户名查询对象
	public EasybuyUser findByUserId(String userId){
		EasybuyUser user = null;
		String sql = "SELECT * FROM `EasybuyUser` WHERE userName= ? ";
		try {
			rs = super.executeQuery(sql, userId);
			if(rs.next()){
				 int userIdInt = rs.getInt("userId");
				 String userName = rs.getString("userName");
				 String nickName = rs.getString("nickName");
				 String userPwd = rs.getString("userPwd");
				 int userSex = rs.getInt("userSex");
				 Date birthday = rs.getDate("birthday");
				 String identityCode = rs.getString("identityCode");
				 String email = rs.getString("email");
				 String mobile = rs.getString("mobile");
				 String address = rs.getString("address");
				 int status = rs.getInt("status");
				 user = new EasybuyUser(userIdInt,userName,nickName,userPwd,userSex,birthday, identityCode,email,mobile,address,status);
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
		return user;
	}
	
	//用户注册
	public int addEasybuyUser(String userName, String nickName, String userPwd,
			int userSex, Date birthday, String identityCode, String email,
			String mobile, String address, int status) {
			String sql = "INSERT INTO easybuy.easybuyuser" +
					" (userName,nickName,userPwd,userSex,birthday,identityCode," +
					"email,mobile,address,status)VALUES(?,?,?,?,?,?,?,?,?,?)";
		return super.executeUpdate(sql, userName,nickName,userPwd,userSex,birthday,
				identityCode,email,mobile,address,status);
	}
	
	//后台用户管理
	//查询用户
	public List <EasybuyUser> findAllEasybuyUser(){
		List<EasybuyUser> list = new ArrayList<EasybuyUser>();
		String sql = "SELECT userId,userName,nickName,userPwd,userSex,birthday,identityCode,email,mobile,address, STATUS FROM easybuyuser";
		try {
			 rs = super.executeQuery(sql);
			 while(rs.next()){
			 int userId = rs.getInt("userId");
			 String userName = rs.getString("userName");
			 String nickName = rs.getString("nickName");
			 String userPwd = rs.getString("userPwd");
			 int userSex = rs.getInt("userSex");
			 Date birthday = rs.getDate("birthday");
			 String identityCode = rs.getString("identityCode");
			 String email = rs.getString("email");
			 String mobile = rs.getString("mobile");
			 String address = rs.getString("address");
			 int status = rs.getInt("status");
			 list.add(new EasybuyUser(userId, userName, nickName, userPwd, userSex, birthday, identityCode, email, mobile, address, status));
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
	
	//根据Id查
	public EasybuyUser findById(int userId){
		EasybuyUser easybuyUser = null;
		String sql = "SELECT * FROM `easybuyuser` WHERE `userId`=?";
		try {
			rs = super.executeQuery(sql, userId);
			if(rs.next()){
				 String userName = rs.getString("userName");
				 String nickName = rs.getString("nickName");
				 String userPwd = rs.getString("userPwd");
				 int userSex = rs.getInt("userSex");
				 Date birthday = rs.getDate("birthday");
				 String identityCode = rs.getString("identityCode");
				 String email = rs.getString("email");
				 String mobile = rs.getString("mobile");
				 String address = rs.getString("address");
				 int status = rs.getInt("status");
				 easybuyUser = new EasybuyUser(userId,userName,nickName,userPwd,userSex,birthday,identityCode, email, mobile, address, status);
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
		return easybuyUser;
		
	}
	
	//修改
	public int updateUser(EasybuyUser easybuy){
		String sql = "UPDATE easybuy.easybuyuser SET" +
				" userName = ? , nickName = ? , userPwd = ? , userSex = ? ," +
				" birthday = ? , identityCode = ? , mobile = ? ," +
				" address = ?  WHERE userId = ?";
		return super.executeUpdate(sql, easybuy.getUserName(),
				easybuy.getNickName(),easybuy.getUserPwd(),easybuy.getUserSex(),
				easybuy.getBirthday(),easybuy.getIdentityCode(),easybuy.getMobile(),
				easybuy.getAddress(),easybuy.getUserId());
	}
	
	//删除
	public int delUser(int userId){
		String sql = "DELETE FROM easybuy.easybuyuser WHERE userId = ?";
		return super.executeUpdate(sql, userId);
	}
	
}
