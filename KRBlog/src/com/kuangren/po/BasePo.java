package com.kuangren.po;

import java.io.Serializable;
import java.util.Date;

public class BasePo implements Serializable{

	private static final long serialVersionUID = 2306981593362568058L;
	/**
	 * 
	 */
	/** 唯一标识 */
	private Integer id;
	/** 创建时间 */
	private Date createTime;
	/** 当前状态 */
	private Integer status;
	
	
	public BasePo() {
		super();
//		this.createTime = new Date();
//		this.status = 1;
	}
	//----------------------------------------------------------
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreateTime() {
		/*SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(createTime);
		Date formatTime = formatter.parse(dateString);*/
		
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	//----------------------------------------------------
	@Override
	public String toString() {
		return "BasePo [id=" + id + ", createTime=" + createTime + ", status=" + status + "]";
	}
	//----------------------------------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BasePo other = (BasePo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
