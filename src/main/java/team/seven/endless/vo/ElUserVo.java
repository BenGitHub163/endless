package team.seven.endless.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO
 *
 * @author ben
 * @version 1.0
 * @date 2022/10/8 15:18
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class ElUserVo  implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 账号
     */
    private String account;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 电子邮件
     */
    private String eMail;

    /**
     * 用户角色
     */
    private Byte userRole;

    /**
     * 头像url
     */
    private String avatarUrl;

    /**
     * 性别
     */
    private Byte sex;

    /**
     * 生日
     */
    private Date birthday;

    private String perSign;

    private Integer rewardsPoints;

    private Integer exp;

    private String telPhone;

    private Byte userState;

    private Date recentLoginTime;

    private String recentLoginIp;
}
