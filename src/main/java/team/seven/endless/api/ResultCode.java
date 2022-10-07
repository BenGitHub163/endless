package team.seven.endless.api;

/**
 * @author ben
 * @date 2022/08/29
 */
public enum ResultCode implements IErrorCode {

    /**
     * 成功
     */
    SUCCESS(200, "操作成功"),
    /**
     * 失败
     */
    FAILED(500, "操作失败"),
    /**
     * 验证失败
     */
    VALIDATE_FAILED(404, "参数检验失败"),
    /**
     * 未经授权
     */
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    /**
     * 被禁止
     */
    FORBIDDEN(403, "没有相关权限");
    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
