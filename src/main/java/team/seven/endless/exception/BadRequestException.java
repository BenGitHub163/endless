package team.seven.endless.exception;

import org.springframework.http.HttpStatus;


/**
 * 错误请求异常
 *
 * @author ben
 * @date 2022/10/06
 */
public class BadRequestException extends RuntimeException{

    private Integer status = HttpStatus.BAD_REQUEST.value();

    public BadRequestException(String msg) {
        super(msg);
    }

    public BadRequestException(HttpStatus status, String msg) {
        super(msg);
        this.status = status.value();
    }

}
