package team.seven.endless.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * TODO
 *
 * @author ben
 * @version 1.0
 * @date 2022/10/10 14:07
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class ElWorkVo implements Serializable {
    private Long workId;

    private Byte workType;

    private Long userId;

    private Integer zanAmount;

    private String workUrl;

    private String workTitle;

    private String workIntroduce;

    private String workCoverUrl;

}
