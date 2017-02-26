package com.kuangren.po.log;

public class LogCustom extends Log {

	private static final long serialVersionUID = 6737789449730663918L;
	/**
	 * 
	 */

	/** 判断是不是置顶 */
	public Boolean isTop;
	
	public Integer typeId;
	
	/** 如果有值，并且等于 1 表示存为草稿 */
	public Integer isDraft;
	
	
	public Boolean getIsTop() {
		return isTop;
	}

	public void setIsTop(Boolean isTop) {
		this.isTop = isTop;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getIsDraft() {
		return isDraft;
	}

	public void setIsDraft(Integer isDraft) {
		this.isDraft = isDraft;
	}

}
