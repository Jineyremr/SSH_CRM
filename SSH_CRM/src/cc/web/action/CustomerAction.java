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
	
	//����������name������ͬ��struts���Զ���ͼƬ��װΪ����
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
		
		
		if(photo!=null){
			//ͼƬ�ϴ�
			photo.renameTo(new File("e:/"+photoFileName));
		}
		
		
		
		
		
		//����service����customer
		cs.add(customer);
		//ת����customeraction
		
		
		return "toList";
		
	}
	
	
	public String toEdit() throws Exception{
		
		//����service��ѯcustomer
		Customer c = cs.getById(customer.getCust_id());
		//��customer�ŵ�request���ض�����editҳ��
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
