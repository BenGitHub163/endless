package team.seven.endless;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import team.seven.endless.dto.UpdateElUserBirthdayParam;
import team.seven.endless.enums.EmailCodeEnum;
import team.seven.endless.service.serviceImpl.ElUserServiceImpl;
import team.seven.endless.service.serviceImpl.EmailServiceImpl;
import team.seven.endless.service.serviceImpl.RedisServiceImpl;
import team.seven.endless.vo.ElUserRegisterVo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO
 *
 * @author ben
 * @version 1.0
 * @date 2022/10/7 15:32
 */
@SpringBootTest
public class ElUserTest {
    @Autowired
    private ElUserServiceImpl elUserService;
    @Autowired
    EmailServiceImpl emailService;

    @Autowired
    RedisServiceImpl redisService;

    @Test
    public void testUpdateBirthday(){
//        UpdateElUserBirthdayParam param = new UpdateElUserBirthdayParam();
//        param.setAccount("zbh_manager");
//        elUserService.updateBirthday()
    }

    @Test
    public void testRegister(){
        ElUserRegisterVo vo = new ElUserRegisterVo();

        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
        Date birthday = null;
        try {
            birthday = sdf.parse("2002-12-4");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        vo.setAccount("xsl_manager");
        vo.setPassword("123456");
        vo.setNickname("徐肃磊");
        vo.setEMail("1796228812@qq.com");
        vo.setSex((byte) 1);
        vo.setBirthday(birthday);
        String redisKey = EmailCodeEnum.VERIFICATION_CODE.getKey() + vo.getEMail();
//        elUserService.sendRegisterCaptcha(vo.getEMaill());
//        System.out.println(redisService.get(redisKey)==null);
        vo.setCaptcha(redisService.get(redisKey).toString());
        elUserService.register(vo);
    }
}

