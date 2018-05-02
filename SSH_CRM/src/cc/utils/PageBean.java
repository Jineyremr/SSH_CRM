package cc.utils;

import java.util.List;

public class PageBean {

	//当前页数
	private Integer currentPage;
	//当前总条数
	private Integer currentCount;
	//总页数
	private Integer totalPage;
	//总条数
	private Integer totalCount;
	//每条实体
	private List list;
	
	//初始化
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
		
		//计算总页数
		this.totalPage=(this.totalCount+this.currentCount-1)/this.currentCount;
		
		
		if(this.currentPage>this.totalPage){
			this.currentPage=this.totalPage;
		}
		
		if(this.currentPage<1){
			this.currentPage=1;
		}		
		
	}

	//计算初始页数
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
