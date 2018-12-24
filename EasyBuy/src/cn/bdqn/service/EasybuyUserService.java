package cn.bdqn.service;

import java.util.Date;
import java.util.List;

import cn.bdqn.dao.EasybuyUserDao;
import cn.bdqn.entity.EasybuyUser;
import cn.bdqn.util.PageBean;

public class EasybuyUserService {

	private EasybuyUserDao userDao = new EasybuyUserDao();
	//�û���¼
		/*public EasybuyUser login(String name,String pwd){
			EasybuyUser user = userDao.findByUserId(name);
			if(user!=null&&user.getUserPwd().equals(pwd)){
				return user;
			}else{
				return null;
			}
		}*/
	//�û���¼
	
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
	//�û�ע��
	public int addEasybuyUser(String userName,String nickName,String userPwd,
			int userSex,Date birthday,String identityCode,String email,
			String mobile,String address,int status){
		return userDao.addEasybuyUser(userName,nickName,userPwd,userSex,
				birthday,identityCode,email,mobile,address,status);
	}
	
	//��̨�û�����
	public List <EasybuyUser> findAllEasybuyUser(){
		return userDao.findAllEasybuyUser();
	}
	
	//����Id��
	public EasybuyUser findById(int userId){
		return userDao.findById(userId);
	}
	
	//�޸�
	public int updateUser(EasybuyUser easybuy){
		return userDao.updateUser(easybuy);
	}
	
	//ɾ��
	public int delUser(int userId){
		return userDao.delUser(userId);
	}
	
	//��ҳ
	public PageBean<EasybuyUser> findByPage(int pageNo,int pageSize){
		PageBean<EasybuyUser> pageBean = new PageBean<EasybuyUser>();
		//��������������
		pageBean.setPageSize(pageSize);
		//������������
		int totalCount = userDao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		//�������õ�ǰҳ
		pageBean.setPageNo(pageNo);
		//�������ÿҳ�ļ���
		List<EasybuyUser> pageList = userDao.findByPage(pageBean.getPageNo(),pageBean.getPageSize());
		pageBean.setPageList(pageList);
		return pageBean;
		
	}
}
