package com.myclouds.manager.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RknowledgesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RknowledgesExample() {
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

        public Criteria andRkidIsNull() {
            addCriterion("rkid is null");
            return (Criteria) this;
        }

        public Criteria andRkidIsNotNull() {
            addCriterion("rkid is not null");
            return (Criteria) this;
        }

        public Criteria andRkidEqualTo(Integer value) {
            addCriterion("rkid =", value, "rkid");
            return (Criteria) this;
        }

        public Criteria andRkidNotEqualTo(Integer value) {
            addCriterion("rkid <>", value, "rkid");
            return (Criteria) this;
        }

        public Criteria andRkidGreaterThan(Integer value) {
            addCriterion("rkid >", value, "rkid");
            return (Criteria) this;
        }

        public Criteria andRkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rkid >=", value, "rkid");
            return (Criteria) this;
        }

        public Criteria andRkidLessThan(Integer value) {
            addCriterion("rkid <", value, "rkid");
            return (Criteria) this;
        }

        public Criteria andRkidLessThanOrEqualTo(Integer value) {
            addCriterion("rkid <=", value, "rkid");
            return (Criteria) this;
        }

        public Criteria andRkidIn(List<Integer> values) {
            addCriterion("rkid in", values, "rkid");
            return (Criteria) this;
        }

        public Criteria andRkidNotIn(List<Integer> values) {
            addCriterion("rkid not in", values, "rkid");
            return (Criteria) this;
        }

        public Criteria andRkidBetween(Integer value1, Integer value2) {
            addCriterion("rkid between", value1, value2, "rkid");
            return (Criteria) this;
        }

        public Criteria andRkidNotBetween(Integer value1, Integer value2) {
            addCriterion("rkid not between", value1, value2, "rkid");
            return (Criteria) this;
        }

        public Criteria andRktitleIsNull() {
            addCriterion("rktitle is null");
            return (Criteria) this;
        }

        public Criteria andRktitleIsNotNull() {
            addCriterion("rktitle is not null");
            return (Criteria) this;
        }

        public Criteria andRktitleEqualTo(String value) {
            addCriterion("rktitle =", value, "rktitle");
            return (Criteria) this;
        }

        public Criteria andRktitleNotEqualTo(String value) {
            addCriterion("rktitle <>", value, "rktitle");
            return (Criteria) this;
        }

        public Criteria andRktitleGreaterThan(String value) {
            addCriterion("rktitle >", value, "rktitle");
            return (Criteria) this;
        }

        public Criteria andRktitleGreaterThanOrEqualTo(String value) {
            addCriterion("rktitle >=", value, "rktitle");
            return (Criteria) this;
        }

        public Criteria andRktitleLessThan(String value) {
            addCriterion("rktitle <", value, "rktitle");
            return (Criteria) this;
        }

        public Criteria andRktitleLessThanOrEqualTo(String value) {
            addCriterion("rktitle <=", value, "rktitle");
            return (Criteria) this;
        }

        public Criteria andRktitleLike(String value) {
            addCriterion("rktitle like", value, "rktitle");
            return (Criteria) this;
        }

        public Criteria andRktitleNotLike(String value) {
            addCriterion("rktitle not like", value, "rktitle");
            return (Criteria) this;
        }

        public Criteria andRktitleIn(List<String> values) {
            addCriterion("rktitle in", values, "rktitle");
            return (Criteria) this;
        }

        public Criteria andRktitleNotIn(List<String> values) {
            addCriterion("rktitle not in", values, "rktitle");
            return (Criteria) this;
        }

        public Criteria andRktitleBetween(String value1, String value2) {
            addCriterion("rktitle between", value1, value2, "rktitle");
            return (Criteria) this;
        }

        public Criteria andRktitleNotBetween(String value1, String value2) {
            addCriterion("rktitle not between", value1, value2, "rktitle");
            return (Criteria) this;
        }

        public Criteria andRkinstroducesIsNull() {
            addCriterion("rkinstroduces is null");
            return (Criteria) this;
        }

        public Criteria andRkinstroducesIsNotNull() {
            addCriterion("rkinstroduces is not null");
            return (Criteria) this;
        }

        public Criteria andRkinstroducesEqualTo(String value) {
            addCriterion("rkinstroduces =", value, "rkinstroduces");
            return (Criteria) this;
        }

        public Criteria andRkinstroducesNotEqualTo(String value) {
            addCriterion("rkinstroduces <>", value, "rkinstroduces");
            return (Criteria) this;
        }

        public Criteria andRkinstroducesGreaterThan(String value) {
            addCriterion("rkinstroduces >", value, "rkinstroduces");
            return (Criteria) this;
        }

        public Criteria andRkinstroducesGreaterThanOrEqualTo(String value) {
            addCriterion("rkinstroduces >=", value, "rkinstroduces");
            return (Criteria) this;
        }

        public Criteria andRkinstroducesLessThan(String value) {
            addCriterion("rkinstroduces <", value, "rkinstroduces");
            return (Criteria) this;
        }

        public Criteria andRkinstroducesLessThanOrEqualTo(String value) {
            addCriterion("rkinstroduces <=", value, "rkinstroduces");
            return (Criteria) this;
        }

        public Criteria andRkinstroducesLike(String value) {
            addCriterion("rkinstroduces like", value, "rkinstroduces");
            return (Criteria) this;
        }

        public Criteria andRkinstroducesNotLike(String value) {
            addCriterion("rkinstroduces not like", value, "rkinstroduces");
            return (Criteria) this;
        }

        public Criteria andRkinstroducesIn(List<String> values) {
            addCriterion("rkinstroduces in", values, "rkinstroduces");
            return (Criteria) this;
        }

        public Criteria andRkinstroducesNotIn(List<String> values) {
            addCriterion("rkinstroduces not in", values, "rkinstroduces");
            return (Criteria) this;
        }

        public Criteria andRkinstroducesBetween(String value1, String value2) {
            addCriterion("rkinstroduces between", value1, value2, "rkinstroduces");
            return (Criteria) this;
        }

        public Criteria andRkinstroducesNotBetween(String value1, String value2) {
            addCriterion("rkinstroduces not between", value1, value2, "rkinstroduces");
            return (Criteria) this;
        }

        public Criteria andRkimgIsNull() {
            addCriterion("rkimg is null");
            return (Criteria) this;
        }

        public Criteria andRkimgIsNotNull() {
            addCriterion("rkimg is not null");
            return (Criteria) this;
        }

        public Criteria andRkimgEqualTo(String value) {
            addCriterion("rkimg =", value, "rkimg");
            return (Criteria) this;
        }

        public Criteria andRkimgNotEqualTo(String value) {
            addCriterion("rkimg <>", value, "rkimg");
            return (Criteria) this;
        }

        public Criteria andRkimgGreaterThan(String value) {
            addCriterion("rkimg >", value, "rkimg");
            return (Criteria) this;
        }

        public Criteria andRkimgGreaterThanOrEqualTo(String value) {
            addCriterion("rkimg >=", value, "rkimg");
            return (Criteria) this;
        }

        public Criteria andRkimgLessThan(String value) {
            addCriterion("rkimg <", value, "rkimg");
            return (Criteria) this;
        }

        public Criteria andRkimgLessThanOrEqualTo(String value) {
            addCriterion("rkimg <=", value, "rkimg");
            return (Criteria) this;
        }

        public Criteria andRkimgLike(String value) {
            addCriterion("rkimg like", value, "rkimg");
            return (Criteria) this;
        }

        public Criteria andRkimgNotLike(String value) {
            addCriterion("rkimg not like", value, "rkimg");
            return (Criteria) this;
        }

        public Criteria andRkimgIn(List<String> values) {
            addCriterion("rkimg in", values, "rkimg");
            return (Criteria) this;
        }

        public Criteria andRkimgNotIn(List<String> values) {
            addCriterion("rkimg not in", values, "rkimg");
            return (Criteria) this;
        }

        public Criteria andRkimgBetween(String value1, String value2) {
            addCriterion("rkimg between", value1, value2, "rkimg");
            return (Criteria) this;
        }

        public Criteria andRkimgNotBetween(String value1, String value2) {
            addCriterion("rkimg not between", value1, value2, "rkimg");
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