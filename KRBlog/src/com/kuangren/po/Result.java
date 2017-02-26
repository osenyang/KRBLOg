package com.kuangren.po;

public class Result {

	public static final String TYPE_ALERT = "alert";
	public static final String TYPE_SUCCESS = "success";
	public static final String TYPE_ERROR = "error";
	public static final String TYPE_WARNING = "warning";
	public static final String TYPE_INFORMATION = "information";

	public static final String TEXT_SUCCESS = "操作成功！";

	/** 默认类型 alert(success, error, warning, information) */
	public String type;
	/** 默认文本 */
	public String text;

	/** 自动关闭时间,默认不会自动关闭 */
	// public String timeout;
	// -----------------------------------
	public Result() {
		super();
		type = TYPE_SUCCESS;
		text = TEXT_SUCCESS;
	}
	/**
	 * 
	 * @param type	类型
	 * @param text	内容
	 */
	public Result(String type, String text) {
		super();
		this.type = type;
		this.text = text;
	}
	// -----------------------------------
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
