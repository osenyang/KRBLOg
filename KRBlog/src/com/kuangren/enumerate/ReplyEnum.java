package com.kuangren.enumerate;


/**
 * 有回复的时候，有一个 mark 属性，用于区分这个回复是哪种类别的回复
 * Title: com.kuangren.enumerate.TypeEnum
 * Description:
 * @createTime: 2017年2月9日 - 下午9:19:25
 * @Company: KuangRen
 * @author: OsenYang
 * @version: 1.0
 *
 */
public class ReplyEnum extends TypeEnum {

	/** reply--回复一条回复 */
	public static final String REPLY = "reply";
	/** photo--单个照片 */
	public static final String PHOTO = "photo";
	/** message--回复留言板的内容 */
//	public static final String MESSAGE = "message";
	/** demand--需求申请 */
	public static final String DEMAND = "demand";
	
}
