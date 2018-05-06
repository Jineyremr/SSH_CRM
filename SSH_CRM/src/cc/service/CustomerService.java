package cc.service;

import org.hibernate.criterion.DetachedCriteria;

import cc.domain.Customer;
import cc.utils.PageBean;

public interface CustomerService {

	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer currentCount);

	public void add(Customer customer);

}
