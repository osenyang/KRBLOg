package com.kuangren.po.log;

import java.util.Date;

import com.kuangren.po.BasePo;

public class Log extends BasePo {

	private static final long serialVersionUID = -287155494759362490L;
	/**
	 * 
	 */

	private String title;

	private Date updateTime;

	private Integer isSecret;

	private Integer seeCount;

	private Integer replyCount;

	private Integer favor;

	private Date topTime;

	private String type;

	private Integer secret_id;

	private String content;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getIsSecret() {
		return isSecret;
	}

	public void setIsSecret(Integer isSecret) {
		this.isSecret = isSecret;
	}

	public Integer getSeeCount() {
		return seeCount;
	}

	public void setSeeCount(Integer seeCount) {
		this.seeCount = seeCount;
	}

	public Integer getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}

	public Integer getFavor() {
		return favor;
	}

	public void setFavor(Integer favor) {
		this.favor = favor;
	}

	public Date getTopTime() {
		return topTime;
	}

	public void setTopTime(Date topTime) {
		this.topTime = topTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public Integer getSecret_id() {
		return secret_id;
	}

	public void setSecret_id(Integer secret_id) {
		this.secret_id = secret_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}
}