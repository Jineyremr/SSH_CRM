package cc.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cc.domain.BaseDict;
import cc.service.BaseDictService;
import net.sf.json.JSONArray;


public class BaseDictAction extends ActionSupport{

	
	private String dict_type_code;
	private BaseDictService bds; 
	
	
	public String execute() throws Exception{
		
		//调用service查list
		List<BaseDict> list = bds.getByTypeCode(dict_type_code);
		//将list转成json
		String json = JSONArray.fromObject(list).toString();
		//将json传到前端
		
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}


	public void setBds(BaseDictService bds) {
		this.bds = bds;
	}


	public String getDict_type_code() {
		return dict_type_code;
	}


	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}
	
}
