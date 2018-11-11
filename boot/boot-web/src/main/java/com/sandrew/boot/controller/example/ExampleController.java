package com.sandrew.boot.controller.example;

import com.sandrew.boot.core.mail.MailContentBuilder;
import com.sandrew.boot.core.mail.MailSender;
import com.sandrew.boot.core.nosql.MongoUtil;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;

/**
 * Created by summer on 2018/11/11.
 */
public class ExampleController
{

    @Resource
    private JavaMailSender mailSender;

    @Resource
    private TemplateEngine templateEngine;

    @Resource
    private MongoTemplate mongoTemplatePri;

    @Resource
    private MongoTemplate mongoTemplateSec;


    /**
     *  发送邮件样例
     */
    public void sendMailExample()
    {
        Runnable runnable = new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(10000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                MailSender.sendTemplateMail(mailSender, "42951690@qq.com", "sandrew1945@gmail.com", "测试主题", new MailContentBuilder()
                {
                    @Override
                    public String build()
                    {
                        Context context = new Context();
                        context.setVariable("name", "张三");
                        return templateEngine.process("email/mailtemplate", context);
                    }
                });
            }
        };
        Thread t = new Thread(runnable);
        t.start();
    }

    /**
     *  mongo CRUD样例
     */
    public void mongoExample()
    {
        MongoUtil util = new MongoUtil(mongoTemplatePri);
        util.save("collection", "testValue");
    }
}
