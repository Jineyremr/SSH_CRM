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
		//ά��customer��baseDict��ϵ
		//����customer
		svd.saveOrUpdate(saleVisit);
	}
	
	public void setSvd(SaleVisitDao svd) {
		this.svd = svd;
	}

	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer currentCount) {
		//ͨ��dc��ѯtotalCount
		Integer totalCount = svd.getTotalCount(dc);
		//��ʼ��pageBean
		PageBean pb = new PageBean(currentPage,currentCount,totalCount);
		//��ѯ��ϵ���б�
		List<SaleVisit> list = svd.getPageList(dc, pb.getStart(), pb.getCurrentCount());
		//����pageBean���󣬷���
		pb.setList(list);
		return pb;
	}

	public SaleVisit getById(String visit_id) {
		return svd.getById(visit_id);
	}

}
