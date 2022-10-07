package team.seven.endless.util.email.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname EmailController
 * @Description
 * @Date 2021/8/20 17:29
 * @Created by 陶其
 */
@RestController
@RequestMapping("api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    /**
     * 发送邮件
     * @param toEmail 目标邮箱
     * @param subject 邮件标题
     * @param content 邮件内容
     * @return
     */
    @PostMapping("/sendMail")
    public String SendEmail(@RequestParam String toEmail, @RequestParam String subject, @RequestParam String content){
        if(StringUtils.isBlank(toEmail)) {
            throw  new BadRequestException("目标邮箱不能为空！");
        }
        if(StringUtils.isBlank(subject)) {
            throw new BadRequestException("邮件标题不能为空！");
        }
        if(StringUtils.isBlank(content)) {
            throw new BadRequestException("邮件内容不能为空！");
        }
        List<String> toEmails = new ArrayList<>();
        toEmails.add(toEmail);
        EmailVo emailVo = new EmailVo(toEmails, subject, content);
        emailService.send(emailVo, null);
        return "邮件已发送！";
    }

    /**
     * 发送验证码
     * @param toEmail 目标邮箱
     * @return
     */
    @PostMapping("/sendVerificationCode")
    public String SendVerificationCode(@RequestParam String toEmail) {
        EmailVo emailVo = emailService.getVerificationCodeEmailVo(toEmail);
        emailService.send(emailVo, null);
        return "邮件已发送！";
    }

    /**
     * 发送验证码
     * @param toEmail 目标邮箱
     * @param msg 通知的信息
     * @return
     */
    @PostMapping("/sendSimpleNotification")
    public String SendSimpleNotification(@RequestParam String toEmail, @RequestParam String msg) {
        if(StringUtils.isBlank(msg)) {
            throw new BadRequestException("通知信息为空！");
        }
        EmailVo emailVo = emailService.getSimpleNotificationEmailVo(toEmail, msg);
        emailService.send(emailVo, null);
        return "邮件已发送！";
    }

}
