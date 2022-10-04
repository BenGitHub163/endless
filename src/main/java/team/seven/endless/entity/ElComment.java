package team.seven.endless.entity;

import java.io.Serializable;
import java.util.Date;

public class ElComment implements Serializable {
    private Long commentId;

    private Long userId;

    private Byte commentType;

    private Long commentedUserId;

    private Long commentedWorkId;

    private String commentContent;

    private Boolean isDeleted;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Byte getCommentType() {
        return commentType;
    }

    public void setCommentType(Byte commentType) {
        this.commentType = commentType;
    }

    public Long getCommentedUserId() {
        return commentedUserId;
    }

    public void setCommentedUserId(Long commentedUserId) {
        this.commentedUserId = commentedUserId;
    }

    public Long getCommentedWorkId() {
        return commentedWorkId;
    }

    public void setCommentedWorkId(Long commentedWorkId) {
        this.commentedWorkId = commentedWorkId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
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
        sb.append(", commentId=").append(commentId);
        sb.append(", userId=").append(userId);
        sb.append(", commentType=").append(commentType);
        sb.append(", commentedUserId=").append(commentedUserId);
        sb.append(", commentedWorkId=").append(commentedWorkId);
        sb.append(", commentContent=").append(commentContent);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}