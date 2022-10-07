package team.seven.endless.vo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;


/**
 * 电子邮件配置元数据
 *
 * @author ben
 * @date 2022/10/06
 */
@Component
@ConfigurationProperties(prefix = EmailConfig.EMAIL_PREFIX)
public class EmailConfig implements Serializable {
    static final String EMAIL_PREFIX = "email";

    /**
     * 发送方 邮件服务器 SMTP 地址
     */
    private String host;

    /**
     * 发送方 邮件服务器 SMTP 端口
     */
    private String port;

    /**
     * 发送方 昵称
     */
    private String from;

    /**
     * 发送方 密码
     */
    private String pass;

    /**
     * 发送方 邮箱地址
     */
    private String user;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "EmailConfig{" +
                "host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", from='" + from + '\'' +
                ", pass='" + pass + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
