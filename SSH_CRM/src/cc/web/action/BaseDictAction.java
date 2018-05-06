package cc.web.action;

import java.io.File;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cc.domain.BaseDict;
import cc.service.BaseDictService;
import net.sf.json.JSONArray;


public class BaseDictAction extends ActionSupport{

	
	private String dict_type_code;
	private BaseDictService bds;
	//����������name������ͬ��struts���Զ���ͼƬ��װΪ����
	private File photo;
	private String photoFileName;


	public String execute() throws Exception{		
		
		//����service��list
		List<BaseDict> list = bds.getByTypeCode(dict_type_code);
		//��listת��json
		String json = JSONArray.fromObject(list).toString();
		//��json����ǰ��
		
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
