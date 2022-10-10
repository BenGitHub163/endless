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
    /**
     * 作品id
     */
    private Long workId;

    /**
     * 作品类型
     */
    private Byte workType;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 赞数
     */
    private Integer zanAmount;

    /**
     * 作品url
     */
    private String workUrl;

    /**
     * 作品标题
     */
    private String workTitle;

    /**
     * 作品介绍
     */
    private String workIntroduce;

    /**
     * 作品封面url
     */
    private String workCoverUrl;

}
