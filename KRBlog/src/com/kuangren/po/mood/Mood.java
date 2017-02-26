package com.kuangren.po.mood;

import java.util.Date;

import com.kuangren.po.BasePo;

public class Mood extends BasePo{

	private static final long serialVersionUID = 6576299480966981222L;
    /**
	 * 
	 */

	private String content;

    private Integer isSecret;

    private Integer seeCount;

    private Integer replyCount;

    private Date topTime;

    private String tag;

    private Integer favor;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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

    public Date getTopTime() {
        return topTime;
    }

    public void setTopTime(Date topTime) {
        this.topTime = topTime;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public Integer getFavor() {
        return favor;
    }

    public void setFavor(Integer favor) {
        this.favor = favor;
    }
}