package com.myclouds.manager.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RinoutsignsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RinoutsignsExample() {
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

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCdateIsNull() {
            addCriterion("cdate is null");
            return (Criteria) this;
        }

        public Criteria andCdateIsNotNull() {
            addCriterion("cdate is not null");
            return (Criteria) this;
        }

        public Criteria andCdateEqualTo(Date value) {
            addCriterionForJDBCDate("cdate =", value, "cdate");
            return (Criteria) this;
        }

        public Criteria andCdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("cdate <>", value, "cdate");
            return (Criteria) this;
        }

        public Criteria andCdateGreaterThan(Date value) {
            addCriterionForJDBCDate("cdate >", value, "cdate");
            return (Criteria) this;
        }

        public Criteria andCdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("cdate >=", value, "cdate");
            return (Criteria) this;
        }

        public Criteria andCdateLessThan(Date value) {
            addCriterionForJDBCDate("cdate <", value, "cdate");
            return (Criteria) this;
        }

        public Criteria andCdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("cdate <=", value, "cdate");
            return (Criteria) this;
        }

        public Criteria andCdateIn(List<Date> values) {
            addCriterionForJDBCDate("cdate in", values, "cdate");
            return (Criteria) this;
        }

        public Criteria andCdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("cdate not in", values, "cdate");
            return (Criteria) this;
        }

        public Criteria andCdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("cdate between", value1, value2, "cdate");
            return (Criteria) this;
        }

        public Criteria andCdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("cdate not between", value1, value2, "cdate");
            return (Criteria) this;
        }

        public Criteria andCtypeIsNull() {
            addCriterion("ctype is null");
            return (Criteria) this;
        }

        public Criteria andCtypeIsNotNull() {
            addCriterion("ctype is not null");
            return (Criteria) this;
        }

        public Criteria andCtypeEqualTo(Integer value) {
            addCriterion("ctype =", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeNotEqualTo(Integer value) {
            addCriterion("ctype <>", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeGreaterThan(Integer value) {
            addCriterion("ctype >", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ctype >=", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeLessThan(Integer value) {
            addCriterion("ctype <", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeLessThanOrEqualTo(Integer value) {
            addCriterion("ctype <=", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeIn(List<Integer> values) {
            addCriterion("ctype in", values, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeNotIn(List<Integer> values) {
            addCriterion("ctype not in", values, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeBetween(Integer value1, Integer value2) {
            addCriterion("ctype between", value1, value2, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ctype not between", value1, value2, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtemperatureIsNull() {
            addCriterion("ctemperature is null");
            return (Criteria) this;
        }

        public Criteria andCtemperatureIsNotNull() {
            addCriterion("ctemperature is not null");
            return (Criteria) this;
        }

        public Criteria andCtemperatureEqualTo(String value) {
            addCriterion("ctemperature =", value, "ctemperature");
            return (Criteria) this;
        }

        public Criteria andCtemperatureNotEqualTo(String value) {
            addCriterion("ctemperature <>", value, "ctemperature");
            return (Criteria) this;
        }

        public Criteria andCtemperatureGreaterThan(String value) {
            addCriterion("ctemperature >", value, "ctemperature");
            return (Criteria) this;
        }

        public Criteria andCtemperatureGreaterThanOrEqualTo(String value) {
            addCriterion("ctemperature >=", value, "ctemperature");
            return (Criteria) this;
        }

        public Criteria andCtemperatureLessThan(String value) {
            addCriterion("ctemperature <", value, "ctemperature");
            return (Criteria) this;
        }

        public Criteria andCtemperatureLessThanOrEqualTo(String value) {
            addCriterion("ctemperature <=", value, "ctemperature");
            return (Criteria) this;
        }

        public Criteria andCtemperatureLike(String value) {
            addCriterion("ctemperature like", value, "ctemperature");
            return (Criteria) this;
        }

        public Criteria andCtemperatureNotLike(String value) {
            addCriterion("ctemperature not like", value, "ctemperature");
            return (Criteria) this;
        }

        public Criteria andCtemperatureIn(List<String> values) {
            addCriterion("ctemperature in", values, "ctemperature");
            return (Criteria) this;
        }

        public Criteria andCtemperatureNotIn(List<String> values) {
            addCriterion("ctemperature not in", values, "ctemperature");
            return (Criteria) this;
        }

        public Criteria andCtemperatureBetween(String value1, String value2) {
            addCriterion("ctemperature between", value1, value2, "ctemperature");
            return (Criteria) this;
        }

        public Criteria andCtemperatureNotBetween(String value1, String value2) {
            addCriterion("ctemperature not between", value1, value2, "ctemperature");
            return (Criteria) this;
        }

        public Criteria andCuidIsNull() {
            addCriterion("cuid is null");
            return (Criteria) this;
        }

        public Criteria andCuidIsNotNull() {
            addCriterion("cuid is not null");
            return (Criteria) this;
        }

        public Criteria andCuidEqualTo(Integer value) {
            addCriterion("cuid =", value, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidNotEqualTo(Integer value) {
            addCriterion("cuid <>", value, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidGreaterThan(Integer value) {
            addCriterion("cuid >", value, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cuid >=", value, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidLessThan(Integer value) {
            addCriterion("cuid <", value, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidLessThanOrEqualTo(Integer value) {
            addCriterion("cuid <=", value, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidIn(List<Integer> values) {
            addCriterion("cuid in", values, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidNotIn(List<Integer> values) {
            addCriterion("cuid not in", values, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidBetween(Integer value1, Integer value2) {
            addCriterion("cuid between", value1, value2, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidNotBetween(Integer value1, Integer value2) {
            addCriterion("cuid not between", value1, value2, "cuid");
            return (Criteria) this;
        }

        public Criteria andCtypenameIsNull() {
            addCriterion("ctypename is null");
            return (Criteria) this;
        }

        public Criteria andCtypenameIsNotNull() {
            addCriterion("ctypename is not null");
            return (Criteria) this;
        }

        public Criteria andCtypenameEqualTo(String value) {
            addCriterion("ctypename =", value, "ctypename");
            return (Criteria) this;
        }

        public Criteria andCtypenameNotEqualTo(String value) {
            addCriterion("ctypename <>", value, "ctypename");
            return (Criteria) this;
        }

        public Criteria andCtypenameGreaterThan(String value) {
            addCriterion("ctypename >", value, "ctypename");
            return (Criteria) this;
        }

        public Criteria andCtypenameGreaterThanOrEqualTo(String value) {
            addCriterion("ctypename >=", value, "ctypename");
            return (Criteria) this;
        }

        public Criteria andCtypenameLessThan(String value) {
            addCriterion("ctypename <", value, "ctypename");
            return (Criteria) this;
        }

        public Criteria andCtypenameLessThanOrEqualTo(String value) {
            addCriterion("ctypename <=", value, "ctypename");
            return (Criteria) this;
        }

        public Criteria andCtypenameLike(String value) {
            addCriterion("ctypename like", value, "ctypename");
            return (Criteria) this;
        }

        public Criteria andCtypenameNotLike(String value) {
            addCriterion("ctypename not like", value, "ctypename");
            return (Criteria) this;
        }

        public Criteria andCtypenameIn(List<String> values) {
            addCriterion("ctypename in", values, "ctypename");
            return (Criteria) this;
        }

        public Criteria andCtypenameNotIn(List<String> values) {
            addCriterion("ctypename not in", values, "ctypename");
            return (Criteria) this;
        }

        public Criteria andCtypenameBetween(String value1, String value2) {
            addCriterion("ctypename between", value1, value2, "ctypename");
            return (Criteria) this;
        }

        public Criteria andCtypenameNotBetween(String value1, String value2) {
            addCriterion("ctypename not between", value1, value2, "ctypename");
            return (Criteria) this;
        }

        public Criteria andCuzhengjianhaomaIsNull() {
            addCriterion("cuzhengjianhaoma is null");
            return (Criteria) this;
        }

        public Criteria andCuzhengjianhaomaIsNotNull() {
            addCriterion("cuzhengjianhaoma is not null");
            return (Criteria) this;
        }

        public Criteria andCuzhengjianhaomaEqualTo(String value) {
            addCriterion("cuzhengjianhaoma =", value, "cuzhengjianhaoma");
            return (Criteria) this;
        }

        public Criteria andCuzhengjianhaomaNotEqualTo(String value) {
            addCriterion("cuzhengjianhaoma <>", value, "cuzhengjianhaoma");
            return (Criteria) this;
        }

        public Criteria andCuzhengjianhaomaGreaterThan(String value) {
            addCriterion("cuzhengjianhaoma >", value, "cuzhengjianhaoma");
            return (Criteria) this;
        }

        public Criteria andCuzhengjianhaomaGreaterThanOrEqualTo(String value) {
            addCriterion("cuzhengjianhaoma >=", value, "cuzhengjianhaoma");
            return (Criteria) this;
        }

        public Criteria andCuzhengjianhaomaLessThan(String value) {
            addCriterion("cuzhengjianhaoma <", value, "cuzhengjianhaoma");
            return (Criteria) this;
        }

        public Criteria andCuzhengjianhaomaLessThanOrEqualTo(String value) {
            addCriterion("cuzhengjianhaoma <=", value, "cuzhengjianhaoma");
            return (Criteria) this;
        }

        public Criteria andCuzhengjianhaomaLike(String value) {
            addCriterion("cuzhengjianhaoma like", value, "cuzhengjianhaoma");
            return (Criteria) this;
        }

        public Criteria andCuzhengjianhaomaNotLike(String value) {
            addCriterion("cuzhengjianhaoma not like", value, "cuzhengjianhaoma");
            return (Criteria) this;
        }

        public Criteria andCuzhengjianhaomaIn(List<String> values) {
            addCriterion("cuzhengjianhaoma in", values, "cuzhengjianhaoma");
            return (Criteria) this;
        }

        public Criteria andCuzhengjianhaomaNotIn(List<String> values) {
            addCriterion("cuzhengjianhaoma not in", values, "cuzhengjianhaoma");
            return (Criteria) this;
        }

        public Criteria andCuzhengjianhaomaBetween(String value1, String value2) {
            addCriterion("cuzhengjianhaoma between", value1, value2, "cuzhengjianhaoma");
            return (Criteria) this;
        }

        public Criteria andCuzhengjianhaomaNotBetween(String value1, String value2) {
            addCriterion("cuzhengjianhaoma not between", value1, value2, "cuzhengjianhaoma");
            return (Criteria) this;
        }

        public Criteria andCfromattrsIsNull() {
            addCriterion("cfromattrs is null");
            return (Criteria) this;
        }

        public Criteria andCfromattrsIsNotNull() {
            addCriterion("cfromattrs is not null");
            return (Criteria) this;
        }

        public Criteria andCfromattrsEqualTo(String value) {
            addCriterion("cfromattrs =", value, "cfromattrs");
            return (Criteria) this;
        }

        public Criteria andCfromattrsNotEqualTo(String value) {
            addCriterion("cfromattrs <>", value, "cfromattrs");
            return (Criteria) this;
        }

        public Criteria andCfromattrsGreaterThan(String value) {
            addCriterion("cfromattrs >", value, "cfromattrs");
            return (Criteria) this;
        }

        public Criteria andCfromattrsGreaterThanOrEqualTo(String value) {
            addCriterion("cfromattrs >=", value, "cfromattrs");
            return (Criteria) this;
        }

        public Criteria andCfromattrsLessThan(String value) {
            addCriterion("cfromattrs <", value, "cfromattrs");
            return (Criteria) this;
        }

        public Criteria andCfromattrsLessThanOrEqualTo(String value) {
            addCriterion("cfromattrs <=", value, "cfromattrs");
            return (Criteria) this;
        }

        public Criteria andCfromattrsLike(String value) {
            addCriterion("cfromattrs like", value, "cfromattrs");
            return (Criteria) this;
        }

        public Criteria andCfromattrsNotLike(String value) {
            addCriterion("cfromattrs not like", value, "cfromattrs");
            return (Criteria) this;
        }

        public Criteria andCfromattrsIn(List<String> values) {
            addCriterion("cfromattrs in", values, "cfromattrs");
            return (Criteria) this;
        }

        public Criteria andCfromattrsNotIn(List<String> values) {
            addCriterion("cfromattrs not in", values, "cfromattrs");
            return (Criteria) this;
        }

        public Criteria andCfromattrsBetween(String value1, String value2) {
            addCriterion("cfromattrs between", value1, value2, "cfromattrs");
            return (Criteria) this;
        }

        public Criteria andCfromattrsNotBetween(String value1, String value2) {
            addCriterion("cfromattrs not between", value1, value2, "cfromattrs");
            return (Criteria) this;
        }

        public Criteria andCshentizhuangkuangIsNull() {
            addCriterion("cshentizhuangkuang is null");
            return (Criteria) this;
        }

        public Criteria andCshentizhuangkuangIsNotNull() {
            addCriterion("cshentizhuangkuang is not null");
            return (Criteria) this;
        }

        public Criteria andCshentizhuangkuangEqualTo(String value) {
            addCriterion("cshentizhuangkuang =", value, "cshentizhuangkuang");
            return (Criteria) this;
        }

        public Criteria andCshentizhuangkuangNotEqualTo(String value) {
            addCriterion("cshentizhuangkuang <>", value, "cshentizhuangkuang");
            return (Criteria) this;
        }

        public Criteria andCshentizhuangkuangGreaterThan(String value) {
            addCriterion("cshentizhuangkuang >", value, "cshentizhuangkuang");
            return (Criteria) this;
        }

        public Criteria andCshentizhuangkuangGreaterThanOrEqualTo(String value) {
            addCriterion("cshentizhuangkuang >=", value, "cshentizhuangkuang");
            return (Criteria) this;
        }

        public Criteria andCshentizhuangkuangLessThan(String value) {
            addCriterion("cshentizhuangkuang <", value, "cshentizhuangkuang");
            return (Criteria) this;
        }

        public Criteria andCshentizhuangkuangLessThanOrEqualTo(String value) {
            addCriterion("cshentizhuangkuang <=", value, "cshentizhuangkuang");
            return (Criteria) this;
        }

        public Criteria andCshentizhuangkuangLike(String value) {
            addCriterion("cshentizhuangkuang like", value, "cshentizhuangkuang");
            return (Criteria) this;
        }

        public Criteria andCshentizhuangkuangNotLike(String value) {
            addCriterion("cshentizhuangkuang not like", value, "cshentizhuangkuang");
            return (Criteria) this;
        }

        public Criteria andCshentizhuangkuangIn(List<String> values) {
            addCriterion("cshentizhuangkuang in", values, "cshentizhuangkuang");
            return (Criteria) this;
        }

        public Criteria andCshentizhuangkuangNotIn(List<String> values) {
            addCriterion("cshentizhuangkuang not in", values, "cshentizhuangkuang");
            return (Criteria) this;
        }

        public Criteria andCshentizhuangkuangBetween(String value1, String value2) {
            addCriterion("cshentizhuangkuang between", value1, value2, "cshentizhuangkuang");
            return (Criteria) this;
        }

        public Criteria andCshentizhuangkuangNotBetween(String value1, String value2) {
            addCriterion("cshentizhuangkuang not between", value1, value2, "cshentizhuangkuang");
            return (Criteria) this;
        }

        public Criteria andCtoattrsIsNull() {
            addCriterion("ctoattrs is null");
            return (Criteria) this;
        }

        public Criteria andCtoattrsIsNotNull() {
            addCriterion("ctoattrs is not null");
            return (Criteria) this;
        }

        public Criteria andCtoattrsEqualTo(String value) {
            addCriterion("ctoattrs =", value, "ctoattrs");
            return (Criteria) this;
        }

        public Criteria andCtoattrsNotEqualTo(String value) {
            addCriterion("ctoattrs <>", value, "ctoattrs");
            return (Criteria) this;
        }

        public Criteria andCtoattrsGreaterThan(String value) {
            addCriterion("ctoattrs >", value, "ctoattrs");
            return (Criteria) this;
        }

        public Criteria andCtoattrsGreaterThanOrEqualTo(String value) {
            addCriterion("ctoattrs >=", value, "ctoattrs");
            return (Criteria) this;
        }

        public Criteria andCtoattrsLessThan(String value) {
            addCriterion("ctoattrs <", value, "ctoattrs");
            return (Criteria) this;
        }

        public Criteria andCtoattrsLessThanOrEqualTo(String value) {
            addCriterion("ctoattrs <=", value, "ctoattrs");
            return (Criteria) this;
        }

        public Criteria andCtoattrsLike(String value) {
            addCriterion("ctoattrs like", value, "ctoattrs");
            return (Criteria) this;
        }

        public Criteria andCtoattrsNotLike(String value) {
            addCriterion("ctoattrs not like", value, "ctoattrs");
            return (Criteria) this;
        }

        public Criteria andCtoattrsIn(List<String> values) {
            addCriterion("ctoattrs in", values, "ctoattrs");
            return (Criteria) this;
        }

        public Criteria andCtoattrsNotIn(List<String> values) {
            addCriterion("ctoattrs not in", values, "ctoattrs");
            return (Criteria) this;
        }

        public Criteria andCtoattrsBetween(String value1, String value2) {
            addCriterion("ctoattrs between", value1, value2, "ctoattrs");
            return (Criteria) this;
        }

        public Criteria andCtoattrsNotBetween(String value1, String value2) {
            addCriterion("ctoattrs not between", value1, value2, "ctoattrs");
            return (Criteria) this;
        }

        public Criteria andCownerrelationshipIsNull() {
            addCriterion("cownerrelationship is null");
            return (Criteria) this;
        }

        public Criteria andCownerrelationshipIsNotNull() {
            addCriterion("cownerrelationship is not null");
            return (Criteria) this;
        }

        public Criteria andCownerrelationshipEqualTo(String value) {
            addCriterion("cownerrelationship =", value, "cownerrelationship");
            return (Criteria) this;
        }

        public Criteria andCownerrelationshipNotEqualTo(String value) {
            addCriterion("cownerrelationship <>", value, "cownerrelationship");
            return (Criteria) this;
        }

        public Criteria andCownerrelationshipGreaterThan(String value) {
            addCriterion("cownerrelationship >", value, "cownerrelationship");
            return (Criteria) this;
        }

        public Criteria andCownerrelationshipGreaterThanOrEqualTo(String value) {
            addCriterion("cownerrelationship >=", value, "cownerrelationship");
            return (Criteria) this;
        }

        public Criteria andCownerrelationshipLessThan(String value) {
            addCriterion("cownerrelationship <", value, "cownerrelationship");
            return (Criteria) this;
        }

        public Criteria andCownerrelationshipLessThanOrEqualTo(String value) {
            addCriterion("cownerrelationship <=", value, "cownerrelationship");
            return (Criteria) this;
        }

        public Criteria andCownerrelationshipLike(String value) {
            addCriterion("cownerrelationship like", value, "cownerrelationship");
            return (Criteria) this;
        }

        public Criteria andCownerrelationshipNotLike(String value) {
            addCriterion("cownerrelationship not like", value, "cownerrelationship");
            return (Criteria) this;
        }

        public Criteria andCownerrelationshipIn(List<String> values) {
            addCriterion("cownerrelationship in", values, "cownerrelationship");
            return (Criteria) this;
        }

        public Criteria andCownerrelationshipNotIn(List<String> values) {
            addCriterion("cownerrelationship not in", values, "cownerrelationship");
            return (Criteria) this;
        }

        public Criteria andCownerrelationshipBetween(String value1, String value2) {
            addCriterion("cownerrelationship between", value1, value2, "cownerrelationship");
            return (Criteria) this;
        }

        public Criteria andCownerrelationshipNotBetween(String value1, String value2) {
            addCriterion("cownerrelationship not between", value1, value2, "cownerrelationship");
            return (Criteria) this;
        }

        public Criteria andCunameIsNull() {
            addCriterion("cuname is null");
            return (Criteria) this;
        }

        public Criteria andCunameIsNotNull() {
            addCriterion("cuname is not null");
            return (Criteria) this;
        }

        public Criteria andCunameEqualTo(String value) {
            addCriterion("cuname =", value, "cuname");
            return (Criteria) this;
        }

        public Criteria andCunameNotEqualTo(String value) {
            addCriterion("cuname <>", value, "cuname");
            return (Criteria) this;
        }

        public Criteria andCunameGreaterThan(String value) {
            addCriterion("cuname >", value, "cuname");
            return (Criteria) this;
        }

        public Criteria andCunameGreaterThanOrEqualTo(String value) {
            addCriterion("cuname >=", value, "cuname");
            return (Criteria) this;
        }

        public Criteria andCunameLessThan(String value) {
            addCriterion("cuname <", value, "cuname");
            return (Criteria) this;
        }

        public Criteria andCunameLessThanOrEqualTo(String value) {
            addCriterion("cuname <=", value, "cuname");
            return (Criteria) this;
        }

        public Criteria andCunameLike(String value) {
            addCriterion("cuname like", value, "cuname");
            return (Criteria) this;
        }

        public Criteria andCunameNotLike(String value) {
            addCriterion("cuname not like", value, "cuname");
            return (Criteria) this;
        }

        public Criteria andCunameIn(List<String> values) {
            addCriterion("cuname in", values, "cuname");
            return (Criteria) this;
        }

        public Criteria andCunameNotIn(List<String> values) {
            addCriterion("cuname not in", values, "cuname");
            return (Criteria) this;
        }

        public Criteria andCunameBetween(String value1, String value2) {
            addCriterion("cuname between", value1, value2, "cuname");
            return (Criteria) this;
        }

        public Criteria andCunameNotBetween(String value1, String value2) {
            addCriterion("cuname not between", value1, value2, "cuname");
            return (Criteria) this;
        }

        public Criteria andCutelIsNull() {
            addCriterion("cutel is null");
            return (Criteria) this;
        }

        public Criteria andCutelIsNotNull() {
            addCriterion("cutel is not null");
            return (Criteria) this;
        }

        public Criteria andCutelEqualTo(String value) {
            addCriterion("cutel =", value, "cutel");
            return (Criteria) this;
        }

        public Criteria andCutelNotEqualTo(String value) {
            addCriterion("cutel <>", value, "cutel");
            return (Criteria) this;
        }

        public Criteria andCutelGreaterThan(String value) {
            addCriterion("cutel >", value, "cutel");
            return (Criteria) this;
        }

        public Criteria andCutelGreaterThanOrEqualTo(String value) {
            addCriterion("cutel >=", value, "cutel");
            return (Criteria) this;
        }

        public Criteria andCutelLessThan(String value) {
            addCriterion("cutel <", value, "cutel");
            return (Criteria) this;
        }

        public Criteria andCutelLessThanOrEqualTo(String value) {
            addCriterion("cutel <=", value, "cutel");
            return (Criteria) this;
        }

        public Criteria andCutelLike(String value) {
            addCriterion("cutel like", value, "cutel");
            return (Criteria) this;
        }

        public Criteria andCutelNotLike(String value) {
            addCriterion("cutel not like", value, "cutel");
            return (Criteria) this;
        }

        public Criteria andCutelIn(List<String> values) {
            addCriterion("cutel in", values, "cutel");
            return (Criteria) this;
        }

        public Criteria andCutelNotIn(List<String> values) {
            addCriterion("cutel not in", values, "cutel");
            return (Criteria) this;
        }

        public Criteria andCutelBetween(String value1, String value2) {
            addCriterion("cutel between", value1, value2, "cutel");
            return (Criteria) this;
        }

        public Criteria andCutelNotBetween(String value1, String value2) {
            addCriterion("cutel not between", value1, value2, "cutel");
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