package cn.bdqn.entity;

import java.util.Date;

public class EasybuyUser {

	private int userId;
	private String userName;
	private String nickName;
	private String userPwd;
	private int userSex;
	private Date birthday;
	private String identityCode;
	private String email;
	private String mobile;
	private String address;
	private int status;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public int getUserSex() {
		return userSex;
	}
	public void setUserSex(int userSex) {
		this.userSex = userSex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getIdentityCode() {
		return identityCode;
	}
	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public EasybuyUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EasybuyUser(int userId, String userName, String nickName,
			String userPwd, int userSex, Date birthday, String identityCode,
			String email, String mobile, String address, int status) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.nickName = nickName;
		this.userPwd = userPwd;
		this.userSex = userSex;
		this.birthday = birthday;
		this.identityCode = identityCode;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.status = status;
	}
	public EasybuyUser(int userId, String userName, String nickName,
			String userPwd, int userSex, Date birthday, String identityCode,
			String mobile, String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.nickName = nickName;
		this.userPwd = userPwd;
		this.userSex = userSex;
		this.birthday = birthday;
		this.identityCode = identityCode;
		this.mobile = mobile;
		this.address = address;
	}
	
	
	
}
