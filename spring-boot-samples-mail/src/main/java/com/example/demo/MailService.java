package com.example.demo;

import org.thymeleaf.context.Context;

/**
 * Created by HUXU on 2017/8/2.
 */
public interface MailService {

    //发送普通邮件
    void sendSimpleMail(String to, String subject, String content);

    //发送html格式邮件
    void sendHtmlMail(String to, String subject, String content);

    //发送带附件的邮件
    void sendAttachmentsMail(String to, String subject, String content, String filePath);

    //发送带静态资源的邮件
    void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);

    //发送模板邮件
    void sendTemplateMail(String to, String subject, Context context, String template);
}
