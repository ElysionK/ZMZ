//package com.tianwen.common.tag;
//
//import java.io.IOException;
//import java.io.Writer;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.tianwen.common.entity.Dict;
//import com.tianwen.common.redisutil.AppCache;
//import com.tianwen.common.util.DictVOComparator;
//import com.tianwen.common.util.SysUtil;
//
//import freemarker.core.Environment;
//import freemarker.template.TemplateDirectiveBody;
//import freemarker.template.TemplateDirectiveModel;
//import freemarker.template.TemplateException;
//import freemarker.template.TemplateModel;
//
//public class DictTag implements TemplateDirectiveModel{
//	
//	// 以下为标签对应的属性，除code、showTip、selectValue为自定义属性外，其它均为select标签属性
//	private String id;
//	private String name;
//	private String style;
//	private String className;
//	private String tabIndex;
//	private String onchange;
//	private Boolean isCreateLable = false;//是自动创建Lable
//	private String showTipInfo;//提示信息  例如：请选择  
//
//	private String selectValue; // 支持多个值,以","分割
//	private Boolean showTip = true;
//	private String filterStr;
//	private String dictType;
//
//	private Boolean isDESC = false;// 是否降序
////
//	/** 控件类型 */
//	private String controlType;
//	private static String CONTROL_TYPE_SELECT = "1";
//	private static String CONTROL_TYPE_RADIO = "2";
//	private static String CONTROL_TYPE_LABLE = "3";
//	private static String CONTROL_TYPE_CHECKBOX = "4";
//	private static String CONTROL_TYPE_TABLEVALUE = "5";
//	private static String CONTROL_TYPE_LIST = "6";//ul控件标签
//	
//	@Autowired
//	private AppCache appCache;
//
//	@Override
//	public void execute(Environment env, Map params, TemplateModel[] loopVars,
//			TemplateDirectiveBody body) throws TemplateException, IOException {
//		try {
//			//初始化参数
//			initParams(params);
//			
//			List<Dict> dictList = appCache.getDictListByType(dictType);
//
//			removeFilterForList(dictList);
//			
//	
//			Writer out = env.getOut();
//			StringBuffer buffer = new StringBuffer();
//			if (isDESC != null) {
//				Collections.sort(dictList, new DictVOComparator(isDESC));
//			}
//			if (CONTROL_TYPE_SELECT.equals(controlType)) {
//				buffer = generationSelectHTML(dictList);
//			} else if (CONTROL_TYPE_RADIO.equals(controlType)) {
//				buffer = generationRadioHTML(dictList);
//			} else if (CONTROL_TYPE_LABLE.equals(controlType)) {
//				buffer = generationLableHTML(dictList);
//			} else if (CONTROL_TYPE_CHECKBOX.equals(controlType)) {
//				buffer = generationCheckBoxHTML(dictList);
//			}else if (CONTROL_TYPE_TABLEVALUE.equals(controlType)) {
//				buffer = generationTableHTML(dictList);
//			}else if(CONTROL_TYPE_LIST.equals(controlType)){
//				buffer = generationListHTML(dictList);
//			}
//			out.write(buffer.toString());
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
//	public void initParams(Map<?,?> params) throws Exception{
//		if(!SysUtil.isEmpty(params.get("id"))){
//			this.id = String.valueOf(params.get("id"));
//		}
//		if(!SysUtil.isEmpty(params.get("name"))){
//			this.name = String.valueOf(params.get("name"));
//		}
//		if(!SysUtil.isEmpty(params.get("style"))){
//			this.style = String.valueOf(params.get("style"));
//		}
//		if(!SysUtil.isEmpty(params.get("className"))){
//			this.className = String.valueOf(params.get("className"));
//		}
//		if(!SysUtil.isEmpty(params.get("tabIndex"))){
//			this.tabIndex = String.valueOf(params.get("tabIndex"));
//		}
//		if(!SysUtil.isEmpty(params.get("onchange"))){
//			this.onchange = String.valueOf(params.get("onchange"));
//		}
//		if(!SysUtil.isEmpty(params.get("isCreateLable"))){
//			this.isCreateLable = (Boolean)params.get("isCreateLable");
//		}
//		if(!SysUtil.isEmpty(params.get("showTipInfo"))){
//			this.showTipInfo = String.valueOf(params.get("showTipInfo"));
//		}
//		if(!SysUtil.isEmpty(params.get("selectValue"))){
//			this.selectValue = String.valueOf(params.get("selectValue"));
//		}
//		if(!SysUtil.isEmpty(params.get("showTip"))){
//			this.showTip = (Boolean)params.get("showTip");
//		}
//		if(!SysUtil.isEmpty(params.get("filterStr"))){
//			this.filterStr = String.valueOf(params.get("filterStr"));
//		}
//		if(!SysUtil.isEmpty(params.get("dictType"))){
//			this.dictType = String.valueOf(params.get("dictType"));
//		}
//		if(!SysUtil.isEmpty(params.get("isDESC"))){
//			this.isDESC = (Boolean)params.get("isDESC");
//		}
//		if(!SysUtil.isEmpty(params.get("controlType"))){
//			this.controlType = String.valueOf(params.get("controlType"));
//		}
//	}
//	
//	/**
//	 * 删除指定filterStr存在的项。
//	 * 
//	 * @param dictList
//	 */
//	private void removeFilterForList(Collection<Dict> dictList) {
//		if (filterStr != null && filterStr.trim().length() > 0) {
//			String[] filterIds = filterStr.split(",");
//			Iterator<Dict> iterator = dictList.iterator();
//			while (iterator.hasNext()) {
//				Dict item = iterator.next();
//				for (String fid : filterIds) {
//					if (item.getDictTypeId().equals(dictType)
//							&& item.getDictCode().equals(fid)) {
//						iterator.remove();
//					}
//				}
//			}
//		}
//	}
//	
//	
//	/**
//	 * 生成LABLE控件。
//	 * 
//	 * @param dictList
//	 * @throws IOException
//	 */
//	private StringBuffer generationLableHTML(Collection<Dict> dictList)
//			throws IOException {
//		StringBuffer out = new StringBuffer();
//		String[] values = null;
//		if (null != selectValue && !"".equals(selectValue)) {
//			values = selectValue.split(",");
//		}
//		out.append("<span");
//		if (this.id != null)
//			out.append(" id=\"" + this.id + "\"");
//		if (this.name != null)
//			out.append(" name=\"" + this.name + "\"");
//		if (this.className != null)
//			out.append(" class=\"" + this.className + "\"");
//		out.append(">");
//		if (values != null && values.length > 0) {
//			String temp;
//			for (int i = 0; i < values.length; i++) {
//				temp = values[i];
//				if (i > 0)
//					out.append("、");
//				for (Dict item : dictList) {
//					if (temp.equals(item.getDictCode())) {
//						out.append(item.getDictName());
//						break;
//					}
//				}
//			}
//		}
//		out.append("</span>");
//		return out;
//	}
//	
//	/**
//	 * 根据list内容动态输出该HTML脚本。<br>
//	 * 默认情况下会有“请选择...”选项,如果有默认选择值但在列表不存在，则会默认选择“请选择...”项;<br>
//	 * 如果showTip=false即“请选择...”，如果有默认选择值但不存在，将会默认选择第一项;<br>
//	 * 控件的value值为DictVO的dictCode;<br>
//	 * <p>
//	 * 生成的示例： <SELECT id="participantType" name="participantType"
//	 * onchange="showChange();" style="width:110px"> <OPTION VALUE="001"
//	 * >个人</OPTION> <OPTION VALUE="002" >企业</OPTION> </SELECT>
//	 * </p>
//	 * 
//	 * @param list
//	 * @throws Exception
//	 */
//	private StringBuffer generationSelectHTML(Collection<Dict> list) throws Exception {
//		StringBuffer out = new StringBuffer();
//		StringBuffer temp = new StringBuffer();
//		boolean isBeSelected = false;// 标识默认选择值是否存在
//
//		out.append("<SELECT ");
//		if (this.id != null)	out.append(" id=\"" + this.id + "\"");
//		if (this.name != null) out.append(" name=\"" + this.name + "\"");
//		else	throw new Exception("The 'name' attrib not null! ");
//		if (this.className != null)  out.append(" class=\"" + this.className + "\"");
//		if (this.onchange != null)	out.append(" onchange=\"" + this.onchange + "\"");
//		if (this.tabIndex != null) out.append(" tabIndex=\"" + this.tabIndex + "\"");
//		if (this.style != null)	out.append(" style=\"" + this.style + "\"");
//		out.append(">\n");
//
//		for (Dict item : list) {
//			if (item.getDictName() != null	&& item.getDictCode().equals(this.selectValue)) {
//				isBeSelected = true;
//				temp.append("<OPTION VALUE=\"" + item.getDictCode()	+ "\"  SELECTED>" + item.getDictName() + "</OPTION>\n");
//			} else {
//				temp.append("<OPTION VALUE=\"" + item.getDictCode() + "\"  >"	+ item.getDictName() + "</OPTION>\n");
//			}
//		}
//
//		
//		if (isBeSelected &&  showTip) {
//			out.append("<OPTION  value=\"\">");
//			if(showTipInfo!=null){
//				out.append(showTipInfo);
//			}else{
//				out.append("请选择");
//			}
//			out.append("</OPTION>\n");
//		} else if (showTip) {
//			out.append("<OPTION  SELECTED value=\"\">");
//			if(showTipInfo!=null ){
//				out.append(showTipInfo);
//			}else{
//				out.append("请选择");
//			}
//			out.append("</OPTION>\n");
//		}
//
//		out.append(temp);
//		out.append("</SELECT>\n");
//		return out;
//	}
//	
//	/**
//	 * 根据list内容动态输出该HTML脚本。<br>
//	 * id的生成较特殊，是根据id名再加索引值来构成的,<br>
//	 * 控件的value值为SysrefcodeDO的主键,控件的code值为SysrefcodeDO的value;<br>
//	 * ;
//	 * <p>
//	 * 示例： <div id="sex"> <INPUT TYPE="radio" name="sex" id="sex0"
//	 * class="validate-one-required" tabIndex="2" code="1"
//	 * value="17">男&nbsp;</INPUT> <INPUT TYPE="radio" name="sex" id="sex1"
//	 * class="validate-one-required" tabIndex="2" code="0"
//	 * value="18">女&nbsp;</INPUT> </div>
//	 * </p>
//	 * 
//	 * @param list
//	 * @throws Exception
//	 */
//	private StringBuffer generationRadioHTML(Collection<Dict> list) throws Exception {
//		StringBuffer out = new StringBuffer();
//
//		int i = 0;// 用于组合ID
//		out.append("<span id=\"" + this.id + "\">\n");
//		for (Dict item : list) {
//			if(isCreateLable)out.append("<label>");
//			
//			out.append("<INPUT TYPE=\"radio\" ");
//			if (this.name != null)
//				out.append(" name=\"" + this.name + "\"");
//			else
//				throw new Exception("The 'name' attrib not null! ");
//			if (this.id != null)
//				out.append(" id=\"" + this.id + (i++) + "\"");
//			if (this.className != null)
//				out.append(" class=\"" + this.className + "\"");
//			if (this.onchange != null)
//				out.append(" onchange=\"" + this.onchange + "\"");
//			if (this.tabIndex != null)
//				out.append(" tabIndex=\"" + this.tabIndex + "\"");
//			if (this.style != null)
//				out.append(" style=\"" + this.style + "\"");
//			out.append(" value=\"" + item.getDictCode() + "\"");
//			if (this.selectValue != null
//					&& this.selectValue.equals(String.valueOf(item
//							.getDictCode())))
//				out.append("checked=\"checked\" ");
//			out.append(">" + item.getDictName() + "&nbsp;");
//			out.append("</INPUT>\n");
//			
//			if(isCreateLable)out.append("</label>");
//		}
//		out.append("</span>\n");
//		return out;
//	}
//	
//	private StringBuffer generationCheckBoxHTML(Collection<Dict> list) throws Exception {
//		StringBuffer out = new StringBuffer();
//		String[] selectValues = this.selectValue != null ? this.selectValue
//				.split(",") : new String[] {};
//
//		int i = 0;// 用于组合ID
//		out.append("<span id=\"" + this.id + "\">\n");
//		for (Dict item : list) {
//			if(isCreateLable)out.append("<label>");
//			
//			out.append("<INPUT TYPE=\"checkbox\" ");
//			if (this.name != null)
//				out.append(" name=\"" + this.name + "\"");
//			else
//				throw new Exception("The 'name' attrib not null! ");
//			if (this.id != null)
//				out.append(" id=\"" + this.id + (i++) + "\"");
//			if (this.className != null)
//				out.append(" class=\"" + this.className + "\"");
//			if (this.onchange != null)
//				out.append(" onchange=\"" + this.onchange + "\"");
//			if (this.tabIndex != null)
//				out.append(" tabIndex=\"" + this.tabIndex + "\"");
//			if (this.style != null)
//				out.append(" style=\"" + this.style + "\"");
//			out.append(" value=\"" + item.getDictCode() + "\"");
//			for (String value : selectValues) {
//				if (value.trim().equals(String.valueOf(item.getDictCode()))) {
//					out.append("checked=\"checked\" ");
//				}
//			}
//			// if(this.selectValue !=null && this.selectValue.equals(
//			// String.valueOf(item.getDictCode()) ))
//			// out.append("checked=\"checked\" ");
//			out.append(">" + item.getDictName() + "&nbsp;");
//			out.append("</INPUT>\n");
//			
//			if(isCreateLable)out.append("</label>");
//		}
//		out.append("</span>\n");
//		return out;
//	}
//	
//	/**
//	 * 生成UL控件脚本。
//	 * 
//	 * @param list
//	 * @throws Exception
//	 */
//	private StringBuffer generationListHTML(Collection<Dict> list) throws Exception {
//		StringBuffer out = new StringBuffer();
//		out.append("<ul");
//		if (this.id != null) {
//			out.append("ID=").append(this.id);
//		}
//		out.append(">");
//			
//		if(showTip){
//			if( showTipInfo!=null && showTipInfo.trim().length()>0){
//				out.append("<li>").append(showTipInfo).append("</li>");
//			}else{
//				out.append("<li>").append("请选择").append("</li>");
//			}
//		}
//		
//		for (Dict item : list) {
//			out.append("<li code='").append(item.getDictCode()).append("'>");
//			out.append(item.getDictName());
//			out.append("</li>");
//		}
//		out.append("</ul>");
//		return out;
//	}
//
//	private StringBuffer generationTableHTML(List<Dict> list) throws Exception {
//		StringBuffer out =new StringBuffer();
//		String temp="";
//		try {
//			out.append("{");
//			for (Dict item : list) {		
//				out.append("\""+item.getDictCode()+"\":\""+item.getDictName()+"\","+"\""+item.getDictCode()+"_remark"+"\":\""+item.getRemark()+"\",");
//				
//			}
//			out.append("}");
//			temp=out.substring(0,(out.toString().length()-2))+"}";
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return out;
//	}
//	
//	public String getId() {
//		return id;
//	}
//
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//
//	public String getName() {
//		return name;
//	}
//
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//
//	public String getStyle() {
//		return style;
//	}
//
//
//	public void setStyle(String style) {
//		this.style = style;
//	}
//
//
//	public String getClassName() {
//		return className;
//	}
//
//
//	public void setClassName(String className) {
//		this.className = className;
//	}
//
//
//	public String getTabIndex() {
//		return tabIndex;
//	}
//
//
//	public void setTabIndex(String tabIndex) {
//		this.tabIndex = tabIndex;
//	}
//
//
//	public String getOnchange() {
//		return onchange;
//	}
//
//
//	public void setOnchange(String onchange) {
//		this.onchange = onchange;
//	}
//
//
//	public Boolean getIsCreateLable() {
//		return isCreateLable;
//	}
//
//
//	public void setIsCreateLable(Boolean isCreateLable) {
//		this.isCreateLable = isCreateLable;
//	}
//
//
//	public String getShowTipInfo() {
//		return showTipInfo;
//	}
//
//
//	public void setShowTipInfo(String showTipInfo) {
//		this.showTipInfo = showTipInfo;
//	}
//
//
//	public String getSelectValue() {
//		return selectValue;
//	}
//
//
//	public void setSelectValue(String selectValue) {
//		this.selectValue = selectValue;
//	}
//
//
//	public Boolean getShowTip() {
//		return showTip;
//	}
//
//
//	public void setShowTip(Boolean showTip) {
//		this.showTip = showTip;
//	}
//
//
//	public String getFilterStr() {
//		return filterStr;
//	}
//
//
//	public void setFilterStr(String filterStr) {
//		this.filterStr = filterStr;
//	}
//
//
//	public String getDictType() {
//		return dictType;
//	}
//
//
//	public void setDictType(String dictType) {
//		this.dictType = dictType;
//	}
//
//
//	public Boolean getIsDESC() {
//		return isDESC;
//	}
//
//
//	public void setIsDESC(Boolean isDESC) {
//		this.isDESC = isDESC;
//	}
//
//
//	public String getControlType() {
//		return controlType;
//	}
//
//
//	public void setControlType(String controlType) {
//		this.controlType = controlType;
//	}
//	
//
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//}
