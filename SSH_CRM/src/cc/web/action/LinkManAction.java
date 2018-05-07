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
		//创建离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		if(StringUtils.isNotBlank(linkMan.getLkm_name())){
			dc.add(Restrictions.like("lkm_name", "%"+linkMan.getLkm_name()+"%"));
		}
		if(linkMan.getCustomer()!=null&&linkMan.getCustomer().getCust_id()!=null){
			dc.add(Restrictions.eq("customer.cust_id", linkMan.getCustomer().getCust_id()));
		}
		//调用servie查询分页数据
		PageBean pb = lms.getPageBean(dc,currentPage,currentCount);
		//将pagebean放入request域，转发到列表页面显
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	public String add(){
		//调用servie保存linkMan
		lms.save(linkMan);
		//重定向至list		
		return "toList";
	}
	
	public String toEdit(){
		//调用servie通过id查询LinkMan
		LinkMan lm = lms.getById(linkMan.getLkm_id());
		//将lm放入request域转发至add	
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
