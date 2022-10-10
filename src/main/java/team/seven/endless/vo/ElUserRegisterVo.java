package team.seven.endless.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户注册参数
 *
 * @author ben
 * @date 2022/07/30
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ElUserRegisterVo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 账号
     */
    @NotEmpty
    private String account;
    /**
     * 密码
     */
    @NotEmpty
    private String password;
    /**
     * 昵称
     */
    @NotEmpty
    private String nickname;
    /**
     * 电子邮件
     */
    @NotEmpty
    @Email
    private String eMail;
    /**
     * 性别
     */
    @NotEmpty
    private byte sex;
    /**
     * 生日
     */
    @DateTimeFormat
    private Date birthday;
    /**
     * 验证码
     */
    @NotEmpty
    private String captcha;
}
