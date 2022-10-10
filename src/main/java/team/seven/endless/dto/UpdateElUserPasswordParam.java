package team.seven.endless.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * 修改用户名密码参数
 *
 * @author ben
 * @date 2022/09/19
 */
@Getter
@Setter
public class UpdateElUserPasswordParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty
    private String account;
//    @NotEmpty
//    private String oldPassword;
    @NotEmpty
    private String newPassword;
}
