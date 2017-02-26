package com.kuangren.po.video;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VideoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VideoExample() {
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

        public Criteria andVedioPathIsNull() {
            addCriterion("vedioPath is null");
            return (Criteria) this;
        }

        public Criteria andVedioPathIsNotNull() {
            addCriterion("vedioPath is not null");
            return (Criteria) this;
        }

        public Criteria andVedioPathEqualTo(String value) {
            addCriterion("vedioPath =", value, "vedioPath");
            return (Criteria) this;
        }

        public Criteria andVedioPathNotEqualTo(String value) {
            addCriterion("vedioPath <>", value, "vedioPath");
            return (Criteria) this;
        }

        public Criteria andVedioPathGreaterThan(String value) {
            addCriterion("vedioPath >", value, "vedioPath");
            return (Criteria) this;
        }

        public Criteria andVedioPathGreaterThanOrEqualTo(String value) {
            addCriterion("vedioPath >=", value, "vedioPath");
            return (Criteria) this;
        }

        public Criteria andVedioPathLessThan(String value) {
            addCriterion("vedioPath <", value, "vedioPath");
            return (Criteria) this;
        }

        public Criteria andVedioPathLessThanOrEqualTo(String value) {
            addCriterion("vedioPath <=", value, "vedioPath");
            return (Criteria) this;
        }

        public Criteria andVedioPathLike(String value) {
            addCriterion("vedioPath like", value, "vedioPath");
            return (Criteria) this;
        }

        public Criteria andVedioPathNotLike(String value) {
            addCriterion("vedioPath not like", value, "vedioPath");
            return (Criteria) this;
        }

        public Criteria andVedioPathIn(List<String> values) {
            addCriterion("vedioPath in", values, "vedioPath");
            return (Criteria) this;
        }

        public Criteria andVedioPathNotIn(List<String> values) {
            addCriterion("vedioPath not in", values, "vedioPath");
            return (Criteria) this;
        }

        public Criteria andVedioPathBetween(String value1, String value2) {
            addCriterion("vedioPath between", value1, value2, "vedioPath");
            return (Criteria) this;
        }

        public Criteria andVedioPathNotBetween(String value1, String value2) {
            addCriterion("vedioPath not between", value1, value2, "vedioPath");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("size is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("size is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(Integer value) {
            addCriterion("size =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(Integer value) {
            addCriterion("size <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(Integer value) {
            addCriterion("size >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("size >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(Integer value) {
            addCriterion("size <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(Integer value) {
            addCriterion("size <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<Integer> values) {
            addCriterion("size in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<Integer> values) {
            addCriterion("size not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(Integer value1, Integer value2) {
            addCriterion("size between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("size not between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andTimeSpanIsNull() {
            addCriterion("timeSpan is null");
            return (Criteria) this;
        }

        public Criteria andTimeSpanIsNotNull() {
            addCriterion("timeSpan is not null");
            return (Criteria) this;
        }

        public Criteria andTimeSpanEqualTo(String value) {
            addCriterion("timeSpan =", value, "timeSpan");
            return (Criteria) this;
        }

        public Criteria andTimeSpanNotEqualTo(String value) {
            addCriterion("timeSpan <>", value, "timeSpan");
            return (Criteria) this;
        }

        public Criteria andTimeSpanGreaterThan(String value) {
            addCriterion("timeSpan >", value, "timeSpan");
            return (Criteria) this;
        }

        public Criteria andTimeSpanGreaterThanOrEqualTo(String value) {
            addCriterion("timeSpan >=", value, "timeSpan");
            return (Criteria) this;
        }

        public Criteria andTimeSpanLessThan(String value) {
            addCriterion("timeSpan <", value, "timeSpan");
            return (Criteria) this;
        }

        public Criteria andTimeSpanLessThanOrEqualTo(String value) {
            addCriterion("timeSpan <=", value, "timeSpan");
            return (Criteria) this;
        }

        public Criteria andTimeSpanLike(String value) {
            addCriterion("timeSpan like", value, "timeSpan");
            return (Criteria) this;
        }

        public Criteria andTimeSpanNotLike(String value) {
            addCriterion("timeSpan not like", value, "timeSpan");
            return (Criteria) this;
        }

        public Criteria andTimeSpanIn(List<String> values) {
            addCriterion("timeSpan in", values, "timeSpan");
            return (Criteria) this;
        }

        public Criteria andTimeSpanNotIn(List<String> values) {
            addCriterion("timeSpan not in", values, "timeSpan");
            return (Criteria) this;
        }

        public Criteria andTimeSpanBetween(String value1, String value2) {
            addCriterion("timeSpan between", value1, value2, "timeSpan");
            return (Criteria) this;
        }

        public Criteria andTimeSpanNotBetween(String value1, String value2) {
            addCriterion("timeSpan not between", value1, value2, "timeSpan");
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

        public Criteria andCommentCountIsNull() {
            addCriterion("commentCount is null");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNotNull() {
            addCriterion("commentCount is not null");
            return (Criteria) this;
        }

        public Criteria andCommentCountEqualTo(Integer value) {
            addCriterion("commentCount =", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotEqualTo(Integer value) {
            addCriterion("commentCount <>", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThan(Integer value) {
            addCriterion("commentCount >", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("commentCount >=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThan(Integer value) {
            addCriterion("commentCount <", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThanOrEqualTo(Integer value) {
            addCriterion("commentCount <=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountIn(List<Integer> values) {
            addCriterion("commentCount in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotIn(List<Integer> values) {
            addCriterion("commentCount not in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountBetween(Integer value1, Integer value2) {
            addCriterion("commentCount between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotBetween(Integer value1, Integer value2) {
            addCriterion("commentCount not between", value1, value2, "commentCount");
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

        public Criteria andIsSecretIsNull() {
            addCriterion("isSecret is null");
            return (Criteria) this;
        }

        public Criteria andIsSecretIsNotNull() {
            addCriterion("isSecret is not null");
            return (Criteria) this;
        }

        public Criteria andIsSecretEqualTo(Integer value) {
            addCriterion("isSecret =", value, "isSecret");
            return (Criteria) this;
        }

        public Criteria andIsSecretNotEqualTo(Integer value) {
            addCriterion("isSecret <>", value, "isSecret");
            return (Criteria) this;
        }

        public Criteria andIsSecretGreaterThan(Integer value) {
            addCriterion("isSecret >", value, "isSecret");
            return (Criteria) this;
        }

        public Criteria andIsSecretGreaterThanOrEqualTo(Integer value) {
            addCriterion("isSecret >=", value, "isSecret");
            return (Criteria) this;
        }

        public Criteria andIsSecretLessThan(Integer value) {
            addCriterion("isSecret <", value, "isSecret");
            return (Criteria) this;
        }

        public Criteria andIsSecretLessThanOrEqualTo(Integer value) {
            addCriterion("isSecret <=", value, "isSecret");
            return (Criteria) this;
        }

        public Criteria andIsSecretIn(List<Integer> values) {
            addCriterion("isSecret in", values, "isSecret");
            return (Criteria) this;
        }

        public Criteria andIsSecretNotIn(List<Integer> values) {
            addCriterion("isSecret not in", values, "isSecret");
            return (Criteria) this;
        }

        public Criteria andIsSecretBetween(Integer value1, Integer value2) {
            addCriterion("isSecret between", value1, value2, "isSecret");
            return (Criteria) this;
        }

        public Criteria andIsSecretNotBetween(Integer value1, Integer value2) {
            addCriterion("isSecret not between", value1, value2, "isSecret");
            return (Criteria) this;
        }

        public Criteria andFavorIsNull() {
            addCriterion("favor is null");
            return (Criteria) this;
        }

        public Criteria andFavorIsNotNull() {
            addCriterion("favor is not null");
            return (Criteria) this;
        }

        public Criteria andFavorEqualTo(Integer value) {
            addCriterion("favor =", value, "favor");
            return (Criteria) this;
        }

        public Criteria andFavorNotEqualTo(Integer value) {
            addCriterion("favor <>", value, "favor");
            return (Criteria) this;
        }

        public Criteria andFavorGreaterThan(Integer value) {
            addCriterion("favor >", value, "favor");
            return (Criteria) this;
        }

        public Criteria andFavorGreaterThanOrEqualTo(Integer value) {
            addCriterion("favor >=", value, "favor");
            return (Criteria) this;
        }

        public Criteria andFavorLessThan(Integer value) {
            addCriterion("favor <", value, "favor");
            return (Criteria) this;
        }

        public Criteria andFavorLessThanOrEqualTo(Integer value) {
            addCriterion("favor <=", value, "favor");
            return (Criteria) this;
        }

        public Criteria andFavorIn(List<Integer> values) {
            addCriterion("favor in", values, "favor");
            return (Criteria) this;
        }

        public Criteria andFavorNotIn(List<Integer> values) {
            addCriterion("favor not in", values, "favor");
            return (Criteria) this;
        }

        public Criteria andFavorBetween(Integer value1, Integer value2) {
            addCriterion("favor between", value1, value2, "favor");
            return (Criteria) this;
        }

        public Criteria andFavorNotBetween(Integer value1, Integer value2) {
            addCriterion("favor not between", value1, value2, "favor");
            return (Criteria) this;
        }

        public Criteria andTrampleIsNull() {
            addCriterion("trample is null");
            return (Criteria) this;
        }

        public Criteria andTrampleIsNotNull() {
            addCriterion("trample is not null");
            return (Criteria) this;
        }

        public Criteria andTrampleEqualTo(Integer value) {
            addCriterion("trample =", value, "trample");
            return (Criteria) this;
        }

        public Criteria andTrampleNotEqualTo(Integer value) {
            addCriterion("trample <>", value, "trample");
            return (Criteria) this;
        }

        public Criteria andTrampleGreaterThan(Integer value) {
            addCriterion("trample >", value, "trample");
            return (Criteria) this;
        }

        public Criteria andTrampleGreaterThanOrEqualTo(Integer value) {
            addCriterion("trample >=", value, "trample");
            return (Criteria) this;
        }

        public Criteria andTrampleLessThan(Integer value) {
            addCriterion("trample <", value, "trample");
            return (Criteria) this;
        }

        public Criteria andTrampleLessThanOrEqualTo(Integer value) {
            addCriterion("trample <=", value, "trample");
            return (Criteria) this;
        }

        public Criteria andTrampleIn(List<Integer> values) {
            addCriterion("trample in", values, "trample");
            return (Criteria) this;
        }

        public Criteria andTrampleNotIn(List<Integer> values) {
            addCriterion("trample not in", values, "trample");
            return (Criteria) this;
        }

        public Criteria andTrampleBetween(Integer value1, Integer value2) {
            addCriterion("trample between", value1, value2, "trample");
            return (Criteria) this;
        }

        public Criteria andTrampleNotBetween(Integer value1, Integer value2) {
            addCriterion("trample not between", value1, value2, "trample");
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