package com.tianwen.common;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 用于常量定义类
 * 
 * @author
 * @date
 */

@SuppressWarnings("serial")
public class SysConstant {

	public static final String SYS_MEMBER_LOG_SUCC_INFO = "memberLogSuccinfo_his";
	
	public static final String SYS_MEMBER_SELECT_DEPT_ID = "sysMemberSelectDeptId";
	
	
	public static final String CONTEXT_PATH = "contextPath";/***项目根路径*/
	
	/*图片路径*/
	public static final String IMAGE_PATH="http://sale.51towin.com";

	/*pcpt项目*/
	public static  final  String PCPT="http://localhost:8060";
	
	//下标0 实验室检查key=LAB,下标1 辅助检查医嘱key=ASSIST, 下标2 治疗医嘱key=TREAT,下标3 物资收费key=MATERIAL,下标4 其他收费key=other,
	public static  final  String [] LAB_KEY={"LAB","ASSIST","TREAT","MATERIAL","other"} ;

	
	/**
	 * 管理系统类型功能菜单权限
	 */
	public static final int MANAGER_TYPE = 2;
	
	/**
	 * 天问管理员
	 */
	public static final String INNERUSER_TYPE1 = "tw_admin";
	
	/**
	 * 区域管理员
	 */
	public static final String INNERUSER_TYPE2 = "area_admin";
	
	// 被选中的门诊部 id 和 name
	public static final String SELECTED_TYPE_DEPT_ID_AND_NAME = "selectedDeptIdAndName";
	// 药品分类选中
	public static final String SYS_MEMBER_SELECT_MEDICINE_TYPE_ID = "sysMemberSelectMedicineTypeId";
	
	public static final String SELECTED_DEPT_ID_NAME = "selectedDeptIdName";
	
	public static final String SELECTED_MEMBER_SELECT_DEPT_NAME = "selectedDeptName";

	public static final String SELECTED_MEMBER_SELECT_MEDICINE_TYPE_NAME = "selectedMemberSelectMedicineTypeName";
	
	public static final String SELECTED_DEPT = "selectedDept";
	
	public static final String SELECTED_DEPT_INDEX ="selectedDeptIndex";
	
	// 被选中的中药分类 id 和 name
	public static final String SELECTED_CHINA_TEMP_TYPE_ID_AND_NAME = "selectChinaTempTypeIdAndName";
	
	// 中药模板
	public static final String CHINA_MEDIC_TEMP = "0";
	
	public static final String ADMIN = "1";
	
	// 区域模板
	public static final String AREA_TEMP = "0";
	
	// 个人模板
	public static final String PERSON_TEMP = "1"; 
	
	// 区域出库到门诊
	public static final String AREA_OUT_GOING_2_ES = "0";
	
	// 药品（包括中药和西药）
	public static final String MEDIC_GOODS = "0";
	
	// start 库存中的 type 类型
	// 物资
	public static final String MATERIAL_GOODS = "1";
	
	// 中药
	public static final String CN_MEDIC = "0";
	
	// 西药
	public static final String EN_MEDIC = "2";
	// end 库存中的 type 类型
	
	// start his_commfeeset 中的 type
	// 实验室个性化零售价
	public static final String COMMFEESET_LABORATORY = "0";
	
	// 物资收费个性化零售价
	public static final String COMMFEESET_MATERIAL = "1";
	
	// 其它收费个性化零售价
	public static final String COMMFEESET_OTHER = "2";
	
	// 诊疗费维护个性化零售价
	public static final String COMMFEESET_TREAT = "3";
	
	// 西/成药个性化零售价
	public static final String COMMFEESET_WEST_MEDIC = "4";
	
	// 中药个性化零售价
	public static final String COMMFEESET_CHINA_MEDIC = "5";
	// end his_commfeeset 中的 type
	
	// his_laboratory_set 中的物资
	public static final String LABORATORY_SET_MATERAIL = "3";
	
	// start 用于表示药品和物资启用和停用状态 
	// 停用
	public static final String CLOSE = "0";
	// 启用
	public static final String OPEN = "1";
	// end 用于表示药品和物资启用和停用状态 
	
	/**
	 * ES操作
	 */
	public static final String ES_OPERATE = "esOperate";
	
	/**
	 * ES批量操作
	 */
	public static final String ES_BATCH_OPERATE = "esBatchOperate";
	
	
	/**
	 * ES根据参数操作
	 */
	public static final String ES_PARAM_OPERATE = "esParamOperate";
	
	/**
	 * 更新数据库字段操作
	 */
	public static final String COLUMN_OPERATE = "columnOperate";
	
	// start 用户(患者)就诊轨迹表 接诊状态
	// 分诊完毕，等待接诊
	public static final String WATING_DOCTOR_TREATMENT = "2";
	
	// 接诊中
	public static final String DOCTOR_TREATMENTING = "3";
	// end 用户(患者)就诊轨迹表
	
	public static final String TREAT_STATS ="today|";

	public static final String SYS_ADMIN_LOG_SUCC_INFO = "admin";
}
