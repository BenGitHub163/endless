package team.seven.endless.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ElWorkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ElWorkExample() {
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

        public Criteria andWorkIdIsNull() {
            addCriterion("work_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkIdIsNotNull() {
            addCriterion("work_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkIdEqualTo(Long value) {
            addCriterion("work_id =", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdNotEqualTo(Long value) {
            addCriterion("work_id <>", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdGreaterThan(Long value) {
            addCriterion("work_id >", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdGreaterThanOrEqualTo(Long value) {
            addCriterion("work_id >=", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdLessThan(Long value) {
            addCriterion("work_id <", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdLessThanOrEqualTo(Long value) {
            addCriterion("work_id <=", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdIn(List<Long> values) {
            addCriterion("work_id in", values, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdNotIn(List<Long> values) {
            addCriterion("work_id not in", values, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdBetween(Long value1, Long value2) {
            addCriterion("work_id between", value1, value2, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdNotBetween(Long value1, Long value2) {
            addCriterion("work_id not between", value1, value2, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIsNull() {
            addCriterion("work_type is null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIsNotNull() {
            addCriterion("work_type is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeEqualTo(Byte value) {
            addCriterion("work_type =", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotEqualTo(Byte value) {
            addCriterion("work_type <>", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeGreaterThan(Byte value) {
            addCriterion("work_type >", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("work_type >=", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLessThan(Byte value) {
            addCriterion("work_type <", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLessThanOrEqualTo(Byte value) {
            addCriterion("work_type <=", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIn(List<Byte> values) {
            addCriterion("work_type in", values, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotIn(List<Byte> values) {
            addCriterion("work_type not in", values, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeBetween(Byte value1, Byte value2) {
            addCriterion("work_type between", value1, value2, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("work_type not between", value1, value2, "workType");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andZanAmountIsNull() {
            addCriterion("zan_amount is null");
            return (Criteria) this;
        }

        public Criteria andZanAmountIsNotNull() {
            addCriterion("zan_amount is not null");
            return (Criteria) this;
        }

        public Criteria andZanAmountEqualTo(Integer value) {
            addCriterion("zan_amount =", value, "zanAmount");
            return (Criteria) this;
        }

        public Criteria andZanAmountNotEqualTo(Integer value) {
            addCriterion("zan_amount <>", value, "zanAmount");
            return (Criteria) this;
        }

        public Criteria andZanAmountGreaterThan(Integer value) {
            addCriterion("zan_amount >", value, "zanAmount");
            return (Criteria) this;
        }

        public Criteria andZanAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("zan_amount >=", value, "zanAmount");
            return (Criteria) this;
        }

        public Criteria andZanAmountLessThan(Integer value) {
            addCriterion("zan_amount <", value, "zanAmount");
            return (Criteria) this;
        }

        public Criteria andZanAmountLessThanOrEqualTo(Integer value) {
            addCriterion("zan_amount <=", value, "zanAmount");
            return (Criteria) this;
        }

        public Criteria andZanAmountIn(List<Integer> values) {
            addCriterion("zan_amount in", values, "zanAmount");
            return (Criteria) this;
        }

        public Criteria andZanAmountNotIn(List<Integer> values) {
            addCriterion("zan_amount not in", values, "zanAmount");
            return (Criteria) this;
        }

        public Criteria andZanAmountBetween(Integer value1, Integer value2) {
            addCriterion("zan_amount between", value1, value2, "zanAmount");
            return (Criteria) this;
        }

        public Criteria andZanAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("zan_amount not between", value1, value2, "zanAmount");
            return (Criteria) this;
        }

        public Criteria andWorkUrlIsNull() {
            addCriterion("work_url is null");
            return (Criteria) this;
        }

        public Criteria andWorkUrlIsNotNull() {
            addCriterion("work_url is not null");
            return (Criteria) this;
        }

        public Criteria andWorkUrlEqualTo(String value) {
            addCriterion("work_url =", value, "workUrl");
            return (Criteria) this;
        }

        public Criteria andWorkUrlNotEqualTo(String value) {
            addCriterion("work_url <>", value, "workUrl");
            return (Criteria) this;
        }

        public Criteria andWorkUrlGreaterThan(String value) {
            addCriterion("work_url >", value, "workUrl");
            return (Criteria) this;
        }

        public Criteria andWorkUrlGreaterThanOrEqualTo(String value) {
            addCriterion("work_url >=", value, "workUrl");
            return (Criteria) this;
        }

        public Criteria andWorkUrlLessThan(String value) {
            addCriterion("work_url <", value, "workUrl");
            return (Criteria) this;
        }

        public Criteria andWorkUrlLessThanOrEqualTo(String value) {
            addCriterion("work_url <=", value, "workUrl");
            return (Criteria) this;
        }

        public Criteria andWorkUrlLike(String value) {
            addCriterion("work_url like", value, "workUrl");
            return (Criteria) this;
        }

        public Criteria andWorkUrlNotLike(String value) {
            addCriterion("work_url not like", value, "workUrl");
            return (Criteria) this;
        }

        public Criteria andWorkUrlIn(List<String> values) {
            addCriterion("work_url in", values, "workUrl");
            return (Criteria) this;
        }

        public Criteria andWorkUrlNotIn(List<String> values) {
            addCriterion("work_url not in", values, "workUrl");
            return (Criteria) this;
        }

        public Criteria andWorkUrlBetween(String value1, String value2) {
            addCriterion("work_url between", value1, value2, "workUrl");
            return (Criteria) this;
        }

        public Criteria andWorkUrlNotBetween(String value1, String value2) {
            addCriterion("work_url not between", value1, value2, "workUrl");
            return (Criteria) this;
        }

        public Criteria andWorkTitleIsNull() {
            addCriterion("work_title is null");
            return (Criteria) this;
        }

        public Criteria andWorkTitleIsNotNull() {
            addCriterion("work_title is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTitleEqualTo(String value) {
            addCriterion("work_title =", value, "workTitle");
            return (Criteria) this;
        }

        public Criteria andWorkTitleNotEqualTo(String value) {
            addCriterion("work_title <>", value, "workTitle");
            return (Criteria) this;
        }

        public Criteria andWorkTitleGreaterThan(String value) {
            addCriterion("work_title >", value, "workTitle");
            return (Criteria) this;
        }

        public Criteria andWorkTitleGreaterThanOrEqualTo(String value) {
            addCriterion("work_title >=", value, "workTitle");
            return (Criteria) this;
        }

        public Criteria andWorkTitleLessThan(String value) {
            addCriterion("work_title <", value, "workTitle");
            return (Criteria) this;
        }

        public Criteria andWorkTitleLessThanOrEqualTo(String value) {
            addCriterion("work_title <=", value, "workTitle");
            return (Criteria) this;
        }

        public Criteria andWorkTitleLike(String value) {
            addCriterion("work_title like", value, "workTitle");
            return (Criteria) this;
        }

        public Criteria andWorkTitleNotLike(String value) {
            addCriterion("work_title not like", value, "workTitle");
            return (Criteria) this;
        }

        public Criteria andWorkTitleIn(List<String> values) {
            addCriterion("work_title in", values, "workTitle");
            return (Criteria) this;
        }

        public Criteria andWorkTitleNotIn(List<String> values) {
            addCriterion("work_title not in", values, "workTitle");
            return (Criteria) this;
        }

        public Criteria andWorkTitleBetween(String value1, String value2) {
            addCriterion("work_title between", value1, value2, "workTitle");
            return (Criteria) this;
        }

        public Criteria andWorkTitleNotBetween(String value1, String value2) {
            addCriterion("work_title not between", value1, value2, "workTitle");
            return (Criteria) this;
        }

        public Criteria andWorkIntroduceIsNull() {
            addCriterion("work_introduce is null");
            return (Criteria) this;
        }

        public Criteria andWorkIntroduceIsNotNull() {
            addCriterion("work_introduce is not null");
            return (Criteria) this;
        }

        public Criteria andWorkIntroduceEqualTo(String value) {
            addCriterion("work_introduce =", value, "workIntroduce");
            return (Criteria) this;
        }

        public Criteria andWorkIntroduceNotEqualTo(String value) {
            addCriterion("work_introduce <>", value, "workIntroduce");
            return (Criteria) this;
        }

        public Criteria andWorkIntroduceGreaterThan(String value) {
            addCriterion("work_introduce >", value, "workIntroduce");
            return (Criteria) this;
        }

        public Criteria andWorkIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("work_introduce >=", value, "workIntroduce");
            return (Criteria) this;
        }

        public Criteria andWorkIntroduceLessThan(String value) {
            addCriterion("work_introduce <", value, "workIntroduce");
            return (Criteria) this;
        }

        public Criteria andWorkIntroduceLessThanOrEqualTo(String value) {
            addCriterion("work_introduce <=", value, "workIntroduce");
            return (Criteria) this;
        }

        public Criteria andWorkIntroduceLike(String value) {
            addCriterion("work_introduce like", value, "workIntroduce");
            return (Criteria) this;
        }

        public Criteria andWorkIntroduceNotLike(String value) {
            addCriterion("work_introduce not like", value, "workIntroduce");
            return (Criteria) this;
        }

        public Criteria andWorkIntroduceIn(List<String> values) {
            addCriterion("work_introduce in", values, "workIntroduce");
            return (Criteria) this;
        }

        public Criteria andWorkIntroduceNotIn(List<String> values) {
            addCriterion("work_introduce not in", values, "workIntroduce");
            return (Criteria) this;
        }

        public Criteria andWorkIntroduceBetween(String value1, String value2) {
            addCriterion("work_introduce between", value1, value2, "workIntroduce");
            return (Criteria) this;
        }

        public Criteria andWorkIntroduceNotBetween(String value1, String value2) {
            addCriterion("work_introduce not between", value1, value2, "workIntroduce");
            return (Criteria) this;
        }

        public Criteria andWorkCoverUrlIsNull() {
            addCriterion("work_cover_url is null");
            return (Criteria) this;
        }

        public Criteria andWorkCoverUrlIsNotNull() {
            addCriterion("work_cover_url is not null");
            return (Criteria) this;
        }

        public Criteria andWorkCoverUrlEqualTo(String value) {
            addCriterion("work_cover_url =", value, "workCoverUrl");
            return (Criteria) this;
        }

        public Criteria andWorkCoverUrlNotEqualTo(String value) {
            addCriterion("work_cover_url <>", value, "workCoverUrl");
            return (Criteria) this;
        }

        public Criteria andWorkCoverUrlGreaterThan(String value) {
            addCriterion("work_cover_url >", value, "workCoverUrl");
            return (Criteria) this;
        }

        public Criteria andWorkCoverUrlGreaterThanOrEqualTo(String value) {
            addCriterion("work_cover_url >=", value, "workCoverUrl");
            return (Criteria) this;
        }

        public Criteria andWorkCoverUrlLessThan(String value) {
            addCriterion("work_cover_url <", value, "workCoverUrl");
            return (Criteria) this;
        }

        public Criteria andWorkCoverUrlLessThanOrEqualTo(String value) {
            addCriterion("work_cover_url <=", value, "workCoverUrl");
            return (Criteria) this;
        }

        public Criteria andWorkCoverUrlLike(String value) {
            addCriterion("work_cover_url like", value, "workCoverUrl");
            return (Criteria) this;
        }

        public Criteria andWorkCoverUrlNotLike(String value) {
            addCriterion("work_cover_url not like", value, "workCoverUrl");
            return (Criteria) this;
        }

        public Criteria andWorkCoverUrlIn(List<String> values) {
            addCriterion("work_cover_url in", values, "workCoverUrl");
            return (Criteria) this;
        }

        public Criteria andWorkCoverUrlNotIn(List<String> values) {
            addCriterion("work_cover_url not in", values, "workCoverUrl");
            return (Criteria) this;
        }

        public Criteria andWorkCoverUrlBetween(String value1, String value2) {
            addCriterion("work_cover_url between", value1, value2, "workCoverUrl");
            return (Criteria) this;
        }

        public Criteria andWorkCoverUrlNotBetween(String value1, String value2) {
            addCriterion("work_cover_url not between", value1, value2, "workCoverUrl");
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