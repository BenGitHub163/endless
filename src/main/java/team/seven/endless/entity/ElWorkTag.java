package team.seven.endless.entity;

import java.io.Serializable;
import java.util.Date;

public class ElWorkTag implements Serializable {
    private Long workTagId;

    private String workTagName;

    private String workTagDescri;

    private Boolean isDeleted;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getWorkTagId() {
        return workTagId;
    }

    public void setWorkTagId(Long workTagId) {
        this.workTagId = workTagId;
    }

    public String getWorkTagName() {
        return workTagName;
    }

    public void setWorkTagName(String workTagName) {
        this.workTagName = workTagName == null ? null : workTagName.trim();
    }

    public String getWorkTagDescri() {
        return workTagDescri;
    }

    public void setWorkTagDescri(String workTagDescri) {
        this.workTagDescri = workTagDescri == null ? null : workTagDescri.trim();
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
        sb.append(", workTagId=").append(workTagId);
        sb.append(", workTagName=").append(workTagName);
        sb.append(", workTagDescri=").append(workTagDescri);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}