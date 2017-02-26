package com.kuangren.po.video;

import java.util.Date;

public class Video {
    private Integer id;

    private String title;

    private String description;

    private String vedioPath;

    private Integer size;

    private String timeSpan;

    private Integer seeCount;

    private Integer commentCount;

    private Date createTime;

    private Integer status;

    private Integer isSecret;

    private Integer favor;

    private Integer trample;

    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getVedioPath() {
        return vedioPath;
    }

    public void setVedioPath(String vedioPath) {
        this.vedioPath = vedioPath == null ? null : vedioPath.trim();
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getTimeSpan() {
        return timeSpan;
    }

    public void setTimeSpan(String timeSpan) {
        this.timeSpan = timeSpan == null ? null : timeSpan.trim();
    }

    public Integer getSeeCount() {
        return seeCount;
    }

    public void setSeeCount(Integer seeCount) {
        this.seeCount = seeCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Date getCreateTime() {
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

    public Integer getIsSecret() {
        return isSecret;
    }

    public void setIsSecret(Integer isSecret) {
        this.isSecret = isSecret;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}