package cn.bdqn.service;

import java.util.ArrayList;
import java.util.List;

import cn.bdqn.dao.EasybuyOrderDetailDao;
import cn.bdqn.dao.OrderDao;
import cn.bdqn.entity.EasybuyOrder;
import cn.bdqn.entity.EasybuyOrderDetail;
import cn.bdqn.entity.OrderDTO;
import cn.bdqn.entity.OrderParam;
import cn.bdqn.util.PageBean;

public class EasybuyOrderDetailService {

	private OrderDao orderDao = new OrderDao();
	private EasybuyOrderDetailDao orderDetailDao = new EasybuyOrderDetailDao();
	
	public PageBean<OrderDTO> findBypage(int pageNo, int pageSize, OrderParam op) {
		PageBean<OrderDTO> pageBean = new PageBean<OrderDTO>();
		pageBean.setPageSize(pageSize);
		//设置总记录数
		pageBean.setTotalCount(orderDao.getTotal(pageNo,pageSize,op));
		
		
		pageBean.setPageNo(pageNo);
		//分页模糊查询订单号
		List<OrderDTO> dto = new ArrayList<OrderDTO>();
		
		List<EasybuyOrder> orderList = orderDao.findByParam(pageNo,pageSize,op);
			for (EasybuyOrder easybuyOrder : orderList) {
				OrderDTO od = new OrderDTO();
				od.setOrder(easybuyOrder);
				List<EasybuyOrderDetail> li = orderDetailDao.findby(easybuyOrder.getEoId());
				od.setDetaiList(li);
				dto.add(od);
			}
		pageBean.setPageList(dto);
		return pageBean;
	}
	
	//添加订单列表
	public int addOrder(EasybuyOrder order){
		return orderDao.addOrder(order);
	}
	
	//添加订单详情表
	public int addOrderDetail(String eoId,int epId,int quantity,double cost){
		return orderDetailDao.addOrderDetail(eoId, epId, quantity, cost);
	}
	
}
