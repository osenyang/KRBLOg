package com.kuangren.po;

import java.util.List;

/**
 * 封装分页信息的类
 * @author Work
 *
 */
@SuppressWarnings("rawtypes")
public class PageBean {


	public PageBean(){};
	
	//===========================================================================
	// 传递的参数或是配置的参数
	/** 当前页 */
	private int currentPage; 
	/** 每页显示多少条记录 */
	private int pageSize; 

	// 查询数据库
	/** 本页的数据列表 */
	private List recordList; 
	/** 总记录数 */
	private int recordCount; 

	// 计算出下面的三个数据
	/** 总页数 */
	private int pageCount; 
	/** 页码列表的开始索引（包含） */
	private int beginPageIndex; 
	/** 页码列表的结束索引（包含） */
	private int endPageIndex; 

	/**
	 * 只接受4个必要的属性，会自动的计算出其他3个属性的值
	 * 
	 * @param currentPage	当前页
	 * @param pageSize 		每页显示多少条记录
	 * @param recordList
	 * @param recordCount   总记录数
	 */
	public PageBean(int currentPage, int pageSize, List recordList, int recordCount) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.recordList = recordList;
		this.recordCount = recordCount;

		// 先用记录总数和每页显示数，计算总页数
		pageCount = (recordCount + pageSize - 1) / pageSize;
 
		// 计算 beginPageIndex 与 endPageIndex
		// >> 总页码小于等于10页时，全部显示
		if (pageCount <= 10) {//这个10，是页面下方显示被点击的10个页码
			beginPageIndex = 1;
			endPageIndex = pageCount;
		}
		// >> 总页码大于10页时，就只显示当前页附近的共10个页码
		else {
			// 默认显示 前4页 + 当前页 + 后5页
			beginPageIndex = currentPage - 4; // 7 - 4 = 3;
			endPageIndex = currentPage + 5; // 7 + 5 = 12; --> 3 ~ 12

			// 如果前面不足4个页码时，则显示前10页
			if (beginPageIndex < 1) {
				beginPageIndex = 1;
				endPageIndex = 10;
			}
			// 如果后面不足5个页码时，则显示后10页
			else if (endPageIndex > pageCount) {
				beginPageIndex = pageCount - 9;
				endPageIndex = pageCount;
			}
		}
	}

	public List getRecordList() {
		return recordList;
	}

	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getBeginPageIndex() {
		return beginPageIndex;
	}

	public void setBeginPageIndex(int beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}

	public int getEndPageIndex() {
		return endPageIndex;
	}

	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}

}
