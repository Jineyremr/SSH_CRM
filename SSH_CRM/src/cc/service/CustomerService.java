package cc.service;

import org.hibernate.criterion.DetachedCriteria;

import cc.utils.PageBean;

public interface CustomerService {

	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer currentCount);

}
