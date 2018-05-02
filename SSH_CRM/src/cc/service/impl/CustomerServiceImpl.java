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
		//����dao��ѯtotalCount
		Integer totalCount = cd.getTotalCount(dc);
		//����PageBean
		PageBean pb = new PageBean(currentPage,currentCount,totalCount);
		//����dao��ѯ��ҳ�б�
		List<Customer> list = cd.getPageList(dc,pb.getStart(),pb.getCurrentCount());
		//���б����pageBean
		pb.setList(list);
		return pb;
	}

}
