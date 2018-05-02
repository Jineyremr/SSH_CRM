package cc.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cc.dao.CustomerDao;
import cc.domain.Customer;
import cc.service.CustomerService;
import cc.utils.PageBean;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao cd;
	
	
	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}


	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer currentCount) {
		//调用dao查询totalCount
		Integer totalCount = cd.getTotalCount(dc);
		//创建PageBean
		PageBean pb = new PageBean(currentPage,currentCount,totalCount);
		//调用dao查询分页列表
		List<Customer> list = cd.getPageList(dc,pb.getStart(),pb.getCurrentCount());
		//将列表放入pageBean
		pb.setList(list);
		return pb;
	}

}
