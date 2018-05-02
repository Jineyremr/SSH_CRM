package cc.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cc.domain.Customer;

public interface CustomerDao {

	Integer getTotalCount(DetachedCriteria dc);

	List<Customer> getPageList(DetachedCriteria dc, Integer start, Integer currentCount);

}
