package cn.bdqn.service;

import java.util.Date;
import java.util.List;

import cn.bdqn.dao.EasybuyUserDao;
import cn.bdqn.entity.EasybuyUser;
import cn.bdqn.util.PageBean;

public class EasybuyUserService {

	private EasybuyUserDao userDao = new EasybuyUserDao();
	//用户登录
		/*public EasybuyUser login(String name,String pwd){
			EasybuyUser user = userDao.findByUserId(name);
			if(user!=null&&user.getUserPwd().equals(pwd)){
				return user;
			}else{
				return null;
			}
		}*/
	//用户登录
	
	public EasybuyUser doLogin(String userId,String password){
		EasybuyUser user = userDao.findByUserId(userId);
		if(user!=null&&user.getUserPwd().equals(password)){
			return user;
		}else{
			return null;
		}
	}
	
	public EasybuyUser checkUserId(String userId){
		return userDao.findByUserId(userId);
	}
	//用户注册
	public int addEasybuyUser(String userName,String nickName,String userPwd,
			int userSex,Date birthday,String identityCode,String email,
			String mobile,String address,int status){
		return userDao.addEasybuyUser(userName,nickName,userPwd,userSex,
				birthday,identityCode,email,mobile,address,status);
	}
	
	//后台用户管理
	public List <EasybuyUser> findAllEasybuyUser(){
		return userDao.findAllEasybuyUser();
	}
	
	//根据Id查
	public EasybuyUser findById(int userId){
		return userDao.findById(userId);
	}
	
	//修改
	public int updateUser(EasybuyUser easybuy){
		return userDao.updateUser(easybuy);
	}
	
	//删除
	public int delUser(int userId){
		return userDao.delUser(userId);
	}
	
	//分页
	public PageBean<EasybuyUser> findByPage(int pageNo,int pageSize){
		PageBean<EasybuyUser> pageBean = new PageBean<EasybuyUser>();
		//最先设置总数量
		pageBean.setPageSize(pageSize);
		//再设置总数量
		int totalCount = userDao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		//第三设置当前页
		pageBean.setPageNo(pageNo);
		//最后设置每页的集合
		List<EasybuyUser> pageList = userDao.findByPage(pageBean.getPageNo(),pageBean.getPageSize());
		pageBean.setPageList(pageList);
		return pageBean;
		
	}
}
