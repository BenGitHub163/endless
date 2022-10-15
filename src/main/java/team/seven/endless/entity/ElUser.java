package team.seven.endless.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * el用户
 *
 * @author ben
 * @date 2022/10/15
 */
public class ElUser implements Serializable {
    private Long userId;

    private String account;

    private String password;

    private String nickname;

    private String eMail;

    private Byte userRole;

    private String avatarUrl;

    private Byte sex;

    private Date birthday;

    private String perSign;

    private Integer rewardsPoints;

    private Integer exp;

    private String telPhone;

    private Byte userState;

    private Date recentLoginTime;

    private String recentLoginIp;

    private Boolean isDeleted;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail == null ? null : eMail.trim();
    }

    public Byte getUserRole() {
        return userRole;
    }

    public void setUserRole(Byte userRole) {
        this.userRole = userRole;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPerSign() {
        return perSign;
    }

    public void setPerSign(String perSign) {
        this.perSign = perSign == null ? null : perSign.trim();
    }

    public Integer getRewardsPoints() {
        return rewardsPoints;
    }

    public void setRewardsPoints(Integer rewardsPoints) {
        this.rewardsPoints = rewardsPoints;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone == null ? null : telPhone.trim();
    }

    public Byte getUserState() {
        return userState;
    }

    public void setUserState(Byte userState) {
        this.userState = userState;
    }

    public Date getRecentLoginTime() {
        return recentLoginTime;
    }

    public void setRecentLoginTime(Date recentLoginTime) {
        this.recentLoginTime = recentLoginTime;
    }

    public String getRecentLoginIp() {
        return recentLoginIp;
    }

    public void setRecentLoginIp(String recentLoginIp) {
        this.recentLoginIp = recentLoginIp == null ? null : recentLoginIp.trim();
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
        sb.append(", userId=").append(userId);
        sb.append(", account=").append(account);
        sb.append(", password=").append(password);
        sb.append(", nickname=").append(nickname);
        sb.append(", eMail=").append(eMail);
        sb.append(", userRole=").append(userRole);
        sb.append(", avatarUrl=").append(avatarUrl);
        sb.append(", sex=").append(sex);
        sb.append(", birthday=").append(birthday);
        sb.append(", perSign=").append(perSign);
        sb.append(", rewardsPoints=").append(rewardsPoints);
        sb.append(", exp=").append(exp);
        sb.append(", telPhone=").append(telPhone);
        sb.append(", userState=").append(userState);
        sb.append(", recentLoginTime=").append(recentLoginTime);
        sb.append(", recentLoginIp=").append(recentLoginIp);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}