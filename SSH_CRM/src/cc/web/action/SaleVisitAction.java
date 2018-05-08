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
		//�������߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
		//�жϲ���װ����
		if(saleVisit.getCustomer()!=null&&saleVisit.getCustomer().getCust_id()!=null){
			dc.add(Restrictions.eq("customer.cust_id", saleVisit.getCustomer().getCust_id()));
		}
		//����service��ѯ��ҳ����
		PageBean pb = svs.getPageBean(dc,currentPage,currentCount);
		//��pageBean����request��
		ActionContext.getContext().put("pageBean", pb);
		return "list";
		
	}
	
	public String add(){
		//����servie����saleVisit
		svs.save(saleVisit);
		//�ض�����list		
		return "toList";
	}
	
	public String toEdit(){
		//����servieͨ��id��ѯLinkMan
		SaleVisit lm = svs.getById(saleVisit.getVisit_id());
		//��lm����request��ת����add	
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
