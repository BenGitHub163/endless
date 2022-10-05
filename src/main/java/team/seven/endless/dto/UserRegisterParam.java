package team.seven.endless.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * 用户注册参数
 *
 * @author ben
 * @date 2022/07/30
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class UserRegisterParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotEmpty
    private String account;
    @NotEmpty
    private String password;
    private byte sex;
    private String nickname;
    private String sno;
}
