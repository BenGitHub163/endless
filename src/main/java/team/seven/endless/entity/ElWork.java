package team.seven.endless.entity;

import java.io.Serializable;
import java.util.Date;

public class ElWork implements Serializable {
    private Long workId;

    private Byte workType;

    private Long userId;

    private Integer zanAmount;

    private String workUrl;

    private String workTitle;

    private String workIntroduce;

    private String workCoverUrl;

    private Boolean isDeleted;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getWorkId() {
        return workId;
    }

    public void setWorkId(Long workId) {
        this.workId = workId;
    }

    public Byte getWorkType() {
        return workType;
    }

    public void setWorkType(Byte workType) {
        this.workType = workType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getZanAmount() {
        return zanAmount;
    }

    public void setZanAmount(Integer zanAmount) {
        this.zanAmount = zanAmount;
    }

    public String getWorkUrl() {
        return workUrl;
    }

    public void setWorkUrl(String workUrl) {
        this.workUrl = workUrl == null ? null : workUrl.trim();
    }

    public String getWorkTitle() {
        return workTitle;
    }

    public void setWorkTitle(String workTitle) {
        this.workTitle = workTitle == null ? null : workTitle.trim();
    }

    public String getWorkIntroduce() {
        return workIntroduce;
    }

    public void setWorkIntroduce(String workIntroduce) {
        this.workIntroduce = workIntroduce == null ? null : workIntroduce.trim();
    }

    public String getWorkCoverUrl() {
        return workCoverUrl;
    }

    public void setWorkCoverUrl(String workCoverUrl) {
        this.workCoverUrl = workCoverUrl == null ? null : workCoverUrl.trim();
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", workId=").append(workId);
        sb.append(", workType=").append(workType);
        sb.append(", userId=").append(userId);
        sb.append(", zanAmount=").append(zanAmount);
        sb.append(", workUrl=").append(workUrl);
        sb.append(", workTitle=").append(workTitle);
        sb.append(", workIntroduce=").append(workIntroduce);
        sb.append(", workCoverUrl=").append(workCoverUrl);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}