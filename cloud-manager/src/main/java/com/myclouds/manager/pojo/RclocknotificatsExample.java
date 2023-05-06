package com.myclouds.manager.pojo;

import java.util.ArrayList;
import java.util.List;

public class RclocknotificatsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RclocknotificatsExample() {
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

        public Criteria andNidIsNull() {
            addCriterion("nid is null");
            return (Criteria) this;
        }

        public Criteria andNidIsNotNull() {
            addCriterion("nid is not null");
            return (Criteria) this;
        }

        public Criteria andNidEqualTo(Integer value) {
            addCriterion("nid =", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidNotEqualTo(Integer value) {
            addCriterion("nid <>", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidGreaterThan(Integer value) {
            addCriterion("nid >", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidGreaterThanOrEqualTo(Integer value) {
            addCriterion("nid >=", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidLessThan(Integer value) {
            addCriterion("nid <", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidLessThanOrEqualTo(Integer value) {
            addCriterion("nid <=", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidIn(List<Integer> values) {
            addCriterion("nid in", values, "nid");
            return (Criteria) this;
        }

        public Criteria andNidNotIn(List<Integer> values) {
            addCriterion("nid not in", values, "nid");
            return (Criteria) this;
        }

        public Criteria andNidBetween(Integer value1, Integer value2) {
            addCriterion("nid between", value1, value2, "nid");
            return (Criteria) this;
        }

        public Criteria andNidNotBetween(Integer value1, Integer value2) {
            addCriterion("nid not between", value1, value2, "nid");
            return (Criteria) this;
        }

        public Criteria andNtitleIsNull() {
            addCriterion("ntitle is null");
            return (Criteria) this;
        }

        public Criteria andNtitleIsNotNull() {
            addCriterion("ntitle is not null");
            return (Criteria) this;
        }

        public Criteria andNtitleEqualTo(String value) {
            addCriterion("ntitle =", value, "ntitle");
            return (Criteria) this;
        }

        public Criteria andNtitleNotEqualTo(String value) {
            addCriterion("ntitle <>", value, "ntitle");
            return (Criteria) this;
        }

        public Criteria andNtitleGreaterThan(String value) {
            addCriterion("ntitle >", value, "ntitle");
            return (Criteria) this;
        }

        public Criteria andNtitleGreaterThanOrEqualTo(String value) {
            addCriterion("ntitle >=", value, "ntitle");
            return (Criteria) this;
        }

        public Criteria andNtitleLessThan(String value) {
            addCriterion("ntitle <", value, "ntitle");
            return (Criteria) this;
        }

        public Criteria andNtitleLessThanOrEqualTo(String value) {
            addCriterion("ntitle <=", value, "ntitle");
            return (Criteria) this;
        }

        public Criteria andNtitleLike(String value) {
            addCriterion("ntitle like", value, "ntitle");
            return (Criteria) this;
        }

        public Criteria andNtitleNotLike(String value) {
            addCriterion("ntitle not like", value, "ntitle");
            return (Criteria) this;
        }

        public Criteria andNtitleIn(List<String> values) {
            addCriterion("ntitle in", values, "ntitle");
            return (Criteria) this;
        }

        public Criteria andNtitleNotIn(List<String> values) {
            addCriterion("ntitle not in", values, "ntitle");
            return (Criteria) this;
        }

        public Criteria andNtitleBetween(String value1, String value2) {
            addCriterion("ntitle between", value1, value2, "ntitle");
            return (Criteria) this;
        }

        public Criteria andNtitleNotBetween(String value1, String value2) {
            addCriterion("ntitle not between", value1, value2, "ntitle");
            return (Criteria) this;
        }

        public Criteria andNdateIsNull() {
            addCriterion("ndate is null");
            return (Criteria) this;
        }

        public Criteria andNdateIsNotNull() {
            addCriterion("ndate is not null");
            return (Criteria) this;
        }

        public Criteria andNdateEqualTo(String value) {
            addCriterion("ndate =", value, "ndate");
            return (Criteria) this;
        }

        public Criteria andNdateNotEqualTo(String value) {
            addCriterion("ndate <>", value, "ndate");
            return (Criteria) this;
        }

        public Criteria andNdateGreaterThan(String value) {
            addCriterion("ndate >", value, "ndate");
            return (Criteria) this;
        }

        public Criteria andNdateGreaterThanOrEqualTo(String value) {
            addCriterion("ndate >=", value, "ndate");
            return (Criteria) this;
        }

        public Criteria andNdateLessThan(String value) {
            addCriterion("ndate <", value, "ndate");
            return (Criteria) this;
        }

        public Criteria andNdateLessThanOrEqualTo(String value) {
            addCriterion("ndate <=", value, "ndate");
            return (Criteria) this;
        }

        public Criteria andNdateLike(String value) {
            addCriterion("ndate like", value, "ndate");
            return (Criteria) this;
        }

        public Criteria andNdateNotLike(String value) {
            addCriterion("ndate not like", value, "ndate");
            return (Criteria) this;
        }

        public Criteria andNdateIn(List<String> values) {
            addCriterion("ndate in", values, "ndate");
            return (Criteria) this;
        }

        public Criteria andNdateNotIn(List<String> values) {
            addCriterion("ndate not in", values, "ndate");
            return (Criteria) this;
        }

        public Criteria andNdateBetween(String value1, String value2) {
            addCriterion("ndate between", value1, value2, "ndate");
            return (Criteria) this;
        }

        public Criteria andNdateNotBetween(String value1, String value2) {
            addCriterion("ndate not between", value1, value2, "ndate");
            return (Criteria) this;
        }

        public Criteria andNstarthourIsNull() {
            addCriterion("nstarthour is null");
            return (Criteria) this;
        }

        public Criteria andNstarthourIsNotNull() {
            addCriterion("nstarthour is not null");
            return (Criteria) this;
        }

        public Criteria andNstarthourEqualTo(String value) {
            addCriterion("nstarthour =", value, "nstarthour");
            return (Criteria) this;
        }

        public Criteria andNstarthourNotEqualTo(String value) {
            addCriterion("nstarthour <>", value, "nstarthour");
            return (Criteria) this;
        }

        public Criteria andNstarthourGreaterThan(String value) {
            addCriterion("nstarthour >", value, "nstarthour");
            return (Criteria) this;
        }

        public Criteria andNstarthourGreaterThanOrEqualTo(String value) {
            addCriterion("nstarthour >=", value, "nstarthour");
            return (Criteria) this;
        }

        public Criteria andNstarthourLessThan(String value) {
            addCriterion("nstarthour <", value, "nstarthour");
            return (Criteria) this;
        }

        public Criteria andNstarthourLessThanOrEqualTo(String value) {
            addCriterion("nstarthour <=", value, "nstarthour");
            return (Criteria) this;
        }

        public Criteria andNstarthourLike(String value) {
            addCriterion("nstarthour like", value, "nstarthour");
            return (Criteria) this;
        }

        public Criteria andNstarthourNotLike(String value) {
            addCriterion("nstarthour not like", value, "nstarthour");
            return (Criteria) this;
        }

        public Criteria andNstarthourIn(List<String> values) {
            addCriterion("nstarthour in", values, "nstarthour");
            return (Criteria) this;
        }

        public Criteria andNstarthourNotIn(List<String> values) {
            addCriterion("nstarthour not in", values, "nstarthour");
            return (Criteria) this;
        }

        public Criteria andNstarthourBetween(String value1, String value2) {
            addCriterion("nstarthour between", value1, value2, "nstarthour");
            return (Criteria) this;
        }

        public Criteria andNstarthourNotBetween(String value1, String value2) {
            addCriterion("nstarthour not between", value1, value2, "nstarthour");
            return (Criteria) this;
        }

        public Criteria andNendhourIsNull() {
            addCriterion("nendhour is null");
            return (Criteria) this;
        }

        public Criteria andNendhourIsNotNull() {
            addCriterion("nendhour is not null");
            return (Criteria) this;
        }

        public Criteria andNendhourEqualTo(String value) {
            addCriterion("nendhour =", value, "nendhour");
            return (Criteria) this;
        }

        public Criteria andNendhourNotEqualTo(String value) {
            addCriterion("nendhour <>", value, "nendhour");
            return (Criteria) this;
        }

        public Criteria andNendhourGreaterThan(String value) {
            addCriterion("nendhour >", value, "nendhour");
            return (Criteria) this;
        }

        public Criteria andNendhourGreaterThanOrEqualTo(String value) {
            addCriterion("nendhour >=", value, "nendhour");
            return (Criteria) this;
        }

        public Criteria andNendhourLessThan(String value) {
            addCriterion("nendhour <", value, "nendhour");
            return (Criteria) this;
        }

        public Criteria andNendhourLessThanOrEqualTo(String value) {
            addCriterion("nendhour <=", value, "nendhour");
            return (Criteria) this;
        }

        public Criteria andNendhourLike(String value) {
            addCriterion("nendhour like", value, "nendhour");
            return (Criteria) this;
        }

        public Criteria andNendhourNotLike(String value) {
            addCriterion("nendhour not like", value, "nendhour");
            return (Criteria) this;
        }

        public Criteria andNendhourIn(List<String> values) {
            addCriterion("nendhour in", values, "nendhour");
            return (Criteria) this;
        }

        public Criteria andNendhourNotIn(List<String> values) {
            addCriterion("nendhour not in", values, "nendhour");
            return (Criteria) this;
        }

        public Criteria andNendhourBetween(String value1, String value2) {
            addCriterion("nendhour between", value1, value2, "nendhour");
            return (Criteria) this;
        }

        public Criteria andNendhourNotBetween(String value1, String value2) {
            addCriterion("nendhour not between", value1, value2, "nendhour");
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