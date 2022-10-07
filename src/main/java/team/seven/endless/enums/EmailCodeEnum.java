package team.seven.endless.enums;

/**
 * @Classname CodeEnum
 * @Description TODO
 * @Date 2021/8/26 22:06
 * @Created by 陶其
 */
public enum EmailCodeEnum {

    /* 验证码 */
    VERIFICATION_CODE("verification_code_", "验证码"),
    /* 通知 */
    NOTIFICATION("natification_", "通知");

    private final String key;
    private final String description;

    EmailCodeEnum(String key, String description) {
        this.key = key;
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }
}
