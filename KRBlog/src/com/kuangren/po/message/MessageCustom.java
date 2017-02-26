package com.kuangren.po.message;

import java.util.List;

import com.kuangren.po.user.User;

public class MessageCustom extends Message {

	private static final long serialVersionUID = 3506050943317668492L;
	/**
	 * 
	 */

	/** 这条回复是回复谁的 */
	private Message parent;
	/** 此条留言的所有回复 */
	private List<Message> children;
	
	private User user;
	
//	public Integer replyCount;

	public Message getParent() {
		return parent;
	}

	public void setParent(Message parent) {
		this.parent = parent;
	}

	public List<Message> getChildren() {
		return children;
	}

	public void setChildren(List<Message> children) {
		this.children = children;
	}

	public Integer getReplyCount() {//这样读取的回复数是真实的，不包括删除的子回复
		return getChildren().size();
	}


	/*
	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}*/
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}