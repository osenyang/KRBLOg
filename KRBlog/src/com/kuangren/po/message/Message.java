package com.kuangren.po.message;

import com.kuangren.po.BasePo;

public class Message extends BasePo{

	private static final long serialVersionUID = -2677018054501571446L;
	/**
	 * 
	 */

	private String title;

	private String content;

	private String ip;

	private Integer floor;

	private Integer replyCount;

	private Boolean sendWord;

	private Integer favor;

	private Integer trample;

	private String nickname;

	private Integer parent_id;

	private Integer user_id;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip == null ? null : ip.trim();
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public Integer getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}

	public Boolean getSendWord() {
		return sendWord;
	}

	public void setSendWord(Boolean sendWord) {
		this.sendWord = sendWord;
	}

	public Integer getFavor() {
		return favor;
	}

	public void setFavor(Integer favor) {
		this.favor = favor;
	}

	public Integer getTrample() {
		return trample;
	}

	public void setTrample(Integer trample) {
		this.trample = trample;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname == null ? null : nickname.trim();
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
}