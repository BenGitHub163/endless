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

    private String account;

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
}
