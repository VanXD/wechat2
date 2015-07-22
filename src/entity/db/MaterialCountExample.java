package entity.db;

import java.util.ArrayList;
import java.util.List;

public class MaterialCountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MaterialCountExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andVoice_countIsNull() {
            addCriterion("voice_count is null");
            return (Criteria) this;
        }

        public Criteria andVoice_countIsNotNull() {
            addCriterion("voice_count is not null");
            return (Criteria) this;
        }

        public Criteria andVoice_countEqualTo(Integer value) {
            addCriterion("voice_count =", value, "voice_count");
            return (Criteria) this;
        }

        public Criteria andVoice_countNotEqualTo(Integer value) {
            addCriterion("voice_count <>", value, "voice_count");
            return (Criteria) this;
        }

        public Criteria andVoice_countGreaterThan(Integer value) {
            addCriterion("voice_count >", value, "voice_count");
            return (Criteria) this;
        }

        public Criteria andVoice_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("voice_count >=", value, "voice_count");
            return (Criteria) this;
        }

        public Criteria andVoice_countLessThan(Integer value) {
            addCriterion("voice_count <", value, "voice_count");
            return (Criteria) this;
        }

        public Criteria andVoice_countLessThanOrEqualTo(Integer value) {
            addCriterion("voice_count <=", value, "voice_count");
            return (Criteria) this;
        }

        public Criteria andVoice_countIn(List<Integer> values) {
            addCriterion("voice_count in", values, "voice_count");
            return (Criteria) this;
        }

        public Criteria andVoice_countNotIn(List<Integer> values) {
            addCriterion("voice_count not in", values, "voice_count");
            return (Criteria) this;
        }

        public Criteria andVoice_countBetween(Integer value1, Integer value2) {
            addCriterion("voice_count between", value1, value2, "voice_count");
            return (Criteria) this;
        }

        public Criteria andVoice_countNotBetween(Integer value1, Integer value2) {
            addCriterion("voice_count not between", value1, value2, "voice_count");
            return (Criteria) this;
        }

        public Criteria andVideo_countIsNull() {
            addCriterion("video_count is null");
            return (Criteria) this;
        }

        public Criteria andVideo_countIsNotNull() {
            addCriterion("video_count is not null");
            return (Criteria) this;
        }

        public Criteria andVideo_countEqualTo(Integer value) {
            addCriterion("video_count =", value, "video_count");
            return (Criteria) this;
        }

        public Criteria andVideo_countNotEqualTo(Integer value) {
            addCriterion("video_count <>", value, "video_count");
            return (Criteria) this;
        }

        public Criteria andVideo_countGreaterThan(Integer value) {
            addCriterion("video_count >", value, "video_count");
            return (Criteria) this;
        }

        public Criteria andVideo_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("video_count >=", value, "video_count");
            return (Criteria) this;
        }

        public Criteria andVideo_countLessThan(Integer value) {
            addCriterion("video_count <", value, "video_count");
            return (Criteria) this;
        }

        public Criteria andVideo_countLessThanOrEqualTo(Integer value) {
            addCriterion("video_count <=", value, "video_count");
            return (Criteria) this;
        }

        public Criteria andVideo_countIn(List<Integer> values) {
            addCriterion("video_count in", values, "video_count");
            return (Criteria) this;
        }

        public Criteria andVideo_countNotIn(List<Integer> values) {
            addCriterion("video_count not in", values, "video_count");
            return (Criteria) this;
        }

        public Criteria andVideo_countBetween(Integer value1, Integer value2) {
            addCriterion("video_count between", value1, value2, "video_count");
            return (Criteria) this;
        }

        public Criteria andVideo_countNotBetween(Integer value1, Integer value2) {
            addCriterion("video_count not between", value1, value2, "video_count");
            return (Criteria) this;
        }

        public Criteria andImage_countIsNull() {
            addCriterion("image_count is null");
            return (Criteria) this;
        }

        public Criteria andImage_countIsNotNull() {
            addCriterion("image_count is not null");
            return (Criteria) this;
        }

        public Criteria andImage_countEqualTo(Integer value) {
            addCriterion("image_count =", value, "image_count");
            return (Criteria) this;
        }

        public Criteria andImage_countNotEqualTo(Integer value) {
            addCriterion("image_count <>", value, "image_count");
            return (Criteria) this;
        }

        public Criteria andImage_countGreaterThan(Integer value) {
            addCriterion("image_count >", value, "image_count");
            return (Criteria) this;
        }

        public Criteria andImage_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("image_count >=", value, "image_count");
            return (Criteria) this;
        }

        public Criteria andImage_countLessThan(Integer value) {
            addCriterion("image_count <", value, "image_count");
            return (Criteria) this;
        }

        public Criteria andImage_countLessThanOrEqualTo(Integer value) {
            addCriterion("image_count <=", value, "image_count");
            return (Criteria) this;
        }

        public Criteria andImage_countIn(List<Integer> values) {
            addCriterion("image_count in", values, "image_count");
            return (Criteria) this;
        }

        public Criteria andImage_countNotIn(List<Integer> values) {
            addCriterion("image_count not in", values, "image_count");
            return (Criteria) this;
        }

        public Criteria andImage_countBetween(Integer value1, Integer value2) {
            addCriterion("image_count between", value1, value2, "image_count");
            return (Criteria) this;
        }

        public Criteria andImage_countNotBetween(Integer value1, Integer value2) {
            addCriterion("image_count not between", value1, value2, "image_count");
            return (Criteria) this;
        }

        public Criteria andNews_countIsNull() {
            addCriterion("news_count is null");
            return (Criteria) this;
        }

        public Criteria andNews_countIsNotNull() {
            addCriterion("news_count is not null");
            return (Criteria) this;
        }

        public Criteria andNews_countEqualTo(Integer value) {
            addCriterion("news_count =", value, "news_count");
            return (Criteria) this;
        }

        public Criteria andNews_countNotEqualTo(Integer value) {
            addCriterion("news_count <>", value, "news_count");
            return (Criteria) this;
        }

        public Criteria andNews_countGreaterThan(Integer value) {
            addCriterion("news_count >", value, "news_count");
            return (Criteria) this;
        }

        public Criteria andNews_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("news_count >=", value, "news_count");
            return (Criteria) this;
        }

        public Criteria andNews_countLessThan(Integer value) {
            addCriterion("news_count <", value, "news_count");
            return (Criteria) this;
        }

        public Criteria andNews_countLessThanOrEqualTo(Integer value) {
            addCriterion("news_count <=", value, "news_count");
            return (Criteria) this;
        }

        public Criteria andNews_countIn(List<Integer> values) {
            addCriterion("news_count in", values, "news_count");
            return (Criteria) this;
        }

        public Criteria andNews_countNotIn(List<Integer> values) {
            addCriterion("news_count not in", values, "news_count");
            return (Criteria) this;
        }

        public Criteria andNews_countBetween(Integer value1, Integer value2) {
            addCriterion("news_count between", value1, value2, "news_count");
            return (Criteria) this;
        }

        public Criteria andNews_countNotBetween(Integer value1, Integer value2) {
            addCriterion("news_count not between", value1, value2, "news_count");
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