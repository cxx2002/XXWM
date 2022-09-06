package com.cxx.reggie.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * @author 陈喜喜
 * @date 2022-09-01 20:17
 */
public class EmailUtil {
    public static void sendAuthCodeEmail(String email, String authCode) {
        try {
            SimpleEmail mail = new SimpleEmail();
            mail.setHostName("smtp.qq.com");//发送邮件的服务器,这个是qq邮箱的，不用修改
            mail.setAuthentication("cxx_2002@qq.com", "zlnjoaawpwgncbbd");//第一个参数是对应的邮箱用户名一般就是自己的邮箱第二个参数就是SMTP的密码,我们上面获取过了
            mail.setFrom("cxx_2002@qq.com", "嘻嘻外卖");  //发送邮件的邮箱和发件人
            mail.setSSLOnConnect(true); //使用安全链接
            mail.addTo(email);//接收的邮箱
            mail.setSubject("验证码");//设置邮件的主题
            mail.setMsg("【嘻嘻外卖】" +
                    "尊敬的用户：你好！欢迎使用嘻嘻外卖，点外卖，来嘻嘻！登录验证码：" + authCode + "" +
                    "(有效期为两分钟)" + "。验证码提供给他人可能导致账号被盗，请勿泄露，谨防被骗，若非本人操作，请忽略此邮件，尽快修改密码。" +
                    "\n\n\n\n\n" + "");//设置邮件的内容
            mail.send();//发送
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

}
