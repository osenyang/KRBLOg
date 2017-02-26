package com.kuangren.po;

import java.util.List;

import com.github.pagehelper.PageInfo;

/**
 * 存储MySQL 查询，分页 limit 的
 * Title: com.kuangren.po.PagingVo
 * Description:
 * @createTime: 2017年2月16日 - 下午10:43:52
 * @Company: KuangRen
 * @author: OsenYang
 * @version: 1.0
 */
public class PagingBean {
	
	/*用mybatis 的真分页插件*/
	private PageInfo<?> pageInfo;
	
	/** MySQL 分页limit 只有一个参数：查询前面最大记录数的前多少条记录 */
	private Integer limitFront;//给mapper.xml的时候分页需要这个数
	//===============================================================
	
	private Boolean isFirst;
	private Boolean isLast;
	
	//下面两个参数是用来计算下面两个数据的。但是不用自个传递，从附带进来的pageInfo里面取
	private int pageCount; //总页数
	// 计算出
	/** 页码列表的开始索引（包含） */
	private int viewBeginIndex; 
	/** 页码列表的结束索引（包含） */
	private int viewEndIndex;
	
	private Integer startIndex;//mysql limit （第一个参数）查询的开始索引
	//=======================================================================
	private int pageNum; //当前页码
	
	private Integer pageSize = 10;//每页显示的数量
	//===============================================================
	//下面两个需要从数据库查询出
	private List<? extends BasePo> poList;//访问页面的实体list
	
	private Integer totalCount;//数据总条数
	//===============================================================
	public PagingBean() {
		super();
	}
	
	private void setStartIndex(){
		this.startIndex = (pageNum - 1) * pageSize;
	}
	public PagingBean(int pageNum) {
		super();
		this.pageNum = pageNum;
		setStartIndex();
	}
	public PagingBean(int pageNum, Integer pageSize) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		setStartIndex();
	}

	public PagingBean(PageInfo<?> pageInfo) {
		super();
		this.pageInfo = pageInfo;
		//用传递进来的pageInfo 给一些参数赋值
		this.pageNum = pageInfo.getPageNum();
		this.pageCount = pageInfo.getNavigatePages();
		
		computeViewInfo();
	} 
	/*public PagingBean(int pageNum, Integer totalCount, List<? extends BasePo> poList) {
		super();
		this.pageNum = pageNum;
		this.totalCount = totalCount;
		this.poList = poList;
		
		computeViewInfo();
	}

	public PagingBean(int pageNum, Integer pageSize, List<? extends BasePo> poList, Integer totalCount) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;//如果你需要指定每页显示的数量。那么查询分页ids 的时候也要指定。并且一致
		this.poList = poList;
		this.totalCount = totalCount;
		
		computeViewInfo();
	}*/

	/*计算页面分页与显示页码等等相关的一些信息*/
	private void computeViewInfo() {
		
		pageCount = (totalCount + pageSize - 1) / pageSize;//计算总页数
		// 计算 viewBeginIndex 与 viewEndIndex
		// >> 总页码小于等于10页时，全部显示
		if (pageCount <= 10) {//这个10，是页面下方显示被点击的10个页码
			viewBeginIndex = 1;
			viewEndIndex = pageCount;
		}
		// >> 总页码大于10页时，就只显示当前页附近的共10个页码
		else {
			// 默认显示 前4页 + 当前页 + 后5页
			viewBeginIndex = pageNum - 4; // 7 - 4 = 3;
			viewEndIndex = pageNum + 5; // 7 + 5 = 12; --> 3 ~ 12

			// 如果前面不足4个页码时，则显示前10页
			if (viewBeginIndex < 1) {
				viewBeginIndex = 1;
				viewEndIndex = 10;
			}
			// 如果后面不足5个页码时，则显示后10页
			else if (viewEndIndex > pageCount) {
				viewBeginIndex = pageCount - 9;
				viewEndIndex = pageCount;
			}
		}
		
		if (this.pageNum == 1) {
			setIsFirst(true);
		}
		if (this.pageNum == pageCount || pageCount == 0 || pageCount == 1) {//没有数据或者只有1页数据
			setIsLast(true);
		}
		
	}
	//===============================================================================

	public PageInfo<?> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<?> pageInfo) {
		this.pageInfo = pageInfo;
	}

	public Integer getLimitFront() {
		return limitFront;
	}

	public void setLimitFront(Integer limitFront) {
		this.limitFront = limitFront;
	}

	public Boolean getIsFirst() {
		return isFirst;
	}

	public void setIsFirst(Boolean isFirst) {
		this.isFirst = isFirst;
	}

	public Boolean getIsLast() {
		return isLast;
	}

	public void setIsLast(Boolean isLast) {
		this.isLast = isLast;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getViewBeginIndex() {
		return viewBeginIndex;
	}

	public void setViewBeginIndex(int viewBeginIndex) {
		this.viewBeginIndex = viewBeginIndex;
	}

	public int getViewEndIndex() {
		return viewEndIndex;
	}

	public void setViewEndIndex(int viewEndIndex) {
		this.viewEndIndex = viewEndIndex;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<? extends BasePo> getPoList() {
		return poList;
	}

	public void setPoList(List<? extends BasePo> poList) {
		this.poList = poList;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
		
		computeViewInfo();
	}

}
