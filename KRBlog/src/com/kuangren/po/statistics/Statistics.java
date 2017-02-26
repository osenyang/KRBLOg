package com.kuangren.po.statistics;

import java.util.Date;

public class Statistics {
    private Integer id;

    private Integer totalVisits;

    private Integer totalReply;

    private Integer dailyVisits;

    private Integer dailyReply;

    private Integer weekVisits;

    private Integer weekReply;

    private Integer monthVisits;

    private Integer monthReply;

    private Date updateTime;

    private Integer executeHour;

    private Integer executeMinute;

    private Integer intervalHour;

    private Integer intervalDay;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalVisits() {
        return totalVisits;
    }

    public void setTotalVisits(Integer totalVisits) {
        this.totalVisits = totalVisits;
    }

    public Integer getTotalReply() {
        return totalReply;
    }

    public void setTotalReply(Integer totalReply) {
        this.totalReply = totalReply;
    }

    public Integer getDailyVisits() {
        return dailyVisits;
    }

    public void setDailyVisits(Integer dailyVisits) {
        this.dailyVisits = dailyVisits;
    }

    public Integer getDailyReply() {
        return dailyReply;
    }

    public void setDailyReply(Integer dailyReply) {
        this.dailyReply = dailyReply;
    }

    public Integer getWeekVisits() {
        return weekVisits;
    }

    public void setWeekVisits(Integer weekVisits) {
        this.weekVisits = weekVisits;
    }

    public Integer getWeekReply() {
        return weekReply;
    }

    public void setWeekReply(Integer weekReply) {
        this.weekReply = weekReply;
    }

    public Integer getMonthVisits() {
        return monthVisits;
    }

    public void setMonthVisits(Integer monthVisits) {
        this.monthVisits = monthVisits;
    }

    public Integer getMonthReply() {
        return monthReply;
    }

    public void setMonthReply(Integer monthReply) {
        this.monthReply = monthReply;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getExecuteHour() {
        return executeHour;
    }

    public void setExecuteHour(Integer executeHour) {
        this.executeHour = executeHour;
    }

    public Integer getExecuteMinute() {
        return executeMinute;
    }

    public void setExecuteMinute(Integer executeMinute) {
        this.executeMinute = executeMinute;
    }

    public Integer getIntervalHour() {
        return intervalHour;
    }

    public void setIntervalHour(Integer intervalHour) {
        this.intervalHour = intervalHour;
    }

    public Integer getIntervalDay() {
        return intervalDay;
    }

    public void setIntervalDay(Integer intervalDay) {
        this.intervalDay = intervalDay;
    }
}