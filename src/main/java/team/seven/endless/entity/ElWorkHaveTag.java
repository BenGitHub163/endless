package team.seven.endless.entity;

import java.io.Serializable;
import java.util.Date;

public class ElWorkHaveTag implements Serializable {
    private Long haveId;

    private Long workTagId;

    private Long workId;

    private Boolean isDeleted;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getHaveId() {
        return haveId;
    }

    public void setHaveId(Long haveId) {
        this.haveId = haveId;
    }

    public Long getWorkTagId() {
        return workTagId;
    }

    public void setWorkTagId(Long workTagId) {
        this.workTagId = workTagId;
    }

    public Long getWorkId() {
        return workId;
    }

    public void setWorkId(Long workId) {
        this.workId = workId;
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
        sb.append(", haveId=").append(haveId);
        sb.append(", workTagId=").append(workTagId);
        sb.append(", workId=").append(workId);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}