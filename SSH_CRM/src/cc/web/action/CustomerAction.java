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
	Customer customer = new Customer();
	private CustomerService cs;
	
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

	public void setCustomerService(CustomerService cs) {
		this.cs = cs;
	}

	public String list(){
		//创建离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		//判断并封装参数
		if(StringUtils.isNotBlank(customer.getCust_name())){
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		//调用service查询分页数据
		PageBean pb = cs.getPageBean(dc,currentPage,currentCount);
		//将pageBean放入session域
		ActionContext.getContext().getSession().put("pageBean", pb);
		return "list";
		
	}

	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}

	
	
}
