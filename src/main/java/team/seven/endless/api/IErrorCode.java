package team.seven.endless.api;


/**
 * ierror代码
 *
 * @author ben
 * @date 2022/08/29
 */
public interface IErrorCode {
    /**
     * 返回码
     */
    long getCode();

    /**
     * 返回信息
     */
    String getMessage();
}
