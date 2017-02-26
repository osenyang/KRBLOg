package com.kuangren.po;

import java.util.List;

/**
 * 父类：查询条件 Title: com.kuangren.po.BaseQueryVo Description:
 * 
 * @createTime: 2017年2月16日 - 下午5:00:55
 * @Company: KuangRen
 * @author: OsenYang
 * @version: 1.0
 */
public class BaseQueryVo<E> {

	private E poCustom;

	private List<E> poCustomList;

//	private PageBean pageBean;

	private PagingBean pagingBean;
	
	private List<Integer> limitIds;
	// -------------------------------------------------------

	public E getPoCustom() {
		return poCustom;
	}

	public void setPoCustom(E poCustom) {
		this.poCustom = poCustom;
	}

	public List<E> getPoCustomList() {
		return poCustomList;
	}

	public void setPoCustomList(List<E> poCustomList) {
		this.poCustomList = poCustomList;
	}

	/*public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}*/

	public PagingBean getPagingBean() {
		return pagingBean;
	}

	public void setPagingBean(PagingBean pagingBean) {
		this.pagingBean = pagingBean;
	}

	public List<Integer> getLimitIds() {
		return limitIds;
	}

	public void setLimitIds(List<Integer> limitIds) {
		this.limitIds = limitIds;
	}

}
