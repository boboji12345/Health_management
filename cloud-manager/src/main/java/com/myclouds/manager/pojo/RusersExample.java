package com.myclouds.manager.pojo;

import java.util.ArrayList;
import java.util.List;

public class RusersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RusersExample() {
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

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUimgIsNull() {
            addCriterion("uimg is null");
            return (Criteria) this;
        }

        public Criteria andUimgIsNotNull() {
            addCriterion("uimg is not null");
            return (Criteria) this;
        }

        public Criteria andUimgEqualTo(String value) {
            addCriterion("uimg =", value, "uimg");
            return (Criteria) this;
        }

        public Criteria andUimgNotEqualTo(String value) {
            addCriterion("uimg <>", value, "uimg");
            return (Criteria) this;
        }

        public Criteria andUimgGreaterThan(String value) {
            addCriterion("uimg >", value, "uimg");
            return (Criteria) this;
        }

        public Criteria andUimgGreaterThanOrEqualTo(String value) {
            addCriterion("uimg >=", value, "uimg");
            return (Criteria) this;
        }

        public Criteria andUimgLessThan(String value) {
            addCriterion("uimg <", value, "uimg");
            return (Criteria) this;
        }

        public Criteria andUimgLessThanOrEqualTo(String value) {
            addCriterion("uimg <=", value, "uimg");
            return (Criteria) this;
        }

        public Criteria andUimgLike(String value) {
            addCriterion("uimg like", value, "uimg");
            return (Criteria) this;
        }

        public Criteria andUimgNotLike(String value) {
            addCriterion("uimg not like", value, "uimg");
            return (Criteria) this;
        }

        public Criteria andUimgIn(List<String> values) {
            addCriterion("uimg in", values, "uimg");
            return (Criteria) this;
        }

        public Criteria andUimgNotIn(List<String> values) {
            addCriterion("uimg not in", values, "uimg");
            return (Criteria) this;
        }

        public Criteria andUimgBetween(String value1, String value2) {
            addCriterion("uimg between", value1, value2, "uimg");
            return (Criteria) this;
        }

        public Criteria andUimgNotBetween(String value1, String value2) {
            addCriterion("uimg not between", value1, value2, "uimg");
            return (Criteria) this;
        }

        public Criteria andUnameIsNull() {
            addCriterion("uname is null");
            return (Criteria) this;
        }

        public Criteria andUnameIsNotNull() {
            addCriterion("uname is not null");
            return (Criteria) this;
        }

        public Criteria andUnameEqualTo(String value) {
            addCriterion("uname =", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotEqualTo(String value) {
            addCriterion("uname <>", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThan(String value) {
            addCriterion("uname >", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThanOrEqualTo(String value) {
            addCriterion("uname >=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThan(String value) {
            addCriterion("uname <", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThanOrEqualTo(String value) {
            addCriterion("uname <=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLike(String value) {
            addCriterion("uname like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotLike(String value) {
            addCriterion("uname not like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameIn(List<String> values) {
            addCriterion("uname in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotIn(List<String> values) {
            addCriterion("uname not in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameBetween(String value1, String value2) {
            addCriterion("uname between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotBetween(String value1, String value2) {
            addCriterion("uname not between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andUpwdIsNull() {
            addCriterion("upwd is null");
            return (Criteria) this;
        }

        public Criteria andUpwdIsNotNull() {
            addCriterion("upwd is not null");
            return (Criteria) this;
        }

        public Criteria andUpwdEqualTo(String value) {
            addCriterion("upwd =", value, "upwd");
            return (Criteria) this;
        }

        public Criteria andUpwdNotEqualTo(String value) {
            addCriterion("upwd <>", value, "upwd");
            return (Criteria) this;
        }

        public Criteria andUpwdGreaterThan(String value) {
            addCriterion("upwd >", value, "upwd");
            return (Criteria) this;
        }

        public Criteria andUpwdGreaterThanOrEqualTo(String value) {
            addCriterion("upwd >=", value, "upwd");
            return (Criteria) this;
        }

        public Criteria andUpwdLessThan(String value) {
            addCriterion("upwd <", value, "upwd");
            return (Criteria) this;
        }

        public Criteria andUpwdLessThanOrEqualTo(String value) {
            addCriterion("upwd <=", value, "upwd");
            return (Criteria) this;
        }

        public Criteria andUpwdLike(String value) {
            addCriterion("upwd like", value, "upwd");
            return (Criteria) this;
        }

        public Criteria andUpwdNotLike(String value) {
            addCriterion("upwd not like", value, "upwd");
            return (Criteria) this;
        }

        public Criteria andUpwdIn(List<String> values) {
            addCriterion("upwd in", values, "upwd");
            return (Criteria) this;
        }

        public Criteria andUpwdNotIn(List<String> values) {
            addCriterion("upwd not in", values, "upwd");
            return (Criteria) this;
        }

        public Criteria andUpwdBetween(String value1, String value2) {
            addCriterion("upwd between", value1, value2, "upwd");
            return (Criteria) this;
        }

        public Criteria andUpwdNotBetween(String value1, String value2) {
            addCriterion("upwd not between", value1, value2, "upwd");
            return (Criteria) this;
        }

        public Criteria andUtelIsNull() {
            addCriterion("utel is null");
            return (Criteria) this;
        }

        public Criteria andUtelIsNotNull() {
            addCriterion("utel is not null");
            return (Criteria) this;
        }

        public Criteria andUtelEqualTo(String value) {
            addCriterion("utel =", value, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelNotEqualTo(String value) {
            addCriterion("utel <>", value, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelGreaterThan(String value) {
            addCriterion("utel >", value, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelGreaterThanOrEqualTo(String value) {
            addCriterion("utel >=", value, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelLessThan(String value) {
            addCriterion("utel <", value, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelLessThanOrEqualTo(String value) {
            addCriterion("utel <=", value, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelLike(String value) {
            addCriterion("utel like", value, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelNotLike(String value) {
            addCriterion("utel not like", value, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelIn(List<String> values) {
            addCriterion("utel in", values, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelNotIn(List<String> values) {
            addCriterion("utel not in", values, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelBetween(String value1, String value2) {
            addCriterion("utel between", value1, value2, "utel");
            return (Criteria) this;
        }

        public Criteria andUtelNotBetween(String value1, String value2) {
            addCriterion("utel not between", value1, value2, "utel");
            return (Criteria) this;
        }

        public Criteria andUsexIsNull() {
            addCriterion("usex is null");
            return (Criteria) this;
        }

        public Criteria andUsexIsNotNull() {
            addCriterion("usex is not null");
            return (Criteria) this;
        }

        public Criteria andUsexEqualTo(String value) {
            addCriterion("usex =", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexNotEqualTo(String value) {
            addCriterion("usex <>", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexGreaterThan(String value) {
            addCriterion("usex >", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexGreaterThanOrEqualTo(String value) {
            addCriterion("usex >=", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexLessThan(String value) {
            addCriterion("usex <", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexLessThanOrEqualTo(String value) {
            addCriterion("usex <=", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexLike(String value) {
            addCriterion("usex like", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexNotLike(String value) {
            addCriterion("usex not like", value, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexIn(List<String> values) {
            addCriterion("usex in", values, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexNotIn(List<String> values) {
            addCriterion("usex not in", values, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexBetween(String value1, String value2) {
            addCriterion("usex between", value1, value2, "usex");
            return (Criteria) this;
        }

        public Criteria andUsexNotBetween(String value1, String value2) {
            addCriterion("usex not between", value1, value2, "usex");
            return (Criteria) this;
        }

        public Criteria andUageIsNull() {
            addCriterion("uage is null");
            return (Criteria) this;
        }

        public Criteria andUageIsNotNull() {
            addCriterion("uage is not null");
            return (Criteria) this;
        }

        public Criteria andUageEqualTo(String value) {
            addCriterion("uage =", value, "uage");
            return (Criteria) this;
        }

        public Criteria andUageNotEqualTo(String value) {
            addCriterion("uage <>", value, "uage");
            return (Criteria) this;
        }

        public Criteria andUageGreaterThan(String value) {
            addCriterion("uage >", value, "uage");
            return (Criteria) this;
        }

        public Criteria andUageGreaterThanOrEqualTo(String value) {
            addCriterion("uage >=", value, "uage");
            return (Criteria) this;
        }

        public Criteria andUageLessThan(String value) {
            addCriterion("uage <", value, "uage");
            return (Criteria) this;
        }

        public Criteria andUageLessThanOrEqualTo(String value) {
            addCriterion("uage <=", value, "uage");
            return (Criteria) this;
        }

        public Criteria andUageLike(String value) {
            addCriterion("uage like", value, "uage");
            return (Criteria) this;
        }

        public Criteria andUageNotLike(String value) {
            addCriterion("uage not like", value, "uage");
            return (Criteria) this;
        }

        public Criteria andUageIn(List<String> values) {
            addCriterion("uage in", values, "uage");
            return (Criteria) this;
        }

        public Criteria andUageNotIn(List<String> values) {
            addCriterion("uage not in", values, "uage");
            return (Criteria) this;
        }

        public Criteria andUageBetween(String value1, String value2) {
            addCriterion("uage between", value1, value2, "uage");
            return (Criteria) this;
        }

        public Criteria andUageNotBetween(String value1, String value2) {
            addCriterion("uage not between", value1, value2, "uage");
            return (Criteria) this;
        }

        public Criteria andUroomnumberIsNull() {
            addCriterion("uroomnumber is null");
            return (Criteria) this;
        }

        public Criteria andUroomnumberIsNotNull() {
            addCriterion("uroomnumber is not null");
            return (Criteria) this;
        }

        public Criteria andUroomnumberEqualTo(String value) {
            addCriterion("uroomnumber =", value, "uroomnumber");
            return (Criteria) this;
        }

        public Criteria andUroomnumberNotEqualTo(String value) {
            addCriterion("uroomnumber <>", value, "uroomnumber");
            return (Criteria) this;
        }

        public Criteria andUroomnumberGreaterThan(String value) {
            addCriterion("uroomnumber >", value, "uroomnumber");
            return (Criteria) this;
        }

        public Criteria andUroomnumberGreaterThanOrEqualTo(String value) {
            addCriterion("uroomnumber >=", value, "uroomnumber");
            return (Criteria) this;
        }

        public Criteria andUroomnumberLessThan(String value) {
            addCriterion("uroomnumber <", value, "uroomnumber");
            return (Criteria) this;
        }

        public Criteria andUroomnumberLessThanOrEqualTo(String value) {
            addCriterion("uroomnumber <=", value, "uroomnumber");
            return (Criteria) this;
        }

        public Criteria andUroomnumberLike(String value) {
            addCriterion("uroomnumber like", value, "uroomnumber");
            return (Criteria) this;
        }

        public Criteria andUroomnumberNotLike(String value) {
            addCriterion("uroomnumber not like", value, "uroomnumber");
            return (Criteria) this;
        }

        public Criteria andUroomnumberIn(List<String> values) {
            addCriterion("uroomnumber in", values, "uroomnumber");
            return (Criteria) this;
        }

        public Criteria andUroomnumberNotIn(List<String> values) {
            addCriterion("uroomnumber not in", values, "uroomnumber");
            return (Criteria) this;
        }

        public Criteria andUroomnumberBetween(String value1, String value2) {
            addCriterion("uroomnumber between", value1, value2, "uroomnumber");
            return (Criteria) this;
        }

        public Criteria andUroomnumberNotBetween(String value1, String value2) {
            addCriterion("uroomnumber not between", value1, value2, "uroomnumber");
            return (Criteria) this;
        }

        public Criteria andUstuidsIsNull() {
            addCriterion("ustuids is null");
            return (Criteria) this;
        }

        public Criteria andUstuidsIsNotNull() {
            addCriterion("ustuids is not null");
            return (Criteria) this;
        }

        public Criteria andUstuidsEqualTo(String value) {
            addCriterion("ustuids =", value, "ustuids");
            return (Criteria) this;
        }

        public Criteria andUstuidsNotEqualTo(String value) {
            addCriterion("ustuids <>", value, "ustuids");
            return (Criteria) this;
        }

        public Criteria andUstuidsGreaterThan(String value) {
            addCriterion("ustuids >", value, "ustuids");
            return (Criteria) this;
        }

        public Criteria andUstuidsGreaterThanOrEqualTo(String value) {
            addCriterion("ustuids >=", value, "ustuids");
            return (Criteria) this;
        }

        public Criteria andUstuidsLessThan(String value) {
            addCriterion("ustuids <", value, "ustuids");
            return (Criteria) this;
        }

        public Criteria andUstuidsLessThanOrEqualTo(String value) {
            addCriterion("ustuids <=", value, "ustuids");
            return (Criteria) this;
        }

        public Criteria andUstuidsLike(String value) {
            addCriterion("ustuids like", value, "ustuids");
            return (Criteria) this;
        }

        public Criteria andUstuidsNotLike(String value) {
            addCriterion("ustuids not like", value, "ustuids");
            return (Criteria) this;
        }

        public Criteria andUstuidsIn(List<String> values) {
            addCriterion("ustuids in", values, "ustuids");
            return (Criteria) this;
        }

        public Criteria andUstuidsNotIn(List<String> values) {
            addCriterion("ustuids not in", values, "ustuids");
            return (Criteria) this;
        }

        public Criteria andUstuidsBetween(String value1, String value2) {
            addCriterion("ustuids between", value1, value2, "ustuids");
            return (Criteria) this;
        }

        public Criteria andUstuidsNotBetween(String value1, String value2) {
            addCriterion("ustuids not between", value1, value2, "ustuids");
            return (Criteria) this;
        }

        public Criteria andUshenIsNull() {
            addCriterion("ushen is null");
            return (Criteria) this;
        }

        public Criteria andUshenIsNotNull() {
            addCriterion("ushen is not null");
            return (Criteria) this;
        }

        public Criteria andUshenEqualTo(String value) {
            addCriterion("ushen =", value, "ushen");
            return (Criteria) this;
        }

        public Criteria andUshenNotEqualTo(String value) {
            addCriterion("ushen <>", value, "ushen");
            return (Criteria) this;
        }

        public Criteria andUshenGreaterThan(String value) {
            addCriterion("ushen >", value, "ushen");
            return (Criteria) this;
        }

        public Criteria andUshenGreaterThanOrEqualTo(String value) {
            addCriterion("ushen >=", value, "ushen");
            return (Criteria) this;
        }

        public Criteria andUshenLessThan(String value) {
            addCriterion("ushen <", value, "ushen");
            return (Criteria) this;
        }

        public Criteria andUshenLessThanOrEqualTo(String value) {
            addCriterion("ushen <=", value, "ushen");
            return (Criteria) this;
        }

        public Criteria andUshenLike(String value) {
            addCriterion("ushen like", value, "ushen");
            return (Criteria) this;
        }

        public Criteria andUshenNotLike(String value) {
            addCriterion("ushen not like", value, "ushen");
            return (Criteria) this;
        }

        public Criteria andUshenIn(List<String> values) {
            addCriterion("ushen in", values, "ushen");
            return (Criteria) this;
        }

        public Criteria andUshenNotIn(List<String> values) {
            addCriterion("ushen not in", values, "ushen");
            return (Criteria) this;
        }

        public Criteria andUshenBetween(String value1, String value2) {
            addCriterion("ushen between", value1, value2, "ushen");
            return (Criteria) this;
        }

        public Criteria andUshenNotBetween(String value1, String value2) {
            addCriterion("ushen not between", value1, value2, "ushen");
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