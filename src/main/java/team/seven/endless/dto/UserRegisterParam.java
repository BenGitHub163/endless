package team.seven.endless.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * 用户注册参数
 *
 * @author ben
 * @date 2022/07/30
 */
@Getter
@Setter
public class UserRegisterParam {
    @NotEmpty
    private String uid;
    @NotEmpty
    private String password;
    private byte sex;
    private String nickname;
    private String sno;
}
