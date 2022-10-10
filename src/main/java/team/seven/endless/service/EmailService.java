package team.seven.endless.service;


import team.seven.endless.vo.EmailConfig;
import team.seven.endless.vo.EmailVo;

/**
 * @Classname EmailService
 * @Description TODO
 * @Date 2021/8/20 17:37
 * @Created by 陶其
 */
public interface EmailService {

    /**
     * 发送邮件
     * @param emailVo 邮件发送的内容
     * @param emailConfig 邮件配置，null:使用默认配置
     * @throws Exception /
     */
    void send(EmailVo emailVo, EmailConfig emailConfig);

    /**
     * 获取验证码邮件签证官
     * 获取验证码的邮件参数类
     *
     * @param toEmail 目标邮箱
     * @return {@link EmailVo}
     */
    EmailVo getVerificationCodeEmailVo(String toEmail);

    /**
     * 简单通知邮件签证官
     * 获取简单通知的邮件参数类
     *
     * @param toEmail 目标邮箱
     * @param msg     味精
     * @return {@link EmailVo}
     */
    EmailVo getSimpleNotificationEmailVo(String toEmail, String msg);

}
