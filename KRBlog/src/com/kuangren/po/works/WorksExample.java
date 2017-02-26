package com.kuangren.po.works;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorksExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorksExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andEnvironmentIsNull() {
            addCriterion("environment is null");
            return (Criteria) this;
        }

        public Criteria andEnvironmentIsNotNull() {
            addCriterion("environment is not null");
            return (Criteria) this;
        }

        public Criteria andEnvironmentEqualTo(String value) {
            addCriterion("environment =", value, "environment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentNotEqualTo(String value) {
            addCriterion("environment <>", value, "environment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentGreaterThan(String value) {
            addCriterion("environment >", value, "environment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentGreaterThanOrEqualTo(String value) {
            addCriterion("environment >=", value, "environment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentLessThan(String value) {
            addCriterion("environment <", value, "environment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentLessThanOrEqualTo(String value) {
            addCriterion("environment <=", value, "environment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentLike(String value) {
            addCriterion("environment like", value, "environment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentNotLike(String value) {
            addCriterion("environment not like", value, "environment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentIn(List<String> values) {
            addCriterion("environment in", values, "environment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentNotIn(List<String> values) {
            addCriterion("environment not in", values, "environment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentBetween(String value1, String value2) {
            addCriterion("environment between", value1, value2, "environment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentNotBetween(String value1, String value2) {
            addCriterion("environment not between", value1, value2, "environment");
            return (Criteria) this;
        }

        public Criteria andToolIsNull() {
            addCriterion("tool is null");
            return (Criteria) this;
        }

        public Criteria andToolIsNotNull() {
            addCriterion("tool is not null");
            return (Criteria) this;
        }

        public Criteria andToolEqualTo(String value) {
            addCriterion("tool =", value, "tool");
            return (Criteria) this;
        }

        public Criteria andToolNotEqualTo(String value) {
            addCriterion("tool <>", value, "tool");
            return (Criteria) this;
        }

        public Criteria andToolGreaterThan(String value) {
            addCriterion("tool >", value, "tool");
            return (Criteria) this;
        }

        public Criteria andToolGreaterThanOrEqualTo(String value) {
            addCriterion("tool >=", value, "tool");
            return (Criteria) this;
        }

        public Criteria andToolLessThan(String value) {
            addCriterion("tool <", value, "tool");
            return (Criteria) this;
        }

        public Criteria andToolLessThanOrEqualTo(String value) {
            addCriterion("tool <=", value, "tool");
            return (Criteria) this;
        }

        public Criteria andToolLike(String value) {
            addCriterion("tool like", value, "tool");
            return (Criteria) this;
        }

        public Criteria andToolNotLike(String value) {
            addCriterion("tool not like", value, "tool");
            return (Criteria) this;
        }

        public Criteria andToolIn(List<String> values) {
            addCriterion("tool in", values, "tool");
            return (Criteria) this;
        }

        public Criteria andToolNotIn(List<String> values) {
            addCriterion("tool not in", values, "tool");
            return (Criteria) this;
        }

        public Criteria andToolBetween(String value1, String value2) {
            addCriterion("tool between", value1, value2, "tool");
            return (Criteria) this;
        }

        public Criteria andToolNotBetween(String value1, String value2) {
            addCriterion("tool not between", value1, value2, "tool");
            return (Criteria) this;
        }

        public Criteria andTimeCostIsNull() {
            addCriterion("timeCost is null");
            return (Criteria) this;
        }

        public Criteria andTimeCostIsNotNull() {
            addCriterion("timeCost is not null");
            return (Criteria) this;
        }

        public Criteria andTimeCostEqualTo(String value) {
            addCriterion("timeCost =", value, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostNotEqualTo(String value) {
            addCriterion("timeCost <>", value, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostGreaterThan(String value) {
            addCriterion("timeCost >", value, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostGreaterThanOrEqualTo(String value) {
            addCriterion("timeCost >=", value, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostLessThan(String value) {
            addCriterion("timeCost <", value, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostLessThanOrEqualTo(String value) {
            addCriterion("timeCost <=", value, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostLike(String value) {
            addCriterion("timeCost like", value, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostNotLike(String value) {
            addCriterion("timeCost not like", value, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostIn(List<String> values) {
            addCriterion("timeCost in", values, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostNotIn(List<String> values) {
            addCriterion("timeCost not in", values, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostBetween(String value1, String value2) {
            addCriterion("timeCost between", value1, value2, "timeCost");
            return (Criteria) this;
        }

        public Criteria andTimeCostNotBetween(String value1, String value2) {
            addCriterion("timeCost not between", value1, value2, "timeCost");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNull() {
            addCriterion("beginTime is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("beginTime is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Date value) {
            addCriterion("beginTime =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Date value) {
            addCriterion("beginTime <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Date value) {
            addCriterion("beginTime >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("beginTime >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Date value) {
            addCriterion("beginTime <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("beginTime <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Date> values) {
            addCriterion("beginTime in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Date> values) {
            addCriterion("beginTime not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Date value1, Date value2) {
            addCriterion("beginTime between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("beginTime not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andNumOfDeveloperIsNull() {
            addCriterion("numOfDeveloper is null");
            return (Criteria) this;
        }

        public Criteria andNumOfDeveloperIsNotNull() {
            addCriterion("numOfDeveloper is not null");
            return (Criteria) this;
        }

        public Criteria andNumOfDeveloperEqualTo(Integer value) {
            addCriterion("numOfDeveloper =", value, "numOfDeveloper");
            return (Criteria) this;
        }

        public Criteria andNumOfDeveloperNotEqualTo(Integer value) {
            addCriterion("numOfDeveloper <>", value, "numOfDeveloper");
            return (Criteria) this;
        }

        public Criteria andNumOfDeveloperGreaterThan(Integer value) {
            addCriterion("numOfDeveloper >", value, "numOfDeveloper");
            return (Criteria) this;
        }

        public Criteria andNumOfDeveloperGreaterThanOrEqualTo(Integer value) {
            addCriterion("numOfDeveloper >=", value, "numOfDeveloper");
            return (Criteria) this;
        }

        public Criteria andNumOfDeveloperLessThan(Integer value) {
            addCriterion("numOfDeveloper <", value, "numOfDeveloper");
            return (Criteria) this;
        }

        public Criteria andNumOfDeveloperLessThanOrEqualTo(Integer value) {
            addCriterion("numOfDeveloper <=", value, "numOfDeveloper");
            return (Criteria) this;
        }

        public Criteria andNumOfDeveloperIn(List<Integer> values) {
            addCriterion("numOfDeveloper in", values, "numOfDeveloper");
            return (Criteria) this;
        }

        public Criteria andNumOfDeveloperNotIn(List<Integer> values) {
            addCriterion("numOfDeveloper not in", values, "numOfDeveloper");
            return (Criteria) this;
        }

        public Criteria andNumOfDeveloperBetween(Integer value1, Integer value2) {
            addCriterion("numOfDeveloper between", value1, value2, "numOfDeveloper");
            return (Criteria) this;
        }

        public Criteria andNumOfDeveloperNotBetween(Integer value1, Integer value2) {
            addCriterion("numOfDeveloper not between", value1, value2, "numOfDeveloper");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("createTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andSeeCountIsNull() {
            addCriterion("seeCount is null");
            return (Criteria) this;
        }

        public Criteria andSeeCountIsNotNull() {
            addCriterion("seeCount is not null");
            return (Criteria) this;
        }

        public Criteria andSeeCountEqualTo(Integer value) {
            addCriterion("seeCount =", value, "seeCount");
            return (Criteria) this;
        }

        public Criteria andSeeCountNotEqualTo(Integer value) {
            addCriterion("seeCount <>", value, "seeCount");
            return (Criteria) this;
        }

        public Criteria andSeeCountGreaterThan(Integer value) {
            addCriterion("seeCount >", value, "seeCount");
            return (Criteria) this;
        }

        public Criteria andSeeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("seeCount >=", value, "seeCount");
            return (Criteria) this;
        }

        public Criteria andSeeCountLessThan(Integer value) {
            addCriterion("seeCount <", value, "seeCount");
            return (Criteria) this;
        }

        public Criteria andSeeCountLessThanOrEqualTo(Integer value) {
            addCriterion("seeCount <=", value, "seeCount");
            return (Criteria) this;
        }

        public Criteria andSeeCountIn(List<Integer> values) {
            addCriterion("seeCount in", values, "seeCount");
            return (Criteria) this;
        }

        public Criteria andSeeCountNotIn(List<Integer> values) {
            addCriterion("seeCount not in", values, "seeCount");
            return (Criteria) this;
        }

        public Criteria andSeeCountBetween(Integer value1, Integer value2) {
            addCriterion("seeCount between", value1, value2, "seeCount");
            return (Criteria) this;
        }

        public Criteria andSeeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("seeCount not between", value1, value2, "seeCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountIsNull() {
            addCriterion("replyCount is null");
            return (Criteria) this;
        }

        public Criteria andReplyCountIsNotNull() {
            addCriterion("replyCount is not null");
            return (Criteria) this;
        }

        public Criteria andReplyCountEqualTo(Integer value) {
            addCriterion("replyCount =", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountNotEqualTo(Integer value) {
            addCriterion("replyCount <>", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountGreaterThan(Integer value) {
            addCriterion("replyCount >", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("replyCount >=", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountLessThan(Integer value) {
            addCriterion("replyCount <", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountLessThanOrEqualTo(Integer value) {
            addCriterion("replyCount <=", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountIn(List<Integer> values) {
            addCriterion("replyCount in", values, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountNotIn(List<Integer> values) {
            addCriterion("replyCount not in", values, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountBetween(Integer value1, Integer value2) {
            addCriterion("replyCount between", value1, value2, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("replyCount not between", value1, value2, "replyCount");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
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