package team.seven.endless.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * 用户登录参数
 *
 * @author ben
 * @date 2022/07/30
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ElUserLoginVo implements Serializable {
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
}
