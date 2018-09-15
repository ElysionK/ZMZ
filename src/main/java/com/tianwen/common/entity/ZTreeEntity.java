package com.tianwen.common.entity;

/**
 * zTree实体类
 * @author 康良玉
 *
 */
@SuppressWarnings("serial")
public class ZTreeEntity implements java.io.Serializable {

	private int id;					//主键id
	
	private int pId;				//父类id
	
	private String name;			//节点名称
	
	private String click;			//点击事件（默认为null）
	
	private boolean isRemove;		//是否删除（默认为true）
	
	private boolean isAdd;			//是否新增（默认为true）
	
	private boolean isRename;		//是否修改（默认为true）
	
	private String addCallback;		//新增成功后台回调方法名（默认为null）
	
	private String updateCallback;	//修改成功后台回调方法名（默认为null）
	
	private String deleteCallback;	//删除成功后台回调方法名（默认为null）
	
	private boolean doCheck;        //是否禁止勾选
	
	private boolean clickable;        //是否禁止勾选
	
	
	
	public boolean isClickable() {
		return clickable;
	}

	public void setClickable(boolean clickable) {
		this.clickable = clickable;
	}

	public ZTreeEntity(){
		isRemove = true;
		isAdd = true;
		isRename = true;
		doCheck = true;
		clickable = true;
	}
	
	public ZTreeEntity(ZTreeSetting setting){
		this.isRemove = setting.isCanRemove();
		this.isAdd = setting.isCanAdd();
		this.isRename = setting.isCanRename();
		this.clickable=setting.isClickable();
		this.doCheck = true;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClick() {
		return click;
	}

	public void setClick(String click) {
		if(clickable){
			this.click = click;
		}
	}

	public boolean isIsRemove() {
		return isRemove;
	}

	public void setRemove(boolean isRemove) {
		this.isRemove = isRemove;
	}

	public boolean isIsAdd() {
		return isAdd;
	}

	public void setAdd(boolean isAdd) {
		this.isAdd = isAdd;
	}

	public boolean isIsRename() {
		return isRename;
	}

	public void setRename(boolean isRename) {
		this.isRename = isRename;
	}

	public String getAddCallback() {
		return addCallback;
	}

	public void setAddCallback(String addCallback) {
		if(isAdd){
			this.addCallback = addCallback;
		}
	}

	public String getUpdateCallback() {
		return updateCallback;
	}

	public void setUpdateCallback(String updateCallback) {
		if(isRename){
			this.updateCallback = updateCallback;
		}
	}

	public String getDeleteCallback() {
		return deleteCallback;
	}

	public void setDeleteCallback(String deleteCallback) {
		if(isRemove){
			this.deleteCallback = deleteCallback;
		}
	}

	public boolean isDoCheck() {
		return doCheck;
	}

	public void setDoCheck(boolean doCheck) {
		this.doCheck = doCheck;
	}

	
	public static class ZTreeSetting implements java.io.Serializable {
		private boolean canAdd;
		private boolean canRename;
		private boolean canRemove;
		private boolean canDoCheck;
		private boolean moreSubNode;
		private boolean clickable;
		
		
		public boolean isClickable() {
			return clickable;
		}

		public void setClickable(boolean clickable) {
			this.clickable = clickable;
		}

		public ZTreeSetting(boolean canAdd, boolean canRename, boolean canRemove,Boolean clickable,boolean canDoCheck, boolean moreSubNode) {
			super();
			this.canAdd = canAdd;
			this.canRename = canRename;
			this.canRemove = canRemove;
			this.clickable = clickable;
			this.canDoCheck = canDoCheck;
			this.moreSubNode = moreSubNode;
		}
		public ZTreeSetting(boolean canRename, boolean canRemove,boolean clickable,boolean canDoCheck, boolean moreSubNode) {
			this(true,canRename,canRemove,clickable,canDoCheck,moreSubNode);
		}
		
		public ZTreeSetting( boolean canRemove,boolean clickable,boolean canDoCheck, boolean moreSubNode) {
			this(true,canRemove,clickable,canDoCheck,moreSubNode);
		}
		
		public ZTreeSetting( boolean clickable,boolean canDoCheck, boolean moreSubNode) {
			this(true,clickable,canDoCheck,moreSubNode);
		}

		public ZTreeSetting(boolean canDoCheck, boolean moreSubNode) {
			this(true,canDoCheck,moreSubNode);
		}

		public ZTreeSetting( boolean moreSubNode) {
			this(true,moreSubNode);
		}
		public ZTreeSetting() {
			this(true);
		}
		

		public boolean isCanDoCheck() {
			return canDoCheck;
		}

		public void setCanDoCheck(boolean canDoCheck) {
			this.canDoCheck = canDoCheck;
		}

		public static ZTreeSetting all(boolean flag) {
			return new ZTreeSetting(flag,flag,flag,flag,flag,flag);
		}
		
		public boolean isCanAdd() {
			return canAdd;
		}

		public boolean isMoreSubNode() {
			return moreSubNode;
		}

		public void setMoreSubNode(boolean moreSubNode) {
			this.moreSubNode = moreSubNode;
		}
		
		public void setCanAdd(boolean canAdd) {
			this.canAdd = canAdd;
		}

		public boolean isCanRename() {
			return canRename;
		}

		public void setCanRename(boolean canRename) {
			this.canRename = canRename;
		}

		public boolean isCanRemove() {
			return canRemove;
		}

		public void setCanRemove(boolean canRemove) {
			this.canRemove = canRemove;
		}

			
	}
	
}