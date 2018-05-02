package cc.utils;

import java.util.List;

public class PageBean {

	//��ǰҳ��
	private Integer currentPage;
	//��ǰ������
	private Integer currentCount;
	//��ҳ��
	private Integer totalPage;
	//������
	private Integer totalCount;
	//ÿ��ʵ��
	private List list;
	
	//��ʼ��
	public PageBean(Integer currentPage, Integer currentCount, Integer totalCount) {
		
		this.currentPage = currentPage;
		this.currentCount = currentCount;
		this.totalCount = totalCount;
		
		if(this.currentPage==null){
			this.currentCount=1;
		}
		
		if(this.currentCount==null){
			this.currentCount=3;
		}
		
		//������ҳ��
		this.totalPage=(this.totalCount+this.currentCount-1)/this.currentCount;
		
		
		if(this.currentPage>this.totalPage){
			this.currentPage=this.totalPage;
		}
		
		if(this.currentPage<1){
			this.currentPage=1;
		}		
		
	}

	//�����ʼҳ��
	public Integer getStart(){
		return (this.currentPage-1)*this.currentCount;
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

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	
	
	
	
	
	
}
