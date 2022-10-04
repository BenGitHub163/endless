package team.seven.endless.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * 用户登录参数
 *
 * @author ben
 * @date 2022/07/30
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class UserLoginParam {
    @NotEmpty
    private String uid;
    @NotEmpty
    private String password;
}
