package com.myclouds.manager.pojo;

import java.util.ArrayList;
import java.util.List;

public class RdailyclocksExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RdailyclocksExample() {
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

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPdateIsNull() {
            addCriterion("pdate is null");
            return (Criteria) this;
        }

        public Criteria andPdateIsNotNull() {
            addCriterion("pdate is not null");
            return (Criteria) this;
        }

        public Criteria andPdateEqualTo(String value) {
            addCriterion("pdate =", value, "pdate");
            return (Criteria) this;
        }

        public Criteria andPdateNotEqualTo(String value) {
            addCriterion("pdate <>", value, "pdate");
            return (Criteria) this;
        }

        public Criteria andPdateGreaterThan(String value) {
            addCriterion("pdate >", value, "pdate");
            return (Criteria) this;
        }

        public Criteria andPdateGreaterThanOrEqualTo(String value) {
            addCriterion("pdate >=", value, "pdate");
            return (Criteria) this;
        }

        public Criteria andPdateLessThan(String value) {
            addCriterion("pdate <", value, "pdate");
            return (Criteria) this;
        }

        public Criteria andPdateLessThanOrEqualTo(String value) {
            addCriterion("pdate <=", value, "pdate");
            return (Criteria) this;
        }

        public Criteria andPdateLike(String value) {
            addCriterion("pdate like", value, "pdate");
            return (Criteria) this;
        }

        public Criteria andPdateNotLike(String value) {
            addCriterion("pdate not like", value, "pdate");
            return (Criteria) this;
        }

        public Criteria andPdateIn(List<String> values) {
            addCriterion("pdate in", values, "pdate");
            return (Criteria) this;
        }

        public Criteria andPdateNotIn(List<String> values) {
            addCriterion("pdate not in", values, "pdate");
            return (Criteria) this;
        }

        public Criteria andPdateBetween(String value1, String value2) {
            addCriterion("pdate between", value1, value2, "pdate");
            return (Criteria) this;
        }

        public Criteria andPdateNotBetween(String value1, String value2) {
            addCriterion("pdate not between", value1, value2, "pdate");
            return (Criteria) this;
        }

        public Criteria andPattrIsNull() {
            addCriterion("pattr is null");
            return (Criteria) this;
        }

        public Criteria andPattrIsNotNull() {
            addCriterion("pattr is not null");
            return (Criteria) this;
        }

        public Criteria andPattrEqualTo(String value) {
            addCriterion("pattr =", value, "pattr");
            return (Criteria) this;
        }

        public Criteria andPattrNotEqualTo(String value) {
            addCriterion("pattr <>", value, "pattr");
            return (Criteria) this;
        }

        public Criteria andPattrGreaterThan(String value) {
            addCriterion("pattr >", value, "pattr");
            return (Criteria) this;
        }

        public Criteria andPattrGreaterThanOrEqualTo(String value) {
            addCriterion("pattr >=", value, "pattr");
            return (Criteria) this;
        }

        public Criteria andPattrLessThan(String value) {
            addCriterion("pattr <", value, "pattr");
            return (Criteria) this;
        }

        public Criteria andPattrLessThanOrEqualTo(String value) {
            addCriterion("pattr <=", value, "pattr");
            return (Criteria) this;
        }

        public Criteria andPattrLike(String value) {
            addCriterion("pattr like", value, "pattr");
            return (Criteria) this;
        }

        public Criteria andPattrNotLike(String value) {
            addCriterion("pattr not like", value, "pattr");
            return (Criteria) this;
        }

        public Criteria andPattrIn(List<String> values) {
            addCriterion("pattr in", values, "pattr");
            return (Criteria) this;
        }

        public Criteria andPattrNotIn(List<String> values) {
            addCriterion("pattr not in", values, "pattr");
            return (Criteria) this;
        }

        public Criteria andPattrBetween(String value1, String value2) {
            addCriterion("pattr between", value1, value2, "pattr");
            return (Criteria) this;
        }

        public Criteria andPattrNotBetween(String value1, String value2) {
            addCriterion("pattr not between", value1, value2, "pattr");
            return (Criteria) this;
        }

        public Criteria andPtemperatureIsNull() {
            addCriterion("ptemperature is null");
            return (Criteria) this;
        }

        public Criteria andPtemperatureIsNotNull() {
            addCriterion("ptemperature is not null");
            return (Criteria) this;
        }

        public Criteria andPtemperatureEqualTo(String value) {
            addCriterion("ptemperature =", value, "ptemperature");
            return (Criteria) this;
        }

        public Criteria andPtemperatureNotEqualTo(String value) {
            addCriterion("ptemperature <>", value, "ptemperature");
            return (Criteria) this;
        }

        public Criteria andPtemperatureGreaterThan(String value) {
            addCriterion("ptemperature >", value, "ptemperature");
            return (Criteria) this;
        }

        public Criteria andPtemperatureGreaterThanOrEqualTo(String value) {
            addCriterion("ptemperature >=", value, "ptemperature");
            return (Criteria) this;
        }

        public Criteria andPtemperatureLessThan(String value) {
            addCriterion("ptemperature <", value, "ptemperature");
            return (Criteria) this;
        }

        public Criteria andPtemperatureLessThanOrEqualTo(String value) {
            addCriterion("ptemperature <=", value, "ptemperature");
            return (Criteria) this;
        }

        public Criteria andPtemperatureLike(String value) {
            addCriterion("ptemperature like", value, "ptemperature");
            return (Criteria) this;
        }

        public Criteria andPtemperatureNotLike(String value) {
            addCriterion("ptemperature not like", value, "ptemperature");
            return (Criteria) this;
        }

        public Criteria andPtemperatureIn(List<String> values) {
            addCriterion("ptemperature in", values, "ptemperature");
            return (Criteria) this;
        }

        public Criteria andPtemperatureNotIn(List<String> values) {
            addCriterion("ptemperature not in", values, "ptemperature");
            return (Criteria) this;
        }

        public Criteria andPtemperatureBetween(String value1, String value2) {
            addCriterion("ptemperature between", value1, value2, "ptemperature");
            return (Criteria) this;
        }

        public Criteria andPtemperatureNotBetween(String value1, String value2) {
            addCriterion("ptemperature not between", value1, value2, "ptemperature");
            return (Criteria) this;
        }

        public Criteria andPuidIsNull() {
            addCriterion("puid is null");
            return (Criteria) this;
        }

        public Criteria andPuidIsNotNull() {
            addCriterion("puid is not null");
            return (Criteria) this;
        }

        public Criteria andPuidEqualTo(Integer value) {
            addCriterion("puid =", value, "puid");
            return (Criteria) this;
        }

        public Criteria andPuidNotEqualTo(Integer value) {
            addCriterion("puid <>", value, "puid");
            return (Criteria) this;
        }

        public Criteria andPuidGreaterThan(Integer value) {
            addCriterion("puid >", value, "puid");
            return (Criteria) this;
        }

        public Criteria andPuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("puid >=", value, "puid");
            return (Criteria) this;
        }

        public Criteria andPuidLessThan(Integer value) {
            addCriterion("puid <", value, "puid");
            return (Criteria) this;
        }

        public Criteria andPuidLessThanOrEqualTo(Integer value) {
            addCriterion("puid <=", value, "puid");
            return (Criteria) this;
        }

        public Criteria andPuidIn(List<Integer> values) {
            addCriterion("puid in", values, "puid");
            return (Criteria) this;
        }

        public Criteria andPuidNotIn(List<Integer> values) {
            addCriterion("puid not in", values, "puid");
            return (Criteria) this;
        }

        public Criteria andPuidBetween(Integer value1, Integer value2) {
            addCriterion("puid between", value1, value2, "puid");
            return (Criteria) this;
        }

        public Criteria andPuidNotBetween(Integer value1, Integer value2) {
            addCriterion("puid not between", value1, value2, "puid");
            return (Criteria) this;
        }

        public Criteria andPuzhengjianhaomaIsNull() {
            addCriterion("puzhengjianhaoma is null");
            return (Criteria) this;
        }

        public Criteria andPuzhengjianhaomaIsNotNull() {
            addCriterion("puzhengjianhaoma is not null");
            return (Criteria) this;
        }

        public Criteria andPuzhengjianhaomaEqualTo(String value) {
            addCriterion("puzhengjianhaoma =", value, "puzhengjianhaoma");
            return (Criteria) this;
        }

        public Criteria andPuzhengjianhaomaNotEqualTo(String value) {
            addCriterion("puzhengjianhaoma <>", value, "puzhengjianhaoma");
            return (Criteria) this;
        }

        public Criteria andPuzhengjianhaomaGreaterThan(String value) {
            addCriterion("puzhengjianhaoma >", value, "puzhengjianhaoma");
            return (Criteria) this;
        }

        public Criteria andPuzhengjianhaomaGreaterThanOrEqualTo(String value) {
            addCriterion("puzhengjianhaoma >=", value, "puzhengjianhaoma");
            return (Criteria) this;
        }

        public Criteria andPuzhengjianhaomaLessThan(String value) {
            addCriterion("puzhengjianhaoma <", value, "puzhengjianhaoma");
            return (Criteria) this;
        }

        public Criteria andPuzhengjianhaomaLessThanOrEqualTo(String value) {
            addCriterion("puzhengjianhaoma <=", value, "puzhengjianhaoma");
            return (Criteria) this;
        }

        public Criteria andPuzhengjianhaomaLike(String value) {
            addCriterion("puzhengjianhaoma like", value, "puzhengjianhaoma");
            return (Criteria) this;
        }

        public Criteria andPuzhengjianhaomaNotLike(String value) {
            addCriterion("puzhengjianhaoma not like", value, "puzhengjianhaoma");
            return (Criteria) this;
        }

        public Criteria andPuzhengjianhaomaIn(List<String> values) {
            addCriterion("puzhengjianhaoma in", values, "puzhengjianhaoma");
            return (Criteria) this;
        }

        public Criteria andPuzhengjianhaomaNotIn(List<String> values) {
            addCriterion("puzhengjianhaoma not in", values, "puzhengjianhaoma");
            return (Criteria) this;
        }

        public Criteria andPuzhengjianhaomaBetween(String value1, String value2) {
            addCriterion("puzhengjianhaoma between", value1, value2, "puzhengjianhaoma");
            return (Criteria) this;
        }

        public Criteria andPuzhengjianhaomaNotBetween(String value1, String value2) {
            addCriterion("puzhengjianhaoma not between", value1, value2, "puzhengjianhaoma");
            return (Criteria) this;
        }

        public Criteria andPlaiyuanIsNull() {
            addCriterion("plaiyuan is null");
            return (Criteria) this;
        }

        public Criteria andPlaiyuanIsNotNull() {
            addCriterion("plaiyuan is not null");
            return (Criteria) this;
        }

        public Criteria andPlaiyuanEqualTo(String value) {
            addCriterion("plaiyuan =", value, "plaiyuan");
            return (Criteria) this;
        }

        public Criteria andPlaiyuanNotEqualTo(String value) {
            addCriterion("plaiyuan <>", value, "plaiyuan");
            return (Criteria) this;
        }

        public Criteria andPlaiyuanGreaterThan(String value) {
            addCriterion("plaiyuan >", value, "plaiyuan");
            return (Criteria) this;
        }

        public Criteria andPlaiyuanGreaterThanOrEqualTo(String value) {
            addCriterion("plaiyuan >=", value, "plaiyuan");
            return (Criteria) this;
        }

        public Criteria andPlaiyuanLessThan(String value) {
            addCriterion("plaiyuan <", value, "plaiyuan");
            return (Criteria) this;
        }

        public Criteria andPlaiyuanLessThanOrEqualTo(String value) {
            addCriterion("plaiyuan <=", value, "plaiyuan");
            return (Criteria) this;
        }

        public Criteria andPlaiyuanLike(String value) {
            addCriterion("plaiyuan like", value, "plaiyuan");
            return (Criteria) this;
        }

        public Criteria andPlaiyuanNotLike(String value) {
            addCriterion("plaiyuan not like", value, "plaiyuan");
            return (Criteria) this;
        }

        public Criteria andPlaiyuanIn(List<String> values) {
            addCriterion("plaiyuan in", values, "plaiyuan");
            return (Criteria) this;
        }

        public Criteria andPlaiyuanNotIn(List<String> values) {
            addCriterion("plaiyuan not in", values, "plaiyuan");
            return (Criteria) this;
        }

        public Criteria andPlaiyuanBetween(String value1, String value2) {
            addCriterion("plaiyuan between", value1, value2, "plaiyuan");
            return (Criteria) this;
        }

        public Criteria andPlaiyuanNotBetween(String value1, String value2) {
            addCriterion("plaiyuan not between", value1, value2, "plaiyuan");
            return (Criteria) this;
        }

        public Criteria andPshentizhuangkuangIsNull() {
            addCriterion("pshentizhuangkuang is null");
            return (Criteria) this;
        }

        public Criteria andPshentizhuangkuangIsNotNull() {
            addCriterion("pshentizhuangkuang is not null");
            return (Criteria) this;
        }

        public Criteria andPshentizhuangkuangEqualTo(String value) {
            addCriterion("pshentizhuangkuang =", value, "pshentizhuangkuang");
            return (Criteria) this;
        }

        public Criteria andPshentizhuangkuangNotEqualTo(String value) {
            addCriterion("pshentizhuangkuang <>", value, "pshentizhuangkuang");
            return (Criteria) this;
        }

        public Criteria andPshentizhuangkuangGreaterThan(String value) {
            addCriterion("pshentizhuangkuang >", value, "pshentizhuangkuang");
            return (Criteria) this;
        }

        public Criteria andPshentizhuangkuangGreaterThanOrEqualTo(String value) {
            addCriterion("pshentizhuangkuang >=", value, "pshentizhuangkuang");
            return (Criteria) this;
        }

        public Criteria andPshentizhuangkuangLessThan(String value) {
            addCriterion("pshentizhuangkuang <", value, "pshentizhuangkuang");
            return (Criteria) this;
        }

        public Criteria andPshentizhuangkuangLessThanOrEqualTo(String value) {
            addCriterion("pshentizhuangkuang <=", value, "pshentizhuangkuang");
            return (Criteria) this;
        }

        public Criteria andPshentizhuangkuangLike(String value) {
            addCriterion("pshentizhuangkuang like", value, "pshentizhuangkuang");
            return (Criteria) this;
        }

        public Criteria andPshentizhuangkuangNotLike(String value) {
            addCriterion("pshentizhuangkuang not like", value, "pshentizhuangkuang");
            return (Criteria) this;
        }

        public Criteria andPshentizhuangkuangIn(List<String> values) {
            addCriterion("pshentizhuangkuang in", values, "pshentizhuangkuang");
            return (Criteria) this;
        }

        public Criteria andPshentizhuangkuangNotIn(List<String> values) {
            addCriterion("pshentizhuangkuang not in", values, "pshentizhuangkuang");
            return (Criteria) this;
        }

        public Criteria andPshentizhuangkuangBetween(String value1, String value2) {
            addCriterion("pshentizhuangkuang between", value1, value2, "pshentizhuangkuang");
            return (Criteria) this;
        }

        public Criteria andPshentizhuangkuangNotBetween(String value1, String value2) {
            addCriterion("pshentizhuangkuang not between", value1, value2, "pshentizhuangkuang");
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