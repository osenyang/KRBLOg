package com.kuangren.exception;

/**
 * 
 * Title: com.kuangren.exception.CustomException
 * Description: 系统 自定义异常类，针对预期的异常，需要在程序中抛出此类的异常 </p>
 * @createTime: 2017年2月3日 - 下午5:07:01
 * @Company: KuangRen
 * @author: OsenYang
 * @version: 1.0
 *
 */
public class CustomException extends Exception {
	
	private static final long serialVersionUID = 5756225308751441590L;
	/**
	 * 
	 */
	//异常信息
	public String message;
	
	public CustomException(String message){
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
