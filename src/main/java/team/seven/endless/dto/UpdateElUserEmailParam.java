package team.seven.endless.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import java.io.Serializable;

/**
 * TODO
 *
 * @author ben
 * @version 1.0
 * @date 2022/10/5 10:47
 */
@Getter
@Setter
public class UpdateElUserEmailParam implements Serializable {
    private static final long serialVersionUID = 1L;
    private String account;
    @Email
    private String Email;
}
