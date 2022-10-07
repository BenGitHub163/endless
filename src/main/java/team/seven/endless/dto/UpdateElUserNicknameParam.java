package team.seven.endless.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * TODO
 *
 * @author ben
 * @version 1.0
 * @date 2022/10/5 10:21
 */
@Getter
@Setter
public class UpdateElUserNicknameParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotEmpty
    private String account;
    @NotEmpty
    private String newNickname;

}
