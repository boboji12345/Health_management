package com.myclouds.manager.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RholidaysExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RholidaysExample() {
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

        public Criteria andHidIsNull() {
            addCriterion("hid is null");
            return (Criteria) this;
        }

        public Criteria andHidIsNotNull() {
            addCriterion("hid is not null");
            return (Criteria) this;
        }

        public Criteria andHidEqualTo(Integer value) {
            addCriterion("hid =", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidNotEqualTo(Integer value) {
            addCriterion("hid <>", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidGreaterThan(Integer value) {
            addCriterion("hid >", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hid >=", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidLessThan(Integer value) {
            addCriterion("hid <", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidLessThanOrEqualTo(Integer value) {
            addCriterion("hid <=", value, "hid");
            return (Criteria) this;
        }

        public Criteria andHidIn(List<Integer> values) {
            addCriterion("hid in", values, "hid");
            return (Criteria) this;
        }

        public Criteria andHidNotIn(List<Integer> values) {
            addCriterion("hid not in", values, "hid");
            return (Criteria) this;
        }

        public Criteria andHidBetween(Integer value1, Integer value2) {
            addCriterion("hid between", value1, value2, "hid");
            return (Criteria) this;
        }

        public Criteria andHidNotBetween(Integer value1, Integer value2) {
            addCriterion("hid not between", value1, value2, "hid");
            return (Criteria) this;
        }

        public Criteria andHuidIsNull() {
            addCriterion("huid is null");
            return (Criteria) this;
        }

        public Criteria andHuidIsNotNull() {
            addCriterion("huid is not null");
            return (Criteria) this;
        }

        public Criteria andHuidEqualTo(Integer value) {
            addCriterion("huid =", value, "huid");
            return (Criteria) this;
        }

        public Criteria andHuidNotEqualTo(Integer value) {
            addCriterion("huid <>", value, "huid");
            return (Criteria) this;
        }

        public Criteria andHuidGreaterThan(Integer value) {
            addCriterion("huid >", value, "huid");
            return (Criteria) this;
        }

        public Criteria andHuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("huid >=", value, "huid");
            return (Criteria) this;
        }

        public Criteria andHuidLessThan(Integer value) {
            addCriterion("huid <", value, "huid");
            return (Criteria) this;
        }

        public Criteria andHuidLessThanOrEqualTo(Integer value) {
            addCriterion("huid <=", value, "huid");
            return (Criteria) this;
        }

        public Criteria andHuidIn(List<Integer> values) {
            addCriterion("huid in", values, "huid");
            return (Criteria) this;
        }

        public Criteria andHuidNotIn(List<Integer> values) {
            addCriterion("huid not in", values, "huid");
            return (Criteria) this;
        }

        public Criteria andHuidBetween(Integer value1, Integer value2) {
            addCriterion("huid between", value1, value2, "huid");
            return (Criteria) this;
        }

        public Criteria andHuidNotBetween(Integer value1, Integer value2) {
            addCriterion("huid not between", value1, value2, "huid");
            return (Criteria) this;
        }

        public Criteria andHdateIsNull() {
            addCriterion("hdate is null");
            return (Criteria) this;
        }

        public Criteria andHdateIsNotNull() {
            addCriterion("hdate is not null");
            return (Criteria) this;
        }

        public Criteria andHdateEqualTo(Date value) {
            addCriterionForJDBCDate("hdate =", value, "hdate");
            return (Criteria) this;
        }

        public Criteria andHdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("hdate <>", value, "hdate");
            return (Criteria) this;
        }

        public Criteria andHdateGreaterThan(Date value) {
            addCriterionForJDBCDate("hdate >", value, "hdate");
            return (Criteria) this;
        }

        public Criteria andHdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("hdate >=", value, "hdate");
            return (Criteria) this;
        }

        public Criteria andHdateLessThan(Date value) {
            addCriterionForJDBCDate("hdate <", value, "hdate");
            return (Criteria) this;
        }

        public Criteria andHdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("hdate <=", value, "hdate");
            return (Criteria) this;
        }

        public Criteria andHdateIn(List<Date> values) {
            addCriterionForJDBCDate("hdate in", values, "hdate");
            return (Criteria) this;
        }

        public Criteria andHdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("hdate not in", values, "hdate");
            return (Criteria) this;
        }

        public Criteria andHdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("hdate between", value1, value2, "hdate");
            return (Criteria) this;
        }

        public Criteria andHdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("hdate not between", value1, value2, "hdate");
            return (Criteria) this;
        }

        public Criteria andHcontIsNull() {
            addCriterion("hcont is null");
            return (Criteria) this;
        }

        public Criteria andHcontIsNotNull() {
            addCriterion("hcont is not null");
            return (Criteria) this;
        }

        public Criteria andHcontEqualTo(String value) {
            addCriterion("hcont =", value, "hcont");
            return (Criteria) this;
        }

        public Criteria andHcontNotEqualTo(String value) {
            addCriterion("hcont <>", value, "hcont");
            return (Criteria) this;
        }

        public Criteria andHcontGreaterThan(String value) {
            addCriterion("hcont >", value, "hcont");
            return (Criteria) this;
        }

        public Criteria andHcontGreaterThanOrEqualTo(String value) {
            addCriterion("hcont >=", value, "hcont");
            return (Criteria) this;
        }

        public Criteria andHcontLessThan(String value) {
            addCriterion("hcont <", value, "hcont");
            return (Criteria) this;
        }

        public Criteria andHcontLessThanOrEqualTo(String value) {
            addCriterion("hcont <=", value, "hcont");
            return (Criteria) this;
        }

        public Criteria andHcontLike(String value) {
            addCriterion("hcont like", value, "hcont");
            return (Criteria) this;
        }

        public Criteria andHcontNotLike(String value) {
            addCriterion("hcont not like", value, "hcont");
            return (Criteria) this;
        }

        public Criteria andHcontIn(List<String> values) {
            addCriterion("hcont in", values, "hcont");
            return (Criteria) this;
        }

        public Criteria andHcontNotIn(List<String> values) {
            addCriterion("hcont not in", values, "hcont");
            return (Criteria) this;
        }

        public Criteria andHcontBetween(String value1, String value2) {
            addCriterion("hcont between", value1, value2, "hcont");
            return (Criteria) this;
        }

        public Criteria andHcontNotBetween(String value1, String value2) {
            addCriterion("hcont not between", value1, value2, "hcont");
            return (Criteria) this;
        }

        public Criteria andHflagIsNull() {
            addCriterion("hflag is null");
            return (Criteria) this;
        }

        public Criteria andHflagIsNotNull() {
            addCriterion("hflag is not null");
            return (Criteria) this;
        }

        public Criteria andHflagEqualTo(Integer value) {
            addCriterion("hflag =", value, "hflag");
            return (Criteria) this;
        }

        public Criteria andHflagNotEqualTo(Integer value) {
            addCriterion("hflag <>", value, "hflag");
            return (Criteria) this;
        }

        public Criteria andHflagGreaterThan(Integer value) {
            addCriterion("hflag >", value, "hflag");
            return (Criteria) this;
        }

        public Criteria andHflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("hflag >=", value, "hflag");
            return (Criteria) this;
        }

        public Criteria andHflagLessThan(Integer value) {
            addCriterion("hflag <", value, "hflag");
            return (Criteria) this;
        }

        public Criteria andHflagLessThanOrEqualTo(Integer value) {
            addCriterion("hflag <=", value, "hflag");
            return (Criteria) this;
        }

        public Criteria andHflagIn(List<Integer> values) {
            addCriterion("hflag in", values, "hflag");
            return (Criteria) this;
        }

        public Criteria andHflagNotIn(List<Integer> values) {
            addCriterion("hflag not in", values, "hflag");
            return (Criteria) this;
        }

        public Criteria andHflagBetween(Integer value1, Integer value2) {
            addCriterion("hflag between", value1, value2, "hflag");
            return (Criteria) this;
        }

        public Criteria andHflagNotBetween(Integer value1, Integer value2) {
            addCriterion("hflag not between", value1, value2, "hflag");
            return (Criteria) this;
        }

        public Criteria andHteacherresultIsNull() {
            addCriterion("hteacherresult is null");
            return (Criteria) this;
        }

        public Criteria andHteacherresultIsNotNull() {
            addCriterion("hteacherresult is not null");
            return (Criteria) this;
        }

        public Criteria andHteacherresultEqualTo(String value) {
            addCriterion("hteacherresult =", value, "hteacherresult");
            return (Criteria) this;
        }

        public Criteria andHteacherresultNotEqualTo(String value) {
            addCriterion("hteacherresult <>", value, "hteacherresult");
            return (Criteria) this;
        }

        public Criteria andHteacherresultGreaterThan(String value) {
            addCriterion("hteacherresult >", value, "hteacherresult");
            return (Criteria) this;
        }

        public Criteria andHteacherresultGreaterThanOrEqualTo(String value) {
            addCriterion("hteacherresult >=", value, "hteacherresult");
            return (Criteria) this;
        }

        public Criteria andHteacherresultLessThan(String value) {
            addCriterion("hteacherresult <", value, "hteacherresult");
            return (Criteria) this;
        }

        public Criteria andHteacherresultLessThanOrEqualTo(String value) {
            addCriterion("hteacherresult <=", value, "hteacherresult");
            return (Criteria) this;
        }

        public Criteria andHteacherresultLike(String value) {
            addCriterion("hteacherresult like", value, "hteacherresult");
            return (Criteria) this;
        }

        public Criteria andHteacherresultNotLike(String value) {
            addCriterion("hteacherresult not like", value, "hteacherresult");
            return (Criteria) this;
        }

        public Criteria andHteacherresultIn(List<String> values) {
            addCriterion("hteacherresult in", values, "hteacherresult");
            return (Criteria) this;
        }

        public Criteria andHteacherresultNotIn(List<String> values) {
            addCriterion("hteacherresult not in", values, "hteacherresult");
            return (Criteria) this;
        }

        public Criteria andHteacherresultBetween(String value1, String value2) {
            addCriterion("hteacherresult between", value1, value2, "hteacherresult");
            return (Criteria) this;
        }

        public Criteria andHteacherresultNotBetween(String value1, String value2) {
            addCriterion("hteacherresult not between", value1, value2, "hteacherresult");
            return (Criteria) this;
        }

        public Criteria andHadminresultIsNull() {
            addCriterion("hadminresult is null");
            return (Criteria) this;
        }

        public Criteria andHadminresultIsNotNull() {
            addCriterion("hadminresult is not null");
            return (Criteria) this;
        }

        public Criteria andHadminresultEqualTo(String value) {
            addCriterion("hadminresult =", value, "hadminresult");
            return (Criteria) this;
        }

        public Criteria andHadminresultNotEqualTo(String value) {
            addCriterion("hadminresult <>", value, "hadminresult");
            return (Criteria) this;
        }

        public Criteria andHadminresultGreaterThan(String value) {
            addCriterion("hadminresult >", value, "hadminresult");
            return (Criteria) this;
        }

        public Criteria andHadminresultGreaterThanOrEqualTo(String value) {
            addCriterion("hadminresult >=", value, "hadminresult");
            return (Criteria) this;
        }

        public Criteria andHadminresultLessThan(String value) {
            addCriterion("hadminresult <", value, "hadminresult");
            return (Criteria) this;
        }

        public Criteria andHadminresultLessThanOrEqualTo(String value) {
            addCriterion("hadminresult <=", value, "hadminresult");
            return (Criteria) this;
        }

        public Criteria andHadminresultLike(String value) {
            addCriterion("hadminresult like", value, "hadminresult");
            return (Criteria) this;
        }

        public Criteria andHadminresultNotLike(String value) {
            addCriterion("hadminresult not like", value, "hadminresult");
            return (Criteria) this;
        }

        public Criteria andHadminresultIn(List<String> values) {
            addCriterion("hadminresult in", values, "hadminresult");
            return (Criteria) this;
        }

        public Criteria andHadminresultNotIn(List<String> values) {
            addCriterion("hadminresult not in", values, "hadminresult");
            return (Criteria) this;
        }

        public Criteria andHadminresultBetween(String value1, String value2) {
            addCriterion("hadminresult between", value1, value2, "hadminresult");
            return (Criteria) this;
        }

        public Criteria andHadminresultNotBetween(String value1, String value2) {
            addCriterion("hadminresult not between", value1, value2, "hadminresult");
            return (Criteria) this;
        }

        public Criteria andHbidIsNull() {
            addCriterion("hbid is null");
            return (Criteria) this;
        }

        public Criteria andHbidIsNotNull() {
            addCriterion("hbid is not null");
            return (Criteria) this;
        }

        public Criteria andHbidEqualTo(Integer value) {
            addCriterion("hbid =", value, "hbid");
            return (Criteria) this;
        }

        public Criteria andHbidNotEqualTo(Integer value) {
            addCriterion("hbid <>", value, "hbid");
            return (Criteria) this;
        }

        public Criteria andHbidGreaterThan(Integer value) {
            addCriterion("hbid >", value, "hbid");
            return (Criteria) this;
        }

        public Criteria andHbidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hbid >=", value, "hbid");
            return (Criteria) this;
        }

        public Criteria andHbidLessThan(Integer value) {
            addCriterion("hbid <", value, "hbid");
            return (Criteria) this;
        }

        public Criteria andHbidLessThanOrEqualTo(Integer value) {
            addCriterion("hbid <=", value, "hbid");
            return (Criteria) this;
        }

        public Criteria andHbidIn(List<Integer> values) {
            addCriterion("hbid in", values, "hbid");
            return (Criteria) this;
        }

        public Criteria andHbidNotIn(List<Integer> values) {
            addCriterion("hbid not in", values, "hbid");
            return (Criteria) this;
        }

        public Criteria andHbidBetween(Integer value1, Integer value2) {
            addCriterion("hbid between", value1, value2, "hbid");
            return (Criteria) this;
        }

        public Criteria andHbidNotBetween(Integer value1, Integer value2) {
            addCriterion("hbid not between", value1, value2, "hbid");
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