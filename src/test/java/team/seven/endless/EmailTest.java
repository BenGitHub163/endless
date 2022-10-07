package team.seven.endless;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import team.seven.endless.service.serviceImpl.EmailServiceImpl;
import team.seven.endless.vo.EmailVo;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author ben
 * @version 1.0
 * @date 2022/10/6 17:09
 */
@SpringBootTest
public class EmailTest {
    @Autowired
    EmailServiceImpl emailService;

    @Test
    public void testSendEmail(){
        List<String> tos = new ArrayList<>();
//        tos.add("841540110@qq.com");
//        tos.add("20767723218@qq.com");
//        tos.add("1796228812@qq.com");
        tos.add("2365969940@qq.com");
        EmailVo e = new EmailVo(tos,"testSendEmail","呦，这不是小菲菲嘛！");
        for (int i = 0; i < 100; i++) {
            emailService.send(e,null);
            System.out.println(i);
        }
        emailService.send(e,null);
//        emailService.send(e,null);
//        emailService.send(e,null);
//        emailService.send(e,null);
//        e = emailService.getVerificationCodeEmailVo("1796228812@qq.com");
//        emailService.send(e,null);
//        e = emailService.getVerificationCodeEmailVo("20767723218@qq.com");
//        emailService.send(e,null);
//        e = emailService.getVerificationCodeEmailVo("841540110@qq.com");
//        emailService.send(e,null);
//        e = emailService.getVerificationCodeEmailVo("2273312864@qq.com");
//        emailService.send(e,null);
//        e = emailService.getVerificationCodeEmailVo("3202989907@qq.com");
//        emailService.send(e,null);
//        e = emailService.getVerificationCodeEmailVo("3202989907@qq.com");
//        emailService.send(e,null);
//        e = emailService.getVerificationCodeEmailVo("3202989907@qq.com");
//        emailService.send(e,null);
//        e = emailService.getVerificationCodeEmailVo("3202989907@qq.com");
//        emailService.send(e,null);
//        e = emailService.getVerificationCodeEmailVo("3202989907@qq.com");
//        emailService.send(e,null);
//        e = emailService.getVerificationCodeEmailVo("3202989907@qq.com");
//        emailService.send(e,null);
//        e = emailService.getVerificationCodeEmailVo("1796228812@qq.com");
//        for(int i = 0 ; i< 100;i++){
//            emailService.send(e,null);
//        }
    }
}
