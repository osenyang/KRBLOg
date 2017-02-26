package com.kuangren.po.statistics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StatisticsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatisticsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTotalVisitsIsNull() {
            addCriterion("totalVisits is null");
            return (Criteria) this;
        }

        public Criteria andTotalVisitsIsNotNull() {
            addCriterion("totalVisits is not null");
            return (Criteria) this;
        }

        public Criteria andTotalVisitsEqualTo(Integer value) {
            addCriterion("totalVisits =", value, "totalVisits");
            return (Criteria) this;
        }

        public Criteria andTotalVisitsNotEqualTo(Integer value) {
            addCriterion("totalVisits <>", value, "totalVisits");
            return (Criteria) this;
        }

        public Criteria andTotalVisitsGreaterThan(Integer value) {
            addCriterion("totalVisits >", value, "totalVisits");
            return (Criteria) this;
        }

        public Criteria andTotalVisitsGreaterThanOrEqualTo(Integer value) {
            addCriterion("totalVisits >=", value, "totalVisits");
            return (Criteria) this;
        }

        public Criteria andTotalVisitsLessThan(Integer value) {
            addCriterion("totalVisits <", value, "totalVisits");
            return (Criteria) this;
        }

        public Criteria andTotalVisitsLessThanOrEqualTo(Integer value) {
            addCriterion("totalVisits <=", value, "totalVisits");
            return (Criteria) this;
        }

        public Criteria andTotalVisitsIn(List<Integer> values) {
            addCriterion("totalVisits in", values, "totalVisits");
            return (Criteria) this;
        }

        public Criteria andTotalVisitsNotIn(List<Integer> values) {
            addCriterion("totalVisits not in", values, "totalVisits");
            return (Criteria) this;
        }

        public Criteria andTotalVisitsBetween(Integer value1, Integer value2) {
            addCriterion("totalVisits between", value1, value2, "totalVisits");
            return (Criteria) this;
        }

        public Criteria andTotalVisitsNotBetween(Integer value1, Integer value2) {
            addCriterion("totalVisits not between", value1, value2, "totalVisits");
            return (Criteria) this;
        }

        public Criteria andTotalReplyIsNull() {
            addCriterion("totalReply is null");
            return (Criteria) this;
        }

        public Criteria andTotalReplyIsNotNull() {
            addCriterion("totalReply is not null");
            return (Criteria) this;
        }

        public Criteria andTotalReplyEqualTo(Integer value) {
            addCriterion("totalReply =", value, "totalReply");
            return (Criteria) this;
        }

        public Criteria andTotalReplyNotEqualTo(Integer value) {
            addCriterion("totalReply <>", value, "totalReply");
            return (Criteria) this;
        }

        public Criteria andTotalReplyGreaterThan(Integer value) {
            addCriterion("totalReply >", value, "totalReply");
            return (Criteria) this;
        }

        public Criteria andTotalReplyGreaterThanOrEqualTo(Integer value) {
            addCriterion("totalReply >=", value, "totalReply");
            return (Criteria) this;
        }

        public Criteria andTotalReplyLessThan(Integer value) {
            addCriterion("totalReply <", value, "totalReply");
            return (Criteria) this;
        }

        public Criteria andTotalReplyLessThanOrEqualTo(Integer value) {
            addCriterion("totalReply <=", value, "totalReply");
            return (Criteria) this;
        }

        public Criteria andTotalReplyIn(List<Integer> values) {
            addCriterion("totalReply in", values, "totalReply");
            return (Criteria) this;
        }

        public Criteria andTotalReplyNotIn(List<Integer> values) {
            addCriterion("totalReply not in", values, "totalReply");
            return (Criteria) this;
        }

        public Criteria andTotalReplyBetween(Integer value1, Integer value2) {
            addCriterion("totalReply between", value1, value2, "totalReply");
            return (Criteria) this;
        }

        public Criteria andTotalReplyNotBetween(Integer value1, Integer value2) {
            addCriterion("totalReply not between", value1, value2, "totalReply");
            return (Criteria) this;
        }

        public Criteria andDailyVisitsIsNull() {
            addCriterion("dailyVisits is null");
            return (Criteria) this;
        }

        public Criteria andDailyVisitsIsNotNull() {
            addCriterion("dailyVisits is not null");
            return (Criteria) this;
        }

        public Criteria andDailyVisitsEqualTo(Integer value) {
            addCriterion("dailyVisits =", value, "dailyVisits");
            return (Criteria) this;
        }

        public Criteria andDailyVisitsNotEqualTo(Integer value) {
            addCriterion("dailyVisits <>", value, "dailyVisits");
            return (Criteria) this;
        }

        public Criteria andDailyVisitsGreaterThan(Integer value) {
            addCriterion("dailyVisits >", value, "dailyVisits");
            return (Criteria) this;
        }

        public Criteria andDailyVisitsGreaterThanOrEqualTo(Integer value) {
            addCriterion("dailyVisits >=", value, "dailyVisits");
            return (Criteria) this;
        }

        public Criteria andDailyVisitsLessThan(Integer value) {
            addCriterion("dailyVisits <", value, "dailyVisits");
            return (Criteria) this;
        }

        public Criteria andDailyVisitsLessThanOrEqualTo(Integer value) {
            addCriterion("dailyVisits <=", value, "dailyVisits");
            return (Criteria) this;
        }

        public Criteria andDailyVisitsIn(List<Integer> values) {
            addCriterion("dailyVisits in", values, "dailyVisits");
            return (Criteria) this;
        }

        public Criteria andDailyVisitsNotIn(List<Integer> values) {
            addCriterion("dailyVisits not in", values, "dailyVisits");
            return (Criteria) this;
        }

        public Criteria andDailyVisitsBetween(Integer value1, Integer value2) {
            addCriterion("dailyVisits between", value1, value2, "dailyVisits");
            return (Criteria) this;
        }

        public Criteria andDailyVisitsNotBetween(Integer value1, Integer value2) {
            addCriterion("dailyVisits not between", value1, value2, "dailyVisits");
            return (Criteria) this;
        }

        public Criteria andDailyReplyIsNull() {
            addCriterion("dailyReply is null");
            return (Criteria) this;
        }

        public Criteria andDailyReplyIsNotNull() {
            addCriterion("dailyReply is not null");
            return (Criteria) this;
        }

        public Criteria andDailyReplyEqualTo(Integer value) {
            addCriterion("dailyReply =", value, "dailyReply");
            return (Criteria) this;
        }

        public Criteria andDailyReplyNotEqualTo(Integer value) {
            addCriterion("dailyReply <>", value, "dailyReply");
            return (Criteria) this;
        }

        public Criteria andDailyReplyGreaterThan(Integer value) {
            addCriterion("dailyReply >", value, "dailyReply");
            return (Criteria) this;
        }

        public Criteria andDailyReplyGreaterThanOrEqualTo(Integer value) {
            addCriterion("dailyReply >=", value, "dailyReply");
            return (Criteria) this;
        }

        public Criteria andDailyReplyLessThan(Integer value) {
            addCriterion("dailyReply <", value, "dailyReply");
            return (Criteria) this;
        }

        public Criteria andDailyReplyLessThanOrEqualTo(Integer value) {
            addCriterion("dailyReply <=", value, "dailyReply");
            return (Criteria) this;
        }

        public Criteria andDailyReplyIn(List<Integer> values) {
            addCriterion("dailyReply in", values, "dailyReply");
            return (Criteria) this;
        }

        public Criteria andDailyReplyNotIn(List<Integer> values) {
            addCriterion("dailyReply not in", values, "dailyReply");
            return (Criteria) this;
        }

        public Criteria andDailyReplyBetween(Integer value1, Integer value2) {
            addCriterion("dailyReply between", value1, value2, "dailyReply");
            return (Criteria) this;
        }

        public Criteria andDailyReplyNotBetween(Integer value1, Integer value2) {
            addCriterion("dailyReply not between", value1, value2, "dailyReply");
            return (Criteria) this;
        }

        public Criteria andWeekVisitsIsNull() {
            addCriterion("weekVisits is null");
            return (Criteria) this;
        }

        public Criteria andWeekVisitsIsNotNull() {
            addCriterion("weekVisits is not null");
            return (Criteria) this;
        }

        public Criteria andWeekVisitsEqualTo(Integer value) {
            addCriterion("weekVisits =", value, "weekVisits");
            return (Criteria) this;
        }

        public Criteria andWeekVisitsNotEqualTo(Integer value) {
            addCriterion("weekVisits <>", value, "weekVisits");
            return (Criteria) this;
        }

        public Criteria andWeekVisitsGreaterThan(Integer value) {
            addCriterion("weekVisits >", value, "weekVisits");
            return (Criteria) this;
        }

        public Criteria andWeekVisitsGreaterThanOrEqualTo(Integer value) {
            addCriterion("weekVisits >=", value, "weekVisits");
            return (Criteria) this;
        }

        public Criteria andWeekVisitsLessThan(Integer value) {
            addCriterion("weekVisits <", value, "weekVisits");
            return (Criteria) this;
        }

        public Criteria andWeekVisitsLessThanOrEqualTo(Integer value) {
            addCriterion("weekVisits <=", value, "weekVisits");
            return (Criteria) this;
        }

        public Criteria andWeekVisitsIn(List<Integer> values) {
            addCriterion("weekVisits in", values, "weekVisits");
            return (Criteria) this;
        }

        public Criteria andWeekVisitsNotIn(List<Integer> values) {
            addCriterion("weekVisits not in", values, "weekVisits");
            return (Criteria) this;
        }

        public Criteria andWeekVisitsBetween(Integer value1, Integer value2) {
            addCriterion("weekVisits between", value1, value2, "weekVisits");
            return (Criteria) this;
        }

        public Criteria andWeekVisitsNotBetween(Integer value1, Integer value2) {
            addCriterion("weekVisits not between", value1, value2, "weekVisits");
            return (Criteria) this;
        }

        public Criteria andWeekReplyIsNull() {
            addCriterion("weekReply is null");
            return (Criteria) this;
        }

        public Criteria andWeekReplyIsNotNull() {
            addCriterion("weekReply is not null");
            return (Criteria) this;
        }

        public Criteria andWeekReplyEqualTo(Integer value) {
            addCriterion("weekReply =", value, "weekReply");
            return (Criteria) this;
        }

        public Criteria andWeekReplyNotEqualTo(Integer value) {
            addCriterion("weekReply <>", value, "weekReply");
            return (Criteria) this;
        }

        public Criteria andWeekReplyGreaterThan(Integer value) {
            addCriterion("weekReply >", value, "weekReply");
            return (Criteria) this;
        }

        public Criteria andWeekReplyGreaterThanOrEqualTo(Integer value) {
            addCriterion("weekReply >=", value, "weekReply");
            return (Criteria) this;
        }

        public Criteria andWeekReplyLessThan(Integer value) {
            addCriterion("weekReply <", value, "weekReply");
            return (Criteria) this;
        }

        public Criteria andWeekReplyLessThanOrEqualTo(Integer value) {
            addCriterion("weekReply <=", value, "weekReply");
            return (Criteria) this;
        }

        public Criteria andWeekReplyIn(List<Integer> values) {
            addCriterion("weekReply in", values, "weekReply");
            return (Criteria) this;
        }

        public Criteria andWeekReplyNotIn(List<Integer> values) {
            addCriterion("weekReply not in", values, "weekReply");
            return (Criteria) this;
        }

        public Criteria andWeekReplyBetween(Integer value1, Integer value2) {
            addCriterion("weekReply between", value1, value2, "weekReply");
            return (Criteria) this;
        }

        public Criteria andWeekReplyNotBetween(Integer value1, Integer value2) {
            addCriterion("weekReply not between", value1, value2, "weekReply");
            return (Criteria) this;
        }

        public Criteria andMonthVisitsIsNull() {
            addCriterion("monthVisits is null");
            return (Criteria) this;
        }

        public Criteria andMonthVisitsIsNotNull() {
            addCriterion("monthVisits is not null");
            return (Criteria) this;
        }

        public Criteria andMonthVisitsEqualTo(Integer value) {
            addCriterion("monthVisits =", value, "monthVisits");
            return (Criteria) this;
        }

        public Criteria andMonthVisitsNotEqualTo(Integer value) {
            addCriterion("monthVisits <>", value, "monthVisits");
            return (Criteria) this;
        }

        public Criteria andMonthVisitsGreaterThan(Integer value) {
            addCriterion("monthVisits >", value, "monthVisits");
            return (Criteria) this;
        }

        public Criteria andMonthVisitsGreaterThanOrEqualTo(Integer value) {
            addCriterion("monthVisits >=", value, "monthVisits");
            return (Criteria) this;
        }

        public Criteria andMonthVisitsLessThan(Integer value) {
            addCriterion("monthVisits <", value, "monthVisits");
            return (Criteria) this;
        }

        public Criteria andMonthVisitsLessThanOrEqualTo(Integer value) {
            addCriterion("monthVisits <=", value, "monthVisits");
            return (Criteria) this;
        }

        public Criteria andMonthVisitsIn(List<Integer> values) {
            addCriterion("monthVisits in", values, "monthVisits");
            return (Criteria) this;
        }

        public Criteria andMonthVisitsNotIn(List<Integer> values) {
            addCriterion("monthVisits not in", values, "monthVisits");
            return (Criteria) this;
        }

        public Criteria andMonthVisitsBetween(Integer value1, Integer value2) {
            addCriterion("monthVisits between", value1, value2, "monthVisits");
            return (Criteria) this;
        }

        public Criteria andMonthVisitsNotBetween(Integer value1, Integer value2) {
            addCriterion("monthVisits not between", value1, value2, "monthVisits");
            return (Criteria) this;
        }

        public Criteria andMonthReplyIsNull() {
            addCriterion("monthReply is null");
            return (Criteria) this;
        }

        public Criteria andMonthReplyIsNotNull() {
            addCriterion("monthReply is not null");
            return (Criteria) this;
        }

        public Criteria andMonthReplyEqualTo(Integer value) {
            addCriterion("monthReply =", value, "monthReply");
            return (Criteria) this;
        }

        public Criteria andMonthReplyNotEqualTo(Integer value) {
            addCriterion("monthReply <>", value, "monthReply");
            return (Criteria) this;
        }

        public Criteria andMonthReplyGreaterThan(Integer value) {
            addCriterion("monthReply >", value, "monthReply");
            return (Criteria) this;
        }

        public Criteria andMonthReplyGreaterThanOrEqualTo(Integer value) {
            addCriterion("monthReply >=", value, "monthReply");
            return (Criteria) this;
        }

        public Criteria andMonthReplyLessThan(Integer value) {
            addCriterion("monthReply <", value, "monthReply");
            return (Criteria) this;
        }

        public Criteria andMonthReplyLessThanOrEqualTo(Integer value) {
            addCriterion("monthReply <=", value, "monthReply");
            return (Criteria) this;
        }

        public Criteria andMonthReplyIn(List<Integer> values) {
            addCriterion("monthReply in", values, "monthReply");
            return (Criteria) this;
        }

        public Criteria andMonthReplyNotIn(List<Integer> values) {
            addCriterion("monthReply not in", values, "monthReply");
            return (Criteria) this;
        }

        public Criteria andMonthReplyBetween(Integer value1, Integer value2) {
            addCriterion("monthReply between", value1, value2, "monthReply");
            return (Criteria) this;
        }

        public Criteria andMonthReplyNotBetween(Integer value1, Integer value2) {
            addCriterion("monthReply not between", value1, value2, "monthReply");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andExecuteHourIsNull() {
            addCriterion("executeHour is null");
            return (Criteria) this;
        }

        public Criteria andExecuteHourIsNotNull() {
            addCriterion("executeHour is not null");
            return (Criteria) this;
        }

        public Criteria andExecuteHourEqualTo(Integer value) {
            addCriterion("executeHour =", value, "executeHour");
            return (Criteria) this;
        }

        public Criteria andExecuteHourNotEqualTo(Integer value) {
            addCriterion("executeHour <>", value, "executeHour");
            return (Criteria) this;
        }

        public Criteria andExecuteHourGreaterThan(Integer value) {
            addCriterion("executeHour >", value, "executeHour");
            return (Criteria) this;
        }

        public Criteria andExecuteHourGreaterThanOrEqualTo(Integer value) {
            addCriterion("executeHour >=", value, "executeHour");
            return (Criteria) this;
        }

        public Criteria andExecuteHourLessThan(Integer value) {
            addCriterion("executeHour <", value, "executeHour");
            return (Criteria) this;
        }

        public Criteria andExecuteHourLessThanOrEqualTo(Integer value) {
            addCriterion("executeHour <=", value, "executeHour");
            return (Criteria) this;
        }

        public Criteria andExecuteHourIn(List<Integer> values) {
            addCriterion("executeHour in", values, "executeHour");
            return (Criteria) this;
        }

        public Criteria andExecuteHourNotIn(List<Integer> values) {
            addCriterion("executeHour not in", values, "executeHour");
            return (Criteria) this;
        }

        public Criteria andExecuteHourBetween(Integer value1, Integer value2) {
            addCriterion("executeHour between", value1, value2, "executeHour");
            return (Criteria) this;
        }

        public Criteria andExecuteHourNotBetween(Integer value1, Integer value2) {
            addCriterion("executeHour not between", value1, value2, "executeHour");
            return (Criteria) this;
        }

        public Criteria andExecuteMinuteIsNull() {
            addCriterion("executeMinute is null");
            return (Criteria) this;
        }

        public Criteria andExecuteMinuteIsNotNull() {
            addCriterion("executeMinute is not null");
            return (Criteria) this;
        }

        public Criteria andExecuteMinuteEqualTo(Integer value) {
            addCriterion("executeMinute =", value, "executeMinute");
            return (Criteria) this;
        }

        public Criteria andExecuteMinuteNotEqualTo(Integer value) {
            addCriterion("executeMinute <>", value, "executeMinute");
            return (Criteria) this;
        }

        public Criteria andExecuteMinuteGreaterThan(Integer value) {
            addCriterion("executeMinute >", value, "executeMinute");
            return (Criteria) this;
        }

        public Criteria andExecuteMinuteGreaterThanOrEqualTo(Integer value) {
            addCriterion("executeMinute >=", value, "executeMinute");
            return (Criteria) this;
        }

        public Criteria andExecuteMinuteLessThan(Integer value) {
            addCriterion("executeMinute <", value, "executeMinute");
            return (Criteria) this;
        }

        public Criteria andExecuteMinuteLessThanOrEqualTo(Integer value) {
            addCriterion("executeMinute <=", value, "executeMinute");
            return (Criteria) this;
        }

        public Criteria andExecuteMinuteIn(List<Integer> values) {
            addCriterion("executeMinute in", values, "executeMinute");
            return (Criteria) this;
        }

        public Criteria andExecuteMinuteNotIn(List<Integer> values) {
            addCriterion("executeMinute not in", values, "executeMinute");
            return (Criteria) this;
        }

        public Criteria andExecuteMinuteBetween(Integer value1, Integer value2) {
            addCriterion("executeMinute between", value1, value2, "executeMinute");
            return (Criteria) this;
        }

        public Criteria andExecuteMinuteNotBetween(Integer value1, Integer value2) {
            addCriterion("executeMinute not between", value1, value2, "executeMinute");
            return (Criteria) this;
        }

        public Criteria andIntervalHourIsNull() {
            addCriterion("intervalHour is null");
            return (Criteria) this;
        }

        public Criteria andIntervalHourIsNotNull() {
            addCriterion("intervalHour is not null");
            return (Criteria) this;
        }

        public Criteria andIntervalHourEqualTo(Integer value) {
            addCriterion("intervalHour =", value, "intervalHour");
            return (Criteria) this;
        }

        public Criteria andIntervalHourNotEqualTo(Integer value) {
            addCriterion("intervalHour <>", value, "intervalHour");
            return (Criteria) this;
        }

        public Criteria andIntervalHourGreaterThan(Integer value) {
            addCriterion("intervalHour >", value, "intervalHour");
            return (Criteria) this;
        }

        public Criteria andIntervalHourGreaterThanOrEqualTo(Integer value) {
            addCriterion("intervalHour >=", value, "intervalHour");
            return (Criteria) this;
        }

        public Criteria andIntervalHourLessThan(Integer value) {
            addCriterion("intervalHour <", value, "intervalHour");
            return (Criteria) this;
        }

        public Criteria andIntervalHourLessThanOrEqualTo(Integer value) {
            addCriterion("intervalHour <=", value, "intervalHour");
            return (Criteria) this;
        }

        public Criteria andIntervalHourIn(List<Integer> values) {
            addCriterion("intervalHour in", values, "intervalHour");
            return (Criteria) this;
        }

        public Criteria andIntervalHourNotIn(List<Integer> values) {
            addCriterion("intervalHour not in", values, "intervalHour");
            return (Criteria) this;
        }

        public Criteria andIntervalHourBetween(Integer value1, Integer value2) {
            addCriterion("intervalHour between", value1, value2, "intervalHour");
            return (Criteria) this;
        }

        public Criteria andIntervalHourNotBetween(Integer value1, Integer value2) {
            addCriterion("intervalHour not between", value1, value2, "intervalHour");
            return (Criteria) this;
        }

        public Criteria andIntervalDayIsNull() {
            addCriterion("intervalDay is null");
            return (Criteria) this;
        }

        public Criteria andIntervalDayIsNotNull() {
            addCriterion("intervalDay is not null");
            return (Criteria) this;
        }

        public Criteria andIntervalDayEqualTo(Integer value) {
            addCriterion("intervalDay =", value, "intervalDay");
            return (Criteria) this;
        }

        public Criteria andIntervalDayNotEqualTo(Integer value) {
            addCriterion("intervalDay <>", value, "intervalDay");
            return (Criteria) this;
        }

        public Criteria andIntervalDayGreaterThan(Integer value) {
            addCriterion("intervalDay >", value, "intervalDay");
            return (Criteria) this;
        }

        public Criteria andIntervalDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("intervalDay >=", value, "intervalDay");
            return (Criteria) this;
        }

        public Criteria andIntervalDayLessThan(Integer value) {
            addCriterion("intervalDay <", value, "intervalDay");
            return (Criteria) this;
        }

        public Criteria andIntervalDayLessThanOrEqualTo(Integer value) {
            addCriterion("intervalDay <=", value, "intervalDay");
            return (Criteria) this;
        }

        public Criteria andIntervalDayIn(List<Integer> values) {
            addCriterion("intervalDay in", values, "intervalDay");
            return (Criteria) this;
        }

        public Criteria andIntervalDayNotIn(List<Integer> values) {
            addCriterion("intervalDay not in", values, "intervalDay");
            return (Criteria) this;
        }

        public Criteria andIntervalDayBetween(Integer value1, Integer value2) {
            addCriterion("intervalDay between", value1, value2, "intervalDay");
            return (Criteria) this;
        }

        public Criteria andIntervalDayNotBetween(Integer value1, Integer value2) {
            addCriterion("intervalDay not between", value1, value2, "intervalDay");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}