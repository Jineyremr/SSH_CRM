package cc.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cc.domain.Customer;
import cc.domain.SaleVisit;
import cc.service.SaleVisitService;
import cc.utils.PageBean;

public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {

	private SaleVisit saleVisit = new SaleVisit();
	private SaleVisitService svs;
	
	private Integer currentPage;
	private Integer currentCount;
	
	public String list() throws Exception{
		System.out.println(currentCount);
		//创建离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
		//判断并封装参数
		if(saleVisit.getCustomer()!=null&&saleVisit.getCustomer().getCust_id()!=null){
			dc.add(Restrictions.eq("customer.cust_id", saleVisit.getCustomer().getCust_id()));
		}
		//调用service查询分页数据
		PageBean pb = svs.getPageBean(dc,currentPage,currentCount);
		//将pageBean放入request域
		ActionContext.getContext().put("pageBean", pb);
		return "list";
		
	}
	
	public String add(){
		//调用servie保存saleVisit
		svs.save(saleVisit);
		//重定向至list		
		return "toList";
	}
	
	public String toEdit(){
		//调用servie通过id查询LinkMan
		SaleVisit lm = svs.getById(saleVisit.getVisit_id());
		//将lm放入request域转发至add	
		ActionContext.getContext().put("linkMan", lm);
		return "edit";
	}
	
	public SaleVisit getModel() {
		// TODO Auto-generated method stub
		return saleVisit;
	}

	public void setSvs(SaleVisitService svs) {
		this.svs = svs;
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
