package team.seven.endless.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ElWorkTagExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ElWorkTagExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andWorkTagIdIsNull() {
            addCriterion("work_tag_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkTagIdIsNotNull() {
            addCriterion("work_tag_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTagIdEqualTo(Long value) {
            addCriterion("work_tag_id =", value, "workTagId");
            return (Criteria) this;
        }

        public Criteria andWorkTagIdNotEqualTo(Long value) {
            addCriterion("work_tag_id <>", value, "workTagId");
            return (Criteria) this;
        }

        public Criteria andWorkTagIdGreaterThan(Long value) {
            addCriterion("work_tag_id >", value, "workTagId");
            return (Criteria) this;
        }

        public Criteria andWorkTagIdGreaterThanOrEqualTo(Long value) {
            addCriterion("work_tag_id >=", value, "workTagId");
            return (Criteria) this;
        }

        public Criteria andWorkTagIdLessThan(Long value) {
            addCriterion("work_tag_id <", value, "workTagId");
            return (Criteria) this;
        }

        public Criteria andWorkTagIdLessThanOrEqualTo(Long value) {
            addCriterion("work_tag_id <=", value, "workTagId");
            return (Criteria) this;
        }

        public Criteria andWorkTagIdIn(List<Long> values) {
            addCriterion("work_tag_id in", values, "workTagId");
            return (Criteria) this;
        }

        public Criteria andWorkTagIdNotIn(List<Long> values) {
            addCriterion("work_tag_id not in", values, "workTagId");
            return (Criteria) this;
        }

        public Criteria andWorkTagIdBetween(Long value1, Long value2) {
            addCriterion("work_tag_id between", value1, value2, "workTagId");
            return (Criteria) this;
        }

        public Criteria andWorkTagIdNotBetween(Long value1, Long value2) {
            addCriterion("work_tag_id not between", value1, value2, "workTagId");
            return (Criteria) this;
        }

        public Criteria andWorkTagNameIsNull() {
            addCriterion("work_tag_name is null");
            return (Criteria) this;
        }

        public Criteria andWorkTagNameIsNotNull() {
            addCriterion("work_tag_name is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTagNameEqualTo(String value) {
            addCriterion("work_tag_name =", value, "workTagName");
            return (Criteria) this;
        }

        public Criteria andWorkTagNameNotEqualTo(String value) {
            addCriterion("work_tag_name <>", value, "workTagName");
            return (Criteria) this;
        }

        public Criteria andWorkTagNameGreaterThan(String value) {
            addCriterion("work_tag_name >", value, "workTagName");
            return (Criteria) this;
        }

        public Criteria andWorkTagNameGreaterThanOrEqualTo(String value) {
            addCriterion("work_tag_name >=", value, "workTagName");
            return (Criteria) this;
        }

        public Criteria andWorkTagNameLessThan(String value) {
            addCriterion("work_tag_name <", value, "workTagName");
            return (Criteria) this;
        }

        public Criteria andWorkTagNameLessThanOrEqualTo(String value) {
            addCriterion("work_tag_name <=", value, "workTagName");
            return (Criteria) this;
        }

        public Criteria andWorkTagNameLike(String value) {
            addCriterion("work_tag_name like", value, "workTagName");
            return (Criteria) this;
        }

        public Criteria andWorkTagNameNotLike(String value) {
            addCriterion("work_tag_name not like", value, "workTagName");
            return (Criteria) this;
        }

        public Criteria andWorkTagNameIn(List<String> values) {
            addCriterion("work_tag_name in", values, "workTagName");
            return (Criteria) this;
        }

        public Criteria andWorkTagNameNotIn(List<String> values) {
            addCriterion("work_tag_name not in", values, "workTagName");
            return (Criteria) this;
        }

        public Criteria andWorkTagNameBetween(String value1, String value2) {
            addCriterion("work_tag_name between", value1, value2, "workTagName");
            return (Criteria) this;
        }

        public Criteria andWorkTagNameNotBetween(String value1, String value2) {
            addCriterion("work_tag_name not between", value1, value2, "workTagName");
            return (Criteria) this;
        }

        public Criteria andWorkTagDescriIsNull() {
            addCriterion("work_tag_descri is null");
            return (Criteria) this;
        }

        public Criteria andWorkTagDescriIsNotNull() {
            addCriterion("work_tag_descri is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTagDescriEqualTo(String value) {
            addCriterion("work_tag_descri =", value, "workTagDescri");
            return (Criteria) this;
        }

        public Criteria andWorkTagDescriNotEqualTo(String value) {
            addCriterion("work_tag_descri <>", value, "workTagDescri");
            return (Criteria) this;
        }

        public Criteria andWorkTagDescriGreaterThan(String value) {
            addCriterion("work_tag_descri >", value, "workTagDescri");
            return (Criteria) this;
        }

        public Criteria andWorkTagDescriGreaterThanOrEqualTo(String value) {
            addCriterion("work_tag_descri >=", value, "workTagDescri");
            return (Criteria) this;
        }

        public Criteria andWorkTagDescriLessThan(String value) {
            addCriterion("work_tag_descri <", value, "workTagDescri");
            return (Criteria) this;
        }

        public Criteria andWorkTagDescriLessThanOrEqualTo(String value) {
            addCriterion("work_tag_descri <=", value, "workTagDescri");
            return (Criteria) this;
        }

        public Criteria andWorkTagDescriLike(String value) {
            addCriterion("work_tag_descri like", value, "workTagDescri");
            return (Criteria) this;
        }

        public Criteria andWorkTagDescriNotLike(String value) {
            addCriterion("work_tag_descri not like", value, "workTagDescri");
            return (Criteria) this;
        }

        public Criteria andWorkTagDescriIn(List<String> values) {
            addCriterion("work_tag_descri in", values, "workTagDescri");
            return (Criteria) this;
        }

        public Criteria andWorkTagDescriNotIn(List<String> values) {
            addCriterion("work_tag_descri not in", values, "workTagDescri");
            return (Criteria) this;
        }

        public Criteria andWorkTagDescriBetween(String value1, String value2) {
            addCriterion("work_tag_descri between", value1, value2, "workTagDescri");
            return (Criteria) this;
        }

        public Criteria andWorkTagDescriNotBetween(String value1, String value2) {
            addCriterion("work_tag_descri not between", value1, value2, "workTagDescri");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Boolean value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Boolean value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Boolean value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Boolean value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Boolean> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Boolean> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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