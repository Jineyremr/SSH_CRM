package cc.web.action;


import java.io.File;

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
	
	//对象名得与name名称相同。struts会自动将图片封装为对象。
	private File photo;
	private String photoFileName;
	
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
		//创建离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		//判断并封装参数
		if(StringUtils.isNotBlank(customer.getCust_name())){
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		//调用service查询分页数据
		PageBean pb = cs.getPageBean(dc,currentPage,currentCount);
		//将pageBean放入request域
		ActionContext.getContext().put("pageBean", pb);
		return "list";
		
	}

	public String add() throws Exception{
		
		
		if(photo!=null){
			//图片上传
			photo.renameTo(new File("e:/"+photoFileName));
		}
		
		
		
		
		
		//调用service保存customer
		cs.add(customer);
		//转发至customeraction
		
		
		return "toList";
		
	}
	
	
	public String toEdit() throws Exception{
		
		//调用service查询customer
		Customer c = cs.getById(customer.getCust_id());
		//将customer放到request域，重定向至edit页面
		ActionContext.getContext().put("customer", c);
		return "edit";
		
	}
	
	
	
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}

	public File getPhoto() {
		return photo;
	}


	public void setPhoto(File photo) {
		this.photo = photo;
	}


	public String getPhotoFileName() {
		return photoFileName;
	}


	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	
	
}
