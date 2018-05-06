package cc.web.action;


import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


import cc.domain.*;
import cc.service.CustomerService;
import cc.service.UserService;
import cc.utils.PageBean;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	private Customer customer = new Customer();
	private CustomerService cs;
	
	public void setCs(CustomerService cs) {
		this.cs = cs;
	}

	private Integer currentPage;
	private Integer currentCount;
	
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

	
	public String list() throws Exception{
		System.out.println(currentCount);
		//�������߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		//�жϲ���װ����
		if(StringUtils.isNotBlank(customer.getCust_name())){
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		//����service��ѯ��ҳ����
		PageBean pb = cs.getPageBean(dc,currentPage,currentCount);
		//��pageBean����request��
		ActionContext.getContext().put("pageBean", pb);
		return "list";
		
	}

	public String add() throws Exception{
		
		
		//����service����customer
		cs.add(customer);
		//ת����customeraction
		
		
		return "toList";
		
	}
	
	
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}

	
	
}
