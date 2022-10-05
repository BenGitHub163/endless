package team.seven.endless.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * TODO
 *
 * @author ben
 * @version 1.0
 * @date 2022/10/5 10:54
 */
@Getter
@Setter
public class UpdateElUserAvatarParam implements Serializable {
    private String account;
    private MultipartFile avatar;
}
