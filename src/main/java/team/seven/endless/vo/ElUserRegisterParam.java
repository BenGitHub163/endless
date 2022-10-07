package team.seven.endless.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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
public class ElUserRegisterParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotEmpty
    private String account;
    @NotEmpty
    private String password;
    private String nickname;
    @Email
    private String eMaill;
    private byte sex;
    private Date birthday;
    private String sno;
}
