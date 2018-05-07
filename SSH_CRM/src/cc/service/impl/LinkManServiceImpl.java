package cc.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cc.dao.LinkManDao;
import cc.domain.LinkMan;
import cc.service.LinkManService;
import cc.utils.PageBean;

public class LinkManServiceImpl implements LinkManService {

	private LinkManDao lmd;
	

	public void save(LinkMan linkMan) {
		//����dao����linkman
		lmd.saveOrUpdate(linkMan);

	}
	
	public void setLmd(LinkManDao lmd) {
		this.lmd = lmd;
	}

	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer currentCount) {
		//ͨ��dc��ѯtotalCount
		Integer totalCount = lmd.getTotalCount(dc);
		//��ʼ��pageBean
		PageBean pb = new PageBean(currentPage,currentCount,totalCount);
		//��ѯ��ϵ���б�
		List<LinkMan> list = lmd.getPageList(dc, pb.getStart(), pb.getCurrentCount());
		//����pageBean���󣬷���
		pb.setList(list);
		return pb;
	}

	public LinkMan getById(Long lkm_id) {
		//����dao��ѯ��ϵ��
		
		return lmd.getById(lkm_id);
	}

}
