package team.seven.endless.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * TODO
 *
 * @author ben
 * @version 1.0
 * @date 2022/10/5 11:12
 */
@Getter
@Setter
public class UpdateElUserSexParam implements Serializable {
    private static final long serialVersionUID = 1L;
    private String account;
    private Byte sex;
}
