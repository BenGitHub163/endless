package team.seven.endless.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * TODO
 *
 * @author ben
 * @version 1.0
 * @date 2022/10/5 11:13
 */
@Getter
@Setter
public class UpdateElUserBirthdayParam implements Serializable {
    private static final long serialVersionUID = 1L;
    private String account;
//    private int year;
//    private int mouth;
//    private int day;
    @DateTimeFormat
    private Date birthday;
}
