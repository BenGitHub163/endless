package team.seven.endless.service.serviceImpl;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.extra.mail.Mail;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import io.lettuce.core.RedisException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import team.seven.endless.enums.EmailCodeEnum;
import team.seven.endless.exception.BadConfigurationException;
import team.seven.endless.exception.BadRequestException;
import team.seven.endless.service.EmailService;
import team.seven.endless.service.RedisService;
import team.seven.endless.vo.EmailConfig;
import team.seven.endless.vo.EmailVo;

import java.util.Collections;


/**
 * @author ben
 * @date 2022/10/06
 */
@Service
public class EmailServiceImpl implements EmailService {

    /**
     * 验证码有效时长(秒)
     */
    @Value("${verification.expiration-time}")
    private Long expirationTime;

    @Autowired
    RedisService redisService;

    @Autowired
    private EmailConfig defaultConfig;

    @Override
    @Async // 发送邮件为异步执行
    @Transactional(rollbackFor = Exception.class)
    public void send(EmailVo emailVo, EmailConfig emailConfig) {
        if(emailConfig == null) {
            emailConfig = defaultConfig;
        } else if (StringUtils.hasLength(emailConfig.getHost()) || StringUtils.hasLength(emailConfig.getPort())
                || StringUtils.hasLength(emailConfig.getFrom()) || StringUtils.hasLength(emailConfig.getPass())
                || StringUtils.hasLength(emailConfig.getUser())) {
            throw new BadConfigurationException("请先配置邮箱数据，再操作!");
        }

        MailAccount account = new MailAccount();
        // 发件人昵称
        account.setFrom(emailConfig.getFrom());
        // 发件人邮箱地址
        account.setUser(emailConfig.getUser());
        account.setHost(emailConfig.getHost());
        account.setPort(Integer.parseInt(emailConfig.getPort()));

        account.setAuth(true);
        account.setPass(emailConfig.getPass());

        // ssl 方式发送
        account.setSslEnable(true);
        // 使用STARTTLS 安全连接
        account.setStarttlsEnable(true);
        // 发送
        try {
           int size = emailVo.getTos().size();
            Mail.create(account)
                    .setTos(emailVo.getTos().toArray(new String[size]))
                    .setTitle(emailVo.getSubject())
                    .setContent(emailVo.getContent())
                    .setHtml(true)
                    // 关闭session
                    .setUseGlobalSession(false)
                    .send();
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public EmailVo getVerificationCodeEmailVo(String toEmail) {
        String content;
        String redisKey = EmailCodeEnum.VERIFICATION_CODE.getKey() + toEmail;

        TemplateEngine engine = TemplateUtil.createEngine(new TemplateConfig("templates", TemplateConfig.ResourceMode.CLASSPATH));
        Template template = engine.getTemplate("email/verificationCode.ftlh");
        Object oldCode = redisService.get(redisKey);
//        Object oldCode = null;
        // 如果不存在有效验证码，就创建一个新的
        // 存在就使用原来的验证码，并将有效期更新
        if (oldCode == null) {
            String code = RandomUtil.randomNumbers(6);
            // 存入缓存
            boolean saveResult = redisService.set(redisKey, code, expirationTime);
            if(!saveResult) {
                throw new RedisException("Redis服务异常! 验证码未保存成功!");
            }
            content = template.render(Dict.create().set("code", code));
        } else {
            redisService.expire(redisKey, expirationTime);
            content = template.render(Dict.create().set("code", oldCode));
        }
        return new EmailVo(Collections.singletonList(toEmail), "Hutool-" + EmailCodeEnum.VERIFICATION_CODE.getDescription(), content);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public EmailVo getSimpleNotificationEmailVo(String toEmail, String msg) {
        String redisKey = EmailCodeEnum.VERIFICATION_CODE.getKey() + toEmail;
        TemplateEngine engine = TemplateUtil.createEngine(new TemplateConfig("templates", TemplateConfig.ResourceMode.CLASSPATH));
        Template template = engine.getTemplate("email/simple_notification.ftlh");
        String content = template.render(Dict.create().set("msg", msg));
        return new EmailVo(Collections.singletonList(toEmail), "Hutool-" + EmailCodeEnum.NOTIFICATION.getDescription(), content);
    }
}
