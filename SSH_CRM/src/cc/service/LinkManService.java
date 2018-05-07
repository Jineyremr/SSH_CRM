package cc.service;

import org.hibernate.criterion.DetachedCriteria;

import cc.domain.LinkMan;
import cc.utils.PageBean;

public interface LinkManService {

	void save(LinkMan linkMan);

	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer currentCount);

	LinkMan getById(Long lkm_id);

}
