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
		//调用dao保存linkman
		lmd.saveOrUpdate(linkMan);

	}
	
	public void setLmd(LinkManDao lmd) {
		this.lmd = lmd;
	}

	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer currentCount) {
		//通过dc查询totalCount
		Integer totalCount = lmd.getTotalCount(dc);
		//初始化pageBean
		PageBean pb = new PageBean(currentPage,currentCount,totalCount);
		//查询联系人列表
		List<LinkMan> list = lmd.getPageList(dc, pb.getStart(), pb.getCurrentCount());
		//放入pageBean对象，返回
		pb.setList(list);
		return pb;
	}

	public LinkMan getById(Long lkm_id) {
		//调用dao查询联系人
		
		return lmd.getById(lkm_id);
	}

}
