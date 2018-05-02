package cc.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cc.dao.CustomerDao;
import cc.domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	public Integer getTotalCount(DetachedCriteria dc) {
		//设置聚合函数
		dc.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		//清空之前设置的聚合函数
		dc.setProjection(null);
		if(list!=null && list.size()>0){
			Long count  = list.get(0);
			return count.intValue();
		}else{
			return null;
		}
		
	}

	public List<Customer> getPageList(DetachedCriteria dc, Integer start, Integer currentCount) {
		List<Customer> list = (List<Customer>) getHibernateTemplate().findByCriteria(dc,start,currentCount);
		return list;
	}

}
