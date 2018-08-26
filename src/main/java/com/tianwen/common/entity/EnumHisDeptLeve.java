package com.tianwen.common.entity;

public enum EnumHisDeptLeve {
	
//	0 天问顶层 1 区域层级 2 门诊部层级
	
	TOP("0","天问顶层"),AREA("1","区域层级"),OUTPATIENT("2","门诊"),PART("3","部门");
	
	private String id ;
	private String text;
	
	EnumHisDeptLeve(String id,String text) {
		this.id = id;
		this.text = text;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public EnumHisDeptLeve subEum(){
		int id = Integer.parseInt(this.id);
		return value(++id);
	}
	
	public static EnumHisDeptLeve value(Integer id){
		return value(String.valueOf(id));
	}
	
	public static EnumHisDeptLeve value(String id){
		for(EnumHisDeptLeve node:values()){
			if (node.id.equals(id)) {
				return node;
			}
		}
		return null;
	}

	public static EnumHisDeptLeve maxLevel(){
		EnumHisDeptLeve maxLevel = null;
		for(EnumHisDeptLeve node:values()){
			if(maxLevel==null){
				continue;
			}else{
				int max = Integer.parseInt(maxLevel.getId());
				int nodeValue = Integer.parseInt(node.getId());
				if(nodeValue>max){
					maxLevel = node;
				}
			}
			maxLevel = node;
		}
		return maxLevel;
	}
	
}
