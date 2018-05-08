package cc.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cc.dao.SaleVisitDao;
import cc.domain.LinkMan;
import cc.domain.SaleVisit;
import cc.service.SaleVisitService;
import cc.utils.PageBean;

public class SaleVisitServiceImpl implements SaleVisitService {

	private SaleVisitDao svd;
	

	public void save(SaleVisit saleVisit) {
		//维护customer与baseDict关系
		//保存customer
		svd.saveOrUpdate(saleVisit);
	}
	
	public void setSvd(SaleVisitDao svd) {
		this.svd = svd;
	}

	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer currentCount) {
		//通过dc查询totalCount
		Integer totalCount = svd.getTotalCount(dc);
		//初始化pageBean
		PageBean pb = new PageBean(currentPage,currentCount,totalCount);
		//查询联系人列表
		List<SaleVisit> list = svd.getPageList(dc, pb.getStart(), pb.getCurrentCount());
		//放入pageBean对象，返回
		pb.setList(list);
		return pb;
	}

	public SaleVisit getById(String visit_id) {
		return svd.getById(visit_id);
	}

}
