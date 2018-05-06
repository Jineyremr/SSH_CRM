function loadBaseDict(typecode,location,dict_id,selected){
	//将id赋给select
	var $select = $("<select name="+dict_id+"></select>");
	//添加提示选项
	$select.append($("<option value='' >---请选择---</option>"));
	//使用ajax访问后台action
	$.post("${pageContext.request.contextPath}/BaseDictAction",{dict_type_code:typecode},
		function(data){
			
			
			
			//遍历
			//返回json数据，对其遍历
			$.each(data,function(i,json){
				
				
				//每次遍历创建一个option对象
				var $option = $("<option value='"+json['dict_id']+"'>"+json["dict_item_name"]+"</option>");
				
				if(json['dict_id'] == selected){
					//判断是否需要回显
					$option.attr("selected","selected");
				}
				
				//添加到select对象
				$select.append($option);
			});
		},"json");
	
	$("#"+location).append($select);
}