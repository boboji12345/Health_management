package com.myclouds.manager.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RnewsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RnewsExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andRnidIsNull() {
            addCriterion("rnid is null");
            return (Criteria) this;
        }

        public Criteria andRnidIsNotNull() {
            addCriterion("rnid is not null");
            return (Criteria) this;
        }

        public Criteria andRnidEqualTo(Integer value) {
            addCriterion("rnid =", value, "rnid");
            return (Criteria) this;
        }

        public Criteria andRnidNotEqualTo(Integer value) {
            addCriterion("rnid <>", value, "rnid");
            return (Criteria) this;
        }

        public Criteria andRnidGreaterThan(Integer value) {
            addCriterion("rnid >", value, "rnid");
            return (Criteria) this;
        }

        public Criteria andRnidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rnid >=", value, "rnid");
            return (Criteria) this;
        }

        public Criteria andRnidLessThan(Integer value) {
            addCriterion("rnid <", value, "rnid");
            return (Criteria) this;
        }

        public Criteria andRnidLessThanOrEqualTo(Integer value) {
            addCriterion("rnid <=", value, "rnid");
            return (Criteria) this;
        }

        public Criteria andRnidIn(List<Integer> values) {
            addCriterion("rnid in", values, "rnid");
            return (Criteria) this;
        }

        public Criteria andRnidNotIn(List<Integer> values) {
            addCriterion("rnid not in", values, "rnid");
            return (Criteria) this;
        }

        public Criteria andRnidBetween(Integer value1, Integer value2) {
            addCriterion("rnid between", value1, value2, "rnid");
            return (Criteria) this;
        }

        public Criteria andRnidNotBetween(Integer value1, Integer value2) {
            addCriterion("rnid not between", value1, value2, "rnid");
            return (Criteria) this;
        }

        public Criteria andRntitleIsNull() {
            addCriterion("rntitle is null");
            return (Criteria) this;
        }

        public Criteria andRntitleIsNotNull() {
            addCriterion("rntitle is not null");
            return (Criteria) this;
        }

        public Criteria andRntitleEqualTo(String value) {
            addCriterion("rntitle =", value, "rntitle");
            return (Criteria) this;
        }

        public Criteria andRntitleNotEqualTo(String value) {
            addCriterion("rntitle <>", value, "rntitle");
            return (Criteria) this;
        }

        public Criteria andRntitleGreaterThan(String value) {
            addCriterion("rntitle >", value, "rntitle");
            return (Criteria) this;
        }

        public Criteria andRntitleGreaterThanOrEqualTo(String value) {
            addCriterion("rntitle >=", value, "rntitle");
            return (Criteria) this;
        }

        public Criteria andRntitleLessThan(String value) {
            addCriterion("rntitle <", value, "rntitle");
            return (Criteria) this;
        }

        public Criteria andRntitleLessThanOrEqualTo(String value) {
            addCriterion("rntitle <=", value, "rntitle");
            return (Criteria) this;
        }

        public Criteria andRntitleLike(String value) {
            addCriterion("rntitle like", value, "rntitle");
            return (Criteria) this;
        }

        public Criteria andRntitleNotLike(String value) {
            addCriterion("rntitle not like", value, "rntitle");
            return (Criteria) this;
        }

        public Criteria andRntitleIn(List<String> values) {
            addCriterion("rntitle in", values, "rntitle");
            return (Criteria) this;
        }

        public Criteria andRntitleNotIn(List<String> values) {
            addCriterion("rntitle not in", values, "rntitle");
            return (Criteria) this;
        }

        public Criteria andRntitleBetween(String value1, String value2) {
            addCriterion("rntitle between", value1, value2, "rntitle");
            return (Criteria) this;
        }

        public Criteria andRntitleNotBetween(String value1, String value2) {
            addCriterion("rntitle not between", value1, value2, "rntitle");
            return (Criteria) this;
        }

        public Criteria andRinstroducesIsNull() {
            addCriterion("rinstroduces is null");
            return (Criteria) this;
        }

        public Criteria andRinstroducesIsNotNull() {
            addCriterion("rinstroduces is not null");
            return (Criteria) this;
        }

        public Criteria andRinstroducesEqualTo(String value) {
            addCriterion("rinstroduces =", value, "rinstroduces");
            return (Criteria) this;
        }

        public Criteria andRinstroducesNotEqualTo(String value) {
            addCriterion("rinstroduces <>", value, "rinstroduces");
            return (Criteria) this;
        }

        public Criteria andRinstroducesGreaterThan(String value) {
            addCriterion("rinstroduces >", value, "rinstroduces");
            return (Criteria) this;
        }

        public Criteria andRinstroducesGreaterThanOrEqualTo(String value) {
            addCriterion("rinstroduces >=", value, "rinstroduces");
            return (Criteria) this;
        }

        public Criteria andRinstroducesLessThan(String value) {
            addCriterion("rinstroduces <", value, "rinstroduces");
            return (Criteria) this;
        }

        public Criteria andRinstroducesLessThanOrEqualTo(String value) {
            addCriterion("rinstroduces <=", value, "rinstroduces");
            return (Criteria) this;
        }

        public Criteria andRinstroducesLike(String value) {
            addCriterion("rinstroduces like", value, "rinstroduces");
            return (Criteria) this;
        }

        public Criteria andRinstroducesNotLike(String value) {
            addCriterion("rinstroduces not like", value, "rinstroduces");
            return (Criteria) this;
        }

        public Criteria andRinstroducesIn(List<String> values) {
            addCriterion("rinstroduces in", values, "rinstroduces");
            return (Criteria) this;
        }

        public Criteria andRinstroducesNotIn(List<String> values) {
            addCriterion("rinstroduces not in", values, "rinstroduces");
            return (Criteria) this;
        }

        public Criteria andRinstroducesBetween(String value1, String value2) {
            addCriterion("rinstroduces between", value1, value2, "rinstroduces");
            return (Criteria) this;
        }

        public Criteria andRinstroducesNotBetween(String value1, String value2) {
            addCriterion("rinstroduces not between", value1, value2, "rinstroduces");
            return (Criteria) this;
        }

        public Criteria andRimgIsNull() {
            addCriterion("rimg is null");
            return (Criteria) this;
        }

        public Criteria andRimgIsNotNull() {
            addCriterion("rimg is not null");
            return (Criteria) this;
        }

        public Criteria andRimgEqualTo(String value) {
            addCriterion("rimg =", value, "rimg");
            return (Criteria) this;
        }

        public Criteria andRimgNotEqualTo(String value) {
            addCriterion("rimg <>", value, "rimg");
            return (Criteria) this;
        }

        public Criteria andRimgGreaterThan(String value) {
            addCriterion("rimg >", value, "rimg");
            return (Criteria) this;
        }

        public Criteria andRimgGreaterThanOrEqualTo(String value) {
            addCriterion("rimg >=", value, "rimg");
            return (Criteria) this;
        }

        public Criteria andRimgLessThan(String value) {
            addCriterion("rimg <", value, "rimg");
            return (Criteria) this;
        }

        public Criteria andRimgLessThanOrEqualTo(String value) {
            addCriterion("rimg <=", value, "rimg");
            return (Criteria) this;
        }

        public Criteria andRimgLike(String value) {
            addCriterion("rimg like", value, "rimg");
            return (Criteria) this;
        }

        public Criteria andRimgNotLike(String value) {
            addCriterion("rimg not like", value, "rimg");
            return (Criteria) this;
        }

        public Criteria andRimgIn(List<String> values) {
            addCriterion("rimg in", values, "rimg");
            return (Criteria) this;
        }

        public Criteria andRimgNotIn(List<String> values) {
            addCriterion("rimg not in", values, "rimg");
            return (Criteria) this;
        }

        public Criteria andRimgBetween(String value1, String value2) {
            addCriterion("rimg between", value1, value2, "rimg");
            return (Criteria) this;
        }

        public Criteria andRimgNotBetween(String value1, String value2) {
            addCriterion("rimg not between", value1, value2, "rimg");
            return (Criteria) this;
        }

        public Criteria andRtidIsNull() {
            addCriterion("rtid is null");
            return (Criteria) this;
        }

        public Criteria andRtidIsNotNull() {
            addCriterion("rtid is not null");
            return (Criteria) this;
        }

        public Criteria andRtidEqualTo(Integer value) {
            addCriterion("rtid =", value, "rtid");
            return (Criteria) this;
        }

        public Criteria andRtidNotEqualTo(Integer value) {
            addCriterion("rtid <>", value, "rtid");
            return (Criteria) this;
        }

        public Criteria andRtidGreaterThan(Integer value) {
            addCriterion("rtid >", value, "rtid");
            return (Criteria) this;
        }

        public Criteria andRtidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rtid >=", value, "rtid");
            return (Criteria) this;
        }

        public Criteria andRtidLessThan(Integer value) {
            addCriterion("rtid <", value, "rtid");
            return (Criteria) this;
        }

        public Criteria andRtidLessThanOrEqualTo(Integer value) {
            addCriterion("rtid <=", value, "rtid");
            return (Criteria) this;
        }

        public Criteria andRtidIn(List<Integer> values) {
            addCriterion("rtid in", values, "rtid");
            return (Criteria) this;
        }

        public Criteria andRtidNotIn(List<Integer> values) {
            addCriterion("rtid not in", values, "rtid");
            return (Criteria) this;
        }

        public Criteria andRtidBetween(Integer value1, Integer value2) {
            addCriterion("rtid between", value1, value2, "rtid");
            return (Criteria) this;
        }

        public Criteria andRtidNotBetween(Integer value1, Integer value2) {
            addCriterion("rtid not between", value1, value2, "rtid");
            return (Criteria) this;
        }

        public Criteria andRdateIsNull() {
            addCriterion("rdate is null");
            return (Criteria) this;
        }

        public Criteria andRdateIsNotNull() {
            addCriterion("rdate is not null");
            return (Criteria) this;
        }

        public Criteria andRdateEqualTo(Date value) {
            addCriterionForJDBCDate("rdate =", value, "rdate");
            return (Criteria) this;
        }

        public Criteria andRdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("rdate <>", value, "rdate");
            return (Criteria) this;
        }

        public Criteria andRdateGreaterThan(Date value) {
            addCriterionForJDBCDate("rdate >", value, "rdate");
            return (Criteria) this;
        }

        public Criteria andRdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rdate >=", value, "rdate");
            return (Criteria) this;
        }

        public Criteria andRdateLessThan(Date value) {
            addCriterionForJDBCDate("rdate <", value, "rdate");
            return (Criteria) this;
        }

        public Criteria andRdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rdate <=", value, "rdate");
            return (Criteria) this;
        }

        public Criteria andRdateIn(List<Date> values) {
            addCriterionForJDBCDate("rdate in", values, "rdate");
            return (Criteria) this;
        }

        public Criteria andRdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("rdate not in", values, "rdate");
            return (Criteria) this;
        }

        public Criteria andRdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rdate between", value1, value2, "rdate");
            return (Criteria) this;
        }

        public Criteria andRdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rdate not between", value1, value2, "rdate");
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