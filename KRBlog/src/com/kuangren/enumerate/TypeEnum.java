package com.kuangren.enumerate;


/**
 * 创建分类的时候，有一个 mark 属性，用于区分这个类别是属于那个实体的类别
 * Title: com.kuangren.enumerate.TypeEnum
 * Description:
 * @createTime: 2017年2月9日 - 下午9:19:25
 * @Company: KuangRen
 * @author: OsenYang
 * @version: 1.0
 *
 */
public class TypeEnum {

	
	/** 表示所有模块都可以引用 */
	public static final String ALL = "all";
	/** log--日志分类 */
	public static final String LOG = "log";
	/** album--相册分类 */
	public static final String ALBUM = "album";
	/** video--视频分类 */
	public static final String VIDEO = "video";
	/** works--作品分类 */
	public static final String WORKS = "works";
	/* tag--心情标签，多标签 
	public static final String TAG = "tag";*/
	/** mood--心情标签--tag */
	public static final String MOOD = "mood";
	
	
	/** news--新闻 */
	public static final String NEWS = "news";
	/** notice--公告 */
	public static final String NOTICE = "notice";
	
}
