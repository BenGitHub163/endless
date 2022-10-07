package team.seven.endless.vo;

import java.util.List;


/**
 * 发送邮件时，接收参数的类
 *
 * @author ben
 * @date 2022/10/06
 */
public class EmailVo {
    /**
     * 收件人，支持多个收件人
     */
    private List<String> tos;

    /**
     * 主题
     */
    private String subject;

    /**
     * 内容
     */
    private String content;

    public EmailVo() {
    }

    public EmailVo(List<String> tos, String subject, String content) {
        this.tos = tos;
        this.subject = subject;
        this.content = content;
    }

    public List<String> getTos() {
        return tos;
    }

    public void setTos(List<String> tos) {
        this.tos = tos;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
