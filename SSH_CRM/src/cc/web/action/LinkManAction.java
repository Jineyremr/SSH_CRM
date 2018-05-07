package cc.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cc.domain.LinkMan;
import cc.service.LinkManService;
import cc.utils.PageBean;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

	private LinkMan linkMan = new LinkMan();
	private LinkManService lms;
	
	private Integer currentPage;
	private Integer currentCount;
	public String list(){
		//�������߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		if(StringUtils.isNotBlank(linkMan.getLkm_name())){
			dc.add(Restrictions.like("lkm_name", "%"+linkMan.getLkm_name()+"%"));
		}
		if(linkMan.getCustomer()!=null&&linkMan.getCustomer().getCust_id()!=null){
			dc.add(Restrictions.eq("customer.cust_id", linkMan.getCustomer().getCust_id()));
		}
		//����servie��ѯ��ҳ����
		PageBean pb = lms.getPageBean(dc,currentPage,currentCount);
		//��pagebean����request��ת�����б�ҳ����
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	public String add(){
		//����servie����linkMan
		lms.save(linkMan);
		//�ض�����list		
		return "toList";
	}
	
	public String toEdit(){
		//����servieͨ��id��ѯLinkMan
		LinkMan lm = lms.getById(linkMan.getLkm_id());
		//��lm����request��ת����add	
		ActionContext.getContext().put("linkMan", lm);
		return "edit";
	}
	
	
	public LinkMan getModel() {
		// TODO Auto-generated method stub
		return linkMan;
	}


	public void setLms(LinkManService lms) {
		this.lms = lms;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(Integer currentCount) {
		this.currentCount = currentCount;
	}

}
