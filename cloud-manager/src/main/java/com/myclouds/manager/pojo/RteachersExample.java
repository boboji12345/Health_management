package com.myclouds.manager.pojo;

import java.util.ArrayList;
import java.util.List;

public class RteachersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RteachersExample() {
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

        public Criteria andTuidIsNull() {
            addCriterion("tuid is null");
            return (Criteria) this;
        }

        public Criteria andTuidIsNotNull() {
            addCriterion("tuid is not null");
            return (Criteria) this;
        }

        public Criteria andTuidEqualTo(Integer value) {
            addCriterion("tuid =", value, "tuid");
            return (Criteria) this;
        }

        public Criteria andTuidNotEqualTo(Integer value) {
            addCriterion("tuid <>", value, "tuid");
            return (Criteria) this;
        }

        public Criteria andTuidGreaterThan(Integer value) {
            addCriterion("tuid >", value, "tuid");
            return (Criteria) this;
        }

        public Criteria andTuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tuid >=", value, "tuid");
            return (Criteria) this;
        }

        public Criteria andTuidLessThan(Integer value) {
            addCriterion("tuid <", value, "tuid");
            return (Criteria) this;
        }

        public Criteria andTuidLessThanOrEqualTo(Integer value) {
            addCriterion("tuid <=", value, "tuid");
            return (Criteria) this;
        }

        public Criteria andTuidIn(List<Integer> values) {
            addCriterion("tuid in", values, "tuid");
            return (Criteria) this;
        }

        public Criteria andTuidNotIn(List<Integer> values) {
            addCriterion("tuid not in", values, "tuid");
            return (Criteria) this;
        }

        public Criteria andTuidBetween(Integer value1, Integer value2) {
            addCriterion("tuid between", value1, value2, "tuid");
            return (Criteria) this;
        }

        public Criteria andTuidNotBetween(Integer value1, Integer value2) {
            addCriterion("tuid not between", value1, value2, "tuid");
            return (Criteria) this;
        }

        public Criteria andTuimgIsNull() {
            addCriterion("tuimg is null");
            return (Criteria) this;
        }

        public Criteria andTuimgIsNotNull() {
            addCriterion("tuimg is not null");
            return (Criteria) this;
        }

        public Criteria andTuimgEqualTo(String value) {
            addCriterion("tuimg =", value, "tuimg");
            return (Criteria) this;
        }

        public Criteria andTuimgNotEqualTo(String value) {
            addCriterion("tuimg <>", value, "tuimg");
            return (Criteria) this;
        }

        public Criteria andTuimgGreaterThan(String value) {
            addCriterion("tuimg >", value, "tuimg");
            return (Criteria) this;
        }

        public Criteria andTuimgGreaterThanOrEqualTo(String value) {
            addCriterion("tuimg >=", value, "tuimg");
            return (Criteria) this;
        }

        public Criteria andTuimgLessThan(String value) {
            addCriterion("tuimg <", value, "tuimg");
            return (Criteria) this;
        }

        public Criteria andTuimgLessThanOrEqualTo(String value) {
            addCriterion("tuimg <=", value, "tuimg");
            return (Criteria) this;
        }

        public Criteria andTuimgLike(String value) {
            addCriterion("tuimg like", value, "tuimg");
            return (Criteria) this;
        }

        public Criteria andTuimgNotLike(String value) {
            addCriterion("tuimg not like", value, "tuimg");
            return (Criteria) this;
        }

        public Criteria andTuimgIn(List<String> values) {
            addCriterion("tuimg in", values, "tuimg");
            return (Criteria) this;
        }

        public Criteria andTuimgNotIn(List<String> values) {
            addCriterion("tuimg not in", values, "tuimg");
            return (Criteria) this;
        }

        public Criteria andTuimgBetween(String value1, String value2) {
            addCriterion("tuimg between", value1, value2, "tuimg");
            return (Criteria) this;
        }

        public Criteria andTuimgNotBetween(String value1, String value2) {
            addCriterion("tuimg not between", value1, value2, "tuimg");
            return (Criteria) this;
        }

        public Criteria andTunameIsNull() {
            addCriterion("tuname is null");
            return (Criteria) this;
        }

        public Criteria andTunameIsNotNull() {
            addCriterion("tuname is not null");
            return (Criteria) this;
        }

        public Criteria andTunameEqualTo(String value) {
            addCriterion("tuname =", value, "tuname");
            return (Criteria) this;
        }

        public Criteria andTunameNotEqualTo(String value) {
            addCriterion("tuname <>", value, "tuname");
            return (Criteria) this;
        }

        public Criteria andTunameGreaterThan(String value) {
            addCriterion("tuname >", value, "tuname");
            return (Criteria) this;
        }

        public Criteria andTunameGreaterThanOrEqualTo(String value) {
            addCriterion("tuname >=", value, "tuname");
            return (Criteria) this;
        }

        public Criteria andTunameLessThan(String value) {
            addCriterion("tuname <", value, "tuname");
            return (Criteria) this;
        }

        public Criteria andTunameLessThanOrEqualTo(String value) {
            addCriterion("tuname <=", value, "tuname");
            return (Criteria) this;
        }

        public Criteria andTunameLike(String value) {
            addCriterion("tuname like", value, "tuname");
            return (Criteria) this;
        }

        public Criteria andTunameNotLike(String value) {
            addCriterion("tuname not like", value, "tuname");
            return (Criteria) this;
        }

        public Criteria andTunameIn(List<String> values) {
            addCriterion("tuname in", values, "tuname");
            return (Criteria) this;
        }

        public Criteria andTunameNotIn(List<String> values) {
            addCriterion("tuname not in", values, "tuname");
            return (Criteria) this;
        }

        public Criteria andTunameBetween(String value1, String value2) {
            addCriterion("tuname between", value1, value2, "tuname");
            return (Criteria) this;
        }

        public Criteria andTunameNotBetween(String value1, String value2) {
            addCriterion("tuname not between", value1, value2, "tuname");
            return (Criteria) this;
        }

        public Criteria andTupwdIsNull() {
            addCriterion("tupwd is null");
            return (Criteria) this;
        }

        public Criteria andTupwdIsNotNull() {
            addCriterion("tupwd is not null");
            return (Criteria) this;
        }

        public Criteria andTupwdEqualTo(String value) {
            addCriterion("tupwd =", value, "tupwd");
            return (Criteria) this;
        }

        public Criteria andTupwdNotEqualTo(String value) {
            addCriterion("tupwd <>", value, "tupwd");
            return (Criteria) this;
        }

        public Criteria andTupwdGreaterThan(String value) {
            addCriterion("tupwd >", value, "tupwd");
            return (Criteria) this;
        }

        public Criteria andTupwdGreaterThanOrEqualTo(String value) {
            addCriterion("tupwd >=", value, "tupwd");
            return (Criteria) this;
        }

        public Criteria andTupwdLessThan(String value) {
            addCriterion("tupwd <", value, "tupwd");
            return (Criteria) this;
        }

        public Criteria andTupwdLessThanOrEqualTo(String value) {
            addCriterion("tupwd <=", value, "tupwd");
            return (Criteria) this;
        }

        public Criteria andTupwdLike(String value) {
            addCriterion("tupwd like", value, "tupwd");
            return (Criteria) this;
        }

        public Criteria andTupwdNotLike(String value) {
            addCriterion("tupwd not like", value, "tupwd");
            return (Criteria) this;
        }

        public Criteria andTupwdIn(List<String> values) {
            addCriterion("tupwd in", values, "tupwd");
            return (Criteria) this;
        }

        public Criteria andTupwdNotIn(List<String> values) {
            addCriterion("tupwd not in", values, "tupwd");
            return (Criteria) this;
        }

        public Criteria andTupwdBetween(String value1, String value2) {
            addCriterion("tupwd between", value1, value2, "tupwd");
            return (Criteria) this;
        }

        public Criteria andTupwdNotBetween(String value1, String value2) {
            addCriterion("tupwd not between", value1, value2, "tupwd");
            return (Criteria) this;
        }

        public Criteria andTutelIsNull() {
            addCriterion("tutel is null");
            return (Criteria) this;
        }

        public Criteria andTutelIsNotNull() {
            addCriterion("tutel is not null");
            return (Criteria) this;
        }

        public Criteria andTutelEqualTo(String value) {
            addCriterion("tutel =", value, "tutel");
            return (Criteria) this;
        }

        public Criteria andTutelNotEqualTo(String value) {
            addCriterion("tutel <>", value, "tutel");
            return (Criteria) this;
        }

        public Criteria andTutelGreaterThan(String value) {
            addCriterion("tutel >", value, "tutel");
            return (Criteria) this;
        }

        public Criteria andTutelGreaterThanOrEqualTo(String value) {
            addCriterion("tutel >=", value, "tutel");
            return (Criteria) this;
        }

        public Criteria andTutelLessThan(String value) {
            addCriterion("tutel <", value, "tutel");
            return (Criteria) this;
        }

        public Criteria andTutelLessThanOrEqualTo(String value) {
            addCriterion("tutel <=", value, "tutel");
            return (Criteria) this;
        }

        public Criteria andTutelLike(String value) {
            addCriterion("tutel like", value, "tutel");
            return (Criteria) this;
        }

        public Criteria andTutelNotLike(String value) {
            addCriterion("tutel not like", value, "tutel");
            return (Criteria) this;
        }

        public Criteria andTutelIn(List<String> values) {
            addCriterion("tutel in", values, "tutel");
            return (Criteria) this;
        }

        public Criteria andTutelNotIn(List<String> values) {
            addCriterion("tutel not in", values, "tutel");
            return (Criteria) this;
        }

        public Criteria andTutelBetween(String value1, String value2) {
            addCriterion("tutel between", value1, value2, "tutel");
            return (Criteria) this;
        }

        public Criteria andTutelNotBetween(String value1, String value2) {
            addCriterion("tutel not between", value1, value2, "tutel");
            return (Criteria) this;
        }

        public Criteria andTusexIsNull() {
            addCriterion("tusex is null");
            return (Criteria) this;
        }

        public Criteria andTusexIsNotNull() {
            addCriterion("tusex is not null");
            return (Criteria) this;
        }

        public Criteria andTusexEqualTo(String value) {
            addCriterion("tusex =", value, "tusex");
            return (Criteria) this;
        }

        public Criteria andTusexNotEqualTo(String value) {
            addCriterion("tusex <>", value, "tusex");
            return (Criteria) this;
        }

        public Criteria andTusexGreaterThan(String value) {
            addCriterion("tusex >", value, "tusex");
            return (Criteria) this;
        }

        public Criteria andTusexGreaterThanOrEqualTo(String value) {
            addCriterion("tusex >=", value, "tusex");
            return (Criteria) this;
        }

        public Criteria andTusexLessThan(String value) {
            addCriterion("tusex <", value, "tusex");
            return (Criteria) this;
        }

        public Criteria andTusexLessThanOrEqualTo(String value) {
            addCriterion("tusex <=", value, "tusex");
            return (Criteria) this;
        }

        public Criteria andTusexLike(String value) {
            addCriterion("tusex like", value, "tusex");
            return (Criteria) this;
        }

        public Criteria andTusexNotLike(String value) {
            addCriterion("tusex not like", value, "tusex");
            return (Criteria) this;
        }

        public Criteria andTusexIn(List<String> values) {
            addCriterion("tusex in", values, "tusex");
            return (Criteria) this;
        }

        public Criteria andTusexNotIn(List<String> values) {
            addCriterion("tusex not in", values, "tusex");
            return (Criteria) this;
        }

        public Criteria andTusexBetween(String value1, String value2) {
            addCriterion("tusex between", value1, value2, "tusex");
            return (Criteria) this;
        }

        public Criteria andTusexNotBetween(String value1, String value2) {
            addCriterion("tusex not between", value1, value2, "tusex");
            return (Criteria) this;
        }

        public Criteria andTuageIsNull() {
            addCriterion("tuage is null");
            return (Criteria) this;
        }

        public Criteria andTuageIsNotNull() {
            addCriterion("tuage is not null");
            return (Criteria) this;
        }

        public Criteria andTuageEqualTo(String value) {
            addCriterion("tuage =", value, "tuage");
            return (Criteria) this;
        }

        public Criteria andTuageNotEqualTo(String value) {
            addCriterion("tuage <>", value, "tuage");
            return (Criteria) this;
        }

        public Criteria andTuageGreaterThan(String value) {
            addCriterion("tuage >", value, "tuage");
            return (Criteria) this;
        }

        public Criteria andTuageGreaterThanOrEqualTo(String value) {
            addCriterion("tuage >=", value, "tuage");
            return (Criteria) this;
        }

        public Criteria andTuageLessThan(String value) {
            addCriterion("tuage <", value, "tuage");
            return (Criteria) this;
        }

        public Criteria andTuageLessThanOrEqualTo(String value) {
            addCriterion("tuage <=", value, "tuage");
            return (Criteria) this;
        }

        public Criteria andTuageLike(String value) {
            addCriterion("tuage like", value, "tuage");
            return (Criteria) this;
        }

        public Criteria andTuageNotLike(String value) {
            addCriterion("tuage not like", value, "tuage");
            return (Criteria) this;
        }

        public Criteria andTuageIn(List<String> values) {
            addCriterion("tuage in", values, "tuage");
            return (Criteria) this;
        }

        public Criteria andTuageNotIn(List<String> values) {
            addCriterion("tuage not in", values, "tuage");
            return (Criteria) this;
        }

        public Criteria andTuageBetween(String value1, String value2) {
            addCriterion("tuage between", value1, value2, "tuage");
            return (Criteria) this;
        }

        public Criteria andTuageNotBetween(String value1, String value2) {
            addCriterion("tuage not between", value1, value2, "tuage");
            return (Criteria) this;
        }

        public Criteria andTushenIsNull() {
            addCriterion("tushen is null");
            return (Criteria) this;
        }

        public Criteria andTushenIsNotNull() {
            addCriterion("tushen is not null");
            return (Criteria) this;
        }

        public Criteria andTushenEqualTo(String value) {
            addCriterion("tushen =", value, "tushen");
            return (Criteria) this;
        }

        public Criteria andTushenNotEqualTo(String value) {
            addCriterion("tushen <>", value, "tushen");
            return (Criteria) this;
        }

        public Criteria andTushenGreaterThan(String value) {
            addCriterion("tushen >", value, "tushen");
            return (Criteria) this;
        }

        public Criteria andTushenGreaterThanOrEqualTo(String value) {
            addCriterion("tushen >=", value, "tushen");
            return (Criteria) this;
        }

        public Criteria andTushenLessThan(String value) {
            addCriterion("tushen <", value, "tushen");
            return (Criteria) this;
        }

        public Criteria andTushenLessThanOrEqualTo(String value) {
            addCriterion("tushen <=", value, "tushen");
            return (Criteria) this;
        }

        public Criteria andTushenLike(String value) {
            addCriterion("tushen like", value, "tushen");
            return (Criteria) this;
        }

        public Criteria andTushenNotLike(String value) {
            addCriterion("tushen not like", value, "tushen");
            return (Criteria) this;
        }

        public Criteria andTushenIn(List<String> values) {
            addCriterion("tushen in", values, "tushen");
            return (Criteria) this;
        }

        public Criteria andTushenNotIn(List<String> values) {
            addCriterion("tushen not in", values, "tushen");
            return (Criteria) this;
        }

        public Criteria andTushenBetween(String value1, String value2) {
            addCriterion("tushen between", value1, value2, "tushen");
            return (Criteria) this;
        }

        public Criteria andTushenNotBetween(String value1, String value2) {
            addCriterion("tushen not between", value1, value2, "tushen");
            return (Criteria) this;
        }

        public Criteria andTubidIsNull() {
            addCriterion("tubid is null");
            return (Criteria) this;
        }

        public Criteria andTubidIsNotNull() {
            addCriterion("tubid is not null");
            return (Criteria) this;
        }

        public Criteria andTubidEqualTo(Integer value) {
            addCriterion("tubid =", value, "tubid");
            return (Criteria) this;
        }

        public Criteria andTubidNotEqualTo(Integer value) {
            addCriterion("tubid <>", value, "tubid");
            return (Criteria) this;
        }

        public Criteria andTubidGreaterThan(Integer value) {
            addCriterion("tubid >", value, "tubid");
            return (Criteria) this;
        }

        public Criteria andTubidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tubid >=", value, "tubid");
            return (Criteria) this;
        }

        public Criteria andTubidLessThan(Integer value) {
            addCriterion("tubid <", value, "tubid");
            return (Criteria) this;
        }

        public Criteria andTubidLessThanOrEqualTo(Integer value) {
            addCriterion("tubid <=", value, "tubid");
            return (Criteria) this;
        }

        public Criteria andTubidIn(List<Integer> values) {
            addCriterion("tubid in", values, "tubid");
            return (Criteria) this;
        }

        public Criteria andTubidNotIn(List<Integer> values) {
            addCriterion("tubid not in", values, "tubid");
            return (Criteria) this;
        }

        public Criteria andTubidBetween(Integer value1, Integer value2) {
            addCriterion("tubid between", value1, value2, "tubid");
            return (Criteria) this;
        }

        public Criteria andTubidNotBetween(Integer value1, Integer value2) {
            addCriterion("tubid not between", value1, value2, "tubid");
            return (Criteria) this;
        }

        public Criteria andTuidsIsNull() {
            addCriterion("tuids is null");
            return (Criteria) this;
        }

        public Criteria andTuidsIsNotNull() {
            addCriterion("tuids is not null");
            return (Criteria) this;
        }

        public Criteria andTuidsEqualTo(String value) {
            addCriterion("tuids =", value, "tuids");
            return (Criteria) this;
        }

        public Criteria andTuidsNotEqualTo(String value) {
            addCriterion("tuids <>", value, "tuids");
            return (Criteria) this;
        }

        public Criteria andTuidsGreaterThan(String value) {
            addCriterion("tuids >", value, "tuids");
            return (Criteria) this;
        }

        public Criteria andTuidsGreaterThanOrEqualTo(String value) {
            addCriterion("tuids >=", value, "tuids");
            return (Criteria) this;
        }

        public Criteria andTuidsLessThan(String value) {
            addCriterion("tuids <", value, "tuids");
            return (Criteria) this;
        }

        public Criteria andTuidsLessThanOrEqualTo(String value) {
            addCriterion("tuids <=", value, "tuids");
            return (Criteria) this;
        }

        public Criteria andTuidsLike(String value) {
            addCriterion("tuids like", value, "tuids");
            return (Criteria) this;
        }

        public Criteria andTuidsNotLike(String value) {
            addCriterion("tuids not like", value, "tuids");
            return (Criteria) this;
        }

        public Criteria andTuidsIn(List<String> values) {
            addCriterion("tuids in", values, "tuids");
            return (Criteria) this;
        }

        public Criteria andTuidsNotIn(List<String> values) {
            addCriterion("tuids not in", values, "tuids");
            return (Criteria) this;
        }

        public Criteria andTuidsBetween(String value1, String value2) {
            addCriterion("tuids between", value1, value2, "tuids");
            return (Criteria) this;
        }

        public Criteria andTuidsNotBetween(String value1, String value2) {
            addCriterion("tuids not between", value1, value2, "tuids");
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