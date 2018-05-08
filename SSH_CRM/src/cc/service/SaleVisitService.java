package cc.service;

import org.hibernate.criterion.DetachedCriteria;

import cc.domain.SaleVisit;
import cc.utils.PageBean;

public interface SaleVisitService {

	void save(SaleVisit saleVisit);

	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer currentCount);

	SaleVisit getById(String visit_id);

}
