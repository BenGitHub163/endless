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
    @NotEmpty
    private String account;
    @NotEmpty
    private String password;
    @NotEmpty
    private String nickname;
    @NotEmpty
    @Email
    private String eMail;
    @NotEmpty
    private byte sex;
    @DateTimeFormat
    private Date birthday;
    @NotEmpty
    private String captcha;
}
