package com.boothmanagement.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * com.gxa.utils.EmailUtils
 * User: hly
 * Date: 2024/11/26 16:00
 * motto:   逆水行舟不进则退
 * Description:
 * Version: v1.0
 */
public class EmailUtils {
    /**
     * 发件⼈邮箱密码 - 登录邮件开启 SMTP 服务后，邮件服务商⽣成的“授权码”
     */
    public static final String authorizeCode = "ujrnybiseddhdggb";  //这个账号的的授权码

    /**
     * 发件⼈SMTP服务器地址，⼀般的格式为：smtp.xxx.com，其中xxx为邮件服务商名称
     */
    public static final String smtpHost = "smtp.qq.com";

    public  static  final  String  sendEmail="2940634257@qq.com";//自己或公司 邮箱账号
    public  static  final  String  sendName="国信安";//自己或公司 邮箱账号

    /**
     * 协议
     */
    public static final String protocol = "smtp";

    //发送邮件代码
    public static boolean sendAuthCodeEmail(String email,String title,String context) {
        try {
            SimpleEmail mail = new SimpleEmail();
            mail.setHostName("smtp.qq.com");//发送邮件的服务器
            mail.setAuthentication(sendEmail,authorizeCode);//刚刚记录的授权码，是开启SMTP的密码
            mail.setFrom(sendEmail,sendName);  //发送邮件的邮箱和发件人
            mail.setSSLOnConnect(true); //使用安全链接
            mail.addTo(email);//接收的邮箱
            mail.setSubject(title);//设置邮件的主题
            mail.setMsg(context);//设置邮件的内容
            mail.send();//发送
            return   true;
        } catch (EmailException e) {
            e.printStackTrace();
            return  false;
        }
    }



//
//    public static Session getEmailSession() {
//        // 参数配置，⽤于连接邮件服务器
//        Properties props = new Properties();
//        // 使⽤协议
//        props.setProperty("mail.transport.protocol", protocol);
//        // 发件⼈邮箱的 SMTP 服务器地址
//        props.setProperty("mail.smtp.host", smtpHost);
//        // 需要请求认证
//        props.setProperty("mail.smtp.auth", "true");
//        // 创建会话对象，⽤于与邮箱服务器交互
//        Session session = Session.getInstance(props);
//        // 设置为debug模式，在控制台中可以查看详细的发送⽇志
//        session.setDebug(true);
//        return session;
//    }
//
//    /**
//     * 发送邮件的工具类
//     */
//    public static MimeMessage createMimeMessage( String receiveEmail, String receiveName, String subject,  String content) throws Exception {
//        Session session = getEmailSession();
//        // 1.创建邮件对象
//        MimeMessage message = new MimeMessage(session);
//        // 2.设置发件⼈，其中 InternetAddress 有三个参数，分别为：邮箱，显示的昵称，昵称的字符集编码
//        message.setFrom(new InternetAddress(sendEmail, sendName, "UTF-8"));
//        // 3.设置收件⼈ - MimeMessage.RecipientType.TO
//        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveEmail, receiveName, "UTF-8"));
//        // 4.设置邮件主题
//        message.setSubject(subject, "UTF-8");
//        // 5.设置邮件正⽂内容，指定格式为HTML格式
//        message.setContent(content, "text/html;charset=UTF-8");
//        // 6.设置显示发件时间
//        message.setSentDate(new Date());
//        // 7.保存设置
//        message.saveChanges();
//        // 8.根据 Session 获取邮件传输对象
//        Transport transport = session.getTransport();
//        // 9.连接邮件服务器
//        transport.connect(sendEmail, authorizeCode);
//        // 10.发送邮件
//        transport.sendMessage(message, message.getAllRecipients());
//        // 11.关闭连接
//        transport.close();
//        return message;
//    }
}
