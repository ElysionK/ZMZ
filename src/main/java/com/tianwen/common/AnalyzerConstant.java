package com.tianwen.common;

public class AnalyzerConstant {
	
	/************************************* INDEX ************************************/
	
	// 对应 db 的 HIS_WESTMEDICINE_SET
	public final static String WEST_MEDIC_INDEX = "west_medicine";
	
	// 对应 db 的  HIS_CHINESEMEDICINE_SET
	public final static String CHINESE_MEDIC_INDEX = "chinese_medicine";
	
	// 对应 db 的 HIS_AREAMEDIC_STOCK （区域库存）
	public final static String AREA_INVENTORY_INDEX = "area_inventory";
	
	// 对应 db 的 HIS_ENTSHOP_MEDSUP_STOCK （门诊库存）
	public final static String HOSPITAL_INVENTORY_INDEX = "hospital_inventory";
	
	public final static String INSPECT_INDEX = "inspect";
	
	// 对应 db 的 his_laboratory_set
	public final static String BASE_INVENTORY_INDEX = "base_inventory";
	
	
	
	/************************************* TYPE ************************************/

	public final static String WEST_MEDIC_TYPE = "medic";
	
	public final static String CHINESE_MEDIC_TYPE = "medic";
	
	public final static String AREA_INVENTORY_TYPE = "iv";
	
	public final static String HOSPITAL_INVENTORY_TYPE = "iv";
	
	public final static String INSPECT_TYPE = "is";
	
	public final static String BASE_INVENTORY_TYPE = "iv";
	
	
	/************************************* ERROR CODE ************************************/
	
	
	public final static Integer ES_OPERATE_SUCCESS = 200;	//操作成功
	
	public final static Integer ES_OPERATE_FAILURE = 400;	//操作失败
	
	public final static Integer ES_PART_OPERATE_SUCCESS = 401;	//部分操作成功
	
	public final static Integer ES_FILE_NOT_FOUND = 404;	//未找到文档
	
	public final static Integer ES_CREATE_SUCCESS = 201;	//更新成功
	
	public final static Integer ES_VERSION_CONFLICT = 409;	//版本冲突
	
	public final static Integer ES_MISSING_INDEX = 101;		//缺少索引名称
	
	public final static Integer ES_MISSING_TYPE = 102;		//缺少索引类型
	
	public final static Integer ES_MISSING_ID = 103;		//缺少索引id
	
	public final static Integer ES_MISSING_SOURCE = 104;	//缺少索引数据
}
